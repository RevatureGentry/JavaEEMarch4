## Better Servlet Example
* This example builds upon the example we did earlier today, incorporating a session to bring a particular user's todos on to the screen via an AJAX request.
    * All you will need to run this example is to provide your own `application.properties` file, with the associated H2 database credentials 
* The code is mainly a cleaned up version with more tests
    * Only one JSP is used for both employees and managers
* The credentials for the users are as follows

| Username | Password | Role |
| -------- | -------- | ---- |
| william | Password123! | Employee |
| manager | Password123! | Manager |