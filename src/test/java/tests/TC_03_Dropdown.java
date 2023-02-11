package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC_03_Dropdown {
    @Test
    public void test() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://demo.guru99.com/test/newtours/register.php");

        Select country = new Select(driver.findElement(By.cssSelector("select[name='country']")));
        country.selectByValue("ALBANIA");
        Thread.sleep(2000);
        country.selectByIndex(2);
        Thread.sleep(2000);
        country.selectByVisibleText("BELARUS");
    }
}
