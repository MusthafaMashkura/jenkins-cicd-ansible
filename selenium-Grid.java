import org.openqa.selenium.*; 
import org.openqa.selenium.remote.DesiredCapabilities; 
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.MalformedURLException; 
import java.net.URL; 
import org.openqa.selenium.remote.RemoteWebDriver; 
import java.util.logging.*;
//import log4j;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.*;


public class SeleniumGridTest {
  
//  private static Logger log = LogManager.getLogger(SeleniumGridTest.class);
  
 // @Test
  //public void JenkinsDemoFunc() throws MalformedURLException {
  //  public void JenkinsDemoFunc(){
  public static void main(String[] args) throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        //initialize chromeOptions
        chromeOptions.setCapability("browserName", "chrome");
        //Define on which browser you want to execute your tests.
        chromeOptions.setCapability("platformName", "LINUX");
        //Define in which mode your tests will run.
        chromeOptions.addArguments("--headless");
        //Define the platform on which you will execute your tests
        WebDriver driver = new RemoteWebDriver(new URL("http://13.232.140.244:4445/wd/hub"), chromeOptions);
        //URL to the hub running on your local system
        driver.get("http://13.232.140.244:8080/hello-world-maven/");
        //URL to hit
 //       log.debug(driver.getTitle());
        //Print the title of the webpage
 //       log.debug(driver.getCurrentUrl());
        //Print the URL of the current webpage
//        driver.quit();
        //Close the browser
    
   //                 Thread.sleep(1000);
 
                if (driver.getPageSource().contains("ansible")) {
                        System.out.println("Pass");
                } else {
                        System.out.println("Fail");
                }
                driver.quit();
    }
}
