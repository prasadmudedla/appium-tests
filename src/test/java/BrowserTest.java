import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserTest {

    public AppiumDriver driver;
    DesiredCapabilities caps;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
        caps.setCapability(MobileCapabilityType.BROWSER_VERSION, "85");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @Test
    public void BrowserTest() {
        driver.get("https://www.nzta.govt.nz/");
        driver.get("https://www.nzta.govt.nz/roads-and-rail/toll-roads/");
        scrollDowntoXPath("//span[text()='Pay a toll']", driver);
        WebElement payATollLink = driver.findElement(By.xpath("//span[text()='Pay a toll']"));
        payATollLink.click();
    }

    public static void scrollDowntoXPath(String xPath, AppiumDriver driver) {
        boolean flag=true;
        int count=1;
        while(flag){
            try {
                driver.findElement(By.xpath(xPath));
                flag=false;
                break;
            }
            catch(Exception NoSuchElementException) {
                count=count+1;
                Map<String, Object> params = new HashMap<>();
                params.put("start","40%,90%");
                params.put("end","40%,20%");
                params.put("duration","2");
                Object res= driver.executeScript("mobile:touch:swipe",params);
                if(count==5)
                {
                    break;
                }
            }
        }
    }

    public static void scroll() {
//        HashMap<String, String> scrollObject = new HashMap<String, String>();
//        RemoteWebElement element = (RemoteWebElement) driver.findElement(By.tagName(scrollableElement));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        String widId = ((RemoteWebElement) element).getId();
//        scrollObject.put("text", text);
//        scrollObject.put("element", widId);
//        js.executeScript("mobile: scrollTo", scrollObject);
    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
