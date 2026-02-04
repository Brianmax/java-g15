# Programación Orientada a Objetos

Paradigma que organiza el código en objetos con atributos (datos) y métodos (comportamiento).

## Clases y Objetos

- **Clase**: plantilla para crear objetos
- **Objeto**: instancia de una clase

```java
public class Dog {
    // atributos
    String breed;
    int age;

    // métodos
    void bark() {
        System.out.println("Woof");
    }
}
```

## Instanciación

```java
Dog myDog = new Dog();    // crear objeto
myDog.breed = "Labrador"; // acceder atributo
myDog.age = 3;
myDog.bark();             // llamar método
```

Cada objeto tiene su propia copia de los atributos.

## Métodos con parámetros y retorno

```java
public class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    void greet(String name) {  // void = no retorna nada
        System.out.println("Hola " + name);
    }
}
```

```java
Calculator calc = new Calculator();
int result = calc.add(5, 3);  // 8
```

## Constructor

Método especial que se ejecuta al crear el objeto. Mismo nombre que la clase, sin tipo de retorno.

```java
public class Dog {
    String breed;
    int age;

    Dog(String breed, int age) {
        this.breed = breed;  // this = atributo de la clase
        this.age = age;
    }
}
```

```java
Dog myDog = new Dog("Labrador", 3);
```

`this` diferencia el atributo del parámetro cuando tienen el mismo nombre.

## Encapsulamiento

Ocultar atributos y exponer solo métodos controlados (getters/setters).

```java
public class Dog {
    private String breed;  // no accesible desde fuera

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
```

### Modificadores de acceso

| Modificador | Acceso |
|-------------|--------|
| `public` | Desde cualquier clase |
| `private` | Solo desde la misma clase |
| `protected` | Misma clase, paquete y subclases |
| (default) | Misma clase y paquete |
