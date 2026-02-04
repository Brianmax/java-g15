# Condicionales en Java

Permiten ejecutar código según una condición.

## Estructura básica

```java
if (condicion) {
    // si es verdadera
} else {
    // si es falsa
}
```

### Ejemplo: par o impar

```java
if (n % 2 == 0) {
    System.out.println("Par");
} else {
    System.out.println("Impar");
}
```

## else if

Para evaluar múltiples condiciones:

```java
if (n > m) {
    System.out.println("n es mayor");
} else if (n < m) {
    System.out.println("m es mayor");
} else {
    System.out.println("Son iguales");
}
```

### Ejemplo: mayor de tres números

```java
if (a >= b && a >= c) {
    System.out.println(a);
} else if (b >= a && b >= c) {
    System.out.println(b);
} else {
    System.out.println(c);
}
```

## Operadores de comparación

| Operador | Significado |
|----------|-------------|
| `==` | Igual a |
| `!=` | Diferente de |
| `<` | Menor que |
| `>` | Mayor que |
| `<=` | Menor o igual |
| `>=` | Mayor o igual |

## Operadores lógicos

| Operador | Significado |
|----------|-------------|
| `&&` | AND (ambas verdaderas) |
| `\|\|` | OR (al menos una verdadera) |
| `!` | NOT (niega) |

```java
if (edad >= 18 && edad <= 65) {
    System.out.println("Edad laboral");
}
```
