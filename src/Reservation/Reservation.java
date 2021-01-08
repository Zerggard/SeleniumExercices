package Reservation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

        //Open URL https://testpages.herokuapp.com/styled/index.html
        driver.get(baseURL);
        String user = "user@phptravels.com";
        String password = "demouser";
        String urlActual = "";

        /*driver.findElement(By.xpath("//*[@id=\"//header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[3]/div")).click();
        Thread.sleep(1000);

        //Click in login button
        driver.findElement(By.xpath("//*[@id=\"//header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[3]/div/div/div/a[1]")).click();
        Thread.sleep(1000);

        urlActual = driver.getCurrentUrl();

        while (urlActual.equalsIgnoreCase("https://phptravels.net/login")) {
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
            urlActual = driver.getCurrentUrl();
        }*/
        //while (urlActual.equalsIgnoreCase("https://phptravels.net/")) {
            //Click in HOTELS option
            driver.findElement(By.xpath("//*[@id=\"search\"]/div/div/div/div/div/nav/ul/li[1]/a")).click();
            Thread.sleep(1000);

            //Click Destination
        WebElement element = driver.findElement(By.xpath("/html/body/div[4]/div/input"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(10000);

            //Click on check in datepicker
            driver.findElement(By.xpath("//*[@id=\"checkin\"]")).click();
            Thread.sleep(1000);

            //Click date check in
            driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[1]/div/div/div[2]/div[12]")).click();
            Thread.sleep(1000);

            //Click date check out
            driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[2]/div/div/div[2]/div[20]")).click();
            Thread.sleep(1000);

            //Click add child
            driver.findElement(By.xpath("//*[@id=\"hotels\"]/div/div/form/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div[2]/div/span/button[1]")).click();
            Thread.sleep(1000);

            //Click search
            driver.findElement(By.xpath("//*[@id=\"hotels\"]/div/div/form/div/div/div[4]/button")).click();
       // }
    }
}
