package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TC_02_Checkbox_Radio {
    @Test
    public void test(){
        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://demo.guru99.com/test/radio.html");

        List< WebElement> checkboxes = driver.findElements(By.cssSelector("input[value*='checkbox']"));

        for (int i=0;i<checkboxes.size();i++){
            if (checkboxes.get(i).isSelected()){
                System.out.println("Checkbox "+i+ " is selected");
            }else {
                System.out.println("Checkbox "+i+ " is not selected");
            }
        }
    }
}
