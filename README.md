Mobiquity Challenge

RestAssured-Java 

Objective:
For this task, write tests for validating comment email

The task is:
1. To create a test automation framework skeleton.
2. To perform the validations for the comments for the post made by a specific user.
   
Flow to be tested:

1. Search for the user with username “Delphine”.
    Steps: Validate response code 200
    Validate email
    get user details id.
3. Use the details fetched to make a search for the posts written by the
   user.
   Steps:
   used userid to fetch post 
   confirm post return has userid
   confirm number of post returned
   
3. For each post, fetch the comments and validate if the emails in the
   comment section are in the proper format.
Steps:
   used postid to fetch comments 
   confirm number of comments returned
   validate email in each comment to know if valid.
   
Test Design:

Created Pojo Classes for each test to accept the object respone of the test
Create Util.java file to genearate Request and Response spec 
Created Get Methods to handle each test resquest and response under the Request Package
Use the test to run all the test scenario:


Test Report: 

Test report generated in allure-results folder.

Tools/ libraries used: 

1. Java 11
2. Rest Assured
3. Testng
4. Maven
5. Allure Report

Steps to start:

1 Clone/Download the project into your local
2. Open command prompt and navigate to project location
3. Execute the following Maven command's
     mvn clean: To clean th maven repo
     mvn install: To install the maven requirements
     mvn test: To execute the test scenarios

