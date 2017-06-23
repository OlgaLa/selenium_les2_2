import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;


/**
 * Created by olapanovich on 23.6.17.
 */
public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final String URL = "https://www.google.com";


    @BeforeMethod
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "../chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myFirstTest() {
        driver.get(URL);
        driver.findElement(By.cssSelector(".gsfi")).sendKeys("webdriver");
        driver.findElement(By.cssSelector(".jsb>center>input")).click();
        wait.until(titleContains("webdriver"));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
