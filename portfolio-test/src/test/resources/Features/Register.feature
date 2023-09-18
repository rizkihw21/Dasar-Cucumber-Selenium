Feature: Portfolio Register Website Testing
  Scenario: Register on ultimatega
    Given Open web ultimega "https://courses.ultimateqa.com/users/sign_up"
    And Input first "hanako" name and last name "sachiko"
    And Input email "sachiko.hanako90@gmail.com" and password "hanako123"
    And Click agree to the terms of use
    When Click button sign up
    Then Should successfully sign up and be redirected to the homepage
