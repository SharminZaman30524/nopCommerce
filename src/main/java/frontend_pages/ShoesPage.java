package frontend_pages;

import base.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ShoesPage extends Common {
    @FindBy(xpath = "//select[@aria-label='Select product sort order']//option") public List<WebElement> sortOptionsDropdown;
    @FindBy(xpath = "//div[@class='prices']") public List<WebElement> listOfUnorderedPrices;
    @FindBy(xpath = "//div[@class='product-item']") public List<WebElement> listOfProductNames;


    public ShoesPage() {
        PageFactory.initElements(driver,this);
    }
    public void selectSortOptionFromDropdown(String option) {
        for (WebElement element : sortOptionsDropdown) {
            if (element.getText().equalsIgnoreCase(option)) {
                click(element);
            }
        }
    }
    public List<Float> getPrices() {
        List<Float> listOfPrices = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            listOfPrices.add(Float.parseFloat(listOfUnorderedPrices.get(i).getText().substring(1)));
        }
        return listOfPrices;
    }
    public List<String> getProductNames() {
        List<String> productNameList = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            productNameList.add(listOfProductNames.get(i).getText());
        }
        return productNameList;
    }

}
