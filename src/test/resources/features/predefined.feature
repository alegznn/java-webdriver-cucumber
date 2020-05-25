@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

  @predefined2
  Scenario: Steps for Yahoo
    Given I open url "https://www.yahoo.com/"
    Then I should see page title as "Yahoo"
    And element with xpath "//input[@name='p']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='p']"
    And I click on element using JavaScript with xpath "//button[@id='header-desktop-search-button']"
    And I wait for 5 sec
    Then element with xpath "//*[@id='results']" should contain text "Behavior-Driven Development"
    
  @predefined3
  Scenario: Steps for Bing
    Given I open url "https://www.bing.com/"
    Then I should see page title as "Bing"
    And element with xpath "//input[@id='sb_form_q']" should be present
    When I type "Behavior driven development" into element with xpath "//input[@id='sb_form_q']"
    And I click on element using JavaScript with xpath "//input[@id='sb_form_go']"
    Then I wait for element with xpath "//div[@id='b_content']" to be present
    Then  element with xpath "//div[@id='b_content']" should contain text "Behavior-Driven Development"
