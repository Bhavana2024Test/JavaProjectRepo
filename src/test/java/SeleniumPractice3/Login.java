package SeleniumPractice3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Login extends Base{
    public void login_page() throws InterruptedException {
        driver.findElement(By.linkText("My account")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("tonys2@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Tonys@1232");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

    }

    public void logout() throws InterruptedException {
        //logout
        WebElement hover=  driver.findElement(By.linkText("My account"));
        Actions action = new Actions(driver);
        action.moveToElement(hover).perform();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Logout")).click();

        String logout_msg=driver.findElement(By.xpath("//h1[@class='page-title my-3']")).getText();
        Assert.assertEquals(logout_msg,"Account Logout");

        driver.findElement(By.linkText("Continue")).click();
    }
}
