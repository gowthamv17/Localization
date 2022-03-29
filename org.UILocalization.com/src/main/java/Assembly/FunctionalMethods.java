package Assembly;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunctionalMethods {

	
public static WebDriver driver;

static int x =1;


	public static void driverlaunch(String browser) {
		
		if(browser.equalsIgnoreCase("Chrome")) {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("Firefox")) {
			
		WebDriverManager.firefoxdriver().setup();
			
		driver = new FirefoxDriver();
		
	}
		
		
	}	
	
	public static void maximize() {
		driver.manage().window().maximize();
		
	}
	public static void loadURL(String url){
			
			driver.get(url);
			
		}
	
	public static String pageTitle(){
		
	String title = driver.getTitle();
	return title;
		
	}
	
	public static void pageContent(WebElement header) {
	
		System.out.println("Content Title is - "+header.getText());
		
	}
	
	public static void waits(WebElement a) {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(a));
	}
	
	public static void pageClick(WebElement clicks) {
		
		clicks.click();
	}
	
	public static void movetoElements(WebElement move) {
		Actions action = new Actions(driver);
		action.moveToElement(move).click().perform();
		
	}
	public static void optionlists(String s) throws InterruptedException {
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='ui-lib-radio-group__items']//h5"));
		list.size();
		System.out.println();
		System.out.println();
		System.out.println("Question Options are - ");
		System.out.println();
		
		for (WebElement options : list) {
			
			System.out.println(options.getText());
			
			
			if(options.getText().equals(s)) {
				
				Thread.sleep(2000);
				movetoElements(options);
			}
			
		}
	}
		
	}
