# Examen Final - Java

**Tema: Sistema de Gestión Hospitalaria**

El examen está dividido en 4 secciones que van de menor a mayor complejidad. Cada sección construye sobre la anterior. Lee los enunciados con cuidado antes de comenzar.

---

## Sección 1: Fundamentos (4 pts)

### Ejercicio 1 — Validador de Historial Médico (1.5 pts)

El hospital asigna códigos de historial médico a sus pacientes. Un código es válido si cumple **todas** las siguientes reglas:

- Tiene exactamente **8 caracteres**.
- Empieza con la letra `'H'` (mayúscula).
- Los **7 caracteres restantes** son todos dígitos numéricos (`'0'` a `'9'`).

Escribe un programa que lea un código por teclado e imprima si es válido o no.

#### Ejemplos

| Input      | Output             |
|------------|--------------------|
| `H0012345` | `Codigo valido`    |
| `h0012345` | `Codigo invalido`  |
| `H00123`   | `Codigo invalido`  |
| `HX012345` | `Codigo invalido`  |

> **Pista**: Usa `charAt()`, el método `Character.isDigit()` y un bucle para recorrer los caracteres.

---

### Ejercicio 2 — Clasificación de Pacientes por IMC (2.5 pts)

El IMC (Índice de Masa Corporal) se calcula como:

```
IMC = peso (kg) / (altura (m) * altura (m))
```

Las categorías son:

| IMC           | Categoría   |
|---------------|-------------|
| Menor a 18.5  | Bajo peso   |
| 18.5 a 24.9   | Normal      |
| 25.0 a 29.9   | Sobrepeso   |
| 30.0 o mayor  | Obesidad    |

Se tiene el siguiente arreglo con datos de `n` pacientes. Cada fila contiene `[peso, altura]`:

```java
double[][] pacientes = {
    {50.0, 1.70},
    {80.0, 1.75},
    {95.0, 1.68},
    {60.0, 1.60},
    {110.0, 1.72}
};
```

Escribe un programa que:

1. Calcule el IMC de cada paciente.
2. Imprima el IMC (con **2 decimales**) y su categoría.
3. Al final, imprima cuántos pacientes hay en cada categoría.

#### Output esperado

```
Paciente 1: IMC = 17.30 -> Bajo peso
Paciente 2: IMC = 26.12 -> Sobrepeso
Paciente 3: IMC = 33.67 -> Obesidad
Paciente 4: IMC = 23.44 -> Normal
Paciente 5: IMC = 37.17 -> Obesidad

Resumen:
Bajo peso: 1
Normal: 1
Sobrepeso: 1
Obesidad: 2
```

---

## Sección 2: POO Básico (5 pts)

### Ejercicio 3 — Clase `Medicamento` (5 pts)

Crea las siguientes clases en el paquete `examen`:

#### Clase `Medicamento`

**Atributos privados:**
- `nombre` de tipo `String`
- `dosis` de tipo `double` (en miligramos)
- `precio` de tipo `double`
- `requiereReceta` de tipo `boolean`
- `totalMedicamentosCreados` de tipo `int` — atributo **estático** que cuenta cuántos objetos `Medicamento` han sido creados.

**Constructores:**
- Constructor completo que reciba todos los atributos de instancia.
- Constructor sin `requiereReceta` que asuma `false` por defecto.

**Métodos:**
- Getters y setters para todos los atributos de instancia.
- `aplicarDescuento(double porcentaje)`: reduce el precio según el porcentaje dado. El porcentaje debe estar entre `0` y `100`; si no lo está, imprime `"Porcentaje invalido"` y no modifica el precio.
- `mostrarInfo()`: imprime toda la información del medicamento con el formato:

```
Medicamento: Paracetamol
Dosis: 500.0 mg
Precio: S/. 12.50
Requiere receta: No
```

- Método **estático** `getTotalMedicamentosCreados()` que retorna el contador estático.

#### Clase `Main`

En el `main`:

1. Crea al menos **3 medicamentos** usando ambos constructores.
2. Llama a `mostrarInfo()` en cada uno.
3. Aplica un descuento del `20%` a uno y muestra su info nuevamente.
4. Intenta aplicar un descuento del `150%` y verifica el mensaje de error.
5. Imprime el total de medicamentos creados usando el método estático.

