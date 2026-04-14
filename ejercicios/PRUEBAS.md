# Casos de Prueba — API Clínica Veterinaria

Ejecuta cada caso en orden. Los IDs de respuesta variarán, pero la **estructura y los datos** deben coincidir exactamente.

> **Criterios generales:**
> - La integración con **Feign (RENIEC)** es **obligatoria** — los campos `nombres` y `apellidos` deben provenir de la API externa, no del request.
> - El desglose de errores de validación agrupados por campo es **opcional** — basta con retornar HTTP 400.

---

## Parte 1 — Registrar Propietarios

### Caso 1.1 — Registro exitoso (DNI: 72224426)

**Request:**
```bash
curl -X POST http://localhost:8080/api/v1/propietario/save \
  -H "Content-Type: application/json" \
  -d '{
    "email": "jerico.chicoma@email.com",
    "telefono": "987654321",
    "dni": "72224426",
    "direccion": "Av. Lima 123"
  }'
```

**Response esperado — HTTP 201:**
```json
{
  "success": true,
  "message": "Propietario registrado exitosamente",
  "data": {
    "id": "<uuid-generado>",
    "nombres": "JERICO BALTAZAR",
    "apellidos": "CHICOMA VARELA",
    "email": "jerico.chicoma@email.com",
    "telefono": "987654321",
    "direccion": "Av. Lima 123",
    "fechaRegistro": "<fecha-actual>",
    "mascotas": null
  }
}
```

> `nombres` y `apellidos` deben venir de RENIEC, no del request.

---

### Caso 1.2 — Registro exitoso (DNI: 71224426)

**Request:**
```bash
curl -X POST http://localhost:8080/api/v1/propietario/save \
  -H "Content-Type: application/json" \
  -d '{
    "email": "abel.crespo@email.com",
    "telefono": "912345678",
    "dni": "71224426",
    "direccion": "Jr. Miraflores 456"
  }'
```

**Response esperado — HTTP 201:**
```json
{
  "success": true,
  "message": "Propietario registrado exitosamente",
  "data": {
    "id": "<uuid-generado>",
    "nombres": "ABEL",
    "apellidos": "CRESPO CHAVEZ",
    "email": "abel.crespo@email.com",
    "telefono": "912345678",
    "direccion": "Jr. Miraflores 456",
    "fechaRegistro": "<fecha-actual>",
    "mascotas": null
  }
}
```

---

### Caso 1.3 — Registro exitoso (DNI: 71224424)

**Request:**
```bash
curl -X POST http://localhost:8080/api/v1/propietario/save \
  -H "Content-Type: application/json" \
  -d '{
    "email": "junior.estela@email.com",
    "telefono": "945678123",
    "dni": "71224424",
    "direccion": "Calle Real 789"
  }'
```

**Response esperado — HTTP 201:**
```json
{
  "success": true,
  "message": "Propietario registrado exitosamente",
  "data": {
    "id": "<uuid-generado>",
    "nombres": "JUNIOR ZAIR",
    "apellidos": "ESTELA REYES",
    "email": "junior.estela@email.com",
    "telefono": "945678123",
    "direccion": "Calle Real 789",
    "fechaRegistro": "<fecha-actual>",
    "mascotas": null
  }
}
```

---

### Caso 1.4 — Email duplicado

**Request:**
```bash
curl -X POST http://localhost:8080/api/v1/propietario/save \
  -H "Content-Type: application/json" \
  -d '{
    "email": "jerico.chicoma@email.com",
    "telefono": "999999999",
    "dni": "72224426",
    "direccion": "Otra direccion"
  }'
```

**Response esperado — HTTP 409:**
```json
{
  "success": false,
  "message": "Ya existe un propietario registrado con ese email",
  "data": null
}
```

---

### Caso 1.5 — Validaciones fallidas

**Request:**
```bash
curl -X POST http://localhost:8080/api/v1/propietario/save \
  -H "Content-Type: application/json" \
  -d '{
    "email": "no-es-email",
    "telefono": "abc",
    "dni": "123",
    "direccion": ""
  }'
```

