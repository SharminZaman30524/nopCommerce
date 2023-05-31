package frontend_pages;

import base.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class ProductReviewPage extends Common {
    @FindBy(xpath = "//input[@class='review-title']") public WebElement inputReviewTitleField;
    @FindBy(className = "review-text") public WebElement inputReviewTextField;
    @FindBy(xpath = "//div[@class='rating-options']//input") public List<WebElement> radioButtonRatingOptions;

    @FindBy(xpath = "//div[@class='review-title']") public List<WebElement> listReviews;
    @FindBy(xpath = "//button[@class='button-1 write-product-review-button']") public WebElement submitReviewButton;
    public ProductReviewPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterTitleInReviewField(String title) {
        type(inputReviewTitleField,title);
    }
    public boolean inputReviewTitleFieldIsEnabled() {
        return inputReviewTitleField.isEnabled();
    }
    public void enterReviewText(String text) {
        type(inputReviewTextField, text);
    }

    public void selectRating(int rate) {
        for(WebElement element : radioButtonRatingOptions) {
            if(element.getAttribute("value").equalsIgnoreCase(String.valueOf(rate))) {
                click(element);
                break;
            }
        }
    }
    public void selectRatingSecond(int rate) {
        click(radioButtonRatingOptions.get(rate));
    }

    public void clickSubmitReivewButton() {
        click(submitReviewButton);
    }

    public List<String> getReviewsPosted() {
        wait.until(ExpectedConditions.visibilityOfAllElements(listReviews));
        List<String> listReview = new ArrayList<>();
        for(WebElement element : listReviews) {
            listReview.add(element.getText());
            }return listReview;
        }

}
