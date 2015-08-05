package org.youbim.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.youbim.Steps;

public class LogInSteps extends Steps {

    @Given("I navigate to dev.youbim.com")
    public void navigate() {
        driver.get("http://dev.youbim.com");
    }

    @Then("I login")
    public void verify() {
        driver.findElement(By.id("username")).sendKeys("demouser");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/form/button")).click();
    }

    @Then("I should see the home page")
    public void iShouldSeeTheHomePage () {
        driver.findElement(By.className("logged-in")).isDisplayed();
        driver.quit();
    }

}