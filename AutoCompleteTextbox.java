import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutoCompleteTextbox {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//        Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://in.search.yahoo.com/?fr2=inr");
        driver.findElement(By.cssSelector("#yschsp")).sendKeys("Selenium");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']/li")));

        List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li"));

        System.out.println("Auto Suggest List :" + list.size());

        for(int i = 0 ;i< list.size();i++)
        {
            System.out.println(list.get(i).getText());

            if(list.get(i).getText().equalsIgnoreCase("selenium webdriver"))
            {
                list.get(i).click();
                break;
            }
        }
        WebElement result = driver.findElement(By.cssSelector("#yschsp"));
        System.out.println(result.getAttribute("value"));
        if(result.getAttribute("value").equals("selenium webdriver")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        Thread.sleep(2000);
        driver.quit();


    }
}
