package com.ExtramarksWebsite_TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ExtramarksWebsite_Pages.LaunchPage;
import com.ExtramarksWebsite_Pages.LoginPage;
import com.ExtramarksWebsite_Utils.Constants;
import com.ExtramarksWebsite_Utils.DataUtil;
import com.ExtramarksWebsite_Utils.ExtentManager;
import com.ExtramarksWebsite_Utils.Xls_Reader;
import com.relevantcodes.extentreports.LogStatus;

import com.ExtramarksWebsite_Pages.LoginPage;
//import com.ExtramarksWebsite_Pages.BaseLib;
import com.ExtramarksWebsite_Pages.ChapVideoPage;
import com.ExtramarksWebsite_Pages.ChapterPage;
import com.ExtramarksWebsite_Pages.SubjectPage;
import com.ExtramarksWebsite_Utils.Constants;
import com.ExtramarksWebsite_Utils.DataUtil;
import com.ExtramarksWebsite_Utils.ExtentManager;
import com.ExtramarksWebsite_Utils.Xls_Reader;
import com.relevantcodes.extentreports.LogStatus;
import com.ExtramarksWebsite_Pages.ClassPage;
import com.ExtramarksWebsite_Pages.DashBoardPage;
import com.ExtramarksWebsite_Pages.LaunchPage;

public class Login12 extends BaseTest

{
	/*private static final boolean True = false;
	WebDriver driver;
	*/
	@BeforeMethod
	public void init(){
		 rep = ExtentManager.getInstance();
		 test=rep.startTest("Login12");
	
		// test = rep.startTest("Login Test");
}
	
	@AfterMethod
	public void quit(){
		rep.endTest(test);
		rep.flush();
		
	/*	if(driver !=null)
			driver.quit();*/
	}
	


	@Test(dataProvider="getData", priority=1)
	public void doLogin(Hashtable<String,String> data)throws InterruptedException{
		String expectedResult="Login_PASS";
		String actualResult="";
		String browser = data.get("Browser");
		test.log(LogStatus.INFO, "Login test started");
		if(!DataUtil.isTestRunnable(xls, "Login12")  ||  data.get("Runmode").equals("N")){
		
			test.log(LogStatus.SKIP, "Skipping the test");
			
			throw new SkipException("skipping the test");
		
			//throw new SkipException("Skipping the test");
		}
		
		//System.out.println("test skip code");
		
		openBrowser(browser);
		test.log(LogStatus.INFO, "Browser Opened");
		LaunchPage launch=new LaunchPage(driver, test);
		//HomePage hp = lp.goToHomePage();
	
		LoginPage lp=launch.goToHomePage();
		String title= driver.getTitle();
		System.out.println(title);
		test.log(LogStatus.INFO, "Extramarks Website Home Page");
		lp.takeScreenShot();
		 WebElement signin = driver.findElement(By.xpath("//*[@class='signin']"));
		 signin.click();
		test.log(LogStatus.INFO, "Trying to Login");
		Object resultPage=lp.doLogin(data.get("Username"),data.get("Password"));
		
		if(!expectedResult.equals(actualResult)){
			//take screenshot
			lp.takeScreenShot();
			test.log(LogStatus.PASS, "Login Test Passed");
		
		}
		
		test.log(LogStatus.PASS, "Login Test Passed");
		
		Thread.sleep(1000);

	}
	


@DataProvider
public Object[][] getData(){
	Xls_Reader xls = new Xls_Reader(Constants.XLS_FILE_PATH);
	Object[][] data = DataUtil.getData(xls, "Login12");
	return data;
}


