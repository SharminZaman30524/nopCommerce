package frontend_pages;

import base.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Common {

    @FindBy(name = "Email") public WebElement emailInputField;
    @FindBy(name = "Password") public WebElement passwordInputField;
    @FindBy(xpath = "//button[@class='button-1 login-button']") public WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        type(emailInputField, email);
    }
    public void enterPassword(String password) {
        type(passwordInputField, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }
}
