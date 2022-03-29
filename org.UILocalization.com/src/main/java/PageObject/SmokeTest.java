package PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Assembly.FunctionalMethods;

public class SmokeTest extends FunctionalMethods{

	@BeforeTest
	public void launchURL() throws InterruptedException {
		
		driverlaunch("Chrome");
		maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test(priority=0)
	public void url() {
		loadURL("https://www.tamm.abudhabi/");
		
		System.out.println("Page Title is - "+pageTitle());
		
		driver.findElement(By.xpath("//a[text()='Accept & Close']")).click();
	}
	
		@Test(priority=1)
		public void startbusinessPage() throws InterruptedException {
		
		WebElement startbusiness = driver.findElement(By.xpath("//*[contains(text(),'Start & Manage a Business')]"));
		
		waits(startbusiness);
		startbusiness.click();
		
		WebElement verifyhomepage = driver.findElement(By.xpath("//div//h1"));
		Thread.sleep(2000);
		pageContent(verifyhomepage);
		}
		
		@Test(priority=2)
		public void businessPage() throws InterruptedException {
		WebElement businesspage = driver.findElement(By.xpath("//*[contains(text(),'Step-by-Step Business Guide')]"));
		businesspage.click();
		
		WebElement verifybusinesspage = driver.findElement(By.xpath("//*[contains(@class,'ui-lib-hero__content-title')]"));
		Thread.sleep(2000);
		pageContent(verifybusinesspage);
		}
		
		@Test(priority=3)
		
		public void questionsPage() throws InterruptedException {
		optionlists("Get a licence now");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='Next']")).click();
		Thread.sleep(5000);
		optionlists("No, I want to open a branch for my existing business.");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='Next']")).click();
		Thread.sleep(2000);
		optionlists("Abu Dhabi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='Next']")).click();
		Thread.sleep(2000);
		}
		
		@Test(priority=4)
		public void loginPage() throws InterruptedException {
			WebElement verifybusinesspage = driver.findElement(By.xpath("//*[contains(@class,'ui-lib-hero__content-title')]"));
			Thread.sleep(2000);
			System.out.println();
			pageContent(verifybusinesspage);
	}
		
	
	@AfterTest		
	public void closeBrowser() {
			
			System.out.println("Script Success");
		}
	
}
