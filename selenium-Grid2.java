import org.openqa.selenium.*; 
import org.openqa.selenium.remote.DesiredCapabilities; 
import java.net.MalformedURLException; 
import java.net.URL; 
import org.openqa.selenium.remote.RemoteWebDriver; 
import org.testng.Assert;
import org.testng.annotations.*; 

public class Grid_2 {
 WebDriver driver;
 String baseUrl, nodeURL; 
 @BeforeTest 
 public void setUpWthrows MalformedURLException {
 baseUrl = "http://newtours.demoaut.com/";
 nodeURL = "http://192.168.1.4:5566/wd/hub"; 
 DesiredCapabilities capability = DesiredCapabilities.firefox();
 capability. setBrowserName("firefox");
 capability. setPlatform(Platform.XP);
 driver = new RemoteWebDriver(new URL(nodeURL), capability); 
} 
@AfterTest 
public void afterTest() {
 driver.quit(); 
 }
@Test 
public void simpleTest() { 
driver.get(baseUr1);
 Assert.assertEquas("Welcome: Mercury Tours", driver.getTitle()); } 
}
