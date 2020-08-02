package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;

    public String SITE_URL = "https://aliexpress.ru/";
    public String LOGIN = "jasex11393@in4mail.net";
    public String PASSWORD = "qaz123";

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=src\\main\\resources\\Profiles");
        options.addArguments("--profile-directory=Profile 1");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    public void closeAdvertisement() {
        try {
            driver.findElement(By.className("close-layer")).click();
        } catch (NoSuchElementException e) {
            System.out.println("No advertisement");
        }
    }

    public void loginInAcc() {
        try {
            // 3. Click Enter button
            driver.findElement(By.linkText("Войти")).click();
            // 4. Wait 3 sec for load frame
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            // 5. Switch to frame
            driver.switchTo().frame("alibaba-login-box");
            // 6. Enter login
//            driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/div[1]/div/input")).sendKeys(login);
            // 7. Enter password
            driver.findElement(By.id("fm-login-password")).sendKeys(PASSWORD);
            // 8. Click submit button
            driver.findElement(By.className("password-login")).click();
        }
        catch (NoSuchElementException e) {
            System.out.println("Registration not required");
        }
    }
}
