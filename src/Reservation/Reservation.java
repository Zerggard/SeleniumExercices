package Reservation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Reservation {
    public static void main(String[] args) throws InterruptedException {
        //Instance an object WebDriver
        WebDriver driver;

        //Declare variables
        String baseURL = "https://phptravels.net/";
        boolean payment = true;


        //Indicate chromedriver.exe file localization in the property
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        //Launch a new Chrome browser.
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Open URL https://testpages.herokuapp.com/styled/index.html
        driver.get(baseURL);
        String user = "user@phptravels.com";
        String password = "demouser";
        String urlActual = "";

        driver.findElement(By.xpath("//*[@id=\"//header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[3]/div")).click();
        Thread.sleep(1000);

        //Click in login button
        driver.findElement(By.xpath("//*[@id=\"//header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[3]/div/div/div/a[1]")).click();
        Thread.sleep(1000);

        //Write username
        driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[3]/div[1]/label/input")).sendKeys(user);
        Thread.sleep(1000);

        //Write password
        driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[3]/div[2]/label/input")).sendKeys(password);
        Thread.sleep(1000);

        //Click login button
        driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/button")).click();
        Thread.sleep(1000);

        //Click Home
        driver.findElement(By.xpath("//*[@id=\"mobileMenuMain\"]/nav/ul[1]/li/a")).click();
        Thread.sleep(1000);


        //Click in HOTELS option
        driver.findElement(By.xpath("//*[@id=\"search\"]/div/div/div/div/div/nav/ul/li[1]/a")).click();
        Thread.sleep(1000);

        //Click Destination
        {
            WebElement element = driver.findElement(By.xpath("//div[@id=\'s2id_autogen16\']/a/span"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();

        }
        {
            WebElement element = driver.findElement(By.xpath("(//input[@type=\'text\'])[44]"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
            Thread.sleep(1000);
        }
        driver.findElement(By.id("checkin")).sendKeys("Istanbul");
        driver.findElement(By.id("checkin")).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        driver.findElement(By.id("checkin")).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        driver.findElement(By.id("checkin")).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        driver.findElement(By.id("checkin")).sendKeys(Keys.ENTER);

        //Click on check in datepicker
        driver.findElement(By.xpath("//*[@id=\"checkin\"]")).click();
        Thread.sleep(1000);

        //Click date check in
        driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[1]/div/div/div[2]/div[19]")).click();
        Thread.sleep(1000);

        //Click date check out
        driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[2]/div/div/div[2]/div[27]")).click();
        Thread.sleep(1000);

        //Click add child
        driver.findElement(By.xpath("//*[@id=\"hotels\"]/div/div/form/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div[2]/div/span/button[1]")).click();
        Thread.sleep(1000);

        //Click search
        driver.findElement(By.xpath("//*[@id=\"hotels\"]/div/div/form/div/div/div[4]/button")).click();

        //Click on hotel that have been selected
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/section/div/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/div/div[1]/div/div[1]/h5/a")).click();
        Thread.sleep(1000);

        //Click on Select Room
        List<WebElement> oCheckBox = driver.findElements(By.name("rooms[]"));
        // This will tell you the number of checkboxes are present
        int iSize = oCheckBox.size();
        // Start the loop from first checkbox to last checkboxe
        for(int i=0; i < iSize ; i++ ) {
            // Store the checkbox name to the string variable, using 'Value' attribute
            String sValue = oCheckBox.get(i).getAttribute("value");
            if (sValue.equalsIgnoreCase("9")) {
                oCheckBox.get(i).sendKeys(Keys.SPACE);
            }
        }

        //Click on book now button
        driver.findElement(By.xpath("//*[@id=\"detail-content-sticky-nav-02\"]/form/div/button")).click();
        Thread.sleep(1000);

        //Click Confirm this booking button
        WebElement element = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/div/div[1]/div[2]/div/div[6]/button"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(1000);

        //CLick on pay arrival
        driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/div/div[2]/center/button[1]")).click();
        Thread.sleep(1000);
        //Accept alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        String response = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/div/div[2]/div[2]/h4")).getText();
        if(response.equalsIgnoreCase("Your booking status is Reserved"))
            System.out.println("Everything was OK");

        //Closing webdriver
        driver.quit();
    }
}
