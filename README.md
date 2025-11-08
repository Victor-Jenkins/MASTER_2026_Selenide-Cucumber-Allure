# Selenide-Cucumber-Allure_2026

Tecnologías usadas

Selenide
 – Automatización de UI en Java.

Cucumber
 – BDD y definición de escenarios en lenguaje natural.

Allure
 – Generación de reportes visuales de test.

JUnit 5
 – Framework de tests unitarios y de integración.

WebDriverManager
 – Manejo automático de drivers de navegador.

GitHub Actions
 – CI/CD y despliegue automático en GitHub Pages.


 # Selenide-Cucumber-Allure_2026

Automated UI tests with **Selenide**, **Cucumber**, and **Allure**.  

---



Todos los tests se ejecutan automáticamente en cada push a `main` o pull request.  

---

## Reporte Allure

El reporte Allure se actualiza automáticamente con cada ejecución y se publica en GitHub Pages:



---

## Ejecutar localmente

Para ejecutar los tests y ver el reporte localmente:

```bash

mvn clean test -X

mvn allure:report
allure serve target/allure-results
