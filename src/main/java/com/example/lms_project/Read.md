 # Overview
## Project : Learning Navigator
### Problem Statement
Develop a RESTful API service using Spring Boot to manage the exam enrollment process for a Learning Management System (LMS). You are required to use MySQL to persist the data.

### Implemented in Project Details
* APIs of CRUD operations for Students, Subjects, and Exams
* Each Student has the following fields:
  * Student Registration ID (Unique Identifier)
  * Student Name
  * List of enrolled Subjects
  * List of registered Exams
* Each Subject has the following fields:
  *  Subject ID (Unique Identifier)
   * Subject Name
   * List of registered Students
* Each Exam has the following fields:
    * Exam ID (Unique Identifier)
    * Subject
    * List of enrolled Students

* The entities must use Foreign Key relationships wherever necessary
* Use GlobalExceptionHandler and @ControllerAdvice to organize and streamline Exception Handling

### Quick Start 
* Clone Repository : https://github.com/Nizam3700/Project.git
* Change the DataBase connection :
  * your userName & Password 
  * Create DataBase with your own in Application.properties
* check APIs in PostMan
  * My Collection : https://elements.getpostman.com/redirect?entityId=34329189-3b58f42d-3f49-44f8-9104-924b7c755777&entityType=collection
