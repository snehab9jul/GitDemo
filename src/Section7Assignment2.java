import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Section7Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Sneha");
		driver.findElement(By.name("email")).sendKeys("gunjasharma@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Gunja@123");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement StaticDD = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(StaticDD);
		dropdown.selectByVisibleText("Female");
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("09/07/1988");
		driver.findElement(By.cssSelector("input[class*='btn-success']")).click();
		System.out.println(driver.findElement(By.cssSelector("div[class*='alert-success']")).getText());

	}

}
