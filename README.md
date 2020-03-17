# code-demo
Application for demonstrating multi-layered project structure via establishing different apis for data, business logic
and presentation layers

Inspired by this article: https://medium.com/the-resonant-web/spring-boot-2-0-project-structure-and-best-practices-part-2-7137bdcba7d3

GUI: http://localhost:8080/
Service: http://localhost:8080/graphql

Package Structure: 
- 
- **api:** presentation layer for an api server, contain only necessary code for making a rest/graphql service 
- **business:** logic layer
- **data:** database/third-party layer

Maven Dependencies:
- **spring-boot-starter-web** starter for a spring boot application
- **spring-boot-starter-actuator** used for health checks /actuator/health
- **spqr** graphql spqr libarary for helping with a graphql java server (code driven, no schema driven)
- **spring-boot-starter-data-jpa** spring boot library for database operations
- **h2** in-memory database
- **lombok** library that helps with day-to-day java development (removes a lot of java ugly syntax)
- **spring-boot-starter-test** spring boot testing helper


IntelliJ Setup:
-
- Settings -> Maven -> Importing -> check "Import Maven projects automatically"
- Settings -> Editor -> Auto Import -> check "Optimize Imports on the Fly"
- Settings -> Plugins -> install "Lombok" plugin
- Settings -> Build, Execution, Deployment -> Compiler -> Annotation Processors -> check "Enable annotation processing"