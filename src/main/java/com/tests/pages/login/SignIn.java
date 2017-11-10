package com.tests.pages.login;

import com.tests.helpers.ui.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignIn extends Page {

    public SignIn() {
        initElements(this);
    }

    // Can access the element by id why to use link text
    @FindBy(id = "userAccountLink")
    public WebElement yourTrips;

    @FindBy(id = "email")
    public WebElement emailID;

    @FindBy(id = "tripidSecond")
    public WebElement tripidSecond;

    @FindBy(id = "registerButton4")
    public WebElement registerButton4;





}
