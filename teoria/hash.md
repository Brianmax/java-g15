# Hash en Java

## Qué es un Hash

Función que convierte datos en un número entero (código hash). Permite acceso O(1).

```java
"hola".hashCode()  // 3208380
"chau".hashCode()  // 3052837
```

Mismo valor → mismo hash (siempre).
Diferente valor → probablemente diferente hash (colisiones posibles).

---

## HashMap

Almacena pares clave-valor. Acceso O(1) por clave.

```java
import java.util.HashMap;

HashMap<String, Integer> edades = new HashMap<>();
```

### Operaciones básicas

```java
HashMap<String, Integer> map = new HashMap<>();

map.put("Ana", 25);      // agregar
map.put("Luis", 30);
map.put("Ana", 26);      // sobrescribe si clave existe

map.get("Ana");          // 26
map.get("Pedro");        // null (no existe)
map.getOrDefault("Pedro", 0);  // 0 (valor por defecto)

map.containsKey("Ana");  // true
map.containsValue(30);   // true

map.remove("Luis");      // eliminar por clave
map.size();              // 1
map.isEmpty();           // false
map.clear();             // vaciar
```

### Recorrer HashMap

```java
HashMap<String, Integer> map = new HashMap<>();
map.put("Ana", 25);
map.put("Luis", 30);

// solo claves
for (String clave : map.keySet()) {
    System.out.println(clave);
}

// solo valores
for (Integer valor : map.values()) {
    System.out.println(valor);
}

// clave y valor
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

---

## HashSet

Colección de elementos únicos (sin duplicados). Acceso O(1).

```java
import java.util.HashSet;

HashSet<String> set = new HashSet<>();
```

### Operaciones básicas

```java
HashSet<Integer> set = new HashSet<>();

set.add(10);        // agregar
set.add(20);
set.add(10);        // ignorado (ya existe)

set.contains(10);   // true
set.remove(20);     // eliminar
set.size();         // 1
```

### Recorrer HashSet

```java
for (Integer n : set) {
    System.out.println(n);
}
```

### Uso común: eliminar duplicados

```java
ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 3));
HashSet<Integer> unicos = new HashSet<>(lista);  // {1, 2, 3}
```

---

## Cómo funciona internamente

HashMap usa un array de "buckets":

```
Índice = hashCode(clave) % capacidad

clave "Ana" → hashCode = 65599 → 65599 % 16 = 15

Buckets:
[0] → null
[1] → null
...
[15] → ("Ana", 25)
```

### Colisiones

Cuando dos claves caen en el mismo bucket:

```
"Ana"  → bucket 15
"Dan"  → bucket 15  (colisión)

[15] → ("Ana", 25) → ("Dan", 22)  // lista enlazada
```

---

## Comparación

| Estructura | Qué guarda | Duplicados | Orden |
|------------|------------|------------|-------|
| HashMap | clave-valor | claves únicas | no garantizado |
| HashSet | valores | no permite | no garantizado |
| LinkedHashMap | clave-valor | claves únicas | orden de inserción |
| TreeMap | clave-valor | claves únicas | ordenado por clave |

---

## hashCode y equals

Para usar objetos propios como clave, sobrescribir ambos:

```java
public class Persona {
    String nombre;
    int edad;

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persona otra = (Persona) obj;
        return edad == otra.edad && Objects.equals(nombre, otra.nombre);
    }
}
```

**Regla:** si `a.equals(b)` es true, entonces `a.hashCode() == b.hashCode()` debe ser true.
