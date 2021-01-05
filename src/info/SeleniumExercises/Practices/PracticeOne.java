package info.SeleniumExercises.Practices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeOne {
    public static void main(String[] args){
        //Instance an object WebDriver
        WebDriver webDriver;

        //Declare variables
        String baseURL = "https://agilethought.com/";
        String pageTitle = "";
        String pageOpened = "";
        String pageSource = "";

        //Indicate chromedriver.exe file localization in the property
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        //Launch a new Chrome browser.
        webDriver = new ChromeDriver();

        // Open Store.DemoQA.com
        webDriver.get(baseURL);

        // Get Page Title name and Title length
        pageTitle = webDriver.getTitle();

        // Print Page Title and Title length on the Intellij IDEA Console.
        System.out.println("Page title..: " + pageTitle + " and have a length..: " + pageTitle.length());

        // Get Page URL and verify if the it is a correct page opened
        pageOpened = webDriver.getCurrentUrl();
        if(baseURL.equals(pageOpened))
            System.out.println("The page was opened correctly");
        else
            System.out.println("The page was not opened correctly");

        // Get Page Source (HTML Source code) and Page Source length
        pageSource = webDriver.getPageSource();
        System.out.println("Page source code..: " + pageSource);


        // Print Page Length on Eclipse Console.
        int pageSourceLenght = pageSource.length();
        System.out.println("Page source code length..: " + pageSourceLenght);

        // Close the Browser.
        webDriver.quit();
    }
}
