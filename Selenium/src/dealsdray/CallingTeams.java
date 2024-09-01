package dealsdray;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CallingTeams {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions setting = new ChromeOptions();//  notifaction pop up handle
		setting.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(setting);//cross broswer testing in chrome
		driver.manage().window().maximize();
		driver.get("https://www.getcalley.com/calley-teams-features/");
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot) driver;// screen shot entire web page
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src = new File("./errorShots/call.jpeg");
		org.openqa.selenium.io.FileHandler.copy(temp, src);
		Thread.sleep(5000);
		driver.quit();

	}

}
