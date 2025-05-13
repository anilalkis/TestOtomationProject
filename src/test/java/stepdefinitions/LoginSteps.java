
package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

    WebDriver driver;

    @Given("kullanıcı login sayfasındadır")
    public void kullanici_login_sayfasinda() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("kullanıcı doğru kullanıcı adı ve şifreyi girer")
    public void kullanici_dogru_bilgileri_girer() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Then("ana sayfaya yönlendirilmelidir")
    public void ana_sayfaya_yonlendirilmelidir() {
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains("inventory");
        driver.quit();
    }
}
