import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ChromeWebDriverInitFlightSearchPractise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String CountryName = "India";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement StaticDD = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropDown = new Select(StaticDD);
		dropDown.selectByIndex(2);
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		for(int i=0;i<3;i++)
		{
		driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("hrefIncChd")).click();
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		Thread.sleep(1000);
		List<WebElement> country = driver.findElements(By.cssSelector("a[class='ui-corner-all']"));	
		for(int j=0;j<country.size();j++)
		{
			if(country.get(j).getText().equalsIgnoreCase(CountryName))
			{
				country.get(j).click();
				break;
			}
		}
		driver.findElement(By.id("familyandfriend")).click();
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[class*='ui-state-active']")).click();
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		driver.findElement(By.cssSelector("a[class*='ui-state-active']")).click();
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
	}

}
