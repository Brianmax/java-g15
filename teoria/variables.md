# Variables en Java

Una variable es un espacio de memoria para almacenar un dato.

## Declaración

```java
tipo nombre = valor;
```

```java
int numero = 10;
```

## Tipos de datos

| Tipo | Descripción |
|------|-------------|
| `byte`, `short`, `int`, `long` | Enteros (de menor a mayor capacidad) |
| `float` | Decimales hasta 7 dígitos |
| `double` | Decimales hasta 15 dígitos |
| `char` | Un solo carácter |
| `String` | Cadena de texto |
| `boolean` | `true` o `false` |

```java
int edad = 25;
double altura = 1.75;
float precio = 10.5f;  // requiere 'f' al final
String nombre = "Juan";
boolean activo = true;
```

## Operaciones aritméticas

```java
int a = 10, b = 3;
a + b   // 13 (suma)
a - b   // 7 (resta)
a * b   // 30 (multiplicación)
a / b   // 3 (división entera)
a % b   // 1 (residuo)
```

### División: cuidado con los tipos

```java
int a = 5, b = 3;
a / b              // 1 (int/int = int, trunca)
(float) a / b      // 1.666... (casting a decimal)
5.0 / 3            // 1.666... (al menos uno decimal)
```

## Modificar variables

```java
int n = 5;
n = 10;       // asignar nuevo valor
n = n + 3;    // usar valor actual (n = 13)
n = n * 2;    // n = 26
```

## Concatenación de Strings

```java
String nombre = "Juan";
String apellido = "Perez";
String completo = nombre + " " + apellido;  // "Juan Perez"
```

## Input con Scanner

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
int numero = sc.nextInt();      // lee entero
String texto = sc.nextLine();   // lee línea
```
