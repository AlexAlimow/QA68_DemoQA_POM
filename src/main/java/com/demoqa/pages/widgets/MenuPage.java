package com.demoqa.pages.widgets;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Main Item 2']")
    WebElement mainItem2;

    @FindBy(xpath = "//a[text()='SUB SUB LIST »']")
    WebElement subSubList;

    @FindBy(xpath = "//a[text()='Sub Sub Item 1']")
    WebElement subItem1;

    public MenuPage hoverMouseOnMenu() {
        scrollAndWaitOfElement(mainItem2, 5, 0, 400);

        actions.moveToElement(mainItem2).pause(1000).perform();

        try {
            getWait(5).until(ExpectedConditions.visibilityOf(subSubList));
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mainItem2);
            actions.moveToElement(mainItem2).pause(1000).perform();
            getWait(5).until(ExpectedConditions.visibilityOf(subSubList));
        }

        actions.moveToElement(subSubList).pause(1000).perform();

        waitOfElementVisibility(subItem1, 5);

        return this;
    }

    public MenuPage verifySubMenu() {
        Assertions.assertTrue(isElementVisible(subItem1));

        return this;
    }
}
