package interview;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import browserInitalize.BrowserInit;

public class CheckBox extends BrowserInit {

	@Test(enabled = false)
	public void Checkbox() {
		browser();
		driver.get("https://artoftesting.com/samplesiteforselenium");
		WebElement checkbox = driver.findElement(By.xpath("//input[(@type='checkbox') and (@class='Automation') ]"));

		if (checkbox.isSelected() == false) {
			checkbox.click();
		}
	}

	@Test(priority = 1)
	public void StaticDropdown() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		browser();
		driver.get("https://artoftesting.com/samplesiteforselenium");
		WebElement dropdown = driver.findElement(By.id("testingDropdown"));
		Select staticdrop = new Select(dropdown);
		List<WebElement> dropvalues = staticdrop.getOptions();
		for (WebElement allDropvalues : dropvalues) {
			System.out.println(allDropvalues.getText());
		}
		driver.quit();
		System.out.println("Git push pull practice");
	}

}
