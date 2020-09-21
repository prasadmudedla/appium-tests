import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class SampleTest {
    public AppiumDriver driver;
    DesiredCapabilities caps;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.android.calculator2");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,".Calculator");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

    }

    @Test
    public void SampleTest(){

        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='plus']")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='equals']")).click();

    }


    @Test
    public void BrowserTest() {

    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }




}
