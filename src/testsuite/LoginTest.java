package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValid() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); //Enter valid username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); //Enter valid password
        driver.findElement(By.id("login-button")).click();
        String expectedText = "Products"; //expected Result
        String actualText = driver.findElement(By.className("title")).getText(); //Actual Result
        Assert.assertEquals("not valid",expectedText,actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); //Enter valid username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); //Enter valid password
        driver.findElement(By.id("login-button")).click();
        int expectedText = 6;
        List<WebElement> productElementList = driver.findElements(By.className("inventory_item"));
        int actualproduct = productElementList.size();
        System.out.println("Total products are :" +productElementList.size());
        Assert.assertEquals("Product should be 6",actualproduct,expectedText);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }

}
