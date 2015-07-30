
Scenario: Successful Login with multiple Valid Credentials
Given User is on Ultimatix Home Page
When User enters valid <UserName>
And User enter valid <Password>
And User click on Login
Then Message displayed Login Successfully
When User LogOut from the Application
Then Message displayed LogOut Successfully

Examples:
|UserName|Password|
|890093|Bdd@2015|
|888932|Bdd@7890|