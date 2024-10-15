
# 💻 Tech Stack:
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white) ![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white) ![Jira](https://img.shields.io/badge/jira-%230A0FFF.svg?style=for-the-badge&logo=jira&logoColor=white) ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white) ![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white) ![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white) ![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white) ![Confluence](https://img.shields.io/badge/confluence-%23172BF4.svg?style=for-the-badge&logo=confluence&logoColor=white) ![Figma](https://img.shields.io/badge/figma-%23F24E1E.svg?style=for-the-badge&logo=figma&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)


# Telefono MiCasa Project Description

Api connects it to the front client:
https://github.com/FactoriaF5-Asturias/P3-Digital-Academy-Project-TelefonoMiCasa-Frontend/blob/main/README.md


## Launching a Spring Boot Application with mvn 

```sh
mvn spring-boot:run
```
## Launching a Spring Boot Test with mvn 
```sh
mvn test 
```


## Dependencias: 
### Spring Boot Starter Data JPA
 URL: https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa
### Spring Boot Starter OAuth2 Authorization Server
URL: https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-oauth2-authorization-server

### Spring Boot Starter Security
URL: https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security

### Spring Boot Starter Web
URL: https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web

### Spring Boot Devtools
URL: https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools

### H2 Database
URL: https://mvnrepository.com/artifact/com.h2database/h2

### MySQL Connector/J
URL: https://mvnrepository.com/artifact/mysql/mysql-connector-j

### Project Lombok
URL: https://mvnrepository.com/artifact/org.projectlombok/lombok

### Spring Boot Starter Test
URL: https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test

### Spring Security Test
URL: https://mvnrepository.com/artifact/org.springframework.security/spring-security-test

### Springdoc OpenAPI Starter WebMvc UI
URL: https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-u


## 🌳​ Project Tree  
- URL: http://localhost:8080/swagger-ui/index.html
```
P3-Digital-Academy-TelefonoMiCasa-Backend
├─ .gitignore
├─ .mvn
│  └─ wrapper
│     └─ maven-wrapper.properties
├─ mvnw
├─ mvnw.cmd
├─ pom.xml
├─ README.md
└─ src
   ├─ main
   │  ├─ java
   │  │  └─ com
   │  │     └─ factoriaf5
   │  │        └─ telefono_micasa
   │  │           ├─ config
   │  │           │  ├─ MyBasicAuthenticationEntryPoint.java
   │  │           │  ├─ SecurityConfig.java
   │  │           │  └─ WebConfig.java
   │  │           ├─ controller
   │  │           │  ├─ AppointmentController.java
   │  │           │  ├─ AuthController.java
   │  │           │  ├─ ClientController.java
   │  │           │  ├─ PersonController.java
   │  │           │  ├─ PropertyController.java
   │  │           │  ├─ SalesmanController.java
   │  │           │  └─ ZoneController.java
   │  │           ├─ dtos
   │  │           │  ├─ AppointmentDTO.java
   │  │           │  ├─ PropertyDTO.java
   │  │           │  ├─ UserRegistrationDTO.java
   │  │           │  └─ ZoneDTO.java
   │  │           ├─ facades
   │  │           │  ├─ EncoderFacade.java
   │  │           │  └─ encryptations
   │  │           │     ├─ Base64Encoder.java
   │  │           │     └─ BcryptEncoder.java
   │  │           ├─ factories
   │  │           │  ├─ FlatFactory.java
   │  │           │  ├─ GarageFactory.java
   │  │           │  ├─ HouseFactory.java
   │  │           │  ├─ PropertyFactory.java
   │  │           │  └─ StorageRoomFactory.java
   │  │           ├─ implementations
   │  │           │  ├─ IEncoder.java
   │  │           │  └─ IEncryptFacade.java
   │  │           ├─ models
   │  │           │  ├─ Appointment.java
   │  │           │  ├─ Flat.java
   │  │           │  ├─ Garage.java
   │  │           │  ├─ House.java
   │  │           │  ├─ PersonForm.java
   │  │           │  ├─ Property.java
   │  │           │  ├─ Role.java
   │  │           │  ├─ SecurityUser.java
   │  │           │  ├─ StorageRoom.java
   │  │           │  ├─ User.java
   │  │           │  └─ Zone.java
   │  │           ├─ repositories
   │  │           │  ├─ AppointmentRepository.java
   │  │           │  ├─ PersonRepository.java
   │  │           │  ├─ PropertyRepository.java
   │  │           │  ├─ RoleRepository.java
   │  │           │  ├─ UserRepository.java
   │  │           │  └─ ZoneRepository.java
   │  │           ├─ services
   │  │           │  ├─ AppointmentService.java
   │  │           │  ├─ JpaUserDetailsService.java
   │  │           │  ├─ PersonService.java
   │  │           │  ├─ PropertyService.java
   │  │           │  ├─ RoleService.java
   │  │           │  ├─ UserService.java
   │  │           │  └─ ZoneService.java
   │  │           └─ TelefonoMicasaApplication.java
   │  └─ resources
   │     ├─ application-h2.properties
   │     ├─ application-mysql.properties
   │     ├─ application.properties
   │     └─ data.sql
   └─ test
      └─ java
         └─ com
            └─ factoriaf5
               └─ telefono_micasa
                  ├─ controller
                  │  ├─ AuthControllerTest.java
                  │  └─ PropertyControllerTest.java
                  ├─ integration
                  │  └─ PropertyRepositoryTest.java
                  ├─ models
                  │  ├─ FlatTest.java
                  │  ├─ HouseTest.java
                  │  ├─ PropertyTest.java
                  │  ├─ RoleTest.java
                  │  ├─ SecurityUserTest.java
                  │  └─ UserTest.java
                  ├─ services
                  │  ├─ PropertyServiceTest.java
                  │  └─ RoleServiceTest.java
                  └─ TelefonoMicasaApplicationTests.java

```
## Doc Swager
![d0b142d27d96ec9dfd16ab2d48483955](https://github.com/user-attachments/assets/48c47163-2c1b-4c1e-9e41-f7c18453b6b7)

## Diagrams

![39b77e440a9c89b65695105dbfacfb91](https://github.com/user-attachments/assets/aca2d965-d141-4328-8568-9c86101801e6)

## 👥​ Authors 
- [@AntonellaEL](https://github.com/AntonellaEL)
- [@hugoperez11](https://github.com/hugoperez11)
- [@eyadcode4](https://github.com/eyadcode4)
- [@Jorgecas71](https://github.com/Jorgecas71)
- [@JuliaParra](https://github.com/JuliaParra)
- [@piperiver97](https://github.com/piperiver97?tab=repositories)
- [@pablosja](https://github.com/pablosja)
