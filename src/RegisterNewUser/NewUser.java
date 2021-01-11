package RegisterNewUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NewUser {
    public static void main(String[] args) throws InterruptedException {
        //Instance an object WebDriver
        WebDriver driver;

        //Declare variables
        String baseURL = "https://testpages.herokuapp.com/styled/index.html";
        WebElement webElementName;
        WebElement comments;


        //Indicate chromedriver.exe file localization in the property
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");


        //Launch a new Chrome browser.
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Open URL https://testpages.herokuapp.com/styled/index.html
        driver.get(baseURL);

        //Select the link that let us to add new user and click it
        driver.findElement(By.id("htmlformtest")).click();
        Thread.sleep(1000);

        //Select textBox username and send it the information of user
        driver.findElement(By.name("username")).sendKeys("Zerggard");
        Thread.sleep(1000);

        //Select textBox password and send it the pass
        driver.findElement(By.name("password")).sendKeys("12345");
        Thread.sleep(1000);

        comments = driver.findElement(By.name("comments"));
        comments.clear();
        comments.sendKeys("This is a probe");
        Thread.sleep(1000);

        // Select check box
        List<WebElement> oCheckBox = driver.findElements(By.name("checkboxes[]"));
        // This will tell you the number of checkboxes are present
        int iSize = oCheckBox.size();
        // Start the loop from first checkbox to last checkboxe
        for(int i=0; i < iSize ; i++ ) {
            // Store the checkbox name to the string variable, using 'Value' attribute
            String sValue = oCheckBox.get(i).getAttribute("value");
            // Select the checkbox it the value of the checkbox is same what you are looking for
            if(oCheckBox.get(i).isSelected()){
                oCheckBox.get(i).click();
            }
            if (sValue.equalsIgnoreCase("cb2")) {
                oCheckBox.get(i).click();
            }
        }
        Thread.sleep(1000);

        // Select radio option
        List<WebElement> oRadioItems = driver.findElements(By.name("radioval"));
        // This will tell you the number of checkboxes are present
        int radioSize = oRadioItems.size();
        // Start the loop from first checkbox to last checkboxe
        for(int i=0; i < radioSize ; i++ ) {
            // Store the checkbox name to the string variable, using 'Value' attribute
            String sValue = oRadioItems.get(i).getAttribute("value");
            // Select the checkbox it the value of the checkbox is same what you are looking for
            if (sValue.equalsIgnoreCase("rd3")) {
                oRadioItems.get(i).click();
            }
        }
        Thread.sleep(1000);

        // Select multiple option
        List <WebElement> elementCount;
        int selectSize = 0;
        Select oSelect = new Select(driver.findElement(By.name("multipleselect[]")));
        oSelect.deselectAll();
        elementCount = oSelect.getOptions();
        selectSize = elementCount.size();
        for(int i =0; i<selectSize ; i++){
            String sValue = elementCount.get(i).getAttribute("value");
            if(sValue.equalsIgnoreCase("ms3")){

                oSelect.selectByValue("ms3");
            }
        }
        Thread.sleep(1000);

        // Select drow down option
        Select oDropDwon = new Select(driver.findElement(By.name("dropdown")));        elementCount = oDropDwon.getOptions();
        selectSize = elementCount.size();
        for(int i =0; i<selectSize ; i++){
            String sValue = elementCount.get(i).getAttribute("value");
            if(sValue.equalsIgnoreCase("dd6")){
                oDropDwon.selectByValue("dd6");
            }
        }
        Thread.sleep(1000);

        //Click submit button
        driver.findElement(By.name("submitbutton")).submit();

        if(driver.getCurrentUrl().equalsIgnoreCase("https://testpages.herokuapp.com/styled/the_form_processor.php")){

            //Taking all information that we have selected
            String userName = driver.findElement(By.xpath("//*[@id=\"_valueusername\"]")).getText();
            String password = driver.findElement(By.xpath("//*[@id=\"_valuepassword\"]")).getText();
            String commentsResults = driver.findElement(By.xpath("//*[@id=\"_valuecomments\"]")).getText();
            String checkBoxes = driver.findElement(By.xpath("//*[@id=\"_valuecheckboxes0\"]")).getText();
            String radioOptions = driver.findElement(By.xpath("//*[@id=\"_valueradioval\"]")).getText();
            String multipleSelect = driver.findElement(By.xpath("//*[@id=\"_valuemultipleselect0\"]")).getText();
            String dropDwon = driver.findElement(By.xpath("//*[@id=\"_valuedropdown\"]")).getText();

            //Comparing information acquired with expected
            if (userName.equalsIgnoreCase("Zerggard") &&
                    password.equalsIgnoreCase("12345") &&
                            commentsResults.equalsIgnoreCase("This is a probe") &&
                                    checkBoxes.equalsIgnoreCase("cb2") &&
                                            radioOptions.equalsIgnoreCase("rd3") &&
                                                    multipleSelect.equalsIgnoreCase("ms3") &&
                                                            dropDwon.equalsIgnoreCase("dd6"))
                System.out.println("Test was right");
        }

        Thread.sleep(10000);
        driver.quit();
    }
}
