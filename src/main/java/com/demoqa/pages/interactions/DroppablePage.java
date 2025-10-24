package com.demoqa.pages.interactions;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DroppablePage extends BasePage {

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;

    @FindBy(id = "droppable")
    WebElement dropHere;

    public DroppablePage actionDragMe() {
        pause(1000);
        scrollAndWaitOfElement(dragMe,5,0,200);

        actions.dragAndDrop(dragMe,dropHere).perform();
        return this;
    }

    public DroppablePage verifyDropped(String text) {
        Assertions.assertTrue(shouldHaveText(dropHere, text,5));
        return this;
    }

    public DroppablePage actionDragMeBy() {
        scrollAndWaitOfElement(dragMe,5,0,200);

        //get coordinates of 'draggable' and print it
        int xOffset1 = dragMe.getLocation().getX();
        int yOffset1 = dragMe.getLocation().getY();
        System.out.println("xOffset1 -> " + xOffset1 + " *** " + "yOffset1 -> " + yOffset1);

        //get coordinates dropHere 'droppable' and print it
        int xOffset = dropHere.getLocation().getX();
        int yOffset = dropHere.getLocation().getY();
        System.out.println("xOffset -> " + xOffset + " *** " + "yOffset -> " + yOffset);

        //find difference
        xOffset = xOffset - xOffset1;
        yOffset = yOffset - yOffset1;

        actions.dragAndDropBy(dragMe,xOffset,yOffset).perform();

        //xOffset1 -> 445 *** yOffset1 -> 337
        //xOffset -> 669 *** yOffset -> 329
        return this;
    }
}