**Mínimo requerido — HTTP 400:**
```json
{
  "success": false,
  "message": "<cualquier mensaje>",
  "data": null
}
```

**Respuesta completa (opcional) — HTTP 400:**
```json
{
  "success": false,
  "message": "Error de validacion",
  "data": {
    "email": ["<mensaje de error>"],
    "telefono": ["<mensaje de error>"],
    "dni": ["<mensaje de error>"],
    "direccion": ["<mensaje de error>"]
  }
}
```

---

## Parte 2 — Buscar Propietarios

### Caso 2.1 — Buscar por ID existente

> Usa el `id` retornado en el Caso 1.1.

**Request:**
```bash
curl -X GET http://localhost:8080/api/v1/propietario/find/<id-caso-1.1>
```

**Response esperado — HTTP 200:**
```json
{
  "success": true,
  "message": "Propietario encontrado",
  "data": {
    "id": "<uuid>",
    "nombres": "JERICO BALTAZAR",
    "apellidos": "CHICOMA VARELA",
    "email": "jerico.chicoma@email.com",
    "telefono": "987654321",
    "direccion": "Av. Lima 123",
    "fechaRegistro": "<fecha-actual>",
    "mascotas": []
  }
}
```

---

### Caso 2.2 — Buscar por ID inexistente

**Request:**
```bash
curl -X GET http://localhost:8080/api/v1/propietario/find/00000000-0000-0000-0000-000000000000
```

**Response esperado — HTTP 404:**
```json
{
  "success": false,
  "message": "Propietario no encontrado",
  "data": null
}
```

---

### Caso 2.3 — Buscar por apellido en minúsculas

**Request:**
```bash
curl -X GET http://localhost:8080/api/v1/propietario/find/apellido/crespo
```

**Response esperado — HTTP 200:**
```json
{
  "success": true,
  "message": "Propietarios encontrados",
  "data": [
    {
      "id": "<uuid>",
      "nombres": "ABEL",
      "apellidos": "CRESPO CHAVEZ",
      "email": "abel.crespo@email.com",
      "telefono": "912345678",
      "direccion": "Jr. Miraflores 456",
      "fechaRegistro": "<fecha-actual>",
      "mascotas": []
    }
  ]
}
```

---

### Caso 2.4 — Buscar por apellido en mayúsculas (case-insensitive)

**Request:**
```bash
curl -X GET http://localhost:8080/api/v1/propietario/find/apellido/ESTELA
```

**Response esperado — HTTP 200:**
```json
{
  "success": true,
  "message": "Propietarios encontrados",
  "data": [
    {
      "id": "<uuid>",
      "nombres": "JUNIOR ZAIR",
      "apellidos": "ESTELA REYES",
      "email": "junior.estela@email.com",
      "telefono": "945678123",
      "direccion": "Calle Real 789",
      "fechaRegistro": "<fecha-actual>",
      "mascotas": []
    }
  ]
}
```

> La búsqueda debe funcionar en minúsculas, mayúsculas y de forma parcial (ej: `est` también debe retornar a ESTELA REYES).

---

## Parte 3 — Registrar Mascotas

> Para los casos siguientes, reemplaza `<id-propietario-X>` con el `id` retornado en el Caso 1.X correspondiente.

### Caso 3.1 — Registrar perro para propietario 1

**Request:**
```bash
curl -X POST http://localhost:8080/api/v1/mascota/save \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Firulais",
    "especie": "perro",
    "raza": "Labrador",
    "fechaNacimiento": "2021-03-15",
    "peso": 25.5,
    "propietarioId": "<id-propietario-1>"
  }'
```

**Response esperado — HTTP 201:**
```json
{
  "success": true,
  "message": "Mascota registrada exitosamente",
  "data": {
    "id": "<uuid-generado>",
    "nombre": "Firulais",
    "especie": "perro",
    "raza": "Labrador",
    "peso": 25.5,
    "fechaNacimiento": "<fecha>"
  }
}
```

---

### Caso 3.2 — Registrar gato para propietario 1

