package day45;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DataProviderDemo {


WebDriver driver;

@BeforeClass
        void setup()
        {
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        @Test(dataProvider = "loginData")
        void testLogin (String email, String password) throws InterruptedException {
                driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
                driver.manage().window().maximize();
                driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
                driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
                driver.findElement(By.xpath("//input[@value='Login']")).click();
                Thread.sleep(2000);

                boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
                if(status==true) {
                        driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
                        Assert.assertTrue(true);
                }else
                        {
                                Assert.fail();
                        }

                }

@AfterClass
        void tearDown ()
        {
                driver.close();
        }
        @DataProvider(name = "loginData")
        public Object[][] loginData() {
                return new Object[][] {
                        {"jaybb@gmail.com", "jay@123"},      // valid
                        {"jaycc@gmai.com", "jaycc@123"},  // invalid
                        {"jaydd@gmail.com", "jaydd@123"},
                        {"jayee@gmail.com", "jayee@123"}
                };
        }

    }



