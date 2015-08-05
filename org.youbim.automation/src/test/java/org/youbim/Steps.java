package org.youbim;

import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by santi on 05/08/2015.
 */
public class Steps {

    public WebDriver driver;

    @BeforeStories
    public void invokeBrowser() {
        driver = new FirefoxDriver();
    }

}
