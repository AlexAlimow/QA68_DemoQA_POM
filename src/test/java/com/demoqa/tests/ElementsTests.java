package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.JsExecutor;
import com.demoqa.pages.SidePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElementsTests extends TestBase {

    SidePanel sidePanel;

    @BeforeEach
    public void precondition() {
        new HomePage(driver).selectElements();
        sidePanel = new SidePanel(driver);
    }

    @Test
    public void JsExecutorTest() {
        sidePanel.selectTextBox();
        new JsExecutor(driver).enterPersonalData("Alex Smith", "alex@gmail.com")
                .clickOnSubmitButton()
                .getInnerText()
                .verifyUrl()
                .refreshPage()
                .navigateToNewTab("https://telranedu.web.app")
                .verifyNewPageFaveIconTitle()
                ;
    }
}
