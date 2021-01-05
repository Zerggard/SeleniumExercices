package info.SeleniumExercises.Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeThree {
    public static void main(String[] args){
        //Instance an object WebDriver
        WebDriver driver;

        //Declare variables
        String baseURL = "https://www.ancestry.com/name-origin?surname=register/";
        WebElement webElementName;
        WebElement webElementLastName;

        //Indicate chromedriver.exe file localization in the property
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        //Launch a new Chrome browser.
        driver = new ChromeDriver();

        //Open URL https://www.ancestry.com/name-origin?surname=register/
        driver.get(baseURL);

        //Type Name & Last Name (Use Name locator)
        webElementName = driver.findElement(By.name("gsfn"));
       webElementName.sendKeys("Luis");

        //Click on Submit button (Use ID locator)
        webElementLastName = driver.findElement(By.name("gsln"));
        webElementLastName.clear();
        webElementLastName.sendKeys("Castillo");

        //Click submit
        driver.findElement(By.id("exploreSubmit")).submit();
    }
}
