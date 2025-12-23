package browserInitalize;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class  BrowserInit {
	
	public static WebDriver driver;
	public void browser() {
		
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--headless");
		 */
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	}

	public void getUrl(String url) {
		
		driver.get(url);
	}
}
