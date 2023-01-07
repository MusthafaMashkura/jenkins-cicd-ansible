package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAutomation {

@Test

public void login() {

System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

WebDriver driver=new ChromeDriver();

driver.manage().window().maximize();

driver.get("https://www.browserstack.com/users/sign_in");

WebElement username=driver.findElement(By.id("user_email_Login"));

WebElement password=driver.findElement(By.id("user_password"));

WebElement login=driver.findElement(By.name("commit"));

username.sendKeys("abc@gmail.com");

password.sendKeys("your_password");

login.click();

String actualUrl="https://live.browserstack.com/dashboard";

String expectedUrl= driver.getCurrentUrl();

Assert.assertEquals(expectedUrl,actualUrl);
 }
}

public class jenkins_demo
{
 
@Test
public void testgooglesearch(){
 
WebDriver driver = new ChromeDriver();
//it will open the goggle page
driver.get("http://google.in"); 
//we expect the title “Google “ should be present 
String Expectedtitle = "Google";
//it will fetch the actual title 
String Actualtitle = driver.getTitle();
System.out.println("Before Assetion " + Expectedtitle + Actualtitle);
//it will compare actual title and expected title
Assert.assertEquals(Actualtitle, Expectedtitle);
//print out the result
System.out.println("After Assertion " + Expectedtitle + Actualtitle + " Title matched ");
 }
}