---

## Sección 3: Herencia y Abstracción (5 pts)

### Ejercicio 4 — Personal Médico (5 pts)

Crea una jerarquía de clases para representar al personal médico del hospital.

#### Clase abstracta `PersonalMedico`

**Atributos protegidos:**
- `nombre` de tipo `String`
- `id` de tipo `String`
- `aniosExperiencia` de tipo `int`
- `salarioBase` de tipo `double`

**Constructor:** recibe todos los atributos.

**Métodos:**
- Getters para todos los atributos.
- `mostrarInfo()`: imprime nombre, id y años de experiencia.
- Método abstracto `calcularSalario()` que retorna un `double`.
- Método abstracto `getTurno()` que retorna un `String`.

---

#### Clase `Doctor` (extiende `PersonalMedico`)

**Atributos adicionales:**
- `especialidad` de tipo `String`
- `numeroPacientes` de tipo `int`

**Constructor:** recibe todos los atributos.

**Cálculo de salario:** salario base + `500.0` por cada paciente atendido.

**Turno:** `"Diurno"`

**Sobrescribe** `mostrarInfo()` para incluir especialidad y número de pacientes, llamando primero al método padre con `super`.

---

#### Clase `Enfermero` (extiende `PersonalMedico`)

**Atributos adicionales:**
- `piso` de tipo `int` (piso del hospital donde trabaja)
- `tieneEspecializacion` de tipo `boolean`

**Constructor:** recibe todos los atributos.

**Cálculo de salario:** salario base + `300.0` si tiene especialización, o solo el salario base si no.

**Turno:** `"Nocturno"`

**Sobrescribe** `mostrarInfo()` para incluir piso y si tiene especialización.

---

#### Clase `Cirujano` (extiende `Doctor`)

**Atributos adicionales:**
- `operacionesRealizadas` de tipo `int`

**Constructor:** recibe todos los atributos.

**Cálculo de salario:** salario del Doctor + `1000.0` por cada operación realizada.

**Turno:** `"Rotativo"`

**Sobrescribe** `mostrarInfo()` para incluir el número de operaciones realizadas.

---

#### Clase `Main`

En el `main`:

1. Crea al menos un objeto de cada tipo: `Doctor`, `Enfermero`, `Cirujano`.
2. Guárdalos en un `ArrayList<PersonalMedico>`.
3. Recorre la lista e imprime la información de cada uno usando polimorfismo.
4. Imprime el salario calculado de cada persona con el formato:
   ```
   [Nombre] - Salario: S/. [monto]
   ```
5. Imprime el turno de cada persona.

---

## Sección 4: Interfaces y Polimorfismo (6 pts)

### Ejercicio 5 — Sistema Hospitalario Completo (6 pts)

Diseña un sistema de gestión hospitalaria que integre interfaces, herencia y polimorfismo.

---

#### Interfaz `Registrable`

Métodos:
- `registrar()`: registra al usuario en el sistema (imprime un mensaje).
- `darDeBaja()`: da de baja al usuario (imprime un mensaje).

---

#### Interfaz `Diagnosticable`

Métodos:
- `emitirDiagnostico(String paciente)`: emite un diagnóstico para un paciente (imprime un mensaje con el nombre del paciente).
- `solicitarExamen(String tipoExamen)`: solicita un examen médico (imprime un mensaje).

---

#### Interfaz `Operable`

Métodos:
- `programarOperacion(String paciente, String tipoOperacion)`: programa una operación (imprime un mensaje).
- `realizarOperacion()`: realiza la operación (imprime un mensaje).

---

#### Clase abstracta `Persona` (implementa `Registrable`)

**Atributos protegidos:**
- `nombre` de tipo `String`
- `dni` de tipo `String`

**Constructor:** recibe ambos atributos.

**Getters** para los atributos.

La forma en que un usuario se registra y se da de baja depende de su tipo, por lo que `registrar()` y `darDeBaja()` pueden tener comportamientos distintos en cada subclase.

---

#### Clase `Paciente` (extiende `Persona`)

**Atributos adicionales:**
- `historialMedico` de tipo `String`
- `estaInternado` de tipo `boolean`

