
Feature: User Login
  User should be able to login using google login

  Scenario: Testing login with Google OAuth2
    Given User should be on the login page
    And both my frontend and backend servers are running
    When I login using GoogleSignIn button 
    And select an accoliteindia.com domain email id
    Then redirect user to dashboard page
    And get fetch his details from database
