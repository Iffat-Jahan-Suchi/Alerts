package JavascriptAlert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Alert extends Base {
	public String url = "https://the-internet.herokuapp.com/javascript_alerts";

	@Test
	public void alert() throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement jsAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		WebElement jsConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		WebElement jsPrompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		jsAlert.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		// assert
		String aspectedResultjsAlert = "You successfully clicked an alert";
		String actualResjsAlert = driver.findElement(By.id("result")).getText();
		System.out.println(actualResjsAlert);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualResjsAlert, aspectedResultjsAlert);
		Thread.sleep(4000);

		jsConfirm.click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		String aspectedResultjsConfirm = "You clicked: Cancel";
		String actualResjsConfirm = driver.findElement(By.id("result")).getText();
		System.out.println(actualResjsConfirm);
		soft.assertEquals(actualResjsConfirm, aspectedResultjsConfirm);
		Thread.sleep(4000);

		Thread.sleep(3000);
		jsPrompt.click();
		driver.switchTo().alert().sendKeys("jahan");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		  String aspectedResultjsPrompt="You entered: jahan"; 
		  String actualResPrompt=driver.findElement(By.id("result")).getText();
		  System.out.println(actualResPrompt);
		  soft.assertEquals(actualResPrompt,aspectedResultjsPrompt);
		  Thread.sleep(3000);
		 
		Thread.sleep(4000);
		soft.assertAll();

	}
}
