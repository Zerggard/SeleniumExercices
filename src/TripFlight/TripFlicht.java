package TripFlight;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TripFlicht {
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

        driver.findElement(By.xpath("//*[@id=\"//header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[3]/div")).click();
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
        }
        while (urlActual.equalsIgnoreCase("https://phptravels.net/")) {
            //Click flights
            driver.findElement(By.xpath("//*[@id=\"search\"]/div/div/div/div/div/nav/ul/li[2]/a")).click();
            Thread.sleep(1000);

            //Click round flight
            //driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div/div[1]/div[1]/div/div[2]/label")).click();

            //Click on depart datepicker
            driver.findElement(By.xpath("//*[@id=\"FlightsDateStart\"]")).click();
            Thread.sleep(1000);

            //Click date depart flight
            driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[9]/div/div/div[2]/div[10]")).click();
            Thread.sleep(1000);

            //Click date return flight
            //driver.findElement(By.xpath("//*[@id=\"datepickers-container\"]/div[10]/div/div/div[2]/div[15]")).click();
            //Thread.sleep(1000);

            //Click one more adult
            driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/span/button[1]")).click();
            Thread.sleep(1000);


            //Click one more child
            driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div/div[3]/div[3]/div/div/div[2]/div/div[2]/div/span/button[1]")).click();
            Thread.sleep(1000);

            //Click send information (search button)
            driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div/div[3]/div[4]/button")).click();
            Thread.sleep(5000);

            urlActual = driver.getCurrentUrl();

            while (urlActual.equalsIgnoreCase("https://phptravels.net/flights/search/LHE/DXB/oneway/economy/2021-01-05/2/1/0")) {
                driver.findElement(By.xpath("//*[@id=\"LIST\"]/li[3]/div/div[1]/div[2]/form/div[2]/div/button")).click();
                Thread.sleep(1000);
                urlActual = driver.getCurrentUrl();
                while (urlActual.equalsIgnoreCase("https://phptravels.net/flights/book")) {
                    driver.findElement(By.xpath("//*[@id=\"passenger_name_0\"]")).sendKeys("Zerggard");
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//*[@id=\"passenger_age_0\"]")).sendKeys("32");
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//*[@id=\"passenger_passport_0\"]")).sendKeys("014797");
                    Thread.sleep(1000);

                    WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div[1]/div/div[1]/div[2]/div[4]/button"));
                    JavascriptExecutor executor = (JavascriptExecutor)driver;
                    executor.executeScript("arguments[0].click();", element);
                    Thread.sleep(10000);

                    while (payment){
                        driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/div/div[2]/center/button[1]")).click();
                        Thread.sleep(1000);
                        Alert alert = driver.switchTo().alert();
                        alert.accept();
                        Thread.sleep(3000);
                        payment = false;
                    }
                    while (!payment){
                        if(driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/div/div[2]/div[2]/h4")).getText().equalsIgnoreCase("Your booking status is Reserved"));
                        payment = true;
                        urlActual = "";
                    }
                }
            }
        }
        System.out.println("Test is complete successfully");
    }
}
