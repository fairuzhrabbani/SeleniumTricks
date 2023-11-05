import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DropdownV3 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//        Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        Thread.sleep(2000);

        String destination = "BLR";
        driver.findElement(By.xpath("//a[@value='"+destination+"']")).click();
//        System.out.println(driver.findElement(By.xpath("//a[@value='"+destination+"']")).getAttribute("selectedtext"));
        System.out.println(driver.findElement(By.xpath("//a[@value='"+destination+"']")).getText());

        Thread.sleep(2000);

        String arrived = "MAA";
//        driver.findElement(By.xpath("(//a[@value='"+arrived+"'])[1]")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='"+arrived+"']")).click();
//        System.out.println(driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='"+arrived+"']")).getAttribute("selectedtext"));
        System.out.println(driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='"+arrived+"']")).getText());
        Thread.sleep(2000);


    }
}
