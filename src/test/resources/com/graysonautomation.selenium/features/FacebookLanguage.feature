@facebook-language
Feature: Facebook Language
  As a Facebook user,
  I want view the home page in my language,
  So that I can create an account.
  
  Background:
  Given a web browser is on the "FACEBOOK_HOME" page 
  
  Scenario Outline: Check language
  When the cookie for "<language>" is added
  Then the home page is translated
  
  Examples: Languages
  |language	|
  |GERMAN	|
  |SPANISH	|
  |FRENCH	|
  