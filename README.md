# SPRING BOOT - MAVEN COMMANDS
0. Create src folder:
    - Ctrl + Shift + P
    - Spring Initializr
    - Spring 3.3.4
    - Java 23
    - Group ID: be_project1
    - Artifact ID: pet_project
    - Dependencies: Spring Web, Lombok, Postgres
1. Edit files in src/main/java/be_project1/pet_project
2. mvn -N io.takari:maven:wrapper
3. ./mvnw spring-boot:run

# POSTGRESQL COMMANDS
0. **Version**: psql --version
1. **Status**: sudo service postgresql status
2. **Start**: sudo service postgresql start
3. **Stop**: sudo service postgresql stop
4. **Connect**: sudo -u postgres psql

# Request list
## Admin
1. Login: POST:    http://localhost:8080/api/v1/admin/login
2. Logout: POST:   http://localhost:8080/api/v1/admin/logout/1
3. Create: POST:   http://localhost:8080/api/v1/admin/create
4. Read:   POST:   http://localhost:8080/api/v1/admin/read
5. Update: PUT:    http://localhost:8080/api/v1/admin/update/1
6. Delete: DELETE: http://localhost:8080/api/v1/admin/delete/1

## User
1. Login:  POST:   http://localhost:8080/api/v1/user/login
    {
        "username": "RandomUser",
        "password": "RandomPassword"
    }
2. Logout: POST:   http://localhost:8080/api/v1/user/logout/1
3. Create: POST:   http://localhost:8080/api/v1/user/create
    {
        "username": "RandomUser",
        "password": "RandomPassword",
        "name": "RandomName"
    }
4. Read:   POST:   http://localhost:8080/api/v1/user/read
5. Update: PUT:    http://localhost:8080/api/v1/user/update/1
    {
        "username": "RandomUser",
        "password": "RandomPassword",
        "name": "RandomName",
        "status": "active"
    }
6. Delete: DELETE: http://localhost:8080/api/v1/user/delete/1

## Course

## Chapter

## Lesson

## UserCourse

## UserCourseLesson

# TODO
1. Make response DTOs for each requests
2. Throw Errors when ID not found when Update or Delete
3. Check existing Username, Course Name, Chapter Name, Lesson Name
4. Hash password
