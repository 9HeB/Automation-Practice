package codenboxautomationlab1.codenboxautomationlab1;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class AppTest {

    WebDriver driver = new ChromeDriver();
    Random rand = new Random();

    @BeforeTest
    public void mySetup() {
        driver.get("https://codenboxautomationlab.com/practice/");
        driver.manage().window().maximize();
    }



    @Test(priority = 1, enabled = true)
    public void RadioButton() {

	    List<WebElement> AllRadioButton = driver.findElements(By.className("radioButton"));
	
	    int totalRadioButtons = driver.findElements(By.className("radioButton")).size();
	
		// this is to select random radio button
		int RandomRadioButtonIndex = rand.nextInt(totalRadioButtons);
	
		AllRadioButton.get(RandomRadioButtonIndex).click();
	
		/*
		 * __ if you need to select spcific raido button to be clicked __
		 * 
		 * AllRadioButton.get(0).click(); AllRadioButton.get(1).click();
		 * AllRadioButton.get(2).click();
		 * 
		 */
		}
	
    
    
    
	@Test(priority = 2, enabled = true)
	public void Dynamic_Dropdown() throws InterruptedException {
		
		String[] countryPrefixes = { "Un", "Ca", "Ge", "Fr", "It", "Sp", "In", "Br", "Ch", "Au" };
	
		WebElement InputField = driver.findElement(By.id("autocomplete"));
		int RandomCountryIndex = rand.nextInt(countryPrefixes.length);
	
		InputField.sendKeys(countryPrefixes[RandomCountryIndex]);
		Thread.sleep(2000);
		InputField.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));
		
	   }
	    
	
	
 
    @Test(priority = 3, enabled = true)
    public void Static_Dropdown() {
        
        WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));

        Select dropdown = new Select(staticDropdown);

        List<WebElement> options = dropdown.getOptions();

        int randomOptionIndex = rand.nextInt(options.size() - 1) + 1; 

        dropdown.selectByIndex(randomOptionIndex);
        
       }
    
 }