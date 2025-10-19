package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgets.SelectPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WidgetsTests extends TestBase {
    SidePanel sidePanel;
    SelectPage select;

    @BeforeEach
    public void precondition() {
        new HomePage(driver).selectWidgets();
        sidePanel = new SidePanel(driver);
        select = new SelectPage(driver);
    }

    @Test
    public void oldStyleSelectMenuTest() {
        sidePanel.selectSelect();
        select.oldStileSelect("Yellow")
                .verifyColor();
    }

    @Test
    public void MultiSelectTest() {
        sidePanel.selectSelect();
        select.MultiSelect(new String[]{"Green", "Red", "Blue"})
                .verifyMultiSelect(new String[]{"Green", "Red", "Blue"});
    }

    @Test
    public void standardMultiSelect(){
        sidePanel.selectSelect();
        select
                //.verifySelectedCarByValue("opel","rgba(25, 103, 210, 1)");
                .verifySelectedCarByHexFormat("opel","#1967d2");
    }
}