**Constructor:** recibe todos los atributos.

**Implementa** `registrar()` imprimiendo:
```
Paciente [nombre] registrado con historial [historialMedico].
```

**Implementa** `darDeBaja()` imprimiendo:
```
Paciente [nombre] dado de alta del sistema.
```

Método adicional `internar()`: cambia `estaInternado` a `true` e imprime un mensaje. Si ya está internado, imprime `"El paciente ya se encuentra internado"`.

---

#### Clase `MedicoGeneral` (extiende `Persona`, implementa `Diagnosticable`)

**Atributos adicionales:**
- `consultorio` de tipo `int`
- `pacientesAtendidos` de tipo `ArrayList<String>`

**Constructor:** recibe `nombre`, `dni` y `consultorio`.

**Implementa** todos los métodos de `Diagnosticable`.

Método adicional `atenderPaciente(String nombrePaciente)`: agrega el nombre a `pacientesAtendidos` e imprime un mensaje.

**Implementa** `registrar()` y `darDeBaja()` con mensajes apropiados para un médico.

---

#### Clase `MedicoCirujano` (extiende `MedicoGeneral`, implementa `Operable`)

**Atributos adicionales:**
- `quirofano` de tipo `int`
- `operacionesPendientes` de tipo `ArrayList<String>`

**Constructor:** recibe `nombre`, `dni`, `consultorio` y `quirofano`.

**Implementa** todos los métodos de `Operable`.

`programarOperacion()` debe agregar la operación a `operacionesPendientes`.

`realizarOperacion()` debe ejecutar la primera operación pendiente y eliminarla de la lista. Si no hay operaciones pendientes, imprime `"No hay operaciones programadas"`.

---

#### Clase `Hospital`

**Atributos:**
- `nombre` de tipo `String`
- `personas` de tipo `ArrayList<Persona>`

**Constructor:** recibe el nombre del hospital.

**Métodos:**
- `registrarPersona(Persona p)`: agrega la persona a la lista y llama a `registrar()`.
- `darDeBajaPersona(String dni)`: busca a la persona por DNI, llama a `darDeBaja()` y la elimina de la lista. Si no existe, imprime `"Persona no encontrada"`.
- `listarPersonas()`: imprime el nombre y DNI de todas las personas registradas.
- `contarPacientes()`: retorna cuántos objetos de tipo `Paciente` hay en la lista.
- `contarMedicos()`: retorna cuántos objetos de tipo `MedicoGeneral` (o subclases) hay en la lista.

---

#### Clase `Main`

En el `main`:

1. Crea una instancia de `Hospital` con el nombre `"Hospital San Juan"`.
2. Crea al menos **2 pacientes**, **1 médico general** y **1 médico cirujano**.
3. Registra a todos en el hospital usando `registrarPersona()`.
4. Lista todas las personas registradas.
5. El médico general atiende a un paciente, emite un diagnóstico y solicita un examen.
6. El médico cirujano programa 2 operaciones y luego las realiza una por una.
7. Uno de los pacientes es internado.
8. Da de baja a uno de los pacientes por DNI.
9. Imprime cuántos pacientes y médicos quedan registrados.

---

## Criterios de Evaluación

| Sección    | Puntaje | Criterios |
|------------|---------|-----------|
| Sección 1  | 4 pts   | Lógica correcta, uso adecuado de bucles y condicionales, manejo de Strings |
| Sección 2  | 5 pts   | Encapsulamiento correcto, uso de `static`, constructores sobrecargados, validaciones |
| Sección 3  | 5 pts   | Jerarquía correcta, métodos abstractos, `@Override`, polimorfismo en colecciones |
| Sección 4  | 6 pts   | Interfaces implementadas correctamente, relaciones entre clases, integración del sistema |
| **Total**  | **20 pts** | |

---

## Instrucciones Generales

- Escribe todo el código en Java.
- Cada clase debe estar en su propio archivo `.java`.
- Organiza las clases en un paquete llamado `examen`.
- No uses librerías externas; solo las de `java.util`.
- El código debe compilar y ejecutarse sin errores.
- Usa nombres descriptivos para variables y métodos.
- Aplica encapsulamiento donde corresponda (`private`, `protected`).
