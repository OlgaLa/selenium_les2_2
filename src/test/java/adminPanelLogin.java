import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * Created by olapanovich on 23.6.17.
 */
public class adminPanelLogin {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final String URL = "http://localhost/litecart/admin/";
    private static final String LOGIN = "admin";
    private static final String PASSWORD = "admin";


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "../chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void adminPanelLoginTest() {
        driver.get(URL);
        driver.findElement(By.name("username")).sendKeys(LOGIN);
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        driver.findElement(By.name("login")).click();
        wait.until(visibilityOf(driver.findElement(By.cssSelector(".fa-sign-out"))));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
