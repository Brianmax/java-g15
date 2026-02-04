# Loops en Java

Repiten un bloque de código.

## for

Cuando sabes cuántas veces repetir:

```java
for (inicialización; condición; actualización) {
    // código
}
```

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);  // 0, 1, 2, 3, 4
}
```

- `int i = 0` → se ejecuta una vez al inicio
- `i < 5` → se evalúa antes de cada iteración
- `i++` → se ejecuta al final de cada iteración

## while

Cuando no sabes cuántas veces repetir:

```java
while (condición) {
    // código
}
```

```java
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}
```

### Ejemplo: Conjetura de Collatz

Si n es par → dividir entre 2. Si es impar → multiplicar por 3 y sumar 1. Siempre llega a 1.

```java
while (n != 1) {
    System.out.println(n);
    if (n % 2 == 0) {
        n = n / 2;
    } else {
        n = 3 * n + 1;
    }
}
```

## do-while

Se ejecuta al menos una vez:

```java
do {
    // código
} while (condición);
```

## break y continue

- `break` → sale del loop
- `continue` → salta a la siguiente iteración

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) break;      // termina en 5
    if (i % 2 == 0) continue; // salta pares
    System.out.println(i);  // 1, 3
}
```
