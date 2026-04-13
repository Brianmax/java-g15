# Java G15

Repositorio de aprendizaje de Java organizado por proyectos temáticos.

## Proyectos

| Proyecto | Descripción | Temas |
|----------|-------------|-------|
| [intro-java](./intro-java) | Fundamentos básicos de Java | Variables, Tipos de datos, Operadores, Condicionales, Loops, Arrays, ArrayList |
| [poo](./poo) | Programación Orientada a Objetos | Clases, Objetos, Herencia, Clases Abstractas, Modificadores de Acceso, Polimorfismo |
| [teoria](./teoria) | Guías teóricas de referencia | Variables, Condicionales, Loops, Arrays, POO, Clases Abstractas, Interfaces, Hash |
| [ejercicios](./ejercicios) | Ejercicios prácticos por tema | Variables, Condicionales, Arrays, Loops, Clases |
| [bases-datos](./bases-datos) | Consultas y diseño de bases de datos | PostgreSQL, Relaciones, Foreign Keys, JOINs, MongoDB, Aggregations, Operadores |
| [api-rest](./api-rest) | API REST con Spring Boot | Spring Boot, Spring Data JPA, PostgreSQL, DTOs, Feign Client, Exception Handling, ModelMapper, RENIEC |
| [biblioteca](./biblioteca) | API REST con pruebas unitarias | Spring Boot, JPA, PostgreSQL, ModelMapper, JUnit 5, Mockito |
| [hexagonal](./hexagonal) | Arquitectura Hexagonal con Spring Boot | Ports & Adapters, Domain Model, Use Cases, JPA Persistence Adapter |
| [security-g15](./security-g15) | Seguridad con Spring Security y JWT | JWT, BCrypt, Roles, Stateless Sessions, Spring Security Filter Chain |

---

## Detalle por Proyecto

### intro-java

Cubre los conceptos fundamentales para comenzar a programar en Java.

**Temas incluidos:**

- **Variables y Tipos de Datos**
  - Tipos numéricos: `byte`, `int`, `float`, `double`
  - Tipos de carácter: `char`, `String`
  - Tipo booleano: `boolean`

- **Operadores**
  - Aritméticos: `+`, `-`, `*`, `/`, `%`
  - Comparación: `<`, `>`, `<=`, `>=`, `==`, `!=`
  - Lógicos: `&&`, `||`, `!`

- **Condicionales**
  - Estructura `if-else`

- **Loops**
  - Bucles `for` y `while`

- **Arrays y Listas**
  - Arrays unidimensionales y bidimensionales
  - `ArrayList`

- **Entrada de Datos**
  - Uso de `Scanner` para entrada por consola

---

### poo

Cubre los conceptos de Programación Orientada a Objetos en Java.

**Temas incluidos:**

- **Clases y Objetos**
  - Definición de clases, atributos y métodos
  - Instanciación de objetos

- **Modificadores de Acceso**
  - `public`, `private`, `protected`
  - Encapsulamiento

- **Getters y Setters**
  - Métodos de acceso a propiedades

- **Herencia**
  - Uso de `extends`
  - Jerarquía de clases (Persona → Alumno, Profesor)

- **Clases Abstractas**
  - Clase abstracta `Figura`
  - Implementación con subclases

- **Polimorfismo**
  - Sobreescritura de métodos con `@Override`

---

### teoria

Guías teóricas de referencia en formato Markdown.

**Temas incluidos:**

- [Variables](./teoria/variables.md) — Tipos de datos, declaración, operaciones
- [Condicionales](./teoria/if-else.md) — Estructuras `if`, `else if`, `else`
- [Loops](./teoria/loops.md) — Bucles `for` y `while`
- [Arrays y Listas](./teoria/arrays-listas.md) — Arrays, arrays multidimensionales, `ArrayList`
- [POO Básico](./teoria/poo-basico.md) — Clases, objetos, métodos
- [Clases Abstractas](./teoria/clasesAbstractas.md) — Herencia y `@Override`
- [Interfaces](./teoria/interfaces.md) — Contratos e implementación múltiple
- [Hash](./teoria/hash.md) — Estructuras de tipo HashMap

---

### ejercicios

Ejercicios prácticos organizados por tema.

- [Variables 1](./ejercicios/EjerciciosVariables1.md)
- [Variables 2](./ejercicios/EjerciciosVariables2.md)
- [Condicionales](./ejercicios/EjerciciosCondicionales.md)
- [Arrays y Loops](./ejercicios/EjerciciosArraysLoops.md)
- [Clases](./ejercicios/EjercicioClases.md)
- [Clases 2](./ejercicios/EjerciciosClases2.md)
- [API Rest](./ejercicios/EjerciciosApiRest.md)

