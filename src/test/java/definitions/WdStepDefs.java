package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class WdStepDefs {
    @Given("I go to {string} and print details")
    public void iGoToAndPrintDetails(String page) {
        if (page.equalsIgnoreCase("google")){
            getDriver().get("https://www.google.com/");
        } else if (page.equals("Get a Quote")){
            getDriver().get("http://skryabin.com/webdriver/html/quote.html");
        } else {
            System.out.println("Unknown page "+getDriver().getCurrentUrl());
        }
        System.out.println(getDriver().getTitle());
        System.out.println();
        System.out.println(getDriver().getCurrentUrl());
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().to("https://www.google.com/");
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @Given("I open {string} then {string} then {string}")
    public void iOpenThenThen(String url1, String url2, String url3) {
        String[] urls={url1,url2,url3};
        for (String url:urls){
            System.out.println(url);
            getDriver().get(url);
        }
    }

    @Given("I open {string} page")
    public void iOpenPage(String page) {
        getDriver().get("http://skryabin.com/webdriver/html/quote.html");
    }

    @When("I fill out first name {string} and last name {string}")
    public void iFillOutFirstNameAndLastName(String firstName, String lastName) {
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
    }

    @And("I fill out remaining required fields")
    public void iFillOutRemainingRequiredFields() {
        WebElement userName=getDriver().findElement(By.xpath("//input[@name='username']"));
        String un="ja";
        String email="ja@mail.com";
        String pw="12345";
        userName.isDisplayed();
        //userName.sendKeys("ja");
        userName.sendKeys(un);
        WebElement emailaddr=getDriver().findElement(By.xpath("//input[@name='email']"));
        emailaddr.sendKeys(email);
        WebElement password=getDriver().findElement(By.xpath("//input[@id='password']"));
        password.sendKeys(pw);
        WebElement confpw=getDriver().findElement(By.xpath("//input[@id='confirmPassword']"));
        confpw.sendKeys(pw);
        WebElement policy=getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']"));
        policy.click();
        WebElement submit=getDriver().findElement(By.xpath("//button[@id='formSubmit']"));
        submit.click();

    }

    @Then("I assert required fields")
    public void iAssertRequiredFields() {
        WebElement resultPage=getDriver().findElement(By.xpath("//div[@id='quotePageResult']"));
        assertThat(resultPage.isDisplayed()).isTrue();
        String policyChecked=getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(policyChecked).isEqualToIgnoringCase("true");
        System.out.println(policyChecked);
        String actualDate=getDriver().findElement(By.xpath("//b[@name='currentDate']")).getText();
        assertThat(actualDate).isEqualTo("04/13/2020");
        System.out.println(actualDate);
        String username=getDriver().findElement(By.xpath("//b[@name='username']")).getText();
        assertThat(username).isEqualTo("ja");
        System.out.println(username);
        String resultText=getDriver().findElement(By.xpath("//div[@id='quotePageResult']//section")).getText();
        System.out.println(resultText);



    }

    @Given("I open the {string} page")
    public void iOpenThePage(String arg0) {
        getDriver().get("http://skryabin.com/webdriver/html/quote.html");
    }

    @When("I change resolution to {string}")
    public void iChangeResolutionTo(String layout) {
        Dimension size;
        switch (layout){
            case ("phone"):
                size=new Dimension(600,1000);
                break;
            case("desktop"):
                size=new Dimension(1024,1000);
                break;
            case("tablet"):
                size=new Dimension(800,1000);
                break;
            default:
                throw new RuntimeException("Not supported layout: "+layout);
        }
        getDriver().manage().window().setSize(size);
    }
}
