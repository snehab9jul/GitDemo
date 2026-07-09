import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Section9Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] itemsNeeded = {"iphone X","Samsung Note 8","Nokia Edge","Blackberry"};
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("Learning@830$3mK2");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='btn-success']")));
		driver.findElement(By.cssSelector("button[class*='btn-success']")).click();
		WebElement StaticDD = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select dropdown = new Select(StaticDD);
		dropdown.selectByVisibleText("Consultant");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class*='btn-primary']")));
		List<WebElement> products = driver.findElements(By.cssSelector("h4[class='card-title']"));
		List itemsNeededList = Arrays.asList(itemsNeeded); 
		int j =0;
		for(int i=0; i<products.size();i++)
		{
			String name = products.get(i).getText();
			if(itemsNeededList.contains(name))
			{
				j++;
				driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
				if(j==itemsNeeded.length)
				{
					break;
				}
			}
		}
		driver.findElement(By.cssSelector("a[class*='btn-primary']")).click();
		

	}

}
