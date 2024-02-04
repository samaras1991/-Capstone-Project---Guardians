@Regression3
Feature: Sign in Feature

  Background: 
    Given User is on retail website
    When User click on Sign in option

  @SignIn
  Scenario: Verify user can sign in into Retail Application
    And User enter email 'mohamed10@gmail.com' and password 'Mohamed1991@'
    And User click on login button
    Then User should be logged in into Account

  @Register
  Scenario: Verify user can create an account into Retail Website
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name    | email               | password     | confirmPassword |
      | mohamed | mohamed2009@gmail.com | Mohamed1991@ | Mohamed1991@    |
    And User click on SignUp button
     Then Verify user account is created

     from upstream
     
     add from eclipse
