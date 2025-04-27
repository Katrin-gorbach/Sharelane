import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;

public class SignUpTest {


	/*
1. Ввести валидное значение zip code
2. Проверить, что мы оказались на странице с форомой регистрации
3. Заполнить форму регистрации
4. Нажать кнопку Register
5. Проверить, что регистрация выполнена успешно
 */
	@Test
	public void checkSignUpValidData() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.get("https://www.sharelane.com/cgi-bin/register.py");
		driver.findElement(By.name("zip_code")).sendKeys("12345");
		driver.findElement(By.cssSelector("[value='Continue']")).click();

		//boolean isDisplayed = driver.findElement(By.cssSelector("[value='Register']")).isDisplayed();
		//Assert.assertTrue(isDisplayed);

		//driver.findElement(By.name("first_name")).sendKeys("Evgeny");
		//driver.findElement(By.name("last_name")).sendKeys("Giga");
		//driver.findElement(By.name("email")).sendKeys("giga@evgeny.com");
		//driver.findElement(By.name("password1")).sendKeys("123123");
		//driver.findElement(By.name("password2")).sendKeys("123123");
		//driver.findElement(By.cssSelector("[value='Register']")).click();

		//String accountCreated = driver.findElement(By.className("confirmation_message")).getText();
		//Assert.assertEquals(accountCreated, "Account is created!");
	}
}
