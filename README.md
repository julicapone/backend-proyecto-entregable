# backend-proyecto-entregable

```
Ejemplo de POST http://localhost:8080/odontologos/

{
    "apellido":"Holmes",
    "nombre":"Sherlock",
    "matricula":32
}
```
```
Ejemplo de POST http://localhost:8080/pacientes/

{
    "apellido":"Watson",
    "nombre":"John",
    "dni":"37956400",
    "domicilio":"Pampa 3268",
    "fechaIngreso":"2021-09-30"
}
```
```
Ejemplo de POST http://localhost:8080/pacientes/

{
    "odontologo":{
        "id":1,
        "apellido":"Holmes",
        "nombre":"Sherlock",
        "matricula":32
    },
    "paciente":{
        "id":1,
        "apellido":"Watson",
        "nombre":"John",
        "dni":"37956400",
        "domicilio":"Pampa 3268",
        "fechaIngreso":"2021-09-30"
    }
}
```
