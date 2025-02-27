package SeleniumPractice3;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class HumburgerMenu  extends Login{

    @Test
    public void humburgerMenu1() throws InterruptedException {
        login_page();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //click on category
        driver.findElement(By.linkText("Shop by Category")).click();
        driver.findElement(By.linkText("Cameras")).click();

        //click on product
        js.executeScript("window.scrollBy(0,440)","");
        driver.findElement(By.linkText("HTC Touch HD")).click();

        //increase product count
        js.executeScript("window.scrollBy(0,340)","");
        driver.findElement(By.xpath("//div[2]//input[@name='quantity']")).clear();
        driver.findElement(By.xpath("//div[2]//input[@name='quantity']")).sendKeys("3");

        // driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@title='Buy now']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='number']")).clear();
        driver.findElement(By.xpath("//input[@type='number']")).sendKeys("1");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#checkout-cart > table > tbody > tr > td:nth-child(3) > div > div > button.btn.btn-primary")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@title='Remove']")).click();
        Thread.sleep(1000);
        String emptymsg= driver.findElement(By.xpath("//div[@id='content']//p")).getText();
        Assert.assertEquals(emptymsg,"Your shopping cart is empty!");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Continue")).click();
    }
}
