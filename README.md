# Taxi-Service <img src="https://github.com/mrmax24/taxi-service/blob/main/taxi-logo-5.png" align="right"/>

## Project description:
```bash
A simple web-application that supports authentication,
registration and basic features of the taxi service.
```

#### [Link to the project on Heroku](https://powerful-bayou-72075.herokuapp.com/login)
## Features:
- registration like a driver;
- authentication like a driver;
- create/update/remove a manufacturer;
- create/update/remove a car;
- create/update/remove a driver;
- display list of all manufacturers;
- display list of all cars;
- display list of all drivers;
- display list of all cars by current driver;
- add driver to car.

## Project structure

The project has an N-Tier Architecture.
- DAO - Data access layer 
- Service - Application logic layer
- Controllers - Presentation layer

## Used technologies and libraries:
| Technology   | Version  |
|:-------------|:---------|
| `JDK`        | `11`     |
| `Maven`      | `4.0.0`  |
| `Tomcat`           | `9.0.50` |
| `Log4j`      | `2.17.2` |
| `MySQL`      | `8.0.22` |
| `JDBC`      | `-`      |
| `Servlet`    | `4.0.1`  |
| `JSP`        | `-`      |
| `JSTL`       | `1.2`    |
| `Junit`      | `5.7.0`  |
| `HTML/CSS`   | `-`      |
| `Checkstyle` | `3.1.1`  |


### Steps to run the program on your computer:
1. Clone the repo: https://github.com/mrmax24/taxi-service; 
2. Install MySQL; 
3. Configure Apache Tomcat version (IMPORTANT): 9.0.xx; 
4. Copy and run SQL script /src/main/resources/init_db.sql to creating a schema and tables for the project; 
5. Configure /src/main/java/taxi/util/ConnectionUtil.java with your URL, USERNAME, PASSWORD, JDBC_DRIVER; 
6. Configure /src/main/resources/log4j2.xml at line 7 with your ABSOLUTE_PATH to this project; 
7. Done. Now just try to use it.
