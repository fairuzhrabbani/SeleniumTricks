import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

//        Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

//        Explicit wait
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='error-message-container error']"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        wait.until(driver1 -> errorMessage.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-message-container error']")));
        boolean errorMsg = errorMessage.isDisplayed();
        System.out.println(errorMsg);

        driver.quit();

    }
}
