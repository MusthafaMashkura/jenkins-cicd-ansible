package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAutomation {

@Test

public void login() {

System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
 
// TESTING CONTENT
ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.addArguments("--headless");
chromeOptions.addArguments("--no-sandbox");
WebDriver driver=new ChromeDriver(chromeOptions);

// chromeOptions = webdriver.ChromeOptions();
// chromeOptions.addArguments("--headless");
// chromeOptions.addArguments("--no-sandbox");
// driver = webdriver.Chrome('/usr/bin/chromedriver',chrome_options=chromeOptions);
// TESTING CONTENT 
 
 //WebDriver driver=new ChromeDriver();

driver.manage().window().maximize();

driver.get("https://www.browserstack.com/users/sign_in");

 //added below line
driver.findElement(By.id("user_email_login"));
//
WebElement username=driver.findElement(By.id("user_email_login"));

//added below line
driver.findElement(By.id("user_password"));
//
WebElement password=driver.findElement(By.id("user_password"));
 
WebElement login=driver.findElement(By.name("commit"));

username.sendKeys("musthamsd@gmail.com");

password.sendKeys("Mashkura@143");

login.click();

String actualUrl="https://live.browserstack.com/dashboard";

String expectedUrl= driver.getCurrentUrl();

Assert.assertEquals(expectedUrl,actualUrl);
 }
}
