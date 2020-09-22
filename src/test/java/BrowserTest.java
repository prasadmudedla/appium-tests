import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserTest {

    public AppiumDriver driver;
    DesiredCapabilities caps;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
        caps.setCapability(MobileCapabilityType.BROWSER_VERSION, "74");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    @Test
    public void BrowserTest() throws InterruptedException {
        driver.get("https://www.nzta.govt.nz/");
        WebElement payATollLink = driver.findElement(By.xpath("//div[4]//ul/li[5]/a/span"));
        payATollLink.click();
        WebElement buyOrPayAToll = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/div/div/div[1]/p[1]/a"));
        buyOrPayAToll.click();
        WebElement declareReg = driver.findElement(By.xpath("/html/body/div[5]/ui-view/div[2]/div/div/form/fieldset[1]/div/div[2]/ul/li/input"));
        declareReg.click();
        WebElement continueButton = driver.findElement(By.xpath("/html/body/div[5]/ui-view/div[2]/div/div/form/fieldset[2]/div/span/input"));
        continueButton.click();
        WebElement plateField = driver.findElement(By.xpath("/html/body/div[5]/ui-view/div[2]/div/div/form/fieldset[1]/div/span/input"));
        plateField.sendKeys("CYJ421");
        WebElement numberContinueButton = driver.findElement(By.xpath("/html/body/div[5]/ui-view/div[2]/div/div/form/fieldset[2]/div/span/input"));
        numberContinueButton.click();
        Thread.sleep(5000);
        WebElement confirmContinue = driver.findElement(By.xpath("/html/body/div[5]/ui-view/div[2]/div/div/form/div/span/input"));
        confirmContinue.click();
        WebElement northernGateToll = driver.findElement(By.xpath("/html/body/div[5]/ui-view/div[2]/div/div/form/div[1]/div[1]/div/span/input"));
        WebElement taurangaToll = driver.findElement(By.xpath("/html/body/div[5]/ui-view/div[2]/div/div/form/div[2]/div[1]/div/span/input"));
        WebElement takitimuToll = driver.findElement(By.xpath("/html/body/div[5]/ui-view/div[2]/div/div/form/div[3]/div[1]/div/span/input"));
        northernGateToll.sendKeys("1");
        taurangaToll.sendKeys("2");
        takitimuToll.sendKeys("3");
        WebElement tollPriceContinue = driver.findElement(By.xpath("/html/body/div[5]/ui-view/div[2]/div/div/form/div[4]/span/input"));
        tollPriceContinue.click();
        WebElement noEmail = driver.findElement(By.xpath("/html/body/div[5]/ui-view/div[2]/div/div/div/form/div[1]/div/ul/li[2]/label"));
        noEmail.click();
        WebElement noEmailConfirmButton = driver.findElement(By.xpath("/html/body/div[5]/ui-view/div[2]/div/div/div/form/div[2]/span/input"));
        noEmailConfirmButton.click();
        WebElement payNowButton = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/span/input"));
        payNowButton.click();

    }

    public void waitforElementXpath(String str) {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str)));
    }




    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
