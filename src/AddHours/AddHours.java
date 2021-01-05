package AddHours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddHours {
    public static void main(String[] args){
        //Instance an object WebDriver
        WebDriver driver;

        //Declare variables
        String baseURL = "https://auth.openair.com/login";


        //Indicate chromedriver.exe file localization in the property
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        //Launch a new Chrome browser.
        driver = new ChromeDriver();

        //Open URL https://testpages.herokuapp.com/styled/index.html
        driver.get(baseURL);
        String useriD = "luis.castillo@agilethought.com";
        String companyID = "demouser";

        //Send user name
        driver.findElement(By.xpath("//*[@id=\"login\"]/label[1]/input")).sendKeys(useriD);
    }
}
