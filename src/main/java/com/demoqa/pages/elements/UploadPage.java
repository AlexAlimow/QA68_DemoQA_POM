package com.demoqa.pages.elements;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UploadPage extends BasePage {
    Robot robot;

    public UploadPage(WebDriver driver) {
        super(driver);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }


    @FindBy(id = "uploadFile")
    WebElement uploadFile;

    public UploadPage performKeyEventWithRobot() {
        scrollAndWaitOfElement(uploadFile, 10, 0, 250);
        clickWithRectangle(uploadFile);

        robot.keyPress(KeyEvent.VK_SHIFT);
        pause(1000);

        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_ENTER);

        return this;
    }

    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public UploadPage verifyFilePath(String path) {
        Assertions.assertTrue(shouldHaveText(uploadedFilePath, path, 10));
        return this;
    }

    public UploadPage performMouseEvent() {
        pause(1000);
        scrollWithJS(0, 250);
        clickWithRectangle(uploadFile);


//        //find coordinates
        pause(10000);
//        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
//        Point location = pointerInfo.getLocation();
//        int x = (int) location.getX();
//        int y = (int) location.getY();
//        System.out.println(y+ " **** " + x);  // 318 **** 611
        // move mouse point with coordinates
        robot.mouseMove(611, 318);
        pause(1000);
        //click left mouse button
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        //release left mouse button
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        pause(1000);
        //press ENTER
        robot.keyPress(KeyEvent.VK_ENTER);

        return this;
    }
}
