import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckAndBoxRadioButton {
    public void checkBoxAndRadioButton(){
        //Instance an object WebDriver
        WebDriver driver;

        //Declare variables
        String baseURL = "https://agilethought.com/";
        WebElement webElement;

        //Indicate chromedriver.exe file localization in the property
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        //Launch a new Chrome browser.
        driver = new ChromeDriver();

        //By ID : If ID is given for the Radio Button/CheckBox and you just want to click on it irrespective of it’s value,
            //then the command will be like this:
        webElement = driver.findElement(By.id("Selection"));
        webElement.click();

        //By CssSelector : You can even select Radio Buttons/Check Boxes with their Values.
        webElement = driver.findElement(By.cssSelector("input[value='QA']"));
        webElement.click();

        //With Value : You can even select Radio Buttons/Check Boxes with their Values.
        // Find the checkbox or radio button element by Name

        /*
        List oCheckBox = driver.findElements(By.name("tool"));
        // This will tell you the number of checkboxes are present
        int iSize = oCheckBox.size();
        // Start the loop from first checkbox to last checkboxe
        for(int i=0; i < iSize ; i++ ){
        // Store the checkbox name to the string variable, using 'Value' attribute
            String sValue = oCheckBox.get(i).getAttribute("value");
        // Select the checkbox it the value of the checkbox is same what you are looking for
            if (sValue.equalsIgnoreCase("QA")){
                oCheckBox.get(i).click();
                break;
            }
        }*/

        //With IsSelected : If the choice is based on the pre-selection of the Radio Button/Check Box and just need to select the
            //deselected Radio Button/Check Box. Assume there are two Radio Buttons/Check Boxes, one is
            //selected by default and you want to select the other one for your test. With IsSelected statement, you
            //can get to know that the element is selected or not.

        /*
            // Store all the elements of same category in the list of WebLements
        List oRadioButton = driver.findElements(By.name("RadioButtons"));
            // This statement will return True, in case of first Radio button is selected
        boolean bValue = oRadioButton.get(0).isSelected();
            // This will check that if the bValue is True means if the first radio button is selected
        if(bValue = true){
            // This will select Second radio button, if the first radio button is selected by default
        oRadioButton.get(1).click();
        }else{
            // If the first radio button is not selected by default, the first will be selected
        oRadioButton.get(0).click();
        }
        */
    }
}
