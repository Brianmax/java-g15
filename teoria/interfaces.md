# Interfaces en Java

Contrato que define métodos que una clase debe implementar.

## Definición

```java
public interface ICalculadora {
    int suma(int a, int b);
    int resta(int a, int b);
}
```

Los métodos en una interfaz son abstractos por defecto (sin implementación).

## Implementación

```java
public class Calculadora implements ICalculadora {
    @Override
    public int suma(int a, int b) {
        return a + b;
    }

    @Override
    public int resta(int a, int b) {
        return a - b;
    }
}
```

## Variable de tipo interfaz

```java
ICalculadora calc = new Calculadora();
calc.suma(5, 3);  // 8
```

Solo puede acceder a métodos definidos en la interfaz.

## Múltiples interfaces

Java no permite herencia múltiple de clases, pero sí implementar múltiples interfaces:

```java
public interface IBasica {
    int suma(int a, int b);
}

public interface IAvanzada {
    int multiplicacion(int a, int b);
}

public class Calculadora implements IBasica, IAvanzada {
    @Override
    public int suma(int a, int b) { return a + b; }

    @Override
    public int multiplicacion(int a, int b) { return a * b; }
}
```
