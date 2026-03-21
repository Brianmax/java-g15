# Ejercicio 1 — Integración con servicio externo SUNAT

## Descripción

El objetivo de este ejercicio es implementar un módulo completo para gestionar empresas dentro de la API REST del proyecto `api-rest`. Para registrar una empresa, el sistema deberá consultar un servicio externo (SUNAT) usando el RUC ingresado por el usuario, completar automáticamente los datos de la empresa con la respuesta obtenida y almacenarlos en la base de datos.

---

## Contexto

Ya existe en el proyecto la entidad `EmpresaEntity` con todos los campos necesarios. Tu trabajo es construir las capas que la rodean: cliente Feign, DTOs, repositorio, servicio y controlador.

---

## Servicio Externo

Para obtener la información de una empresa se debe consumir el siguiente endpoint:

```
GET https://api.decolecta.com/v1/sunat/ruc/full?numero={ruc}
```

El token de autorización ya está configurado en el proyecto (`${api.token}`), el mismo que se usa para RENIEC.

**Ejemplo de respuesta del servicio:**
```json
{
    "razon_social": "REXTIE S.A.C.",
    "numero_documento": "20601030013",
    "estado": "ACTIVO",
    "condicion": "HABIDO",
    "direccion": "AV. JOSE GALVEZ BARRENECHEA NRO 566 INT. 101 URB. CORPAC",
    "ubigeo": "150131",
    "via_tipo": "AV.",
    "via_nombre": "JOSE GALVEZ BARRENECHEA",
    "zona_codigo": "URB.",
    "zona_tipo": "CORPAC",
    "numero": "566",
    "interior": "101",
    "lote": "-",
    "dpto": "-",
    "manzana": "-",
    "kilometro": "-",
    "distrito": "SAN ISIDRO",
    "provincia": "LIMA",
    "departamento": "LIMA",
    "es_agente_retencion": false,
    "es_buen_contribuyente": false,
    "tipo": "SOCIEDAD ANONIMA CERRADA",
    "actividad_economica": "OTROS TIPOS DE INTERMEDIACION MONETARIA",
    "numero_trabajadores": "45",
    "tipo_facturacion": "MANUAL/COMPUTARIZADO",
    "tipo_contabilidad": "MANUAL/COMPUTARIZADO",
    "comercio_exterior": "SIN ACTIVIDAD"
}
```

---

## Lo que debes implementar

### 1. Query Parameters en el Controlador

Hasta ahora hemos enviado datos al servidor usando `@RequestBody` (en el cuerpo de la solicitud) o `@PathVariable` (en la URL). Existe una tercera forma: los **query parameters**, que se envían al final de la URL después de un `?`.

**Ejemplo:**
```
POST /api/v1/empresa/save?ruc=20601030013
```

Investiga cómo usar la anotación `@RequestParam` en Spring Boot para recibir el RUC directamente como query parameter en el endpoint de creación de empresa, **sin necesidad de un `@RequestBody`**.

Preguntas guía para tu investigación:
- ¿Qué diferencia hay entre `@RequestParam`, `@PathVariable` y `@RequestBody`?
- ¿Cómo se marca un query parameter como obligatorio o como opcional?
- ¿Cómo se define un valor por defecto si el parámetro no se envía?

Aplica lo que investigues al endpoint `POST /save` del controlador de empresa.

---

### 2. DTO de request — `EmpresaCreateDto`

> **Nota:** dado que ahora el RUC se recibe como query parameter directamente en el controlador, este DTO ya **no es necesario** para el endpoint de creación. Puedes omitirlo. Se incluye aquí solo como referencia para entender la diferencia entre ambos enfoques.

Si de todas formas quisieras usarlo, contendría:

- `ruc` de tipo `String`

### 2. DTO de response — `EmpresaResponseDto`

Crea un DTO de respuesta con los campos relevantes para el cliente. No es necesario retornar todos los campos de la entidad — selecciona los que sean útiles para quien consume la API:

- `id`
- `razonSocial`
- `numeroDocumento`
- `estado`
- `condicion`
- `direccion`
- `distrito`
- `provincia`
- `departamento`
- `tipo`
- `actividadEconomica`
- `numeroTrabajadores`
- `esAgenteRetencion`
- `esBuenContribuyente`

### 3. DTO de respuesta del servicio externo — `SunatResponse`

Crea un DTO que represente la respuesta del servicio de SUNAT. Debe tener los mismos campos que el JSON de respuesta mostrado arriba. Usa la anotación `@JsonProperty` para mapear los nombres en snake_case del JSON a camelCase en Java.

**Ejemplo:**
```java
@JsonProperty("razon_social")
private String razonSocial;
```

### 4. Feign Client — `SunatClient`

Crea un cliente Feign para consumir el servicio de SUNAT.

- La URL base debe estar en `application.yaml` bajo la clave `sunat.url`
- El método debe recibir el número de RUC y el token de autorización como parámetros
- Observa cómo está implementado `ReniecClient` en el proyecto y sigue el mismo patrón

### 5. Repositorio — `EmpresaRepository`

Crea el repositorio que extienda `JpaRepository<EmpresaEntity, UUID>` e implementa las siguientes native queries:

- `findByRazonSocial(String nombre)` — busca empresas cuya razón social contenga el texto ingresado (búsqueda parcial, insensible a mayúsculas)

### 6. Servicio — `EmpresaService`

Implementa los siguientes métodos:

**`saveEmpresa(String ruc)`**
- Valida que el RUC tenga exactamente 11 dígitos y sea numérico
- Llama al cliente Feign de SUNAT con el RUC
- Si el servicio externo falla, lanza un `ExternalServiceException`
- Mapea la respuesta del servicio a la entidad `EmpresaEntity` y guarda en base de datos
- Retorna un `EmpresaResponseDto`

**`findById(UUID id)`**
- Busca la empresa por su ID usando el método de JPA
- Si no existe, lanza un `ResourceNotFoundException` con el mensaje `"Empresa no encontrada"`
- Retorna un `EmpresaResponseDto`

**`findByNombre(String nombre)`**
- Usa la native query del repositorio para buscar empresas por razón social
- Retorna una `List<EmpresaResponseDto>`

### 7. Controlador — `EmpresaController`

Crea un controlador REST con base en `/api/v1/empresa` que exponga los siguientes endpoints:

| Método | Ruta | Descripción |
|--------|------|-------------|
| `POST` | `/save?ruc={ruc}` | Registrar una empresa por RUC (query parameter) |
| `GET` | `/find/{id}` | Buscar empresa por ID |
| `GET` | `/find/nombre/{nombre}` | Buscar empresas por razón social |

Todos los endpoints deben retornar `ResponseEntity<ApiResponse<T>>` con el código HTTP apropiado.

---

## Instrucciones Adicionales

- Sigue la misma arquitectura en capas del proyecto: Controller → Service → Repository
- Reutiliza `ApiResponse<T>` como wrapper de todas las respuestas
- Reutiliza `ModelMapper` para mapear entre entidades y DTOs
- No repitas lógica que ya existe — observa cómo está implementado el módulo de `Usuario` y úsalo como referencia
