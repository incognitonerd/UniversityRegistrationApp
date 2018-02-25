# UniversityRegistrationApp

Simple application that displays a few basic architectural principles such as authentication, how to connect to a database, how to create repositories, and how to create services in an efficient manner. Users land on a log in page and from there, they're able to log in or sign up. Once logged in, users are able to add a university, add a student, remove a student, see a list of all the added students, see a list of all of the added universities, and view the university statistics as to how many students are registered.  

Dev Environment -  
* Github - Code repository  
* Jenkins Server - Continuous integration continious deployment build tool  
* Ubuntu Server - Linux box to host my applications  
* Macbook Pro - My personal machine  
* Eclipse Java EE - IDE
* Java 8 - Programming language used  
* Mysql Server - For my database  
* Wildfly Server - Application server to host the war  

Build Management And Automation Tool -
* Maven - project management framework for compilation, packaging, simplifies and standardizes a project's build process, a default/standard project structure, dependency management, relies on internet connection. Based on the pom (project object model)  

Database Connections -
* Jpa - java persistence api for crud operations and annotations. runs jdbc in the background.    
* Hibernate - vendor to implement the jpa specifications  

Wiring the technologies together -  
* Spring framework for java enterprise projects  - develop enterprise applications using pojos instead of beans, forces programmers to use the best-known practices. Handles instantiating classes (dependency injection).  

UI Components -   
* Vaadin Framework - To build UI related applications. Don't have to worry about html or css related stuff  

Authentication -  
* Spring Security - Encrypts passwords when adding a user and validates user when signing in

Testing -    
* Junit - Unit testing  
