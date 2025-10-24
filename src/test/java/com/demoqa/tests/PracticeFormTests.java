package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class PracticeFormTests extends TestBase {

    SidePanel sidePanel;
    PracticeFormPage practiceForm;

    @BeforeEach
    public void precondition() {

        practiceForm = new PracticeFormPage(driver);
        new HomePage(driver).selectForms();
        new SidePanel(driver).selectPracticeForm();
    }

    @Test
    public void createStudentAccountPositiveTest() {
        practiceForm.enterPersonalData("Robert", "Wide", "wide@gmail.com", "1234567890")
                .selectGender("Male")
                .typeOfDate("16 Jun 1988")
                .addSubjects(new String[]{"Maths", "Chemistry", "English"})
                .selectHobby(new String[]{"Sports", "Reading"})
                .uploadFile("C:/Tools/cat.jpg")
                .inputState("NCR")
                .inputCity("Delhi")
                .submitForm()
                .verifySuccess("Thanks for submitting the form");


    }

    @RepeatedTest(value = 4,name="{displayName} {currentRepetition}/{totalRepetitions}")
    public void createStudentAccountWithSelectDatePositiveTest() {
        practiceForm.enterPersonalData("Robert", "Wide", "wide@gmail.com", "1234567890")
                .selectGender("Male")
                .selectDate("June","1988","16")
                .submitForm()
                .verifySuccess("Thanks for submitting the form");


    }
}