**Request:**
```bash
curl -X POST http://localhost:8080/api/v1/mascota/save \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Mishi",
    "especie": "gato",
    "raza": "Siames",
    "fechaNacimiento": "2020-06-01",
    "peso": 4.2,
    "propietarioId": "<id-propietario-1>"
  }'
```

**Response esperado — HTTP 201:**
```json
{
  "success": true,
  "message": "Mascota registrada exitosamente",
  "data": {
    "id": "<uuid-generado>",
    "nombre": "Mishi",
    "especie": "gato",
    "raza": "Siames",
    "peso": 4.2,
    "fechaNacimiento": "<fecha>"
  }
}
```

---

### Caso 3.3 — Registrar ave para propietario 2

**Request:**
```bash
curl -X POST http://localhost:8080/api/v1/mascota/save \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Piolín",
    "especie": "ave",
    "raza": "Canario",
    "fechaNacimiento": "2022-01-10",
    "peso": 0.05,
    "propietarioId": "<id-propietario-2>"
  }'
```

**Response esperado — HTTP 201:**
```json
{
  "success": true,
  "message": "Mascota registrada exitosamente",
  "data": {
    "id": "<uuid-generado>",
    "nombre": "Piolín",
    "especie": "ave",
    "raza": "Canario",
    "peso": 0.05,
    "fechaNacimiento": "<fecha>"
  }
}
```

---

### Caso 3.4 — Registrar perro para propietario 3

**Request:**
```bash
curl -X POST http://localhost:8080/api/v1/mascota/save \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Rocky",
    "especie": "perro",
    "raza": "Pastor Alemán",
    "fechaNacimiento": "2019-11-20",
    "peso": 32.0,
    "propietarioId": "<id-propietario-3>"
  }'
```

**Response esperado — HTTP 201:**
```json
{
  "success": true,
  "message": "Mascota registrada exitosamente",
  "data": {
    "id": "<uuid-generado>",
    "nombre": "Rocky",
    "especie": "perro",
    "raza": "Pastor Alemán",
    "peso": 32.0,
    "fechaNacimiento": "<fecha>"
  }
}
```

---

### Caso 3.5 — Propietario inexistente

**Request:**
```bash
curl -X POST http://localhost:8080/api/v1/mascota/save \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Rex",
    "especie": "perro",
    "fechaNacimiento": "2021-01-01",
    "peso": 10.0,
    "propietarioId": "00000000-0000-0000-0000-000000000000"
  }'
```

**Response esperado — HTTP 404:**
```json
{
  "success": false,
  "message": "Propietario no encontrado",
  "data": null
}
```

---

### Caso 3.6 — Validaciones fallidas

**Request:**
```bash
curl -X POST http://localhost:8080/api/v1/mascota/save \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "",
    "especie": "",
    "fechaNacimiento": "2030-01-01",
    "peso": -5.0,
    "propietarioId": "00000000-0000-0000-0000-000000000000"
  }'
```

**Mínimo requerido — HTTP 400:**
```json
{
  "success": false,
  "message": "<cualquier mensaje>",
  "data": null
}
```

**Respuesta completa (opcional) — HTTP 400:**
```json
{
  "success": false,
  "message": "Error de validacion",
  "data": {
    "nombre": ["<mensaje de error>"],
    "especie": ["<mensaje de error>"],
    "fechaNacimiento": ["<mensaje de error>"],
    "peso": ["<mensaje de error>"]
  }
}
```

---

## Parte 4 — Buscar Mascotas

### Caso 4.1 — Buscar por especie "perro"

> Ejecutar **después** de registrar los Casos 3.1 al 3.4.

**Request:**
```bash
curl -X GET http://localhost:8080/api/v1/mascota/find/especie/perro
```

**Response esperado — HTTP 200:**
```json
{
  "success": true,
  "message": "Mascotas encontradas",
  "data": [
    {
      "id": "<uuid>",
      "nombre": "Firulais",
      "especie": "perro",
      "raza": "Labrador",
      "peso": 25.5,
      "fechaNacimiento": "<fecha>"
    },
    {
      "id": "<uuid>",
      "nombre": "Rocky",
      "especie": "perro",
      "raza": "Pastor Alemán",
      "peso": 32.0,
      "fechaNacimiento": "<fecha>"
    }
  ]
}
```

