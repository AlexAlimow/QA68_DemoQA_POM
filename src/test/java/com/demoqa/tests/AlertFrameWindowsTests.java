package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.alertsFrameWindows.AlertsPage;
import com.demoqa.pages.alertsFrameWindows.FramesPage;
import com.demoqa.pages.alertsFrameWindows.WindowsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlertFrameWindowsTests extends TestBase {

    SidePanel sidePanel;
    AlertsPage alerts;
    FramesPage frame;


    @BeforeEach
    public void precondition() {
        new HomePage(driver).selectAlertsFrameWindows();
        sidePanel = new SidePanel(driver);
        alerts = new AlertsPage(driver);
        frame = new FramesPage(driver);
    }

    @Test
    public void waitAlertTest() {
        sidePanel.selectAlerts();
        alerts.verifyAlertWithTimer();
    }

    @Test
    @DisplayName("Verify to -> 'Cancel' is displayed")
    public void alertWithSelectResultTest() {
        sidePanel.selectAlerts();
        alerts.clickOnConfirmButton()
                .selectResult("Cancel")
                .verifyResult("Cancel");
    }

    @Test
    @DisplayName("Verify to -> 'Text you entered' is displayed")
    public void sendMessageToAlertTest() {
        sidePanel.selectAlerts();
        alerts.clickOnPromptButton()
                .sendMessageToAlert("Hello World")
                .verifyMessage("Hello World");
    }

    @Test
    public void switchToNewTabTest(){
        sidePanel.selectWindows();
        new WindowsPage(driver).clickOnNewTabButton()
                .switchToNewTab(1)
                .verifyNewTabTitle("This is a sample page");
    }

    @Test
    public void switchToNewIframeByIndexTest(){
        sidePanel.selectFrame();
        frame.returnListOfFrames()
                .switchToIframeByIndex(2)
                .verifyByTitle("This is a sample page");
    }

    @Test
    public void switchToIframeByIdTest(){
        sidePanel.selectFrame();
        frame.switchToIframeById()
                .verifyByTitle("This is a sample page")
                .switchToMainPage()
                .verifyMainPageTitle("Frames")
                ;
    }
    @Test
    public void nestedIframesTest(){
        sidePanel.selectNestedFrames().hideFooter();
        frame.handleNestedIframes();
    }

}
