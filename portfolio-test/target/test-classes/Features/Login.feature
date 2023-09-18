Feature: Portfolio Login Website Testing
  Scenario: Login on ultimatega
    Given Open web url "https://courses.ultimateqa.com/users/sign_in"
    And Input username "hutama.harada2@gmail.com" and password "hutama123"
    When Click sign in button
    Then Should success login and redirected to homepage