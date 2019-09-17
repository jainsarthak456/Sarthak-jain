package com.ExtramarksWebsite_TestCases;
    import java.util.List;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Dimension;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.Wait;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class LPT_Services {

		public static WebDriver driver;

		@BeforeTest
		public void preCond() {
			System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.navigate().to("http://testautomation-www.extramarks.com/");

		}

		@Test(enabled = false)
		public void validSignup() {
			driver.findElement(By.xpath("//a[@class='register'][text()='SIGN UP']")).click();
			driver.findElement(By.linkText("Student")).click();
			driver.findElement(By.id("y_1")).click();
			driver.findElement(By.id("display_name")).sendKeys("abcdef");
			driver.findElement(By.id("mobile")).sendKeys("9891806678");
			driver.findElement(By.id("s2id_city")).click();
			driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Noida");
			driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();

			driver.findElement(By.xpath("//button[text()='Create Account']")).click();

			driver.findElement(By.id("popupemail")).sendKeys("abc1@gmail.com");

			Select sel = new Select(driver.findElement(By.id("board_popup")));
			sel.selectByVisibleText("CBSE");

			Select sel1 = new Select(driver.findElement(By.id("classname_popup")));
			sel1.selectByVisibleText("V");

			driver.findElement(By.id("popup_newpassword")).sendKeys("12345");
			driver.findElement(By.xpath("//button[text()='Update']"));
			
		
					

		}

		@Test
		public void validLogin() throws InterruptedException {

			driver.findElement(By.xpath("//ul[@id='navigation-top']//a[text()='LOGIN']")).click();

			driver.findElement(By.id("usernameLogin")).sendKeys("9090901010");
			driver.findElement(By.id("passwdLogin")).sendKeys("Extra@123");
			driver.findElement(By.id("login-account")).click();

			driver.findElement(By
					.xpath("//ul[@class='nav navbar-nav']//img[@src='//developer1.extramarks.com/images/website_v7/m-pelajaran.png']"))
					.click();
			List<WebElement> l1 = driver.findElements(By.xpath("//div[@class='postlogin-card ng-scope']//a[@href]"));
			int links = l1.size();
			System.out.println(links);

			l1.get(0).click();

			driver.navigate()
					.to("http://testautomation-www.extramarks.com/website/lpt/dashboard/36#/chapterDetails/36/class");
			driver.navigate().refresh();

			Thread.sleep(10000);
			l1.get(1).click();
			driver.navigate().back();
			/*
			 * Thread.sleep(10000); l1.get(2).click(); driver.navigate().back();
			 * 
			 * l1.get(3).click(); l1.get(4).click(); l1.get(5).click();
			 * l1.get(6).click();
			 */

			/*
			 * for(int i=0; i<links;i=i+1) {
			 * System.out.println(l1.get(i).getText());
			 * 
			 * }
			 */
			/*
			 * for(int i=0; i<links; i++) { try{ //driver.navigate().refresh();
			 * l1.get(i).click(); Thread.sleep(3000); driver.navigate().back();
			 * Thread.sleep(3000);
			 * //Wait.until(ExpectedConditions.presenceOfElementLocated(By.id(
			 * "table"))); }
			 */
			// driver.navigate().refresh();
			// Thread.sleep(3000);

			/*
			 * catch(Exception e){ System.out.println(e.getMessage()); }
			 */
			/*
			 * catch(org.openqa.selenium.StaleElementReferenceException ex) {
			 * l1.get(i).click(); Thread.sleep(3000); driver.navigate().back(); }
			 */
		}

	}
	// }


