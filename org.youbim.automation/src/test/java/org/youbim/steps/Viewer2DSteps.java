package org.youbim.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.youbim.Steps;

/**
 * Created by santi on 05/08/2015.
 */
public class Viewer2DSteps extends Steps {

    @Then("I click on Viewer")
    public void verify() {
        driver.findElement(By.id("menuItemViewer")).click();
    }

    @Then("I should see the Viewer 2D")
    public void iShouldSeeTheHomePage () {
        driver.findElement(By.className("viewer-inner-wrapper")).isDisplayed();
        driver.quit();
    }
    
}
