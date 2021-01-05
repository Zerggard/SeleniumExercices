import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebElementCommands {
    public void informationCommandSelenium(){
        //Instance an object WebDriver
        WebDriver driver;

        //Declare variables
        String baseURL = "https://agilethought.com/";
        String commandReturnString = "";
        String commandReturnInt = "";
        boolean commandReturnBoolen;
        Dimension dimensionReturn;
        Point pointReturn;

        //Indicate chromedriver.exe file localization in the property
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        //Launch a new Chrome browser.
        driver = new ChromeDriver();

        //WebElement Commands
        //clear : If this element is a text entry element, this will clear the value. This method
            //accepts nothing as a parameter and returns nothing.
        driver.findElement(By.id("UserName")).clear();

        //sendKeys : This simulate typing into an element, which may set its value. This
            //method accepts CharSequence as a parameter and returns nothing.
        driver.findElement(By.id("UserName")).sendKeys("4thSource");

        //click : If this element is a text entry element, this will clear the value. This method
            //accepts nothing as a parameter and returns nothing.
        driver.findElement(By.linkText("4thSource")).click();

        //isDisplayed : This method determines if an element is currently being displayed
            //or not. This accepts nothing as a parameter but returns boolean value(true/false).
        commandReturnBoolen = driver.findElement(By.id("UserName")).isDisplayed();

        //isEnabled : This determines if the element currently is Enabled or not? This
            //accepts nothing as a parameter but returns boolean value(true/false).
        commandReturnBoolen = driver.findElement(By.id("UserName")).isEnabled();

        //isSelected : Determine whether or not this element is selected or not. This
            //accepts nothing as a parameter but returns boolean value(true/false).
        commandReturnBoolen = driver.findElement(By.id("Sex-Male")).isSelected();

        //submit : This method works well/better than the click() if the current element is a
            //form, or an element within a form. This accepts nothing as a parameter and returns nothing.
        driver.findElement(By.id("SubmitButton")).submit();

        //getText : This method will fetch the visible (i.e. not hidden by CSS) innerText of
            //the element. This accepts nothing as a parameter but returns a String value.
        commandReturnString = driver.findElement(By.xpath("anyLink")).getText();

        //getTagName : This method gets the tag name of this element. This accepts
            //nothing as a parameter and returns a String value.
        commandReturnString = driver.findElement(By.id("SubmitButton")).getTagName();

        //getCssValue : This method Fetch CSS property value of the give element. This
            //accepts nothing as a parameter and returns a String value.
        commandReturnString = driver.findElement(By.id("SubmitButton")).getAttribute("id");

        //getSize : This method fetch the width and height of the rendered element.
            //This accepts nothing as a parameter but returns the Dimension object.
        dimensionReturn = driver.findElement(By.id("SubmitButton")).getSize();

        //getLocation : This method locate the location of the element on the page. This
            //accepts nothing as a parameter but returns the Point object.
        pointReturn = driver.findElement(By.id("SubmitButton")).getLocation();
    }
}
