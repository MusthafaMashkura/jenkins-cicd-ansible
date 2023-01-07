package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class jenkins_demo
{
 
@Test
public void testgooglesearch(){

// TESTING CONTENT
//ChromeOptions chromeOptions = new ChromeOptions();
//chromeOptions.addArguments("--headless");
//chromeOptions.addArguments("--no-sandbox");

//WebDriver driver=new ChromeDriver(chromeOptions);
chromeOptions = webdriver.ChromeOptions();
chromeOptions.add_argument("--headless");
//chromeOptions.add_argument("--remote-debugging-port=9222")
chromeOptions.add_argument('--no-sandbox');

driver = webdriver.Chrome('/usr/bin/chromedriver',chrome_options=chromeOptions);
 //WebDriver driver=new ChromeDriver();

// TESTING CONTENT
 
//WebDriver driver = new ChromeDriver();
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
