Feature: OrangeHRM Login

Scenario: Validate Login functionality
 Given user launch application
 When user enter username
 When user enter password
 When user click on login button
 Then user verify pageTitle
 Then user close application