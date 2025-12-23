package automationlearn.seleniumlearn;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver lik = new ChromeDriver();
		lik.manage().window().fullscreen();
		lik.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		lik.get("https://practice.expandtesting.com/dynamic-table");
		List<WebElement> mik = lik.findElements(By.xpath("//td[normalize-space()='Chrome'] /following-sibling::*"));
		
		for(int a = 0; a<mik.size(); a++) {
			String nik = lik.findElement(By.xpath("//td[normalize-space()='Chrome']//following-sibling::*[(contains(text(),\"%\"))]")).getText();
			System.out.println(nik);
		}
		System.out.println("git test");
	}

}