	@Test(priority = 2)
	public void ClassLog() throws InterruptedException {
		DashBoardPage dp = new DashBoardPage(driver,test);
		SubjectPage sp = new SubjectPage(driver,test);
		ChapterPage chPg = new ChapterPage(driver,test);
		ChapVideoPage vdPg = new ChapVideoPage(driver,test);
		ClassPage clPg = new ClassPage(driver,test);

		test.log(LogStatus.INFO, "OPen Study Tab");
		Thread.sleep(3000);
		dp.takeScreenShot();


		System.out.println("Open Study");
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		//wait.until(ExpectedConditions.visibilityOfAllElements(clPg.getAllClsLink()));
	
		
		
		List<WebElement> l1=driver.findElements(By.xpath("//div[@class='postlogin-card ng-scope']//a[@href]"));
		
		
		int links = l1.size();
		System.out.println(links);
		Thread.sleep(3000);
		l1.get(0).click();
		
		test.log(LogStatus.INFO, "Open Chapter List");
		
		Thread.sleep(3000);
		dp.takeScreenShot();

		
		List<WebElement> chapL = driver.findElements(By.xpath("//div[@class='postlogin-card ng-scope']//div[@ng-click]"));
		wait.until(ExpectedConditions.visibilityOfAllElements(chapL));
		int chaptercount= chapL.size();
		test.log(LogStatus.INFO, "Number of Chapters :"+chaptercount);
		

		System.out.println(chaptercount);
		
		Thread.sleep(3000);
		chapL.get(0).click();
		//chapL.get(0).click();
		Thread.sleep(2000);
	
		List<WebElement> SubDiv=driver.findElements(By.xpath("//div[@class='panel-collapse sub-subject collapse ng-scope in']//a[@ng-if]"));
		SubDiv.get(0).click();

		// ---------------------------------------------LESSON
		// TAB--------------------
driver.findElement(By.xpath("//i[@class='lesson']")).click();

test.log(LogStatus.INFO, "Open Lesson");


		//chPg.getLessonTb().click();

		try
		// if (chPg.getTOCDiv()==null)
		{
			System.out.println("try block");
			driver.switchTo().frame("fulscr");
driver.findElement(By.xpath("//button[@class='component_base std outline']")).click();
			//vdPg.getOutline().click();
List<WebElement> outlineDiv=driver.findElements(By.xpath("//div[@class='outline']//div[@class='thumb']"));

			int outSize = outlineDiv.size();
			System.out.println(outSize);
			WebDriverWait wt1 = new WebDriverWait(driver, 10);
			WebElement nextLk = wt1.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='component_base next']")));

			// WebDriverWait wt1 = new WebDriverWait(driver, 10);
			WebElement prevLk = wt1.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='component_base prev']")));

