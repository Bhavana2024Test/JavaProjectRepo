package SeleniumPractice2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class sauceDemoFilter extends SaucedemoLoginpage {

    @Test
    public void add_prod()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement filter = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(filter);

        select.selectByValue("za");
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("Tony");
        driver.findElement(By.id("last-name")).sendKeys("Stark");
        driver.findElement(By.id("postal-code")).sendKeys("4311");

        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("finish")).click();

        String msg = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
        Assert.assertEquals("Thank you for your order!", msg);

        driver.findElement(By.id("back-to-products")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();

        driver.findElement(By.id("logout_sidebar_link")).click();
    }
}
