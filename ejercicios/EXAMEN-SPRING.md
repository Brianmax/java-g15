**# Examen: API REST con Spring Boot

**Curso:** Desarrollo de APIs REST con Java
**Duración:** 3 horas
**Puntaje total:** 110 puntos

---

## Instrucciones Generales

- Crea un proyecto **Spring Boot** nuevo desde [start.spring.io](https://start.spring.io) con las siguientes dependencias: `Spring Web`, `Spring Data JPA`, `PostgreSQL Driver`, `Lombok`, `Validation`, `Spring Cloud OpenFeign`.
  - Usa **Java 17** y **Maven**.
  - Conecta la aplicación a una base de datos PostgreSQL local. El nombre de la base de datos debe ser obligatoriamente **`clinica_veterinaria`**.
  - Sigue la arquitectura en capas: `controller → service → repository → entity`.
  - Usa DTOs para los requests y responses (nunca expongas la entidad directamente en los endpoints).
  - Todas las respuestas deben envolverse en un objeto genérico `ApiResponse<T>` con los campos: `success` (boolean), `message` (String) y `data` (T).
  - Maneja los errores con un `GlobalExceptionHandler` usando `@RestControllerAdvice`.

---

## Contexto del Sistema

Vas a construir una API REST para gestionar una **clínica veterinaria**. El sistema permite registrar propietarios de mascotas, las mascotas mismas y las consultas médicas que se realizan.

### Entidades

**Propietario**
- `id` (UUID, generado automáticamente)
  - `nombres` (String)
  - `apellidos` (String)
  - `email` (String)
  - `telefono` (String)
  - `dni` (String, 8 dígitos)
  - `direccion` (String)
  - `fechaRegistro` (Date, por defecto fecha actual)
  - `createdAt` (fecha y hora de creación, se asigna automáticamente en el servidor)
  - `updatedAt` (fecha y hora de última modificación, se actualiza automáticamente en el servidor)
  - Relación: un propietario puede tener **muchas mascotas** (`@OneToMany`)

**Mascota**
- `id` (UUID, generado automáticamente)
  - `nombre` (String)
  - `especie` (String) — ej: perro, gato, ave
  - `raza` (String)
  - `fechaNacimiento` (Date)
  - `peso` (Double)
  - `fechaRegistro` (Date, por defecto fecha actual)
  - `createdAt` (fecha y hora de creación, se asigna automáticamente en el servidor)
  - `updatedAt` (fecha y hora de última modificación, se actualiza automáticamente en el servidor)
  - Relación: una mascota pertenece a **un propietario** (`@ManyToOne`)
  - Relación: una mascota puede tener **muchas vacunas** (`@ManyToMany`)

**Vacuna**
- `id` (UUID, generado automáticamente)
  - `nombre` (String)
  - `descripcion` (String)
  - `laboratorio` (String)
  - `dosis` (int)
  - `createdAt` (fecha y hora de creación, se asigna automáticamente en el servidor)
  - `updatedAt` (fecha y hora de última modificación, se actualiza automáticamente en el servidor)
  - Relación: una vacuna puede aplicarse a **muchas mascotas** (`@ManyToMany`)

---

## Parte 1 — Entidades y Relaciones (20 puntos)

Crea las tres entidades JPA con sus respectivas anotaciones.

**Requisitos:**
- Usa `@Entity`, `@Table`, `@Id`, `@GeneratedValue` correctamente en cada entidad.
  - Usa Lombok (`@Getter`, `@Setter`, `@NoArgsConstructor`, `@AllArgsConstructor`) para eliminar el boilerplate.
  - Implementa correctamente las relaciones:
    - `Propietario` → `Mascota`: `@OneToMany(mappedBy = "propietario", fetch = FetchType.LAZY)`
    - `Mascota` → `Propietario`: `@ManyToOne` con `@JoinColumn(name = "propietario_id_fk")`
    - `Mascota` ↔ `Vacuna`: `@ManyToMany` con tabla intermedia `mascota_vacuna`
  - Nombra las tablas en la BD: `propietarios`, `mascotas`, `vacunas`.
  - Usa `@Column` cuando el nombre en la BD difiera del nombre en Java (ej: `fecha_nacimiento`, `fecha_registro`).

**Criterios de evaluación:**
- Anotaciones JPA correctas y completas (10 pts)
  - Relaciones bien definidas con fetch type y join column apropiados (10 pts)

---

## Parte 2 — DTOs y Validaciones (20 puntos)

Crea los DTOs de request y response para `Propietario` y `Mascota`.

### DTOs de Request

**`PropietarioCreateDto`** — con las siguientes validaciones:
- `email`: obligatorio, debe tener formato de email válido (`@Email`)
  - `telefono`: obligatorio, solo dígitos, entre 7 y 9 caracteres (`@Pattern`)
  - `dni`: obligatorio, exactamente 8 dígitos numéricos (`@Pattern`)
  - `nombres`: obligatorio, no puede estar en blanco (`@NotBlank`)
  - `apellidos`: obligatorio, no puede estar en blanco (`@NotBlank`)
  - `direccion`: obligatoria, no puede estar en blanco (`@NotBlank`)

**`MascotaCreateDto`**:
- `nombre`: obligatorio, no puede estar en blanco
  - `especie`: obligatoria, no puede estar en blanco
  - `fechaNacimiento`: obligatoria, debe ser una fecha pasada (`@Past`)
  - `peso`: obligatorio, debe ser mayor a 0 (`@Positive`)
  - `propietarioId`: obligatorio (UUID del propietario dueño)

### DTOs de Response

**`PropietarioResponseDto`**: id, nombres, apellidos, email, telefono, direccion, fechaRegistro, lista de `MascotaResponseDto`.

**`MascotaResponseDto`**: id, nombre, especie, raza, peso, fechaNacimiento.

**`ApiResponse<T>`**: clase genérica reutilizable con campos `success` (boolean), `message` (String) y `data` (T).

**Criterios de evaluación:**
- Anotaciones de validación correctas y mensajes de error descriptivos (10 pts)
  - DTOs de response bien estructurados con los tipos correctos (10 pts)

---

## Parte 3 — Repositorios con Queries Personalizadas (15 puntos)

Crea los repositorios extendiendo `JpaRepository`. En `PropietarioRepository` implementa las siguientes queries con `@Query(nativeQuery = true)`:

1. **Buscar propietario por email** — retorna `Optional<PropietarioEntity>`:
   ```sql
   SELECT * FROM propietarios WHERE email = :email
   ```

   2. **Buscar propietarios por apellido** (búsqueda parcial, case-insensitive) — retorna `List<PropietarioEntity>`:
      ```sql
      SELECT * FROM propietarios WHERE apellidos ILIKE CONCAT('%', :apellido, '%')
      ```

   3. **Buscar propietarios registrados después de una fecha** — retorna `List<PropietarioEntity>`:
      ```sql
      SELECT * FROM propietarios WHERE fecha_registro > :fecha
      ```

En `MascotaRepository` implementa:

4. **Buscar mascotas por especie** — retorna `List<MascotaEntity>`:
   ```sql
   SELECT * FROM mascotas WHERE especie ILIKE :especie
   ```

**Criterios de evaluación:**
- Repositorios extienden `JpaRepository` con los tipos genéricos correctos (3 pts)
  - Las 4 queries nativas correctamente implementadas (12 pts)

---

## Parte 4 — Capa de Servicio (20 puntos)

Implementa los servicios con la lógica de negocio.

### `PropietarioService`

**`savePropietario(PropietarioCreateDto dto)`** — debe:
1. Verificar que no exista ya un propietario con el mismo email usando la query personalizada. Si existe, lanzar `ResourceNotFoundException` con el mensaje `"Ya existe un propietario registrado con ese email"`.
   2. Mapear el DTO a la entidad usando `ModelMapper`.
   3. Guardar la entidad.
   4. Mapear la entidad guardada a `PropietarioResponseDto` y retornarla.

**`findById(UUID id)`** — debe:
1. Buscar el propietario por ID. Si no existe, lanzar `ResourceNotFoundException` con el mensaje `"Propietario no encontrado"`.
   2. Obtener la lista de mascotas del propietario y mapearlas a `List<MascotaResponseDto>`.
   3. Retornar el `PropietarioResponseDto` completo incluyendo sus mascotas.

**`findByApellido(String apellido)`** — debe:
1. Buscar propietarios usando la query personalizada por apellido.
   2. Mapear la lista de entidades a `List<PropietarioResponseDto>` y retornarla.

### `MascotaService`

**`saveMascota(MascotaCreateDto dto)`** — debe:
1. Buscar el propietario por `propietarioId`. Si no existe, lanzar `ResourceNotFoundException` con mensaje `"Propietario no encontrado"`.
   2. Crear la entidad `MascotaEntity` mapeando el DTO, y asignarle el propietario encontrado.
   3. Guardar la mascota y retornar el `MascotaResponseDto`.

**Criterios de evaluación:**
- Lógica de negocio correcta con manejo de excepciones donde corresponde (10 pts)
  - Uso correcto de `ModelMapper` para las conversiones entre capas (10 pts)

---

## Parte 5 — Controladores REST (15 puntos)

Implementa los controladores siguiendo las convenciones REST.

### `PropietarioController` — base path: `/api/v1/propietario`

| Método HTTP | URL completa | Descripción | Status esperado |
|-------------|--------------|-------------|-----------------|
| POST | `/api/v1/propietario/save` | Registrar un nuevo propietario | 201 Created |
| GET | `/api/v1/propietario/find/{id}` | Buscar propietario por ID | 200 OK |
| GET | `/api/v1/propietario/find/apellido/{apellido}` | Buscar propietarios por apellido | 200 OK |

### `MascotaController` — base path: `/api/v1/mascota`

| Método HTTP | URL completa | Descripción | Status esperado |
|-------------|--------------|-------------|-----------------|
| POST | `/api/v1/mascota/save` | Registrar una nueva mascota | 201 Created |
| GET | `/api/v1/mascota/find/especie/{especie}` | Buscar mascotas por especie | 200 OK |

**Requisitos:**
- Usa `@RestController` y `@RequestMapping`.
  - Inyecta el servicio **por constructor** (no uses `@Autowired` en campo).
  - Usa `@Valid` en los parámetros de `@RequestBody`.
  - Retorna siempre `ResponseEntity<ApiResponse<T>>`.

**Criterios de evaluación:**
- Anotaciones y rutas REST correctas (5 pts)
  - Uso correcto de `ResponseEntity` y códigos HTTP (5 pts)
  - Inyección por constructor y uso de `@Valid` (5 pts)

---

## Parte 6 — Manejo de Excepciones (10 puntos)

Implementa un `GlobalExceptionHandler` con `@RestControllerAdvice` que maneje:

1. **`MethodArgumentNotValidException`** → HTTP **400 Bad Request**
   - Retorna `ApiResponse` con `success = false` y un mensaje de error.
   - **Opcional:** Agrupa los errores por campo en un `Map<String, List<String>>` y retorna `ApiResponse<Map<String, List<String>>>` con mensaje `"Error de validacion"`.

   2. **`ResourceNotFoundException`** → HTTP **404 Not Found**
      - Retorna `ApiResponse<Void>` con `success = false` y el mensaje de la excepción.

   3. **`DuplicateResourceException`** → HTTP **409 Conflict**
      - Retorna `ApiResponse<Void>` con `success = false` y el mensaje de la excepción.
      - Lánzala cuando se intente registrar un propietario con un email ya existente.

   4. **`ExternalServiceException`** → HTTP **502 Bad Gateway**
      - Retorna `ApiResponse<Void>` con `success = false` y el mensaje de la excepción.
      - Lánzala cuando la llamada al servicio externo de RENIEC falle.

**Criterios de evaluación:**
- Manejo de errores de validación retornando HTTP 400 (3 pts)
  - Agrupación de errores por campo en `Map<String, List<String>>` (opcional, 2 pts)
  - Manejo correcto de `ResourceNotFoundException` (5 pts)

---

## Parte 7 — Cliente Feign (10 puntos)

Integra un servicio externo de validación de DNI al momento de registrar un propietario.

**Contexto:** Existe una API externa que, dado un DNI, retorna los datos del ciudadano con la siguiente estructura:

```json
{
  "firstName": "CARLOS ALBERTO",
  "firstLastName": "MENDOZA",
  "secondLastName": "TORRES",
  "fullName": "CARLOS ALBERTO MENDOZA TORRES",
  "documentNumber": "12345678"
}
```

**Implementa:**

1. La interfaz `@FeignClient` apuntando a `https://api.decolecta.com/v1/reniec/dni`, con un método que reciba `numero` como `@RequestParam` y `Authorization` como `@RequestHeader`.

   2. El DTO `ReniecResponse` con los campos de la respuesta.

   3. En `PropietarioService.savePropietario()`, antes de guardar:
      - Llama al Feign Client para validar el DNI.
      - Si la llamada falla (excepción), lanza `ExternalServiceException`.
      - Usa `firstName` para establecer `nombres` y `firstLastName + " " + secondLastName` para `apellidos` en la entidad.

   4. Lee el token de la API desde `application.yaml` con `@Value("${api.token}")`.

   5. Agrega el manejo de `ExternalServiceException` en el `GlobalExceptionHandler` → HTTP **502 Bad Gateway**.

   6. Agrega `@EnableFeignClients` en la clase principal de la aplicación.

**Criterios de evaluación:**
- Feign Client correctamente configurado con anotaciones y parámetros (3 pts)
  - Lógica de integración en el servicio (nombres/apellidos desde la respuesta) (4 pts)
  - Excepción `ExternalServiceException` manejada en `GlobalExceptionHandler` (3 pts)

---

## Entregables

1. Proyecto Maven completo con el código fuente, entregado como archivo `.zip` o repositorio. El nombre debe seguir el formato: **`nombre_apellidoPaterno_apellidoMaterno`** (ej: `carlos_mendoza_torres`).
   2. Archivo `application.yaml` configurado con las credenciales de tu BD local. La base de datos **debe llamarse obligatoriamente `clinica_veterinaria`**.
   3. Prueba los endpoints con Postman o similar.**
