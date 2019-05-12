# Full Stack Spring + Angular
* This project is made to demo how to create a full stack application using Spring and Angular
    * Although I used Spring Boot to get the project setup quickly, the exact same logic can be used without Spring Boot

## Important Notes when running project
* In the Spring backend project, there is a class `com.revature.util.DataInitializer` which sets up two starter users, one tweet, and two comments
* The `com.revature.util.TokenPresentFilter` is used alongside the `com.revature.util.TokenRegistry` class to determine if an incoming request to the API is valid
    * Upon successful log in, a token is generated, stored in the `TokenRegistry`, and returned to the client in the response Body
    * Once there has been a successful login, the Angular application takes that token and stores it in sessionStorage
    * On the Angular application, there is a `HeaderAddingInterceptorService` that adds the Cross Origin and Auth token to every outgoing request


# Please Slack me if you run into any issues understaning or running this application