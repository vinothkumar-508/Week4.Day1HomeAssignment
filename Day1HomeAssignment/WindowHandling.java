package Week4.Day1HomeAssignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();

		driver.findElement(By.xpath("//div[@id='label']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();

		Thread.sleep(2000);

		List<String> window1 = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window1.get(0));
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		windowHandles = driver.getWindowHandles();
		List<String> window2 = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window2.get(1));

		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();

		windowHandles = driver.getWindowHandles();
		driver.switchTo().window(window1.get(0));
		
		WebElement Merge = driver.findElement(By.xpath("//a[text()='Merge']"));
		Merge.click();
		driver.switchTo().alert().accept();
		
		String pageTitle = driver.getTitle();
		System.out.println("Title of Page :" +pageTitle);

	}

}
