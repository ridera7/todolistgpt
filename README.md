# Todo List Application

This is a simple RESTful Todo List application developed with Java and Spring Boot. It allows users to create, read, update, and delete todo items, each having a title and description. The application uses MySQL as the database and achieves high code quality with 92% test coverage using JaCoCo.

---

## **Technologies Used**
- **Java 17**
- **Spring Boot** (REST API development)
- **Hibernate** (ORM for database interaction)
- **MySQL** (Database)
- **Lombok** (Boilerplate code reduction)
- **Maven** (Build tool and dependency management)
- **JUnit 5** (Unit testing)
- **Mockito** (Mocking dependencies in tests)
- **JaCoCo** (Code coverage analysis)
- **MySQL Workbench** (Database management)

---

## **Installation Instructions**

### **Step 1: Clone the Project**
1. Open a terminal.
2. Run the following command to clone the repository:
   ```bash
   git clone https://github.com/ridera7/todo-list-application.git
   cd todo-list-application
   ```

### **Step 2: Import into IntelliJ IDEA**
1. Open IntelliJ IDEA.
2. Select **File > Open**, navigate to the project directory, and click **Open**.
3. IntelliJ will detect the Maven project and download all dependencies automatically.

### **Step 3: Configure MySQL Database**
1. Open **MySQL Workbench** and create a new database:
   ```sql
   CREATE DATABASE todo_db;
   ```
2. Create a user for the application and grant privileges:
   ```sql
   CREATE USER 'todo_user'@'localhost' IDENTIFIED BY 'password';
   GRANT ALL PRIVILEGES ON todo_db.* TO 'todo_user'@'localhost';
   FLUSH PRIVILEGES;
   ```

### **Step 4: Update `application.properties`**
Update the database connection settings in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=todo_user
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```

---

## **Running the Application**

### **Step 1: Run the Application**
In IntelliJ IDEA:
1. Navigate to the `TodoListGptApplication` class in the `src/main/java` directory.
2. Right-click on the class and select **Run 'TodoListApplication'**.

Alternatively, use Maven to run the application:
```bash
mvn spring-boot:run
```

### **Step 2: Access the Application**
The application will start on [http://localhost:8080/api/todos](http://localhost:8080/api/todos).

---

## **Test Coverage: 92%**
The project maintains **92% test coverage**, ensuring high-quality code.

### **Steps to Check Test Coverage**
1. Run the following Maven command to execute tests and generate the JaCoCo report:
   ```bash
   mvn clean verify
   ```
2. Open the coverage report located at:
   ```
   target/site/jacoco/index.html
   ```
3. Open `index.html` in your browser to view the detailed coverage report.

---

Short feedback:
1. Was it easy to complete the task using AI?
   - The task was relatively easy except for some configuration issues.
2. How long did task take you to complete?
   - About 3 hours.
3. Was the code ready to run after generation? What did you have to change to make it usable?
   - The main code that provided the chat was fully working.