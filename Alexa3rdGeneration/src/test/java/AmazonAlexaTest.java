import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AmazonAlexaTest {

        WebDriver driver;

        @BeforeTest
        public void setup() {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Syed\\IdeaProjects\\Alexa3rdGeneration\\src\\test\\resources\\geckodriver.exe");
                //driver = new FirefoxDriver();
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Syed\\IdeaProjects\\Alexa3rdGeneration\\src\\test\\resources\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @Test
        public void gotoamazon() {
                driver.get("https://www.amazon.com/");
                //assert driver.getTitle().contains("Amazon");
                if(driver.getTitle().contains("Amazon"))
                        System.out.println("The Tiltle Contains Amazon." );
                        else System.out.println("FAILED");
                driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Alexa " + Keys.ARROW_DOWN + Keys.ARROW_DOWN + Keys.ENTER);
                driver.findElement(By.linkText("All-new Echo Dot (3rd Gen) - Smart speaker with Alexa - Charcoal")).click();
                String price = driver.findElement(By.id("priceblock_ourprice")).getText();
                System.out.println("PRICE = " + price);

        }

        @AfterTest
        public void teardown() {
                try {
                        Thread.sleep(5000);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
                //driver.close();
                driver.quit();
        }
}