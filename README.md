# Readme:
## About the project?
This is my application, built on the architectural style of programming RESTful application (API).
It doesn't have a pretty design, but works as a resource.
In it, I used fairly modern and popular frameworks like Hibernate and Spring (Core + MVC + Security). 
I also once again practiced creating an application from scratch following the SOLID principle. 
Improved my knowledge of Java Core.

## How to use?
You are given the following endpoints and example to use:

Method | Endpoint | Roles | URL params | Body (JSON)
--- | --- | --- | --- | ---
POST | /register | all | (no) | ```{"email":"email@email.ua", "password":"12345678", "repeatPassword":"12345678"}```
GET | /cinema-halls | user/admin | (no) | (no body)
POST | /cinema-halls | admin | (no) | ```{"capacity":20, "description":"null"}```
GET | /movies | user/admin | (no) | (no body)
POST | /movies | admin | (no) | ```{"title":"not null", "description":"null"}```
GET | /movie-sessions/available | user/admin | ```?movieId={id}&date=dd.MM.yyyy``` | (no body)
GET | /movie-sessions/{id} | user/admin | (no) | (no body)
POST | /movie-sessions | admin | (no) | ```{"movieId":{positive number}, "cinemaHallId": {positive number}, "showTime": "dd.MM.yyyy HH:mm"}```
PUT | /movie-sessions/{id} | admin | (no) | ```{"movieId":{positive number}, "cinemaHallId": {positive number}, "showTime": "dd.MM.yyyy HH:mm"}```
DELETE | /movie-sessions/{id} | admin | (no) | (no body)
GET | /orders | user | (no) | (no body)
POST | /orders/complete | user | (no) | (no body)
PUT | /shopping-carts/movie-sessions | user | ```?movieSessionId={id}``` | (no body)
GET | /shopping-carts/by-user | user | (no) | (no body)
GET | /users/by-email | admin | ```?email={email}``` | (no body)


## Online version (deployment on Heroku):
1. To use the online version of the application, you can follow the [link](https://cinema-app-orlov.herokuapp.com/)
2. For testing, you can use the admin account with the next credentials: 
   - email: admin@i.ua 
   - password: admin123
3. Or use Postmen with the following parameters:
   - Authentication - Basic
   - Insert email + password
   - use suffix of URL: "https://cinema-app-orlov.herokuapp.com"
   - use prefix of URL - my endpoint with correct HTTP method
4. For details see my Controllers in the code (serhii/orlov/spring/controller) and use this as documentation

## Inside structure of project and DataBase:
This project - emulation of Cinema shop service. if you use my application for a cinema, 
you will get a lot of benefits: simple speedy code, no unnecessary dependencies, security, maintenance and development. 

The API has the next structure:
![CinemaAppStructure.png](CinemaAppStructure.png)

Examples of code:
```java
package serhii.orlov.spring.controller;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import serhii.orlov.spring.dto.request.UserRequestDto;
import serhii.orlov.spring.dto.response.UserResponseDto;
import serhii.orlov.spring.model.User;
import serhii.orlov.spring.service.AuthenticationService;
import serhii.orlov.spring.service.mapper.UserMapper;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final UserMapper userMapper;

    public AuthenticationController(AuthenticationService authService, UserMapper userMapper) {
        this.authService = authService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        User user = authService.register(requestDto.getEmail(), requestDto.getPassword());
        return userMapper.mapToDto(user);
    }
}
```

## Recommended parameters to run on your platform:
- OS: Windows / Linux / Mac OS
- WebServer: TomCat - 9.0.54 + fix it with: Application context - "/"
- DataBase: MySql (ver. 8.*) or another 
- JDK: 11
- IDE: prefer JetBrains IntelliJ IDEA or another

## Configure DataBase:
- Please open the file src/main/resources/db.properties:
```
#MySQL properties
db.driver=YOUR_DRIVER
db.url=YOUR_DATABASE_URL
db.user=YOUR_USERNAME
db.password=YOUR_PASSWORD

#Hibernate properties
hibernate.show_sql=true
hibernate.hbm2ddl.auto=create
hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
- Insert minimum data and configure to your needs 
- Run TomCat
