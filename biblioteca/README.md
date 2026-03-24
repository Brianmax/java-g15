# biblioteca

API REST de ejemplo con pruebas unitarias en Spring Boot.

## Stack

- Java 17 + Spring Boot 3.4.1
- Spring Data JPA + PostgreSQL
- Spring Validation (`@Valid`, `@NotBlank`, `@Email`, etc.)
- ModelMapper
- JUnit 5 + Mockito (pruebas unitarias)

## Entidades

| Entidad | Tabla | Descripción |
|---|---|---|
| `AutorEntity` | `autores` | Autor de libros |
| `LibroEntity` | `libros` | Libro vinculado a un autor (N:1) |
| `CategoriaEntity` | `categorias` | Categoría con relación N:M a libros |

## Endpoints

| Método | Ruta | Descripción |
|---|---|---|
| `POST` | `/api/v1/autores` | Crear autor |
| `GET` | `/api/v1/autores/{id}` | Buscar autor por ID |
| `GET` | `/api/v1/autores` | Listar todos los autores |
| `POST` | `/api/v1/libros` | Crear libro |
| `GET` | `/api/v1/libros/{id}` | Buscar libro por ID |
| `GET` | `/api/v1/libros/autor/{autorId}` | Libros de un autor |
| `POST` | `/api/v1/categorias` | Crear categoría |
| `GET` | `/api/v1/categorias/{id}` | Buscar categoría por ID |
| `GET` | `/api/v1/categorias` | Listar todas las categorías |

## Ejecutar los tests

```bash
mvn test
```

---

## Próxima feature — Sistema de descuentos por popularidad

### Descripción

Los libros de autores más prolíficos tienen mayor descuento. La lógica de descuento vive en un helper compartido (`DescuentoHelper`) que será usado por **dos servicios distintos**: `LibroService` para calcular el precio final de un libro, y `AutorService` para consultar qué descuento aplica a un autor según su catálogo.

### Reglas de negocio

| Libros publicados por el autor | Descuento |
|---|---|
| Menos de 3 | 0 % |
| Entre 3 y 5 | 10 % |
| 6 o más | 20 % |

### Endpoints a implementar

| Método | Ruta | Descripción |
|---|---|---|
| `GET` | `/api/v1/libros/{id}/precio` | Precio final del libro con descuento aplicado |
| `GET` | `/api/v1/autores/{id}/descuento` | Descuento vigente del autor y cantidad de libros |

### Lo que se deberá implementar

1. **DTOs de respuesta:** `LibroPrecioResponseDto` y `AutorDescuentoResponseDto`
2. **Inyectar `DescuentoHelper`** en `LibroService` y `AutorService`
3. **Métodos de servicio:** `calcularPrecioFinal(UUID libroId)` y `calcularDescuentoAutor(UUID autorId)`
4. **Endpoints** en `LibroController` y `AutorController`
5. **Tests unitarios** usando `@Spy DescuentoHelper` para que usen la implementación real

### Por qué los tests con `@Spy` son poderosos aquí

Al usar `@Spy` en lugar de `@Mock` para el helper, los tests ejecutan la lógica **real** de `DescuentoHelper`. Esto significa que si alguien modifica los umbrales de descuento, los tests de **ambos servicios** fallarán al mismo tiempo, dejando en evidencia que el helper es compartido.

**Modificación que romperá tests en dos servicios a la vez:**

En `DescuentoHelper.calcularPorcentajeDescuento()`, cambia el umbral de `>= 3` a `>= 4`:

```java
// Antes:
if (cantidadLibros >= 3) return 10.0;

// Después (roto):
if (cantidadLibros >= 4) return 10.0;
```

Tests que fallarán simultáneamente:
- `LibroPrecioTest` → `calcularPrecioFinal_conAutorCon3Libros_aplica10PorCiento`
- `AutorDescuentoTest` → `calcularDescuentoAutor_con3Libros_retorna10PorCiento`

Esto demuestra que modificar un helper compartido sin correr los tests puede romper funcionalidades que aparentemente no tienen relación entre sí.

---

## Pruebas unitarias — qué modificar para ver que avisan

Cada test tiene un comentario `PARA ROMPER ESTE TEST` que indica exactamente
qué cambiar en el servicio para que el test falle. Úsalos para entender el valor
de las pruebas unitarias.

### Modificaciones sugeridas

#### 1. Eliminar la validación de email duplicado

En `AutorService.saveAutor()`, comenta este bloque:

```java
// boolean emailExiste = autorRepository.findByEmail(dto.getEmail()).isPresent();
// if (emailExiste) {
//     throw new BusinessException("...");
// }
```

**Test que fallará:** `saveAutor_cuandoEmailYaExiste_lanzaBusinessException`
**Por qué:** el test espera que se lance `BusinessException`, pero si eliminas
la validación, el método continuará sin lanzar nada.

---

#### 2. Eliminar la validación del autor antes de guardar un libro

En `LibroService.saveLibro()`, comenta la búsqueda del autor:

```java
// AutorEntity autor = autorRepository.findById(dto.getAutorId())
//         .orElseThrow(() -> new ResourceNotFoundException("..."));
```

**Test que fallará:** `saveLibro_cuandoAutorNoExiste_lanzaResourceNotFoundException`
**Por qué:** el test espera que se valide la existencia del autor. Sin esa validación,
se podría guardar un libro con un autor inexistente, lo cual es un error de integridad.

---

#### 3. No asignar el nombre del autor en la respuesta del libro

En `LibroService.saveLibro()`, elimina esta línea:

```java
response.setNombreAutor(autor.getNombre() + " " + autor.getApellido());
```

**Test que fallará:** `saveLibro_conDatosValidos_guardaYRetornaDtoConNombreAutor`
**Por qué:** el test verifica que `resultado.getNombreAutor()` sea `"Gabriel García Márquez"`.
Si no asignas ese valor, retornará `null` y el assertEquals fallará.

---

#### 4. Cambiar el orElseThrow por orElse(null)

En `LibroService.findById()`, cambia:

```java
// Antes (correcto):
LibroEntity libro = libroRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("..."));

// Después (roto):
LibroEntity libro = libroRepository.findById(id).orElse(null);
```

**Test que fallará:** `findById_cuandoNoExiste_lanzaResourceNotFoundException`
**Por qué:** el test usa `assertThrows` esperando la excepción. Si devuelves `null`,
se lanzará un `NullPointerException` inesperado (o ninguno), y el test fallará.

---

#### 5. No validar existencia del autor al buscar sus libros

En `LibroService.findByAutorId()`, elimina la validación del autor:

```java
// autorRepository.findById(autorId)
//         .orElseThrow(() -> new ResourceNotFoundException("..."));
```

**Test que fallará:** `findByAutorId_cuandoAutorNoExiste_lanzaResourceNotFoundException`
**Por qué:** sin esa validación, el método devuelve una lista vacía silenciosamente
cuando el autor no existe, en vez de avisarle al cliente que el recurso no fue encontrado.
