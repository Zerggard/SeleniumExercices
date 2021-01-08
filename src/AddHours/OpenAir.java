package AddHours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class OpenAir {

    public static boolean loginOpenAir() throws InterruptedException {
        //Instance an object WebDriver
        WebDriver driver;

        //Declare variables
        String baseURL = "https://auth.openair.com/login_sso";

        //Indicate chromedriver.exe file localization in the property
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        //Launch a new Chrome browser.
        driver = new ChromeDriver();

        //Open URL https://testpages.herokuapp.com/styled/index.html
        driver.get(baseURL);
        String useriD = "luis.castillo@agilethought.com";
        String companyID = "AgileThought";

        //Send companyId
        driver.findElement(By.xpath("//*[@id=\"login\"]/label[1]/input")).sendKeys(companyID);
        Thread.sleep(1000);

        //Send user name
        driver.findElement(By.xpath("//*[@id=\"login\"]/label[2]/input")).sendKeys(useriD);
        Thread.sleep(1000);

        if(!driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/label/input")).isSelected()){
            driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/label/input")).click();
            Thread.sleep(1000);
        }

        //Click button login
        driver.findElement(By.xpath("//*[@id=\"login_submit_button\"]")).submit();
        Thread.sleep(5000);

        //Write mail in microsoft account
        driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys(useriD);
        Thread.sleep(1000);

        //Click in next button
        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
        Thread.sleep(10000);

        //Send password
        driver.findElement(By.xpath("//*[@id=\"passwordInput\"]")).sendKeys("ZerggardSuper!0!1986");
        Thread.sleep(1000);

        //Click sign in
        driver.findElement(By.xpath("//*[@id=\"submitButton\"]")).submit();
        Thread.sleep(1000);

        String response;
        boolean resp = true;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Have you accepted login?(y/n)..: ");
            response = scanner.nextLine();
            if(response.equalsIgnoreCase("y") || response.equalsIgnoreCase("n")){
                resp = false;
            }
        }while (resp);

        driver.switchTo().activeElement();

        //Select don't show again
        driver.findElement(By.xpath("//*[@id=\"KmsiCheckboxField\"]")).click();
        Thread.sleep(1000);

        //Click Yes
        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
        Thread.sleep(5000);

        //Verifying if exist a timesheet
        if(driver.findElement(By.xpath("//*[@id=\"chart_1091158\"]/div[3]/div[1]/table/tbody/tr/td[2]/a")).getText()
            .equalsIgnoreCase(" Open Timesheets")){
            driver.findElement(By.xpath("//*[@id=\"chart_1091158\"]/div[3]/div[1]/table/tbody/tr/td[2]/a")).click();
        }
       /* //Click new button
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/ul[1]/li[1]/a")).click();
        Thread.sleep(1000);

        //Click new timesheet
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/ul/li[4]/a")).click();
        Thread.sleep(1000);

        //Click save button
        driver.findElement(By.xpath("//*[@id=\"formButtonsBottom\"]/input[2]")).click();
        Thread.sleep(1000);*/
        return true;
    }
}
