@quote
  Feature: Predefined Quote form
    @quote1
    Scenario: Responsive UI
      Given I open url "http://skryabin.com/webdriver/html/quote.html"
      #Desktop UI
      When I resize window to 1024 and 1000
      Then element with xpath "//b[@id='location']" should be displayed
      And element with xpath "//b[@id='currentDate']" should be displayed
      And element with xpath "//b[@id='currentTime']" should be displayed
      #Tablet UI
      When I resize window to 800 and 1000
      Then element with xpath "//b[@id='location']" should be displayed
      And element with xpath "//b[@id='currentDate']" should be displayed
      And element with xpath "//b[@id='currentTime']" should be displayed
      #Mobile UI
      When I resize window to 600 and 1000
      Then element with xpath "//b[@id='location']" should not be displayed
      And element with xpath "//b[@id='currentDate']" should not be displayed
      And element with xpath "//b[@id='currentTime']" should not be displayed

    @quote2
    Scenario: Validate Name field
      Given I open url "http://skryabin.com/webdriver/html/quote.html"
      When I click on element with xpath "//input[@id='name']"
      Then element with xpath "//div[@aria-describedby='nameDialog']" should be displayed
      When I type "John" into element with xpath "//input[@id='firstName']"
      And I type "Appleseed" into element with xpath "//input[@id='lastName']"
      And I click on element with xpath "//span[contains(text(),'Save')]"
      Then element with xpath "//input[@id='name']" should have attribute "value" as "John Appleseed"
      
    @quote3
    Scenario: Validate Username field
      Given I open url "http://skryabin.com/webdriver/html/quote.html"
      When I type "j" into element with xpath "//input[@name='username']"
      And I click on element with xpath "//input[@name='email']"
      Then element with xpath "//label[@id='username-error']" should contain text "at least 2 characters"
      
   @quote4
   Scenario: Validate Password field
     Given I open url "http://skryabin.com/webdriver/html/quote.html"
     When I type "1234" into element with xpath "//input[@id='password']"
     And I click on element with xpath "//input[@name='email']"
     Then element with xpath "//label[@id='password-error']" should contain text "at least 5 characters"

   @quote5
   Scenario: Validate Email field is required
     Given I open url "http://skryabin.com/webdriver/html/quote.html"
     When I click on element with xpath "//button[@id='formSubmit']"
     Then element with xpath "//label[@id='email-error']" should contain text "This field is required."

   @quote6
   Scenario: Validate Confirm Password field is disabled and password mismatch error is displayed
     Given I open url "http://skryabin.com/webdriver/html/quote.html"
     When  I type "12345" into element with xpath "//input[@id='password']"
     And I clear element with xpath "//input[@id='password']"
     And I click on element with xpath "//input[@id='confirmPassword']"
     Then element with xpath "//input[@id='confirmPassword']" should have attribute "disabled" as "true"
     Then I wait for 3 sec
     When  I type "12345" into element with xpath "//input[@id='password']"
     And I type "54321" into element with xpath "//input[@id='confirmPassword']"
     And I click on element with xpath "//input[@name='username']"
     Then element with xpath "//label[@id='confirmPassword-error']" should contain text "Passwords do not match!"

   @quote7
   Scenario: Validate form submit successfull with all required fields filled
     Given I open url "http://skryabin.com/webdriver/html/quote.html"
     When I click on element with xpath "//input[@id='name']"
     Then element with xpath "//div[@aria-describedby='nameDialog']" should be displayed
     When I type "John" into element with xpath "//input[@id='firstName']"
     And I type "Appleseed" into element with xpath "//input[@id='lastName']"
     And I click on element with xpath "//span[contains(text(),'Save')]"
     And I type "ja" into element with xpath "//input[@name='username']"
     And I type "j_appleseed@mail.com" into element with xpath "//input[@name='email']"
     And I type "12345" into element with xpath "//input[@id='password']"
     And I type "12345" into element with xpath "//input[@id='confirmPassword']"
     And I click on element with xpath "//span[contains(text(),'I have read and accept Privacy Policy.')]"
     And I click on element with xpath "//button[@id='formSubmit']"
     Then element with xpath "//b[@name='firstName']" should have text as "John"
     And element with xpath "//b[@name='lastName']" should have text as "Appleseed"
     And element with xpath "//b[@name='username']" should have text as "ja"
     And element with xpath "//b[@name='email']" should have text as "j_appleseed@mail.com"
     And element with xpath "//b[@name='name']" should have text as "John Appleseed"
     And element with xpath "//b[@name='password']" should have text as "[entered]"
     And element with xpath "//b[@name='agreedToPrivacyPolicy']" should have text as "true"