import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Sec11Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption1")).click();
		String option = driver.findElement(By.cssSelector("label[for='bmw']")).getText();
		WebElement staticDD = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown= new Select(staticDD);
		dropdown.selectByContainsVisibleText(option);
		driver.findElement(By.id("name")).sendKeys(option);
		driver.findElement(By.id("alertbtn")).click();
		String textFromPopUp = driver.switchTo().alert().getText().split(",")[0].split(" ")[1];
		Assert.assertEquals(textFromPopUp, option);

	}

}
