

### - Domain Driven Design 🕴️
### - Hexagonal Artchitecture 🔶
### - Axon & SpringBoot for CQRS 🚌

## what am I looking at? 👀

- This project is an INCOMPLETE, introductive, tiny app used to perform a demo in the final project of a higher technical certification in web development.
The project is based on https://github.com/CodelyTV/java-ddd-skeleton and the DDD courses of this platform. I highly encourage you to join them in order to 
understand DDD and improve advanced developing skills.
I also tried to use hexagonal architecture and CQRS is adapted to this project with Axon framework to manage CQRS.
It is an incidences manager app wich notifies the assigned worker by mail.

- Esta app (INCOMPLETA) se utilizó en una demo dentro de un trabajo teórico sobre Domain Driven Design, arquitectura heagonal y CQRS en Java,para el TFG de un grado superior DAW, usando los frameworks Spring Boot y Axon.
La aplicación está basada en los ejemplos de https://github.com/CodelyTV/java-ddd-skeleton y los cursos de su plataforma. Os recomiendo que le echeís un vistazo porque merecen la pena.

### How to make it work

- create image axonserver
	 docker run -d --name axonserver -p 8024:8024 -p 8124:8124 axoniq/axonserver
	 docker start axonserver
- create database incidences_manager
- clone this app and make http requests

### In order to notify when an incidence is assigned you should to add your google app programatic password and your gmail account to application.properties
