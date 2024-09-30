# SPRING BOOT - MAVEN COMMANDS
0. Create src folder:
    - Ctrl + Shift + P
    - Spring Initializr
    - Spring 3.3.4
    - Java 23
    - Group ID: be_project1
    - Artifact ID: lesson_<n>
    - Dependencies: Spring Web, Lombok, Postgres
1. Edit files in src/main/java/<group_id>/<artifact_id>
2. mvn -N io.takari:maven:wrapper 
3. ./mvnw spring-boot:run

# POSTGRESQL COMMANDS
0. **Version**: psql --version
1. **Status**: sudo service postgresql status 
2. **Start**: sudo service postgresql start
3. **Stop**: sudo service postgresql stop
4. **Connect**: sudo -u postgres psql

# MONGODB COMMANDS
0. **Version**: mongod --version
1. **Status**: sudo systemctl status mongod
2. **Start**: sudo systemctl start mongod
3. **Stop**: sudo systemctl stop mongod
4. **Connect**: 