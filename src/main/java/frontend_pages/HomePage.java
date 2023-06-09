package frontend_pages;

import base.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Common {
    @FindBy(xpath = "//a[@href='/electronics']")
    public WebElement electronicsLink;
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[@href='/computers']")
    public WebElement computersLink;
    @FindBy(xpath = "//a[@href='/notebooks']")
    public WebElement notebooksLink;
    @FindBy(xpath = "//a[@href='/desktops']")
    public WebElement desktopsLink;
    @FindBy(xpath = "//a[@href='/apple-macbook-pro-13-inch']")
    public WebElement macbookPro13InchLink;
    @FindBy(xpath = "//input[@id='product_enteredQuantity_4']")
    public WebElement itemQuantityInput;
    @FindBy(xpath = "//button[@id='add-to-cart-button-4']")
    public WebElement addToCartButton;
    @FindBy(xpath = "//p[text()='The minimum quantity allowed for purchase is 2.']")
    public WebElement minimumPurchaseErrorNotification;
    @FindBy(xpath = "//span[@class='close']")
    public WebElement closeNotificationButton;
    @FindBy(xpath = "//a[@href='/cart']")
    public WebElement shoppingCartNotificationButton;

    @FindBy(xpath = "//div[@class='header-links']//li") public List<WebElement> headerList;

    @FindBy(xpath = "//a[@href='/register?returnUrl=%2F']") public WebElement registerLink;
    @FindBy(xpath = "//a[@href='/apparel']") public WebElement apparelLink;
    @FindBy(xpath = "//a[@href='/shoes']") public WebElement shoesLink;
    //@FindBy(xpath = "//ul[@class='top-menu notmobile']//a") public List<WebElement> topMenuOptionsLinks;



    public HomePage() {PageFactory.initElements(driver, this);}

    public void clickElectronicsMenuOption() {
        click(electronicsLink);
    }
    public void clickComputersMenuOption() {
        click(computersLink);
    }
    public void hoverOverComputersMenuOption() {
        hover(computersLink);
    }
    public void clickNotebooksOption() {
        click(notebooksLink);
    }
    public void clickDesktopOption() {
        click(desktopsLink);
    }
    public void clickMacbookPro13InchLink() {
        click(macbookPro13InchLink);
    }
    public void enterItemQuantity(String quantity) {
        click(itemQuantityInput);
        itemQuantityInput.clear();
        type(itemQuantityInput, quantity);
    }
    public void clickAddToCart() {
        click(addToCartButton);
    }
    public void clickCloseNotification() {
        click(closeNotificationButton);
    }
    public void clickShoppingCartNotification() {
        click(shoppingCartNotificationButton);
    }
    public void clickRegister() {click(registerLink);}

    public void clickHeaderMenu(String option) {
        for(WebElement element : headerList) {
            if(element.getText().contains(option)) {
                click(element);
                break;
            }
        }
    }
    /*public void selectTopMenuOption(String menuOption) {
        for (WebElement element : topMenuOptionsLinks) {
            if (element.getText().equalsIgnoreCase(menuOption)) {
                click(element);
                break;
            }
        }
    }*/
    public void hoverOverApparelMenuOption() {
        hover(apparelLink);
    }
    public void clickShoesOption() {
        click(shoesLink);
    }

}


