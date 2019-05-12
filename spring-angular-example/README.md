# Full Stack Spring + Angular
* This project is made to demo how to create a full stack application using Spring and Angular
    * Although I used Spring Boot to get the project setup quickly, the exact same logic can be used without Spring Boot

## Important Notes when running project
* In the Spring backend project, there is a class `com.revature.util.DataInitializer` which sets up two starter users, one tweet, and two comments
* The `com.revature.util.TokenPresentFilter` is used alongside the `com.revature.util.TokenRegistry` class to determine if an incoming request to the API is valid
    * Upon successful log in, a token is generated, stored in the `TokenRegistry`, and returned to the client in the response Body
    * Once there has been a successful login, the Angular application takes that token and stores it in sessionStorage
    * On the Angular application, there is a `HeaderAddingInterceptorService` that adds the Cross Origin and Auth token to every outgoing request

## When Running the Angular Project
* The `proxy.conf.json` file in the root directory is used to help Angular send each request to another origin (http://localhost:4200 -> http://localhost:8080)
* DO NOT USE `ng serve` to run this project, as it will fail because it doesnt take the proxy into consideration
* INSTEAD USE `npm start` to run the project, where I have modified the `npm start` script in `package.json`


# Please Slack me if you run into any issues understaning or running this application
