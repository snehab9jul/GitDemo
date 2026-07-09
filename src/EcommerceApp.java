import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EcommerceApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] itemsNeeded = {"Cucumber","Brocolli","Tomato","Carrot"};
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		addItems(driver, itemsNeeded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());

	}
	
	public static void addItems(WebDriver driver,String[] itemsNeeded)
	{
		int j=0;
		List<WebElement> productList = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0; i<productList.size();i++)
		{
			String[] name = productList.get(i).getText().split("-");
			String formattedName = name[0].trim();
			List itemsNeededList = Arrays.asList(itemsNeeded);
			
			if(itemsNeededList.contains(formattedName))
{
				j++;
	driver.findElements(By.cssSelector("div[class='product-action'] button")).get(i).click();
	if(j==itemsNeeded.length)
	{
		break;
	}
}
		}
	}

}
