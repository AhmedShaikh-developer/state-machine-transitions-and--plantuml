# CSSE374 Homework: State Machine

## Deliverables
- design.puml
- Code

## Contributors
<YOUR_NAME>

## Configuration and Structure 

This project is configured as follows:

- **Java Version**: 11 
- **JUnit Version**: 5.8.1
- **Mocking Library: EasyMock**: 5.1.0
- **Project Paths**
  - *Source Code Root*: `/src/main/java`
  - *Non-Code Resources Root*: `/src/main/resources`
  - *Unit Test Code Root*: `/src/test/java`
  - *Testing Non-Code Resources*: `/src/test/resources`
  - *Compiled outputs*: `/target`

## Building/Testing

Most _modern_ IDEs (IntelliJ IDEA, VS Code w/ Java Extension Pack) should immediately recognize this as a Maven project,
and determine how to build the project and run unit tests. You can also use the Maven CLI to execute "lifecycle" commands
that perform the same operations as the IDE. The important ones are:
 
- **Clean Build directory**: "clean" (`mvn clean`)
- **Build Source**: "compile" (`mvn compile`)
- **Run Tests**: "test" (`mvn test`)

You can learn more about the Maven lifecycle by reading the [Introduction to the Build Lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html).
