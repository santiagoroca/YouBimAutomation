package org.youbim.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import org.youbim.BasePage;
import org.youbim.pages.LogInPage;

public class LogInSteps {
    private LogInPage page;

    public LogInSteps(LogInPage page) {
        this.page = page;
    }

    @Given("I am in the log in page")
    public void navigateToLogInPage () {
        page.navigate ();
    }

    @Then("I login")
    public void logIn () {
        page.typeUsername("demouser");
        page.typePassword("123456");
        page.submit();
    }

    @Then("I should see the home page")
    public void iShouldSeeTheHomePage () {
        Assert.assertTrue(page.assertPage(page.HOME_PAGE));
    }

}