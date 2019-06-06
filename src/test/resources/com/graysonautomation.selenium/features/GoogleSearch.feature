@google-search
Feature: Google Search
  As a web user,
  I want to search Google,
  So that I can learn new things.
  
  Background:
  Given a web browser is on the "GOOGLE_HOME" page 
  
  Scenario: Google search
  When the term "automation" is submitted
  Then results for the term are displayed