			for (int i = 0; i <= outSize - 2; i++) {
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='component_base next']"));
				nextLk.click();
				Thread.sleep(3000);
				int j=i+1;
				test.log(LogStatus.INFO, "Open"+j+" Video");
				Thread.sleep(3000);
				dp.takeScreenShot();
				
				
			}

			for (int j = 0; j <= outSize - 2; j++) {
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='component_base prev']"));
				prevLk.click();
				int z=j+1;
				test.log(LogStatus.INFO, "Open"+z+" Video");
				Thread.sleep(3000);
				dp.takeScreenShot();
			}
			driver.navigate().back();

		}

		// else

		catch (NoSuchFrameException e) {
			System.out.println("Table of Content");
			List<WebElement> TableOfContent=driver.findElements(By.xpath("//div[@class='pl-table-cont']//a[@class='ng-binding ng-scope']"));
			int count = TableOfContent.size();
			System.out.println(count);

			for (int m = 0; m < count; ++m) {
				WebElement LessonTb=driver.findElement(By.xpath("//i[@class='lesson']"));
			
				LessonTb.click();
				List<WebElement> TableOfContent1=driver.findElements(By.xpath("//div[@class='pl-table-cont']//a[@class='ng-binding ng-scope']"));
			
				TableOfContent1.get(m).click();
				
				

				driver.switchTo().frame("fulscr");
				WebElement outline=driver.findElement(By.xpath("//button[@class='component_base std outline']"));
				outline.click();
				List<WebElement> outlineDiv=driver.findElements(By.xpath("//div[@class='outline']//div[@class='thumb']"));

				int outSize = outlineDiv.size();
				System.out.println(outSize);
				
				System.out.println("Total slides in " + m + " = " + outSize);
				WebDriverWait wt1 = new WebDriverWait(driver, 10);
				WebElement nextLk = wt1.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//button[@class='component_base next']")));

				// WebDriverWait wt1 = new WebDriverWait(driver, 10);
				WebElement prevLk = wt1.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//button[@class='component_base prev']")));

				for (int i = 0; i <= outSize - 2; i++) {
					ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='component_base next']"));
					nextLk.click();
					int z=i+1;
					test.log(LogStatus.INFO, "Open"+z+" Video");
					Thread.sleep(3000);
					dp.takeScreenShot();
				}

				for (int j = 0; j <= outSize - 2; j++) {
					ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='component_base prev']"));
					prevLk.click();
					int z=j+1;
					test.log(LogStatus.INFO, "Open"+z+" Video");
					Thread.sleep(3000);
					dp.takeScreenShot();
				}
				driver.navigate().back();

			}
			test.log(LogStatus.PASS, "Learn Test Pass");
		}

		// ----------------------------------PRACTICE TAB-------------

		Thread.sleep(3000);
		//wt.until(ExpectedConditions.elementToBeClickable(chPg.getPracticeTb()));
		WebElement PracticeTb=driver.findElement(By.xpath("//a[@id='practise-panel']"));
		
		PracticeTb.click();
		
		test.log(LogStatus.INFO, "Open Practice tab");
		Thread.sleep(3000);
		dp.takeScreenShot();
		//chPg.getPracticeTb().click();

		WebElement qaclick = driver.findElement(By.xpath("//p[@class='ng-binding'][contains(text(),'Q&A')]"));

		qaclick.click();
		
		test.log(LogStatus.INFO, "Open QA Module");
		Thread.sleep(3000);
		dp.takeScreenShot();

		List<WebElement> AnsTab = driver
				.findElements(By.xpath("//div[@class='postlogin-card ng-scope']//a[contains(text(),'Answer')]"));// 69

		int size = AnsTab.size();// 69

		System.out.println("Total answers : " + size);
		test.log(LogStatus.INFO, "Total Number of Questions :"+size);
		Thread.sleep(3000);
		//dp.takeScreenShot();

		Thread.sleep(3000);
		{
			List<WebElement> SelAns = driver
					.findElements(By.xpath("//form[@class='form col-sm-9 ng-pristine ng-valid']"));
			List<WebElement> TypeAns = driver.findElements(By.xpath("//textarea[@class='form-control qa-textarea']"));
			int TestArea = TypeAns.size();
			System.out.println(TestArea);
			// AnsTab.get(60).click(); //ypeAns.get(0).sendKeys("dsgfchgj");

			int ASize = SelAns.size();
			System.out.println(ASize);

			Thread.sleep(3000);
			for (int zi = 0; zi < ASize; zi++) {
				Thread.sleep(3000);
				AnsTab.get(zi).click();
				boolean az = SelAns.get(zi).isDisplayed();
				System.out.println(zi + " clicks");
				Thread.sleep(1000);
				List<WebElement> list = driver.findElements(By.xpath(" //div[@class='row ng-scope']//form//div[4]"));
				list.get(zi).click();
				int xi=zi+1;
				test.log(LogStatus.INFO, "Open"+xi+"Question");
				Thread.sleep(1000);
				dp.takeScreenShot();
				System.out.println("welcome in practise");
				driver.findElement(By.xpath("//div[@class='modal fade ng-scope in']//*[@class='close']")).click();
				test.log(LogStatus.INFO, "Close"+xi+" Answer");
				dp.takeScreenShot();
				System.out.println(zi + " clicked");
				Thread.sleep(1000);

			}
			// else if(!az)
			for (int j = 0; j < TestArea; j++) {
				int count = j + ASize;
				AnsTab.get(count).click();
				TypeAns.get(j).sendKeys("Done");
				System.out.println(j + "1234");
				Thread.sleep(3000);
			}

		}
		test.log(LogStatus.PASS, "Practice Test Pass");
		driver.navigate().back();

		// ---------------------------------------TEST
		// TAB----------------------------
		
		Thread.sleep(3000);
		WebElement TestTb=driver.findElement(By.xpath("//a[@id='test-panel']"));
		TestTb.click();
		//chPg.getTestTb().click();
		List<WebElement> testtype = driver
				.findElements(By.xpath(" //div[@class='tab-pane fade in active']//div[@class='mb0 clearfix']//a"));

		int testtype_count = testtype.size();

		System.out.println("Total type of Test in MCQ: " + testtype_count);

		// ---------------------------------MCQ-----------------------

		WebElement mcq = driver.findElement(By.xpath("//i[@class='mcq']"));
		mcq.click();

		test.log(LogStatus.INFO, "Open MCQ Type ");
		Thread.sleep(3000);
		dp.takeScreenShot();
		List<WebElement> level_test = driver.findElements(
				By.xpath("//div[@id='pl-table-cont13']//div[@class='media-body media-middle text-left']"));

		WebDriverWait wt1 = new WebDriverWait(driver, 10);
		//wt.until(ExpectedConditions.visibilityOfAllElements(level_test));
		Thread.sleep(3000);
		
		int no_of_leveltest = level_test.size();
		test.log(LogStatus.INFO, "Total Number of Level :"+no_of_leveltest);
		System.out.println("no of level count in MCQ: " + no_of_leveltest);

		WebElement choosetest = driver.findElement(By.xpath("//*[@class='btn practise-btn orange ng-scope']"));
		Thread.sleep(3000);
		choosetest.click();
		Thread.sleep(3000);
