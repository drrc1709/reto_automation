# Siigo Backend

## Requisitos Mínimos
- Java 21 instalado y configurado.
- Maven 3.8.1 o superior.
- Herramienta de testing para APIs: Serenity Rest Assured.

### Compilar
```bash
mvn clean install
```

### Ejecutar pruebas
```bash
mvn clean verify -Dcucumber.options='@createUser'
```