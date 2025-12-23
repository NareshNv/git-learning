package automationlearn.seleniumlearn;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import browserInitalize.BrowserInit;

public class DropDownTest extends BrowserInit {

	static WebDriver driver;

	@BeforeMethod
	public void setupBrowser() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void tearDown() throws IOException {
		driver.quit();
		File snapShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(snapShot, new File("C:\\Users\\nares\\OneDrive\\Documents\\My Games\\sma.png"));

	}

	@Test(enabled = false)
	public void selectDrop() {
		String url = "https://letcode.in/dropdowns";

		driver.get(url);
		WebElement values = driver.findElement(By.id("superheros"));
		Select drop = new Select(values);
		List<WebElement> options = drop.getOptions();
		for (WebElement option : options) {
			System.out.println(option.getText());
		}

	}

	@Test(enabled = true)
	public void alertsExample() throws InterruptedException {

		driver.get("https://letcode.in/alert");
		driver.findElement(By.xpath("//button[contains(text(),'Simple Alert')]")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.findElement(By.xpath("//button[contains(text(),'Confirm Alert')]")).click();
		alert.dismiss();
		driver.findElement(By.xpath("//button[contains(text(),'Prompt Alert')]")).click();
		alert.sendKeys("User");
		alert.accept();
		driver.findElement(By.xpath("//button[contains(text(),'Modern Alert')]")).click();
		WebElement elem = driver.findElement(By.xpath("//button[contains(@class,'modal-close')]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(elem));
		elem.click();
	}

	@Test(enabled = false, dependsOnMethods = "iframes")
	public void windowHandles() throws InterruptedException {

		driver.get("https://letcode.in/window");
		driver.findElement(By.xpath("//button[contains(text(),'Muiltiple windows')]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		String secondWindow = windows.get(1);
		String thirdWindow = windows.get(0);
		driver.switchTo().window(secondWindow);
		String parentWindow = windows.get(0);
		// driver.switchTo().window(parentWindow);
		driver.switchTo().window(thirdWindow);
		driver.manage().window().minimize();
	}

	@Test(enabled = false)
	public void iframes() {

		driver.get("https://letcode.in/frame");
		driver.switchTo().frame("firstFr");
		driver.findElement(By.xpath("//input[contains(@placeholder, 'Enter name')]")).sendKeys("Name");
		driver.switchTo().parentFrame();

	}

	@Test(enabled = false)
	public void actions() {

		driver.get("https://vinothqaacademy.com/mouse-event/");
		Actions me = new Actions(driver);
		WebElement mouseOver = driver.findElement(By.xpath("//input[@id='textbox']"));
		WebElement doubleClick = driver.findElement(By.id("dblclick"));
		WebElement rightClick = driver.findElement(By.id("rightclick"));

		WebElement dragSource = driver.findElement(By.id("draggableElement"));
		WebElement dropLocation = driver.findElement(By.id("droppableElement"));

		me.dragAndDrop(dragSource, dropLocation).perform();
		me.moveToElement(mouseOver).perform();
		me.doubleClick(doubleClick).perform();
		me.contextClick(rightClick).perform();
		me.keyDown(Keys.F5).keyUp(Keys.F5).build().perform();
	}
}
