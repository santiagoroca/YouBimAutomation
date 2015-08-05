package org.youbim.pages;

import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.openqa.selenium.By;
import org.youbim.BasePage;
import org.youbim.steps.LogInSteps;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromPath;

public class LogInPage extends BasePage {

    public By USERNAME_FIELD = By.xpath("//*[@id=\"username\"]");
    public By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
    public By SUBMIT_BUTTON = By.xpath("/html/body/div[1]/div[1]/div/div/form/button");
    public By HOME_PAGE = By.xpath("//*[@id=\"main\"]");

    public LogInPage () {
        super();
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromPath("src/test/resources"), "**/log_in_page/*.story", "");
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),
                new LogInSteps(this)
        );
    }

    public void navigate () {
        driver.get("http://dev.youbim.com");
    }

    public void typeUsername (String username) {
        driver.findElement(USERNAME_FIELD).sendKeys(username);
    }

    public void typePassword (String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void submit () {
        driver.findElement(SUBMIT_BUTTON).submit();
    }

    public boolean assertPage (By by) {
        return driver.findElement(by).isDisplayed();
    }

}