import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementAndFindElements {
    public void findElementAndFindElements(){
        //Instance an object WebDriver
        WebDriver driver;

        //Declare variables
        String baseURL = "https://agilethought.com/";
        WebElement webElement;

        //Indicate chromedriver.exe file localization in the property
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        //Launch a new Chrome browser.
        driver = new ChromeDriver();

        //FindElement And FindElements Commands
        //By ID: This is the most efficient and preferred way to locate an element, as
            //most of the times IDs are unique. It takes a parameter of String which is a Value of ID attribute and it returns a BY
            //object to findElement() method.
        webElement = driver.findElement(By.id("Element ID"));

        //By Name : By – This is also an efficient way to locate an element but again
            //the problem is same as with ID that UI developer make it having non-unique names on a page or auto-generating
            //the names. It takes a parameter of String which is a Value of NAME attribute and it returns a BY object to
            //findElement() method.
        webElement = driver.findElement(By.name("Element NAME"));

        //By ClassName : This finds elements based on the value of the
            //CLASS attribute. It takes a parameter of String which is a Value of CLASS attribute and it returns a BY object to
            //findElement() method.
        webElement = driver.findElement(By.className("Element CLASSNAME"));

        //By TagName : With this you can find elements by their
            //TAGNAMES. It takes a parameter of String which is a Value of TAG attribute and it returns a BY object to
            //findElement() method.
        webElement = driver.findElement(By.tagName("Element TAGNAME"));

        //By LinkText : With this you can find elements of “a” tags(Link) with
            //the link names. Use this when you know link text used within an anchor tag. It takes a parameter of String which is
            //a Value of LINKTEXT attribute and it returns a BY object to findElement() method.
        webElement = driver.findElement(By.linkText("Element LINKTEXT"));

        //PartialLinkText : With this you can find elements of “a” tags(Link) with the partial link names.
        webElement = driver.findElement(By.partialLinkText("Element LINKTEXT"));

        //By XPath : It is most popular and majorly used locating element technique or the easiest way to locate element in WebDriver.
            // It takes a parameter of String which is a XPATHEXPRESSION and it returns a BY object to findElement() method.
        webElement = driver.findElement(By.xpath("Element XPATHEXPRESSION"));
    }
}
