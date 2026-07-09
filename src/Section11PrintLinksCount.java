import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Section11PrintLinksCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/practice");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerDriver = driver.findElement(By.cssSelector("div[class*='grid grid-cols-1']"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		WebElement columnDriver = footerDriver.findElement(By.cssSelector("div[class*='lg:col-span-1']"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		for(int i=0;i<columnDriver.findElements(By.tagName("a")).size();i++)
		{
			String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
		}
		
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