dp.takeScreenShot();
		//*[@id="instruksi-modal_mcq"]/div/div/div/button
		WebElement popmenu = driver.findElement(By.xpath("//div[@class='modal fade ng-scope in']//*[@class='close']"));
		popmenu.click();
		

		List<WebElement> questions = driver
				.findElements(By.xpath("//div[@class='row']//ul[@class='testq-counter ng-scope']//li//span"));
		System.out.println("number of questions in MCQ: " + questions.size());
		test.log(LogStatus.INFO, "Total Number of Questions in MCQ :"+no_of_leveltest);
		for (int i = 0; i <= questions.size(); i++) {
			if (i < 4) {
				//Thread.sleep(5000);
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='col-sm-12 chapter-list-name']//form//div[1]"))));
				driver.findElement(By.xpath(" //div[@class='col-sm-12 chapter-list-name']//form//div[1]")).click();
				dp.takeScreenShot();
				//test.log(LogStatus.INFO, "Select :"+no_of_leveltest);
				
			} else if (i > 4) {
				//Thread.sleep(5000);
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='col-sm-12 chapter-list-name']//form//div[2]"))));
				driver.findElement(By.xpath(" //div[@class='col-sm-12 chapter-list-name']//form//div[2]")).click();
				dp.takeScreenShot();
			}
		}
		Thread.sleep(2000);
		WebElement finish = driver.findElement(By.xpath("//*[@class='btn practise-btn orange ml10 font12 ng-scope']"));
		finish.click();
		test.log(LogStatus.PASS, "MCQ Test Pass");
		
		// --------------------------------Addaptive test-----------------------

		driver.navigate().back();

		WebElement Test_1 = driver.findElement(By.xpath("//a[@id='test-panel']"));
		Test_1.click();

		WebElement Test_Adaptive = driver.findElement(By.xpath("//i[@class='adaptive-test']"));
		Test_Adaptive.click();

		WebElement Start_Test = driver.findElement(By.xpath("//a[@class='btn jawab-btn']"));
		Start_Test.click();

		Thread.sleep(3000);

		//WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement closeIcon = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='modal fade ng-scope in']//*[@class='close']")));
		closeIcon.click();

		List<WebElement> questionsinAdaptive = driver
				.findElements(By.xpath("//div[@class='row']//ul[@class='testq-counter ng-scope']//li//span"));
		System.out.println("number of questions in Adaptive Test: " + questionsinAdaptive.size());

		for (int b = 0; b <= questionsinAdaptive.size(); b++) {
			if (b < 4) {
				Thread.sleep(4000);
				driver.findElement(By.xpath(" //div[@class='col-sm-12 chapter-list-name']//form//div[3]")).click();
			} else if (b > 4) {
				Thread.sleep(2000);
				driver.findElement(By.xpath(" //div[@class='col-sm-12 chapter-list-name']//form//div[2]")).click();
			}

		}
		driver.findElement(By.xpath("//a[@class='btn practise-btn orange ml10 font12 ng-scope']")).click();
		System.out.println("Adaptive test complete");

		test.log(LogStatus.PASS, "Adaptive test Pass");
		// --------------------------------Peroidic test----------------------

		// wt.until(ExpectedConditions.elementToBeClickable(chPg.getTestTb()));
		driver.navigate().back();

		WebElement Periodic_TestTb=driver.findElement(By.xpath("//a[@id='test-panel']"));
		Periodic_TestTb.click();

		try {
			// if(chPg.getPeriodicTest()!=null)
			// {
			driver.findElement(By.xpath("//i[@class='periodic-test']")).click();
			//chPg.getPeriodicTest().click();

			List<WebElement> Servicetype = driver
					.findElements(By.xpath("//ul[@class='table-list ng-scope']//a[@id='serviceType.serviceId']"));
			int Servicecount = Servicetype.size();
			System.out.println("total number of service under Periodic Test ---" + Servicecount);

			// for (int j = 0; j < Servicecount; j++) {
			int j = 0;
			Servicetype.get(j).click();
			List<WebElement> ques = driver.findElements(By.xpath("//*[contains(text(),'View Answer')]"));
			int quescount = ques.size();
			System.out.println("no of questions = " + quescount);
			driver.navigate().back();

			Thread.sleep(3000);
			WebElement Test22=driver.findElement(By.xpath("//a[@id='test-panel']"));
			Test22.click();
			//chPg.getTestTb().click();

			try {
				// else if (chPg.getUniformTest()!=null)
				driver.findElement(By.xpath("//i[@class='uniform-sa']")).click();
				//chPg.getUniformTest().click();

				List<WebElement> Service_uniformSA = driver.findElements(By.xpath("//a[@id='serviceType.serviceId']"));
				int count1 = Service_uniformSA.size();
				System.out.println("total number of service under Uniform SA Test ---" + count1);

				Thread.sleep(3000);

				// for (int ki = 0; ki < count1; ki++) {

				int ki = 0;
				Service_uniformSA.get(ki).click();
				List<WebElement> Question = driver.findElements(By.xpath("//*[contains(text(),'View Answer')]"));
				int Questioncount = Question.size();
				System.out.println("no of questions = " + Questioncount);

				driver.navigate().back();
				Thread.sleep(3000);
				
				
				WebElement Test33=driver.findElement(By.xpath("//a[@id='test-panel']"));
				Test33.click();
				//chPg.getTestTb().click();

			}

			catch (NoSuchElementException e) {
				
				
WebElement solvedpaper=driver.findElement(By.xpath("//i[@class='solved-board-papers']"));
solvedpaper.click();
				//chPg.getSolvedPapersTab().click();

				Thread.sleep(3000);
				List<WebElement> TotalSolvedPapers=driver.findElements(By.xpath("//ul[@class='table-list ng-scope']/li"));
				//int TotalServiceCount = chPg.getTotalSolvedPapers().size();
				int TotalServiceCount = TotalSolvedPapers.size();
				System.out.println("total number of solved paper ----" + TotalServiceCount);// 25
				Thread.sleep(2000);
				
			
				TotalSolvedPapers.get(0).click();
				
				List<WebElement> ViewAns=driver.findElements(By.xpath("//a[@class='btn jawab-btn pull-right']"));
				int questionCount = ViewAns.size();
				System.out.println("no of questions = " + questionCount);// 23
				/*
				 * for (int p = 0; p < questionCount; p++) { Thread.sleep(3000);
				 * chPg.getViewAns().get(p).click(); Thread.sleep(3000);
				 * System.out.println("welcome in Test"); Thread.sleep(5000);
				 * WebElement qs = driver.findElement(By.
				 * xpath("//*[@class='modal fade in']/div/div/div/button"));
				 * boolean qa = qs.isDisplayed(); System.out.println(qa);
				 * qs.click(); System.out.println(p); WebDriverWait wt2 = new
				 * WebDriverWait(driver, 20);
				 * 
				 * }
				 */
				driver.findElement(By.xpath("//a[@id='endTest']")).click();
				driver.switchTo().alert().accept();

				driver.navigate().back();
			}
		}

		catch (Exception e) {
			Thread.sleep(3000);
			List<WebElement> TotalSolvedPapers=driver.findElements(By.xpath("//ul[@class='table-list ng-scope']/li"));
			//int TotalServiceCount = chPg.getTotalSolvedPapers().size();
			int TotalServiceCount = TotalSolvedPapers.size();
			System.out.println("total number of solved paper ----" + TotalServiceCount);// 25
			Thread.sleep(2000);
			
		
			TotalSolvedPapers.get(0).click();
			
			List<WebElement> ViewAns=driver.findElements(By.xpath("//a[@class='btn jawab-btn pull-right']"));
			int questionCount = ViewAns.size();
			System.out.println("no of questions = " + questionCount);// 23
			/*
			 * for (int p = 0; p < questionCount; p++) { Thread.sleep(3000);
			 * chPg.getViewAns().get(p).click(); Thread.sleep(3000);
			 * System.out.println("welcome in Test"); Thread.sleep(5000);
			 * WebElement qs = driver.findElement(By.
			 * xpath("//*[@class='modal fade in']/div/div/div/button")); boolean
			 * qa = qs.isDisplayed(); System.out.println(qa); qs.click();
			 * System.out.println(p); WebDriverWait wt2 = new
			 * WebDriverWait(driver, 20);
			 */

			driver.findElement(By.xpath("//a[@id='endTest']")).click();
			driver.switchTo().alert().accept();

			driver.navigate().back();
		} // TODO: handle exception
		WebElement solvedpaper1=driver.findElement(By.xpath("//i[@class='solved-board-papers']"));
		WebElement Test44=driver.findElement(By.xpath("//a[@id='test-panel']"));
		if (solvedpaper1 != null) {
			Test44.click();
			solvedpaper1.click();

			Thread.sleep(3000);
			List<WebElement> TotalSolvedPapers2=driver.findElements(By.xpath("//ul[@class='table-list ng-scope']/li"));
			//int TotalServiceCount = chPg.getTotalSolvedPapers().size();
			int TotalServiceCount = TotalSolvedPapers2.size();
			System.out.println("total number of solved paper ----" + TotalServiceCount);// 25
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "UniformSA Test Pass");
			test.log(LogStatus.PASS, "solvedpaper Test Pass");
			TotalSolvedPapers2.get(0).click();
			List<WebElement> ViewAns2=driver.findElements(By.xpath("//a[@class='btn jawab-btn pull-right']"));
			int questionCount = ViewAns2.size();
			System.out.println("no of questions = " + questionCount);// 23
			for (int p = 0; p < questionCount; p++) {
				Thread.sleep(3000);
				ViewAns2.get(p).click();
				Thread.sleep(3000);
				System.out.println("welcome in Test");
				Thread.sleep(5000);
				WebElement qs = driver.findElement(By.xpath("//*[@class='modal fade in']/div/div/div/button"));
				boolean qa = qs.isDisplayed();
				System.out.println(qa);
				qs.click();
				System.out.println(p);
				WebDriverWait wt2 = new WebDriverWait(driver, 20);
Thread.sleep(5000);
				driver.findElement(By.xpath("//a[@id='endTest']")).click();
				driver.switchTo().alert().accept();

				driver.navigate().back();
			}
			driver.close();

		}
	}
}