> Deben retornar **2 mascotas**: Firulais y Rocky.

---

### Caso 4.2 — Buscar por especie en mayúsculas (case-insensitive)

**Request:**
```bash
curl -X GET http://localhost:8080/api/v1/mascota/find/especie/GATO
```

**Response esperado — HTTP 200:**
```json
{
  "success": true,
  "message": "Mascotas encontradas",
  "data": [
    {
      "id": "<uuid>",
      "nombre": "Mishi",
      "especie": "gato",
      "raza": "Siames",
      "peso": 4.2,
      "fechaNacimiento": "<fecha>"
    }
  ]
}
```

---

### Caso 4.3 — Buscar por especie "ave"

**Request:**
```bash
curl -X GET http://localhost:8080/api/v1/mascota/find/especie/ave
```

**Response esperado — HTTP 200:**
```json
{
  "success": true,
  "message": "Mascotas encontradas",
  "data": [
    {
      "id": "<uuid>",
      "nombre": "Piolín",
      "especie": "ave",
      "raza": "Canario",
      "peso": 0.05,
      "fechaNacimiento": "<fecha>"
    }
  ]
}
```

---

## Parte 5 — Verificación final: Propietario con sus mascotas

### Caso 5.1 — Propietario 1 debe tener 2 mascotas

> Ejecutar **después** de los Casos 3.1 y 3.2.

**Request:**
```bash
curl -X GET http://localhost:8080/api/v1/propietario/find/<id-propietario-1>
```

**Response esperado — HTTP 200:**
```json
{
  "success": true,
  "message": "Propietario encontrado",
  "data": {
    "id": "<uuid>",
    "nombres": "JERICO BALTAZAR",
    "apellidos": "CHICOMA VARELA",
    "email": "jerico.chicoma@email.com",
    "telefono": "987654321",
    "direccion": "Av. Lima 123",
    "fechaRegistro": "<fecha-actual>",
    "mascotas": [
      {
        "id": "<uuid>",
        "nombre": "Firulais",
        "especie": "perro",
        "raza": "Labrador",
        "peso": 25.5,
        "fechaNacimiento": "<fecha>"
      },
      {
        "id": "<uuid>",
        "nombre": "Mishi",
        "especie": "gato",
        "raza": "Siames",
        "peso": 4.2,
        "fechaNacimiento": "<fecha>"
      }
    ]
  }
}
```

> El campo `mascotas` debe ser una lista con **exactamente 2 elementos**.

---

## Resumen de criterios

| Caso | Endpoint | Obligatorio | Lo que se evalúa |
|------|----------|:-----------:|------------------|
| 1.1 – 1.3 | `POST /propietario/save` | ✅ | Feign RENIEC setea nombres/apellidos, HTTP 201 |
| 1.4 | `POST /propietario/save` | ✅ | Detección de email duplicado, HTTP 409 |
| 1.5 | `POST /propietario/save` | ⚠️ opcional | HTTP 400 (desglose por campo es plus) |
| 2.1 | `GET /propietario/find/{id}` | ✅ | Propietario encontrado con lista de mascotas |
| 2.2 | `GET /propietario/find/{id}` | ✅ | HTTP 404 con mensaje correcto |
| 2.3 – 2.4 | `GET /propietario/find/apellido/{apellido}` | ✅ | Búsqueda parcial case-insensitive |
| 3.1 – 3.4 | `POST /mascota/save` | ✅ | Mascota creada y asignada al propietario, HTTP 201 |
| 3.5 | `POST /mascota/save` | ✅ | Propietario no encontrado, HTTP 404 |
| 3.6 | `POST /mascota/save` | ⚠️ opcional | HTTP 400 (desglose por campo es plus) |
| 4.1 – 4.3 | `GET /mascota/find/especie/{especie}` | ✅ | Filtro case-insensitive, cantidad correcta |
| 5.1 | `GET /propietario/find/{id}` | ✅ | Lista de mascotas embebida en el propietario |
