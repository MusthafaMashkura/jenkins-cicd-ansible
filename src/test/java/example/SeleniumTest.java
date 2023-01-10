package example;

import java.io.IOException; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
 
public class SeleniumTest {
 
@Test
 
        public static void main(String[] args) throws IOException, InterruptedException {
                System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--no-sandbox");
 
                WebDriver driver = new ChromeDriver(chromeOptions);
 
         //       driver.get("https://google.com");
                driver.get("http://13.232.140.244:8080/hello-world-maven/");
 
                Thread.sleep(1000);
 
         //       if (driver.getPageSource().contains("I'm Feeling Lucky")) {
                if (driver.getPageSource().contains("ansible roles")) {
                        System.out.println("Pass");
                } else {
                        System.out.println("Fail");
                }
                driver.quit();
        }
}
