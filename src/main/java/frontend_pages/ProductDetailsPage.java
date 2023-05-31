package frontend_pages;

import base.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends Common {

    @FindBy(xpath = "//a[@href='/productreviews/3']") public WebElement addYourReviewButton;

    public ProductDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickAddYourReview() {
        click(addYourReviewButton);
    }
}