---

### bases-datos

Ejemplos de consultas SQL y MongoDB para el manejo de bases de datos relacionales y no relacionales.

**Temas incluidos:**

- **PostgreSQL**
  - Diseño de esquemas relacionales
  - Restricciones: `FOREIGN KEY`, `ON DELETE CASCADE`, `ON DELETE SET NULL`, `ON DELETE SET DEFAULT`
  - Consultas: `INNER JOIN`, `LEFT OUTER JOIN`

- **MongoDB**
  - Operaciones de colección: `insertOne`, `insertMany`, `find`, `updateOne`
  - Validación de esquemas con JSON Schema
  - Operadores: `$gt`, `$gte`, `$and`, `$or`
  - Aggregation pipelines: `$unwind`, `$group`, `$avg`, `$sum`, `$sort`

---

### api-rest

API REST construida con Spring Boot para gestión de usuarios, artículos y categorías, con integración al servicio externo RENIEC.

**Temas incluidos:**

- **Spring Boot**
  - Arquitectura en capas: Controller → Service → Repository
  - Anotaciones: `@RestController`, `@Service`, `@Repository`, `@Entity`

- **Spring Data JPA**
  - Entidades y relaciones (`@OneToMany`, `@ManyToOne`, `@ManyToMany`)
  - Native queries con `@Query(nativeQuery = true)`

- **DTOs y Mapeo**
  - Separación de DTOs de request y response
  - Mapeo con ModelMapper

- **Feign Client**
  - Integración con API externa (RENIEC) para consulta de DNI

- **Manejo de Excepciones**
  - `@RestControllerAdvice` con excepciones custom
  - `ResourceNotFoundException` (404), `ExternalServiceException` (502)

- **Diseño REST**
  - Respuesta genérica `ApiResponse<T>`
  - Códigos HTTP apropiados por operación

---

### biblioteca

API REST de ejemplo para gestión de libros, autores y categorías, con énfasis en pruebas unitarias.

**Temas incluidos:**

- **Spring Boot + JPA**
  - Entidades: `AutorEntity`, `LibroEntity`, `CategoriaEntity`
  - Relaciones: `@ManyToOne`, `@ManyToMany`
  - Validaciones con `@Valid`, `@NotBlank`, `@Email`

- **Pruebas Unitarias**
  - JUnit 5 + Mockito
  - Uso de `@Mock`, `@InjectMocks` y `@Spy`
  - Tests para servicios: `AutorService`, `LibroService`

- **Endpoints**
  - `/api/v1/autores` — CRUD de autores
  - `/api/v1/libros` — CRUD de libros con validación de autor
  - `/api/v1/categorias` — CRUD de categorías

---

### hexagonal

Implementación de Arquitectura Hexagonal (Ports & Adapters) con Spring Boot aplicada a gestión de productos.

**Temas incluidos:**

- **Domain Layer**
  - Modelo de dominio: `Product`
  - Puertos de entrada (`ProductUseCase`) y salida (`ProductPort`)
  - Excepción de dominio: `ProductNotFoundException`

- **Application Layer**
  - Caso de uso: `ProductService` implementa `ProductUseCase`

- **Infrastructure Layer**
  - Adaptador de persistencia: `ProductPersistenceAdapter` implementa `ProductPort`
  - Entidad JPA: `ProductJpaEntity`
  - Controlador REST: `ProductController`
  - DTOs: `ProductRequest`, `ProductResponse`
  - Manejo global de excepciones: `GlobalExceptionHandler`

---

### security-g15

API REST con autenticación y autorización usando Spring Security y JWT.

**Temas incluidos:**

- **Spring Security**
  - Configuración stateless con `SecurityFilterChain`
  - `DaoAuthenticationProvider` con `BCryptPasswordEncoder`
  - Rutas públicas (`/auth/login`, `/auth/register`) y protegidas

- **JWT (JSON Web Tokens)**
  - Generación y validación de tokens en `JwtService`
  - Filtro de autenticación: `JwtFilter`

- **Roles y Usuarios**
  - Entidades: `UserEntity`, `RoleEntity` con enum `Role`
  - `UserDetailsServiceImpl` para carga de usuarios
  - Endpoints: `AuthController`, `UserController`, `ProductController`

- **DTOs**
  - `LoginRequest`, `RegisterRequest`, `AuthResponse`
  - `UserResponse`, `UpdateUserRequest`
  - `ProductRequest`, `ProductResponse`

---