# API Test Assignment

>This is an API automation test project written as an assignment for an interview. 
Testing requirements are to validate below three acceptance criteria against the REST API response of the given URI.

 **API** = [https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false](https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false)

 

**Acceptance Criteria:**

1. Name = "Carbon credits"
2. CanRelist = true
3. The Promotions element with Name = "Gallery" has a Description that contains the text "2x larger image"

## Tools and Technologies
* Java
* REST Assured
* TestNG
* Maven
* GIT

## Setup

* Install JDK 8 and set JAVA_HOME [If not available]
* Install Maven and set M2_HOME [If not available]
* Install Git [If not available]
* Navigate to the directory you want to cloned the code
* Right click on the folder window and click 'Git Bash Here'
* Type git clone, and then paste the URL "" and press 'Enter'.
  ```
  $ git clone https://github.com/surangaj17/assignment-api-test.git
  ```





## Usage
To run the scripts, open command prompt and navigate in to the clonned project folder `assignment-api-test` where `pom.xml` exists.

> Since the testng.xml set as the default test plan in the pom, test project can directly run as below,
```
mvn test 

```
>Or else, can execute testng.xml or any other test plan, passing as a parameter through command line as below,


```
mvn test -Dsurefire.suiteXmlFiles=testplans/testng.xml

```
## Test Results report

* In command prompt window  you will see below results

![picture alt](https://raw.githubusercontent.com/surangaj17/assignment-api-test/master/readmecontent/commandline_results.JPG "Command prompt results")


* TestNg generates report which you can find in the below location.

Navigate to `<Local repo>\assignment-api-test\target\surefire-reports` folder and open the `emailable-report.html` on your default web browser. You will see a html report as below,

![picture alt](https://raw.githubusercontent.com/surangaj17/assignment-api-test/master/readmecontent/emailable-report.JPG "emailable-report.html")



## Description of Project Structure & Files

This automation framework designed as a three-layered architecture, in which solution is divided into three logical horizontal layers. Which are,
* Test layer
* Business layer
* Core layer

The project folder structure and classes based on the respective layers have described below.

***Test Layer*** contains test scripts and related test classes. 
```
\\src\test\java\testscripts
```
> * BaseTest.java : This is the parent class of all test classes, which contains Base URI and before and after test methods. Can include any common prerequisite methods for tests here.
> * VerifyCategoriesTest.java : Contains test script related to categories URI validation. This is a child class of BaseTest.java.

***Business Layer*** contains classes related to the application domain specific requirements.
```
\\src\main\java\services
```
> * CategoriesHelper.java : Contains Categories resource related domain specific methods.


***Core Layer*** contains all the classes and methods related to framework and common purpose. 
```
\\src\main\java\common
```
> * RestCallHelper.java : Contains REST response related methods.
> * Utils.java : Contains generic methods to be used across the entire framework.
