# Pico y placa API

## Descripción
Esta es una aplicación Java Spring Boot que proporciona una API REST para gestionar las restricciones de los coches basadas en los números de matrícula y las fechas. La aplicación utiliza Gradle como herramienta de construcción.

## Características
- Comprobar si un coche es válido para conducir basándose en su matrícula y la fecha actual.

## Tecnologías Utilizadas
- Java
- Spring Boot
- Gradle

## Configuración e Instalación
1. Clona el repositorio en tu máquina local.
2. Navega hasta el directorio del proyecto.
3. Ejecuta `./gradlew build` para construir el proyecto.
4. Ejecuta `./gradlew bootRun` para iniciar la aplicación.

## Puntos Finales de la API
- `GET /api/cars/isValidToDrive?licensePlate={licensePlate}&currentDate={currentDate}`: Comprueba si un coche con la matrícula dada es válido para conducir en la fecha dada.

## Estructura del Código
- `api.advance.util.Constants`: Contiene los valores constantes utilizados en toda la aplicación.
- `api.advance.util.Helper`: Contiene los métodos auxiliares para la aplicación.
- `api.advance.controllers.CarRestController`: Contiene los puntos finales de la API REST.
- `api.advance.service.CarService`: Contiene la lógica de negocio para la aplicación.
