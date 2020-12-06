# retail-module

This project is a starter application for Retail Module using Java, Spring Boot, Maven, MySql.

## Prerequisites
For building and running the application you need:
* Java
* Maven
* MySql

## Build an executable JAR

you can build a single executable JAR file that contains all the necessary dependencies, classes, and resources with:

`retail-module>mvn clean install

Then you can run the JAR file with this command:

`retail-module\taget>java -jar retail-module-0.0.1-SNAPSHOT.jar`

## Running the application locally

There are several ways to run a Spring Boot application on your local machine.

Then you can go to the browser and hit the following URLs  

*For valid Employee : http://localhost:6070/fetchBill/virat

*For valid Affiliate : http://localhost:6070/fetchBill/shikhar

*For valid Customer purchasing more than 2 years : http://localhost:6070/fetchBill/dhoni

*For valid New Customer : http://localhost:6070/fetchBill/rahul

*Note : Any other names will give same response as for new customer  : http://localhost:6070/fetchBill/{new customer}