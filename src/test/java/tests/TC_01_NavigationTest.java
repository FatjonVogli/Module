package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_01_NavigationTest {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://qatechhub.com/");
        String titleExpected="QA Automation Tools Trainings and Tutorials | QA Tech Hub";
        String title = driver.getTitle();

        if (title.equalsIgnoreCase(titleExpected)){
            System.out.println("Pass");
        } else System.out.println("Fail");

        WebElement demoSitesButton = driver.findElement(By.cssSelector("a[href='https://test.qatechhub.com']"));
        demoSitesButton.click();

        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.close();
        driver.quit();
    }
}
