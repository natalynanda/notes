# Notes

It is an application similar to Obsidian. The goal is to develop an MVP that allows users to manage notes efficiently, by adding tags, organizing them into categories, and utilizing advanced features such as search and archiving

## Prerequisites

Before running the project, make sure you have the following tools installed on your machine:

- [JDK 11 or later](https://openjdk.java.net/) (to compile and run the project)
- [Maven](https://maven.apache.org/)
- Database PostgreSQL

## Installation

### Clone the Repository

Start by cloning the repository to your local machine:

```bash
git clone git@github.com:natalynanda/notes.git
cd notes
```

### Data base init POSTGRES

Run Script located in /scripts/init.sql

Set application.properties

```
spring.application.name=notes
spring.datasource.url=jdbc:postgresql://localhost:5432/notes
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver
```

### Init Project

```
mvn spring-boot:run  
```