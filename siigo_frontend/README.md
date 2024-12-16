# Siigo Frontend

## Requisitos Mínimos
- Java 21 instalado y configurado.
- Maven 3.8.1 o superior.
- Navegador Chrome instalado para pruebas automatizadas.
- WebDriver configurado (Serenity BDD se encarga de gestionarlo automáticamente).

### Compilar
```bash
mvn clean install
```

### Ejecutar pruebas
```bash
mvn clean verify -Dcucumber.options='@CP008'
```