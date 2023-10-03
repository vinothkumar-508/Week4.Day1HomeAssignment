package Week4.Day1HomeAssignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert1 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://buythevalue.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("(//a[@class='grid-image'])[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Zipcode']")).sendKeys("600001");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='btn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
		driver.findElement(By.xpath("(//a[text()='View Cart'])[2]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='checkout']")).click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();	

	}

}
