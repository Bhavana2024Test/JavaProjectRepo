package SeleniumPractice3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
    WebDriver driver ;
    JavascriptExecutor js;
    @BeforeTest
    public void launch_page() {
        driver = new ChromeDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/");
        driver.manage().window().maximize();
        js= (JavascriptExecutor) driver;

    }

    @AfterTest
    public void tear_down()
    {
        driver.quit();
    }
}
