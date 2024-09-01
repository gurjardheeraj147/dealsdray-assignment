package dealsdray;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class DemoDealSaray {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver = new ChromeDriver();//cross broswer testing in chrome
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.dealsdray.com/");// navigate the url
		Thread.sleep(3000);
		
		// field the username and password than click login button
		
		driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		// usnig javascript click order becuse locater are not working
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		for(;;) {
			try {
        driver.findElement(By.xpath("//body/div[@id='root']/div[@class='theme-light MuiBox-root css-cbjwpp']/div[@class='MuiBox-root css-okb3zz']/div[@class='MuiBox-root css-kd3xim']/div[@class='MuiBox-root css-xhd3h8']/div[@class='css-ocyc1z']/div/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-3 css-1h77wgb']/div[1]/div[1]")).click();		
		Thread.sleep(3000);
		break;
		}catch(Exception e) {
			js.executeScript("window.scrollBy(196,194)");
		}
	}
		driver.findElement(By.xpath("//button[normalize-space()='Add Bulk Orders']")).click();// click button
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); // 10 seconds wait

        // Wait until the file input element is present and visible
        WebElement fileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='file']")));

        // Upload the file
        fileInput.sendKeys("C:\\\\Users\\\\suman\\\\Downloads\\\\demo-data.xlsx");
        
        
        driver.findElement(By.xpath("//button[normalize-space()='Import']")).click();	// click the import button	
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();//click the validate but
		
		// Optional: Validate that the file upload was successful
        // Check if there's an indication of successful upload or a specific element that appears after the upload
		
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success-message"))); // Adjust the selector as needed
        Assert.assertTrue(successMessage.isDisplayed(), "Success message is not displayed after file upload.");		
		Thread.sleep(3000);
		
		driver.quit();
		
}
}
