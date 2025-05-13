package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

public class AddToCartSteps {
    
    WebDriver driver;

    @Given("kullanıcı geçerli bilgilerle giriş yapar")
    public void kullanici_giris_yapar() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("kullanıcı 'sauce labs backpack' urunu sepete ekler")
    public void kullanici_urunu_sepete_ekler() {
        driver.findElement(By.xpath("//button[contains(@id, 'to-cart-sauce-labs-backpack')]")).click();
    }

    @And("sepetim butonuna tıklanır,sepete gidilir")
    public void sepetim_butonuna_tiklanir_sepete_gidilir(){
        WebElement cartLink = driver.findElement(By.id("shopping_cart_container"));
        Actions actions = new Actions(driver);
        actions.moveToElement(cartLink).click().perform();
    }

    @Then("'sauce labs backpack' urununun sepete eklendiği kontrol edilir")
    public void urunun_sepete_eklendigi_kontrol_edilir(){
        WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]"));
        Assert.assertTrue(element.isDisplayed());
        driver.quit();
    }
}
