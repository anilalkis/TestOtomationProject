
package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

public class LoginFailSteps {
    
    WebDriver driver;

    @Given("kullanıcı başarısız giriş denemesi için login sayfasında")
    public void kullanici_login_sayfasinda() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("kullanıcı \"standard_user\" ve hatalı \"123456\" şifresini girer")
    public void kullanici_dogru_bilgileri_girer() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("login-button")).click();
    }

    @Then("kullanıcı hata mesajı görmelidir")
    public void kullanici_hata_mesaji_gormelidir() {
        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
        driver.quit();
    }
    
}
