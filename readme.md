# Serenity-cucumber-RestAssured

##Running test from terminal

    mvn clean verify serenity:aggregate( To get the serenity reports)
    mvn clean verify -Dcucumber.options="--tags @tag" serenity:aggregate( To run with tags)
    mvn verify -Dcucumber.options="classpath:features/my_first.feature" ( To run specific feature)
    
***
## Path to check reports after test execution

    target/site/serenity/index.html
Navigate to the above path and open with any browser
***

## References

http://thucydides.info/docs/articles/an-introduction-to-serenity-bdd-with-cucumber.html
 (framework doc)

https://johnfergusonsmart.com/whats-new-in-serenity-2/ (serenity 2.0 report doc)

https://reqres.in (API's url)
***