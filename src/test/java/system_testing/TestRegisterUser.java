package system_testing;

import base.Common;
import frontend_pages.HomePage;
import frontend_pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.GenerateRandomData;

public class TestRegisterUser extends Common {
    String firstName = GenerateRandomData.firstName();
    String lastName = GenerateRandomData.lastName();
    String email = "@gmail.com";
    String password = GenerateRandomData.password();


    HomePage homePage;
    RegisterPage registerPage;
    @Test
    public void testRegisterUser() throws InterruptedException {
        homePage = new HomePage();

        homePage.clickRegister();
        logger.info("User clicks on register link");
        registerPage = new RegisterPage();
        registerPage.selectGender("MaLe");
        logger.info("User selects gender: Male/Female");
        registerPage.enterFirstName(firstName);
        logger.info("User enters their first name");
        registerPage.enterLastName(lastName);
        logger.info("User enters their last name");
        registerPage.enterEmail(firstName + lastName + email);
        logger.info("User enters their email");
        registerPage.selectDay(String.valueOf(GenerateRandomData.day()));
        logger.info("User selects date of birth using a dropdown");
        registerPage.selectMonth(GenerateRandomData.month1to12());
        logger.info("User selects month of birth using a dropdown");
        registerPage.selectYear(String.valueOf(GenerateRandomData.year()));
        logger.info("User selects year of birth using a dropdown");
        registerPage.enterPassword(password);
        logger.info("User enters a password for the account");
        registerPage.enterConfirmPassword(password);
        logger.info("User confirms the password for the account");
        registerPage.clickRegisterButton();
        logger.info("User clicks on the Register button");
        String expectedRegistrationCompleteMessage = "Your registration completed";
        Assert.assertEquals(registerPage.getRegistrationCompletionText(), expectedRegistrationCompleteMessage);

    }
}
