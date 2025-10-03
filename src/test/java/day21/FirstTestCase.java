package day21;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/*
Test case
-----------

1) Launch Browser (Chrome)
2) Open URL https://demo.opencart.com/
3) Validate title should be "Your Store"
4) Close Browser
 */



public class FirstTestCase {

    public static void main(String[]args){

       // 1) Launch Browser (Chrome)
        //ChromeDriver driver = new ChromeDriver(); //Calling the constructor
        //WebDriver driver = new ChromeDriver(); //This is upcasting
        //WebDriver driver = new EdgeDriver();
        WebDriver driver = new FirefoxDriver();


        //2) Open URL https://demo.opencart.com/
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //3) Validate title should be "Your Store"
        String act_title=driver.getTitle();
        if (act_title.equals("Your Store")){
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }

        //4) Close Browser
        driver.close();
       // driver.quit();
    }
}
