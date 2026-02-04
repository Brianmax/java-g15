# Clases Abstractas en Java

Clase que no puede instanciarse directamente y puede contener métodos abstractos (sin implementación).

## Definición

```java
public abstract class Figura {
    private String color;

    public Figura(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    // métodos abstractos: las subclases DEBEN implementarlos
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
}
```

## Herencia

Se usa `extends`. Una clase solo puede heredar de una clase abstracta.

```java
public class Circulo extends Figura {
    private double radio;

    public Circulo(String color, double radio) {
        super(color);  // llama al constructor del padre
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}
```

```java
public class Rectangulo extends Figura {
    private double base, altura;

    public Rectangulo(String color, double base, double altura) {
        super(color);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}
```

## Polimorfismo

Variable de tipo padre puede referenciar objetos hijos:

```java
Figura f1 = new Circulo("rojo", 5);
Figura f2 = new Rectangulo("azul", 4, 3);

f1.calcularArea();  // usa implementación de Circulo
f2.calcularArea();  // usa implementación de Rectangulo
```

Para acceder a métodos específicos de la subclase, usar casting:

```java
Circulo c = (Circulo) f1;
```

## Interfaz vs Clase Abstracta

| Interfaz | Clase Abstracta |
|----------|-----------------|
| `implements` | `extends` |
| Múltiples interfaces | Solo una clase padre |
| Solo métodos abstractos* | Métodos concretos y abstractos |
| Sin constructor | Puede tener constructor |

*Java 8+ permite métodos default en interfaces.
