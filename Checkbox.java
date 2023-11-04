import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Checkbox {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//        Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/automation-practice-form");

//        Cara Pertama
        WebElement sport = driver.findElement(By.cssSelector("#hobbies-checkbox-1"));
        WebElement reading = driver.findElement(By.cssSelector("#hobbies-checkbox-2"));
        WebElement music = driver.findElement(By.cssSelector("#hobbies-checkbox-3"));
//          Scroll to element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reading);
        Thread.sleep(2000);
//        Action
        Actions actions = new Actions(driver);
        actions.moveToElement(sport).click().build().perform();
        actions.moveToElement(music).click().build().perform();
        System.out.println("Sport selected is " + sport.isSelected());
        System.out.println("Reading selected is " + reading.isSelected());
        System.out.println("Music selected is " + music.isSelected());
        System.out.println();
        actions.moveToElement(music).click().build().perform();
        System.out.println("Sport selected is " + sport.isSelected());
        System.out.println("Reading selected is " + reading.isSelected());
        System.out.println("Music selected is " + music.isSelected());
        System.out.println();
//        Cara Kedua
        List<WebElement> hobbies_input = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']/div[2]/div/input"));
//        List<WebElement> hobbies_label = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']/div[2]/div/label"));
        System.out.println("hobbies_input is :" + hobbies_input.size());
        //          Scroll to element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reading);
        for (WebElement q: hobbies_input){
            System.out.println(q.getAttribute("value"));
//            System.out.println(q.getText());
            System.out.println("Selected " + q.isSelected());
            System.out.println("Displayed " + q.isDisplayed());
            System.out.println("Enabled " + q.isEnabled());
            System.out.println("===============================");
            if(q.getAttribute("value").equals("3")){
                Actions actionskedua = new Actions(driver);
                actionskedua.moveToElement(q).click().build().perform();
                System.out.println("Apakah terselected " + q.isSelected());
                break;
            }
        }
        Thread.sleep(2000);
        driver.quit();

    }
}
