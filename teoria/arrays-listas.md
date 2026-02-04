# Arrays y Listas en Java

## Arrays

Colección de tamaño fijo del mismo tipo.

### Declaración e inicialización

```java
// Declarar con tamaño
int[] numeros = new int[5];  // [0, 0, 0, 0, 0]

// Declarar con valores
int[] numeros = {10, 20, 30, 40, 50};
String[] nombres = {"Ana", "Luis", "Pedro"};
```

### Acceso y modificación

```java
int[] nums = {10, 20, 30};
nums[0]      // 10 (primer elemento)
nums[2]      // 30 (último elemento)
nums[1] = 25 // modificar: [10, 25, 30]
nums.length  // 3 (tamaño)
```

Los índices van de `0` a `length - 1`.

### Recorrer array

```java
// con for tradicional
for (int i = 0; i < nums.length; i++) {
    System.out.println(nums[i]);
}

// con for-each
for (int n : nums) {
    System.out.println(n);
}
```

### Arrays multidimensionales

```java
int[][] matriz = {
    {1, 2, 3},
    {4, 5, 6}
};

matriz[0][0]  // 1
matriz[1][2]  // 6
matriz.length       // 2 (filas)
matriz[0].length    // 3 (columnas)
```

---

## ArrayList

Array dinámico que puede crecer/reducir su tamaño.

```java
import java.util.ArrayList;

ArrayList<String> lista = new ArrayList<>();
```

### Operaciones básicas

```java
ArrayList<Integer> nums = new ArrayList<>();

nums.add(10);        // agregar al final: [10]
nums.add(20);        // [10, 20]
nums.add(0, 5);      // insertar en índice 0: [5, 10, 20]

nums.get(1);         // 10 (obtener elemento)
nums.set(1, 15);     // modificar: [5, 15, 20]

nums.remove(0);      // eliminar por índice: [15, 20]
nums.remove(Integer.valueOf(20));  // eliminar por valor: [15]

nums.size();         // 1 (tamaño)
nums.isEmpty();      // false
nums.contains(15);   // true
nums.clear();        // vaciar lista
```

### Recorrer ArrayList

```java
ArrayList<String> nombres = new ArrayList<>();
nombres.add("Ana");
nombres.add("Luis");

// for-each
for (String nombre : nombres) {
    System.out.println(nombre);
}

// for tradicional
for (int i = 0; i < nombres.size(); i++) {
    System.out.println(nombres.get(i));
}
```

---

## LinkedList

Lista doblemente enlazada. Eficiente para insertar/eliminar al inicio o final.

```java
import java.util.LinkedList;

LinkedList<String> lista = new LinkedList<>();
```

### Operaciones básicas

```java
LinkedList<Integer> nums = new LinkedList<>();

// mismos métodos que ArrayList
nums.add(10);
nums.get(0);
nums.remove(0);

// métodos específicos de LinkedList
nums.addFirst(5);    // agregar al inicio
nums.addLast(20);    // agregar al final
nums.getFirst();     // obtener primero
nums.getLast();      // obtener último
nums.removeFirst();  // eliminar primero
nums.removeLast();   // eliminar último
```

### Uso como Cola (Queue) o Pila (Stack)

```java
LinkedList<Integer> cola = new LinkedList<>();
cola.offer(1);    // encolar
cola.poll();      // desencolar (retorna y elimina el primero)
cola.peek();      // ver primero sin eliminar

LinkedList<Integer> pila = new LinkedList<>();
pila.push(1);     // apilar
pila.pop();       // desapilar
pila.peek();      // ver tope
```

---

## Comparación

| Característica | Array | ArrayList | LinkedList |
|----------------|-------|-----------|------------|
| Tamaño | Fijo | Dinámico | Dinámico |
| Acceso por índice | O(1) rápido | O(1) rápido | O(n) lento |
| Insertar/eliminar al inicio | - | O(n) lento | O(1) rápido |
| Insertar/eliminar al final | - | O(1)* rápido | O(1) rápido |
| Memoria | Menos | Media | Más |

*Amortizado

### Cuándo usar cada uno

- **Array**: tamaño conocido y fijo, máximo rendimiento
- **ArrayList**: tamaño variable, acceso frecuente por índice
- **LinkedList**: muchas inserciones/eliminaciones al inicio/final, implementar colas o pilas
