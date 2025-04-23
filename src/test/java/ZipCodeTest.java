import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.System.*;

public class ZipCodeTest {


		/*
		1. Открыть браузер Хроме
		2. В адресную строку ввести URL https://www.sharelane.com/cgi-bin/register.py
		3. В поле ZIP code  ввести 1234
		4. Нажать кнопку Continue

		Expected result: Error message: Oops, error on page. ZIP code should have 5 digits
		 */

	@Test
	public void checkZipCode4Digits() {
		setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		WebDriver browser = new ChromeDriver(); // WebDriver - Selenium class помогает управлять браузером
		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		browser.get("https://www.sharelane.com/cgi-bin/register.py"); // get - тк по протоколу по http. method get
		// of http protocol
		//<input type="text" name="zip_code" value="">
		browser.findElement(By.name("zip_code")).sendKeys("1234"); //
		//<input type="submit" value="Continue">
		browser.findElement(By.cssSelector("[value='Continue']")).click(); // sendKeys(ENTER)
		//<span class="error_message">Oops, error on page. ZIP code should have 5 digits</span>
		String actualErrorMessage = browser.findElement(By.className("error_message")).getText();
		Assert.assertEquals(actualErrorMessage, "Oops, error on page. ZIP code should have 5 digits");
		browser.quit();
	}




}
