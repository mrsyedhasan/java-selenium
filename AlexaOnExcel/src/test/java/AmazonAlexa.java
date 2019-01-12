import PageObject.amazonalexa;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static java.lang.Thread.sleep;

public class AmazonAlexa extends amazonalexa {




    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/syedhasan/Desktop/AlexaOnExcel/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //driver.get("https://www.google.com/");

    }

    @Test
    public void searchtype() {
        //goto amazon.com
        gotoamazon();

        //wait 5 seconds.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // confirming Amazon is the title page.

        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        // confirming Amazon is the title page.
        if (driver.getTitle().contains("Amazon"))
            System.out.println("The title contains" + " Amazon.");
        else System.out.println("failed");

        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Alexa " + Keys.ARROW_DOWN + Keys.ARROW_DOWN + Keys.ENTER);

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Search  Alexa on Amazon and press Return Key.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Alexa " + Keys.RETURN);

        Actions actions = new Actions(driver);

        WebElement main = driver.findElement(By.linkText("All-new Echo Dot (3rd Gen) - Smart speaker with Alexa - Charcoal"));

        actions.moveToElement(main);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.click().build().perform();

        String price = driver.findElement(By.id("priceblock_dealprice")).getText();
        System.out.println("Price = " + price);

    }

    @AfterTest
    public void teardown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
        driver.quit();

    }
}