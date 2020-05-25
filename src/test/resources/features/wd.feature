@wd
  Feature: WebDriver methods

    @wd1
    Scenario: Open the webpage
      Given I go to "Get a Quote" and print details
      And I go back and forward, then refresh the page

    @wd2
    Scenario: Loop through URLs
      Given I open "https://www.google.com/" then "http://skryabin.com/webdriver/html/quote.html" then "https://yandex.ru"

    @wd3
    Scenario: Quote with required fields
      Given I open "quote" page
      When I fill out first name "John" and last name "Appleseed"
      And I fill out remaining required fields
      Then I assert required fields

    @wd4
    Scenario: Responsive UI
      Given I open the "qoute" page
      When I change resolution to "phone"