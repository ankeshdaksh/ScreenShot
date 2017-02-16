package nop;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Acer on 10/01/2017.
 */
public class ChangeCurrency extends BasePage {
    @FindBy(id = "customerCurrency")
    WebElement customerCurrence;
    @FindBy(css = "[class='product-title'] [href='/25-virtual-gift-card']")
    WebElement productTitle;
    @FindBy(xpath = "//span[text()='€19.75']")
    WebElement currencyChangedInToEuro;
    @FindBy(xpath = "//span[text()='$25.00']")
    WebElement currencyChangedInToDollar;


//    public void changeTheCurrency(String Currency) throws InterruptedException {
//       // driver.findElement(By.linkText(Currency)).click();
//        customerCurrence.click();
//        customerCurrence.sendKeys("Euro");


    public void changeTheCurrency() throws InterruptedException {
        currencyUsDollar();
        currencyEuro();

    }

    private void currencyEuro() {
        customerCurrence.click();
        customerCurrence.sendKeys("Euro");
        currencyChangedInToEuro.getText();
        System.out.println("product prices====" + currencyChangedInToEuro.getText());
        Assert.assertTrue(currencyChangedInToEuro.getText().contains("€19.75"));

    }

    private void currencyUsDollar() throws InterruptedException {
        Thread.sleep(5000);
        customerCurrence.click();
        customerCurrence.sendKeys("US Dollar");
        currencyChangedInToDollar.getText();
        System.out.println("product prices====" + currencyChangedInToDollar.getText());
        Assert.assertTrue(currencyChangedInToDollar.getText().contains("$25.00"));
    }




}
