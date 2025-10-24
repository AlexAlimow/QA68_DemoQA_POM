package com.demoqa.pages.elements;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public TextBoxPage copyPast(String address) {
        scrollAndWaitOfElement(currentAddress, 10, 0, 400);
        // enter address to the current address
        type(currentAddress,address);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        //select current address
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        //copy current address
        actions.sendKeys(Keys.TAB).perform();
        //press TAB to switch focus on permanent address
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        // past current address on permanent address field
        return this;

    }

    @FindBy(id = "submit")
    WebElement submit;

    public TextBoxPage clickOnSubmit() {
        click(submit);
        return this;
    }

    @FindBy(css = "p#currentAddress")
    WebElement currentAddressResult;
    @FindBy(css = "p#permanentAddress")
    WebElement permanentAddressResult;

    public TextBoxPage verifyAddress() {
        String[] current = currentAddressResult.getText().split(":");
        String[] permanent = permanentAddressResult.getText().split(":");
        Assertions.assertEquals(current[1],permanent[1]);

        return this;
    }

    @FindBy(id = "userName")
    WebElement userName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;

    public TextBoxPage enterData(String name, String email, String address) {
        scrollAndWaitOfElement(userName,5,0,600);
        type(userName,name);
        type(userEmail,email);
        type(currentAddress,address);
        type(permanentAddress,address);
        return this;
    }
}
