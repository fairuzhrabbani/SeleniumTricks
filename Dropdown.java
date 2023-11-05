import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Dropdown {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//        Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.automationtesting.in/Register.html");

        WebElement skills = driver.findElement(By.id("Skills"));
        Select drpSkills = new Select(skills);
//        drpSkills.selectByIndex(4);
//        drpSkills.selectByValue("Certifications");
        drpSkills.selectByVisibleText("Certifications");
        System.out.println(drpSkills.getFirstSelectedOption().getText());

        List<WebElement> listSkills1 = drpSkills.getOptions();
        System.out.println(listSkills1.size());

        WebElement resultSkill = driver.findElement(By.id("Skills"));
        System.out.println(resultSkill.getAttribute("value"));
        Thread.sleep(2000);

        List<WebElement> listSkills = driver.findElements(By.xpath("//select[@id='Skills']/option"));
        System.out.println(listSkills.size()); // 78

//        Create New Array
        List<String> actListSkills = new ArrayList<String>();
        for (WebElement q: listSkills){
//            System.out.println(q.getText());
            actListSkills.add(q.getText());
        }
        System.out.println(actListSkills);
        System.out.println(actListSkills.get(1));

        driver.quit();
    }
}
