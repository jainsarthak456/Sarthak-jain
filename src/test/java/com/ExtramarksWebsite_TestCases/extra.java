package com.ExtramarksWebsite_TestCases;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ExtramarksWebsite_Pages.ChapterPage;
import com.ExtramarksWebsite_Pages.ClassPage;
import com.ExtramarksWebsite_Pages.DashBoardPage;
import com.ExtramarksWebsite_Pages.LaunchPage;
import com.ExtramarksWebsite_Pages.LoginPage;
import com.ExtramarksWebsite_Pages.SubjectPage;
import com.ExtramarksWebsite_Utils.Constants;
import com.ExtramarksWebsite_Utils.DataUtil;
import com.ExtramarksWebsite_Utils.ExtentManager;
import com.ExtramarksWebsite_Utils.Xls_Reader;
import com.relevantcodes.extentreports.LogStatus;

public class extra extends BaseTest
{
	@BeforeMethod
	public void init()
	{
		 rep = ExtentManager.getInstance();
		 test=rep.startTest("extra");
	}
	
	@AfterMethod
	public void quit()
	{
		rep.endTest(test);
		rep.flush();
	}
	

	@Test(dataProvider="getData", priority=1)
	public void doLogin(Hashtable<String,String> data)throws InterruptedException
	{
	
		String browser = data.get("Browser");
		test.log(LogStatus.INFO, "Login test started");
		if(!DataUtil.isTestRunnable(xls, "TNPractise")  ||  data.get("Runmode").equals("N"))
		{
		
			test.log(LogStatus.SKIP, "Skipping the test");
			
			throw new SkipException("skipping the test");
		}
		
		openBrowser(browser);
		test.log(LogStatus.INFO, "Browser Opened");
		LaunchPage launch=new LaunchPage(driver, test);
		
		LoginPage lp=launch.goToHomePage();
		String title= driver.getTitle();
		System.out.println(title);
		test.log(LogStatus.INFO, "Extramarks Website Home Page");
		lp.takeScreenShot();
		
		WebElement signin = driver.findElement(By.xpath("//*[@class='signin']"));
		signin.click();
		test.log(LogStatus.INFO, "Trying to Login");
		Object resultPage=lp.doLogin(data.get("Username"),data.get("Password"));
		Thread.sleep(5000);
		
		
		test.log(LogStatus.PASS, "Login Test Passed");
	}	
		@DataProvider
		public Object[][] getData()
		{
			Xls_Reader xls = new Xls_Reader(Constants.XLS_FILE_PATH);
			Object[][] data = DataUtil.getData(xls, "TNPractise");
			return data;
		}


	@Test(priority=2)
	public void openPractise() throws InterruptedException
	{
			LoginPage lp= new LoginPage(driver, test);
			SubjectPage sp = new SubjectPage(driver, test);
			ChapterPage chPg = new ChapterPage(driver, test);
			ClassPage cp = new ClassPage(driver, test);
			
			/*WebDriverWait wt = new WebDriverWait(driver, 20);
			wt.until(ExpectedConditions.visibilityOfAllElements(cp.SubjectLinks));
			*/
			DashBoardPage dp = new DashBoardPage(driver, test);
			dp.openstudytab();
			test.log(LogStatus.INFO, "Open Study Tab");
			Thread.sleep(2000);
			lp.takeScreenShot();
			Thread.sleep(5000);
			
			int l1 = cp.getTotalSub();
			for(int i=5; i<l1;i++) 
			  {
				  System.out.println("Subjects:"+cp.getSubjectLinks().get(i).getText()); 
				  cp.getSubjectLinks().get(i).click();
				  test.log(LogStatus.INFO, "Open Chapters");
				  
				  Thread.sleep(2000);
				  lp.takeScreenShot();
				  
				  Thread.sleep(3000);
				  int elink=sp.getMainChapter().size();
				  test.log(LogStatus.INFO, "Number of Chapters :"+elink);
				  lp.takeScreenShot();
				  System.out.println("No. of chapters in this subject = "+ elink );
				  Thread.sleep(1000); 
			 
				  for (int j =0; j < elink ;j++)//1st-elink= 10 
				  { 
				  Thread.sleep(5000);
				  test.log(LogStatus.INFO, "Chapter: "+j+"= " +sp.getMainChapter().get(j).getText());
				  System.out.println(sp.getMainChapter().get(j).getText());
				  sp.getMainChapter().get(j).click();
				
				  Thread.sleep(2000);
				  lp.takeScreenShot();
				  
				  int sizeChap = sp.getSubChapter().size();
				  int postSubChap = sp.getPostSubChap().size();
				  System.out.println("No.Sub Chapters = "+sizeChap);
				  
				  if(sizeChap!=0)
		//..............................................
				  {
				   for(int su=0; su<sizeChap;++su)
				  {
					
					test.log(LogStatus.INFO, "No. of Sub Chapter : "+ sizeChap);
						
					System.out.println("Chapter : "+ su+"=" +sp.getSubChapter().get(su).getText());  
					Thread.sleep(1000);
					sp.getSubChapter().get(su).click();
					test.log(LogStatus.INFO, "Open SubChapter");
					
					Thread.sleep(2000);
					lp.takeScreenShot();
					
					WebDriverWait wt= new WebDriverWait(driver, 30);
					int PractisePresent = chPg.getPracticeTb().size();
					if(PractisePresent!=0)
					{
						chPg.getPracticeTb().get(0).click();
						int CaseStudyPresent = chPg.getCaseStudy().size();
						if(CaseStudyPresent!=0)
						{
							chPg.CaseStudy();
						}							
							
				  }
			  }
		  }
	  }
	}
				  driver.navigate().back();
  }
}
