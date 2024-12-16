# Reto Automation

Este proyecto es un framework de automatización de pruebas diseñado para cubrir pruebas de frontend, backend y performance, utilizando herramientas modernas como Serenity BDD, Screenplay Pattern, y Gatling.

## Estructura del Proyecto
El proyecto está dividido en tres subproyectos independientes:

1. Frontend: Automatización de pruebas para interfaces de usuario web, utilizando:
    - Serenity BDD con Screenplay Pattern.
    - Soporte para navegadores como Chrome.
    - Casos de prueba escritos en Gherkin.
2. Backend: Automatización de pruebas para servicios RESTful, utilizando:
    - Serenity Rest Assured para validar APIs.
    - Patrón Screenplay para organizar tareas y validaciones.
    - Cobertura de endpoints de creación, consulta, actualización y eliminación.
3. Performance: Pruebas de rendimiento diseñadas para evaluar la carga y capacidad de las APIs backend, utilizando:
    - Gatling como herramienta de pruebas de carga.
    - Escnarios configurados para cargas graduales y sostenidas.