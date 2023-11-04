import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Pagination {



    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//        Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://datatables.net/");

        List<WebElement> show_data = driver.findElements(By.cssSelector("select[name='example_length'] option"));
        System.out.println(show_data.size());

        ArrayList actual_show_data = new ArrayList();
        for (WebElement q : show_data){
//            System.out.println(q.getText());
            actual_show_data.   add(q.getText());
        }
        driver.close();
        driver.quit();
    }
}
