import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class Check {

    public static void chromeTestWithDriverExclude() {
        //      Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

        System.out.println(cap);

        String os = cap.getPlatformName().toString();
        System.out.println("Platform " + os);

        String browserName = cap.getBrowserName().toLowerCase();
        System.out.println("Browser is " + browserName);

        String browserVersion = cap.getBrowserVersion().toString();
        System.out.println("Browser Version " + browserVersion);

        driver.close();
        driver.quit();
    }

    public static void chromeTestWithDriver(){
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

        System.out.println(cap);

        String os = cap.getPlatformName().toString();
        System.out.println("Platform " + os);

        String browserName = cap.getBrowserName().toLowerCase();
        System.out.println("Browser is " + browserName);

        String browserVersion = cap.getBrowserVersion().toString();
        System.out.println("Browser Version " + browserVersion);

        driver.close();
        driver.quit();
    }

    public static void chromeForTest(){
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:\\Automation\\ChromeTesting\\chrome.exe"))
                .build();

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(service,options);

        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

        System.out.println(cap);

        String os = cap.getPlatformName().toString();
        System.out.println("Platform " + os);

        String browserName = cap.getBrowserName().toLowerCase();
        System.out.println("Browser is " + browserName);

        String browserVersion = cap.getBrowserVersion().toString();
        System.out.println("Browser Version " + browserVersion);

        driver.close();
        driver.quit();
    }

    public static void main(String[] args) {
        chromeTestWithDriverExclude();
//        chromeTestWithDriver();
//          chromeForTest();
    }
}
