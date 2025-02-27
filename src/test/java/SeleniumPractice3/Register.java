package SeleniumPractice3;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Register extends Base{
    @Test
    public void RegisterLink() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.linkText("My account")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Tony4");
        driver.findElement(By.id("input-lastname")).sendKeys("Stark4");
        driver.findElement(By.id("input-email")).sendKeys("tonys4@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("+91 9988776653");
        js.executeScript("window.scrollBy(0,360)","");
        driver.findElement(By.id("input-password")).sendKeys("Tonys@1234");
        driver.findElement(By.id("input-confirm")).sendKeys("Tonys@1234");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[@for='input-newsletter-yes']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@for='input-agree']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String msg= driver.findElement(By.xpath("//h1[@class='page-title my-3']")).getText();
        Assert.assertEquals(msg,"Your Account Has Been Created!");
        driver.findElement(By.linkText("Continue")).click();

    }
}
