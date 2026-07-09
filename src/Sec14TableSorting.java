import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Sec14TableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("th[aria-label*='Veg/fruit name']")).click();
		List<WebElement> List = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<String> originalList = List.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));
		List<String> Price;
		do
		{
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		Price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getVeggiePrice(s)).collect(Collectors.toList());
		Price.forEach(a->System.out.println(a));
		if(Price.size()<1)
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(Price.size()<1);
		
		
	}

	private static String getVeggiePrice(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
