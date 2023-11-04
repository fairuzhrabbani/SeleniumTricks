import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class DatePicker {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//        Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mdbootstrap.com/docs/standard/forms/datepicker/");

        WebElement icon = driver.findElement(By.xpath("//body/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[1]/section[2]/section[1]/div[1]/section[1]/div[1]/button[1]/i[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(icon).click().build().perform();
        Thread.sleep(2000);

        WebElement previous_button = driver.findElement(By.cssSelector(".datepicker-previous-button"));
        WebElement next_button = driver.findElement(By.cssSelector(".datepicker-next-button"));
        WebElement clear_button = driver.findElement(By.cssSelector(".datepicker-footer-btn.datepicker-clear-btn"));
        WebElement cancel_button = driver.findElement(By.cssSelector(".datepicker-footer-btn.datepicker-cancel-btn"));
        WebElement ok_button = driver.findElement(By.cssSelector(".datepicker-footer-btn.datepicker-ok-btn"));
        WebElement changeyear_button = driver.findElement(By.cssSelector(".datepicker-view-change-button"));
        List<WebElement> datepicker_cell = driver.findElements(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[2]/table[1]/tbody[1]/tr/td/div"));
//        List<WebElement> changedaylist_button = driver.findElements(By.xpath("//*[@class='datepicker-table-body']/tr/td/div"));

        String years = changeyear_button.getText().substring(8);
        System.out.println(years);

        if (years.equals("2023")){
            changeyear_button.click();
            Thread.sleep(2000);
            for (WebElement q : datepicker_cell){
                System.out.println(q.getText());
            }
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
