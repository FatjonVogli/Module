package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_04_Actions {
    WebDriver driver;
    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver= new ChromeDriver();

        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        WebElement menuButton = driver.findElement(By.cssSelector("span[class*='context-menu-one']"));

        WebElement editButton = driver.findElement(By.cssSelector("ul[class*='menu-root'] li[class*='edit']"));
        Actions actions = new Actions(driver);
        actions.contextClick(menuButton).perform();
        Thread.sleep(500);
        editButton.click();

        driver.switchTo().alert().accept();

        driver.close();
        driver.quit();
    }


    @Test
    public void test2(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://demoqa.com/menu/");

        WebDriverWait wait = new WebDriverWait(driver, 20);

        //Instantiate Action Class
        Actions actions = new Actions(driver);
        //Retrieve WebElement 'Second Menu' to perform mouse hover
        WebElement secondMenu = driver.findElement(By.xpath("//a[text() = 'Main Item 2']"));
        wait.until(ExpectedConditions.visibilityOf(secondMenu));
        actions.moveToElement(secondMenu).perform();

        System.out.println("Done Mouse hover on 'Menu 2' from Menu");

        WebElement subSubMenu = driver.findElement(By.xpath("//a[text() = 'SUB SUB LIST »']"));

        wait.until(ExpectedConditions.visibilityOf(subSubMenu));
        actions.moveToElement(subSubMenu).perform();

        driver.close();
        driver.quit();
    }

    @Test
    public void test3() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://demoqa.com/droppable/");

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        //Actions class method to drag and drop
        Actions builder = new Actions(driver);

        WebElement from = driver.findElement(By.id("draggable"));

        WebElement to = driver.findElement(By.id("droppable"));
        //Perform drag and drop
        builder.dragAndDrop(from, to).perform();
        Thread.sleep(2000);

        //verify text changed in to 'Drop here' box
        String textTo = to.getText();

        if(textTo.equals("Dropped!")) {
            System.out.println("PASS: Source is dropped to target as expected");
        }else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected");
        }

        driver.close();
        driver.quit();
    }
}
