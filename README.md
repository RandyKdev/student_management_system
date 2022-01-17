# SUNSHINE

 - SUNSHINE is a desktop application for a student management system built with java and mysql.

## Required Environment for running the project
- Java version: 17.0.1 2021-10-19 LTS
- JDK version: 17.0.1
- Eclipse Version: 2021-09 (4.21.0)
- Mysql Version:  8.0.27
- JavaFX Version: 11.0.2
- j-connector version: 8.0.26

### After downloading and setting up your environment,
 - create a user in your mysql terminal called "sdt" with password "sdtproject"
 - create a database named "sunshine"

 OR

if you already have a user and database created with different information,
 - goto the file located at "src/database/DBConnection.java" and edit the username, password, database name and port fields to match yours.

Then link the java project to mysql using the j-connector version 8.0.26
You should be set to go....


## Implemented Features
 - Registration - Student, Lecturer and Admin
 - Login - Student, Lecturer and Admin
 - Resetting Password of Student, Lecturer and Admin
 - Logout - Student, Lecturer and Admin
 - Admit and Un-admit a student by an admin
 - Creation of courses by an admin
 - Editing of courses information by an admin
 - Assigning Courses to Lecturer by an admin
 - Viewing info of Student and Lecturer
 - View list of students taking a particular course
 - Give marks to students by Lecturer
 - View list of courses and marks for each course by a student

All implemented UIs are located in the "implemented design" folder

Demo data can be found in the "src/database/dummyDB.java" file

## Advisable to run the "work" branch and not the "main" branch :)