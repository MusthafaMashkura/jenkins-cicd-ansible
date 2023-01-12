package example;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

 public class SeleniumGrid {

     WebDriver driver;
     String baseURL, nodeURL;

     @BeforeTest
     public void setUp() throws MalformedURLException {
         ChromeOptions chromeOptions = new ChromeOptions();
         baseURL = "http://13.232.140.244:8080/hello-world-maven/";
         nodeURL = "http://13.232.140.244:4445/wd/hub";
         DesiredCapabilities capability = DesiredCapabilities.chrome();
         capability.setBrowserName("chrome");
         capability.setPlatform(Platform.LINUX);
         chromeOptions.addArguments("--headless");
         chromeOptions.addArguments("--no-sandbox");
         driver = new RemoteWebDriver(new URL(nodeURL), capability);
     }

     @AfterTest
     public void afterTest() {
         driver.quit();
     }
     @Test
     public void sampleTest() {
         driver.get(baseURL);
         

         if (driver.getPageSource().contains("ansible")) {
             Assert.assertTrue(true, "Ansible word Found");
         } else {
             Assert.assertTrue(false, "Failed: Ansible word not found");
         }

     }

 }
