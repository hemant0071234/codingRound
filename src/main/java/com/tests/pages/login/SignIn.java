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
    public WebElement emailId;

    @FindBy(id = "password")
    public WebElement passWord;

    @FindBy(id = "signInButton")
    public WebElement signInButton;

    @FindBy(id = "SignIn")
    public WebElement signIns;

    @FindBy(linkText = "I forgot my password")
    public WebElement forgotPassword;

    @FindBy(id = "errors1")
    public WebElement error1;

   public void signIn(String emailId, String password) throws InterruptedException {
       click(signIns);
       fill(this.emailId,"Email Id").with(emailId);
       fill(passWord,"Passwword Id").with(password);
       click(signInButton);
   }

   public boolean presenceOfErrorMessage(){
       return isElementVisible(error1);
   }
}
