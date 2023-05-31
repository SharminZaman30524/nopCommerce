package system_testing;

import base.Common;
import frontend_pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.GenerateRandomData;
import utility.ReadPropertyFile;

import java.time.format.DecimalStyle;
import java.util.Random;

public class TestWriteReview extends Common {
    String title = GenerateRandomData.reviewTitle();
    String review = GenerateRandomData.review();
    String firstName = GenerateRandomData.firstName();
    String lastName = GenerateRandomData.lastName();
    String email = "@gmail.com";
    String password = GenerateRandomData.password();
    HomePage homePage;
    DesktopPage desktopPage;
    ProductDetailsPage productDetailsPage;
    ProductReviewPage productReviewPage;
    RegisterPage registerPage;
    @Test(enabled = false)
    public void testWriteReviewWithoutLogin() throws InterruptedException {
        homePage = new HomePage();
        homePage.hoverOverComputersMenuOption();
        homePage.clickDesktopOption();
        desktopPage = new DesktopPage();
        desktopPage.selectProductFromDesktopPage("Lenovo");
        productDetailsPage = new ProductDetailsPage();
        productDetailsPage.clickAddYourReview();
        productReviewPage = new ProductReviewPage();
        Assert.assertFalse(productReviewPage.inputReviewTitleFieldIsEnabled());
        Thread.sleep(3000);
    }

    @Test
    public void testWriteReviewWithRegisteredUser() throws InterruptedException {
        homePage = new HomePage();
        homePage.clickRegister();
        registerPage = new RegisterPage();
        registerPage.selectGender("MaLe");
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterEmail(firstName + lastName + email);
        registerPage.selectDay(String.valueOf(GenerateRandomData.day()));
        registerPage.selectMonth(GenerateRandomData.month1to12());
        registerPage.selectYear(String.valueOf(GenerateRandomData.year()));
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.clickRegisterButton();
        homePage.clickHeaderMenu("Log in");
        LoginPage loginPage= new LoginPage();
        loginPage.enterEmail(firstName + lastName + email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        homePage.hoverOverComputersMenuOption();
        homePage.clickDesktopOption();
        desktopPage = new DesktopPage();
        desktopPage.selectProductFromDesktopPage("Lenovo");
        productDetailsPage = new ProductDetailsPage();
        productDetailsPage.clickAddYourReview();
        productReviewPage = new ProductReviewPage();
        productReviewPage.enterTitleInReviewField(title);
        productReviewPage.enterReviewText(review);
        productReviewPage.selectRatingSecond(GenerateRandomData.rating());
        productReviewPage.clickSubmitReivewButton();
        Assert.assertTrue(productReviewPage.getReviewsPosted().contains(title));
        Thread.sleep(5000);
    }
}
