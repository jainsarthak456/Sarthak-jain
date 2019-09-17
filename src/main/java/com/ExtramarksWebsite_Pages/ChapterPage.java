package com.ExtramarksWebsite_Pages;
	
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.GetTable;

	public class ChapterPage extends BasePage 
	{
		
		
		@FindBy(xpath="//div[@id='pl-table-cont13']//div[@class='media-body media-middle text-left']")
		public List<WebElement> TestLevel;
		
		@FindBy(xpath="//*[@class='btn practise-btn orange ng-scope']")
		public WebElement ChooseTest;
		
		@FindBy(xpath="//div[@class='modal fade ng-scope in']//*[@class='close']")
		public WebElement ClosePopup;
		
		@FindBy(xpath="//div[@class='row']//li[@ng-repeat='ques in testData.data']")
		public	List<WebElement> TotalQues;
		
		@FindBy(xpath="//a[contains(text(),'Finish')]")
		public WebElement FinishBtn;
		
		@FindBy(xpath="//a[@class='btn jawab-btn']")
		public WebElement StartTest;
		
		@FindBy(xpath="//ul[@class='table-list ng-scope']//a[@id='serviceType.serviceId']")
		List<WebElement> TableContent;
		
		@FindBy(xpath="//p[contains(text(),'Lesson')]")
		public List<WebElement> Lesson;
		
		@FindBy(xpath="//ul[@class='table-list ng-scope']//a[@ng-click]")
		List<WebElement> Table;
		
		public ChapterPage(WebDriver dr, ExtentTest t)
		{
			super(dr, t);
			PageFactory.initElements(driver, this);
			
		}
		LoginPage lp= new LoginPage(driver, test);
		
		
		public List<WebElement> getTableContent()
		{
			return TableContent;
		}
//.......................................................LEARN...............................................................
		public List<WebElement> getLearnTB()
		{
			List<WebElement> LearnTb = driver.findElements(By.xpath("//a[@id='learn-panel']"));
			return LearnTb;
		}
		public void clickLearn()
		{
			List<WebElement> LearnTb = driver.findElements(By.xpath("//a[@id='learn-panel']"));
			LearnTb.get(0).click();
		}
	
	
		public List<WebElement> getConceptLearning()
		{
			List<WebElement> ConceptLearning = driver.findElements(By.xpath("//div[@class='mb10  ng-scope lpt-service-thumb']"));
			return ConceptLearning;
		}
		public void clickConceptLearning()
		{
			List<WebElement> ConceptLearning = driver.findElements(By.xpath("//div[@class='mb10  ng-scope lpt-service-thumb']"));
			ConceptLearning.get(0).click();
		}
		public void ConceptLearning() throws InterruptedException
		{
			WebDriverWait wt= new WebDriverWait(driver, 30);
			int framePresent1 = driver.findElements(By.xpath("//iframe[@id='fulscr']")).size();
			if(framePresent1==0)
			{
				Thread.sleep(3000);
				driver.navigate().back();
			}
			else
			{
			driver.switchTo().frame("fulscr");
			wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='component_base std outline']")));

			driver.findElement(By.xpath("//button[@class='component_base std outline']")).click();
			
			List<WebElement> outlineDiv = driver.findElements(By.xpath("//div[@class='outline']//div[@class='thumb']"));
			int outSize = outlineDiv.size();
			WebElement NextBtn = driver.findElement(By.xpath("//button[@class='component_base next']"));
			//WebElement PrevBtn= driver.findElement(By.xpath("//button[@class='component_base prev']"));
			System.out.println("Total slides  = " + outSize);
			
			for (int k = 0; k <= outSize - 2; k++) 
			{
				wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='component_base next']")));

				NextBtn.click();
				int j= k+1;
				test.log(LogStatus.INFO, "Open"+j+" Video");
				
				Thread.sleep(1000);
				lp.takeScreenShot();
			}

			/*for (int l = 0; l <= outSize - 2; l++) 
			{
				Thread.sleep(1000);
				PrevBtn.click();
				int j= l+1;
				test.log(LogStatus.INFO, "Open"+j+" Video");
				Thread.sleep(1000);
				lp.takeScreenShot();
			}*/
			driver.navigate().back();
			}
			}
	
		

		public List<WebElement> getDetailedLearning()
		{
			List<WebElement> DetailedLearning = driver.findElements(By.xpath("//div[@class='item ng-scope']//img[@class='img-responsive']"));
			return DetailedLearning;
		}
		public void clickDetailedLearning()
		{
			List<WebElement> DetailedLearning = driver.findElements(By.xpath("//div[@class='item ng-scope']//img[@class='img-responsive']"));
			DetailedLearning.get(0).click();
		}
		public void DetailedLearning() throws InterruptedException
		{
			WebDriverWait wt= new WebDriverWait(driver, 30);
			int framePresent1 = driver.findElements(By.xpath("//iframe[@id='fulscr']")).size();
			if(framePresent1==0)
			{
				Thread.sleep(1000);
				driver.navigate().back();
			}
			else
			{
			driver.switchTo().frame("fulscr");
			wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='component_base std outline']")));

			driver.findElement(By.xpath("//button[@class='component_base std outline']")).click();
			
			
			List<WebElement> outlineDiv = driver.findElements(By.xpath("//div[@class='outline']//div[@class='thumb']"));
			int outSize = outlineDiv.size();
			WebElement NextBtn = driver.findElement(By.xpath("//button[@class='component_base next']"));
			//WebElement PrevBtn= driver.findElement(By.xpath("//button[@class='component_base prev']"));
			System.out.println("Total slides  = " + outSize);
			
			for (int k = 0; k <= outSize - 2; k++) 
			{
				wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='component_base next']")));

				NextBtn.click();
				int j= k+1;
				test.log(LogStatus.INFO, "Open"+j+" Video");
				
				Thread.sleep(1000);
				lp.takeScreenShot();
			}

			/*for (int l = 0; l <= outSize - 2; l++) 
			{
				Thread.sleep(1000);
				PrevBtn.click();
				int j=l+1;
				test.log(LogStatus.INFO, "Open"+j+" Video");
				
				Thread.sleep(1000);
				lp.takeScreenShot();
			}*/
			driver.navigate().back();
		
			}
			
		}
		
		public List<WebElement> getGuideLines()
		{
			List<WebElement> GuideLines = driver.findElements(By.xpath("//p[contains(text(),'Guidelines')]"));
			return GuideLines;
		}
		public void Guidelines() throws InterruptedException
		{
			WebDriverWait wt= new WebDriverWait(driver, 20);
			getGuideLines().get(0).click();
			driver.switchTo().frame("fulscr");
			wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='component_base std outline']")));

			driver.findElement(By.xpath("//button[@class='component_base std outline']")).click();
			
			
			List<WebElement> outlineDiv = driver.findElements(By.xpath("//div[@class='outline']//div[@class='thumb']"));
			int outSize = outlineDiv.size();
			WebElement NextBtn = driver.findElement(By.xpath("//button[@class='component_base next']"));
			WebElement PrevBtn= driver.findElement(By.xpath("//button[@class='component_base prev']"));
			System.out.println("Total slides  = " + outSize);
			
			for (int k = 0; k <= outSize - 2; k++) 
			{
				wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='component_base next']")));

				NextBtn.click();
				int j= k+1;
				test.log(LogStatus.INFO, "Open"+j+" Video");
				
				Thread.sleep(1000);
				lp.takeScreenShot();
			}

			/*for (int l = 0; l <= outSize - 2; l++) 
			{
				Thread.sleep(1000);
				PrevBtn.click();
				int j=l+1;
				test.log(LogStatus.INFO, "Open"+j+" Video");
				
				Thread.sleep(1000);
				lp.takeScreenShot();
			}*/
			driver.navigate().back();
		}
	
		
		
		
		
		
		
		
		
		
		
		
		
		

		
//.................................................................PRACTISE...........................................................
	
		public List<WebElement> getPracticeTb()
		{
			List<WebElement> PracticeTb = driver.findElements(By.xpath("//a[@id='practise-panel']"));
			return PracticeTb;
		}	
		
		/*public void clickPractise()
		{
			List<WebElement> PracticeTb = driver.findElements(By.xpath("//a[@id='practise-panel']"));
			PracticeTb.get(0).click();
			
		}*/
		
		
		
		public List<WebElement> getMotionGallery() throws InterruptedException
		{
			List<WebElement> MotionGallery = driver.findElements(By.xpath("//p[contains(text(),'Motion Gallery')]"));
			return MotionGallery;
		}
	
		public void MotionGallery() throws InterruptedException
		{
			WebDriverWait wt= new WebDriverWait(driver, 40);
			wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Motion Gallery')]")));
			getMotionGallery().get(0).click();
			int tableSize=Table().size();
			System.out.println("No. of content = "+tableSize);
			
			for(int z=0;z<tableSize; z++)
			{

				wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='practise-panel']")));
				getPracticeTb().get(0).click();
				wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Motion Gallery')]")));
				getMotionGallery().get(0).click();
				
				wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='table-list ng-scope']//a[@ng-click]")));
				Table().get(z).click();
				System.out.println("S.No.= "+z);
			List<WebElement> frame = driver.findElements(By.xpath("//iframe[@id='fulscr']"));
			int framePresent = frame.size();
			
			if(framePresent==0)
			{
				Thread.sleep(3000);
				test.log(LogStatus.INFO, "Video is playing");
				
				lp.takeScreenShot();
				driver.navigate().back();
			}
		}
		}
			
		public List<WebElement> Table()
		{
			List<WebElement> Table = driver.findElements(By.xpath("//ul[@class='table-list ng-scope']//a[@ng-click]"));
			return Table;
		}
		
		
		public List<WebElement> LessonTable()
		{
			List<WebElement> LessonTable = driver.findElements(By.xpath("//ul[@class='table-list']//a[@ng-click]"));
			return LessonTable;
		}
		public void getTable()
		{
			Table().size();
		}
		
		
		
		public List<WebElement> getCaseStudy() throws InterruptedException
		{
			
			List<WebElement> CaseStudy = driver.findElements(By.xpath("//p[contains(text(),'Case Study')]"));
			return CaseStudy;
		}
	
		public void CaseStudy() throws InterruptedException
		{
			getCaseStudy().get(0).click();
			WebDriverWait wt= new WebDriverWait(driver, 30);
			test.log(LogStatus.INFO, "Open Case Study");
			lp.takeScreenShot();
			
			int framePresent1 = driver.findElements(By.xpath("//iframe[@id='fulscr']")).size();
			if(framePresent1==0)
			{
				Thread.sleep(5000);
				lp.takeScreenShot();
				driver.navigate().back();
			}
			else
			{
			driver.switchTo().frame("fulscr");
			wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='component_base std outline']")));

			driver.findElement(By.xpath("//button[@class='component_base std outline']")).click();
			
			List<WebElement> outlineDiv = driver.findElements(By.xpath("//div[@class='outline']//div[@class='thumb']"));
			int outSize = outlineDiv.size();
			WebElement NextBtn = driver.findElement(By.xpath("//button[@class='component_base next']"));
			WebElement PrevBtn= driver.findElement(By.xpath("//button[@class='component_base prev']"));
			System.out.println("Total slides  = " + outSize);
			
			for (int k = 0; k <= outSize - 2; k++) 
			{
				wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='component_base next']")));

				NextBtn.click();
				int j= k+1;
				test.log(LogStatus.INFO, "Open"+j+" Video");
				
				Thread.sleep(1000);
				lp.takeScreenShot();
			}

			/*for (int l = 0; l <= outSize - 2; l++) 
			{
				Thread.sleep(1000);
				PrevBtn.click();
				int j=l+1;
				test.log(LogStatus.INFO, "Open"+j+" Video");
				
				Thread.sleep(1000);
				lp.takeScreenShot();
			}*/
			driver.navigate().back();
			}
		}
		
		public List<WebElement> getQA()
		{
			List<WebElement> QA = driver.findElements(By.xpath("//p[contains(text(),'Q&A')]"));
			return QA;
		}
		
		public void QA() throws InterruptedException
		{
			getQA().get(0).click();
			List<WebElement> AnswerTab = driver.findElements(By.xpath("//div[@class='postlogin-card ng-scope']//a[contains(text(),'Answer')]"));// 69

			int size = AnswerTab.size();
			test.log(LogStatus.INFO, "Total Questions in QA= "+size);
			System.out.println("Total answers : " + size);

			Thread.sleep(1000);
			{
				List<WebElement> SelectAns = driver.findElements(By.xpath("//form[@class='form col-sm-9 ng-pristine ng-valid']"));
				List<WebElement> TypedAns = driver.findElements(By.xpath("//textarea[@class='form-control qa-textarea']"));
				int TestArea = TypedAns.size();
				System.out.println("Ansers to be typed : "+TestArea);
				

				int Size = SelectAns.size();
				System.out.println("Answers to be selected from multiple options: "+Size);

				Thread.sleep(1000);
				for (int i = 0; i < Size; i++)
				{
					AnswerTab.get(i).click();
					Thread.sleep(1000);
					lp.takeScreenShot();
					//boolean az = SelAns.get(zi).isDisplayed();
					//System.out.println(i + " clicks");
					//Thread.sleep(1000);
					List<WebElement> list = driver.findElements(By.xpath(" //div[@class='row ng-scope']//form//div[4]"));
					list.get(i).click();
					Thread.sleep(1000);
					lp.takeScreenShot();
					//System.out.println("welcome in practise");
					WebElement closePopup = driver.findElement(By.xpath("//div[@class='modal fade ng-scope in']//*[@class='close']"));
					 closePopup.click();
					Thread.sleep(1000);

				}
				for (int p = 0; p < TestArea; p++)
				{
					int count = p + Size;
					AnswerTab.get(count).click();
					TypedAns.get(p).sendKeys("Test");
					//Thread.sleep(1000);
					lp.takeScreenShot();
				}
			}
			driver.navigate().back();
		}
		
		public List<WebElement> getTopicWiseQA()
		{
			List<WebElement> TopicWiseQA=driver.findElements(By.xpath("//p[contains(text(),'Topicwise QA')]"));
			return TopicWiseQA;
		}
		public void TopicwiseQA()
		{
			getTopicWiseQA().get(0).click();
			test.log(LogStatus.INFO, "Opening Topic Wise QA");
			List<WebElement> Answers = driver.findElements(By.xpath("//a[contains(text(),'Answer')]"));
			int AnsCount = Answers.size();
			test.log(LogStatus.INFO, "Total questions in TopicWiseQA = "+AnsCount);
			System.out.println("Number of Questions = "+AnsCount);
			driver.navigate().back();
		}
		
		public List<WebElement> getAssignment()
		{
			List<WebElement> Assignment = driver.findElements(By.xpath("//p[contains(text(),'Assignment')]"));
			return Assignment;
		}
		
		public List<WebElement> getConceptCraft()
		{
			List<WebElement> ConceptCraft = driver.findElements(By.xpath("//p[contains(text(),'Concept Craft')]"));
			return ConceptCraft;
		}
		
		public void ConceptCraft() throws InterruptedException
		{
			getConceptCraft().get(0).click();
		
			int TableSize =Table().size();
			System.out.println("Table of Content = "+TableSize);
			if(TableSize==0)
			{
				Thread.sleep(2000);
				System.out.println("Opening Concept Craft");
				test.log(LogStatus.INFO, "Opening Concept Craft");
				lp.takeScreenShot();
				driver.navigate().back();
			}
			else
			{
			for(int a1=0; a1<TableSize; a1++)
			{
				getPracticeTb().get(0).click();
				getConceptCraft().get(0).click();
				Thread.sleep(2000);
				Table().get(a1).click();
				System.out.println("Opening"+" "+a1+ " Concept Craft");
				test.log(LogStatus.INFO, "Opening"+" "+a1+ " Concept Craft");
				
				Thread.sleep(2000);
				lp.takeScreenShot();
				driver.navigate().back();
			}
			}
			}
			
		/*public List<WebElement> getProjects()
		{
			List<WebElement> Projects = driver.findElements(By.xpath("//p[contains(text(),'Projects')]"));
			return Projects;
		}
		public void Projects()
		{
			getProjects().get(0).click();
		}
		*/
		
		public void Assignment() throws InterruptedException
		{
			getAssignment().get(0).click();
			
			int Tablesize =Table().size();
			System.out.println("Table of Content = "+Tablesize);
			if(Tablesize==0)
			{
				Thread.sleep(2000);
				List<WebElement> ViewAns = driver.findElements(By.xpath("//*[contains(text(),'View Answer')]"));
				int Questions = ViewAns.size();
				test.log(LogStatus.INFO, "No. of questions : "+Questions);
				lp.takeScreenShot();
				
				System.out.println("Number of questions: "+Questions);
				Thread.sleep(2000);
				WebElement EndTest = driver.findElement(By.id("endTest"));
				EndTest.click();
				driver.switchTo().alert().accept();
				test.log(LogStatus.INFO, "End Test");
				lp.takeScreenShot();
				driver.navigate().back();	
			}
			
			else
			{
			for(int a=0; a<Tablesize; a++)
			{
				getPracticeTb().get(0).click();
				getAssignment().get(0).click();
				test.log(LogStatus.INFO, "Open Assignment");
				lp.takeScreenShot();
				
				Thread.sleep(1000);
				Table().get(a).click();
				test.log(LogStatus.INFO, "Opening"+" "+a+ " Assignment");
				Thread.sleep(1000);
				List<WebElement> ViewAns = driver.findElements(By.xpath("//*[contains(text(),'View Answer')]"));
				int Questions = ViewAns.size();
				test.log(LogStatus.INFO, "No. of questions : "+Questions);
				lp.takeScreenShot();
				
				System.out.println("Number of questions: "+Questions);
				Thread.sleep(1000);
				WebElement EndTest = driver.findElement(By.id("endTest"));
				EndTest.click();
				driver.switchTo().alert().accept();
				test.log(LogStatus.INFO, "End Test");
				lp.takeScreenShot();
				
				driver.navigate().back();
			}	
			}
		}
		
		public List<WebElement> getNCERTSol()
		{
			List<WebElement> NCERTSolution = driver.findElements(By.xpath("//p[contains(text(),'NCERT SOLUTIONS')]"));
			return NCERTSolution;
		}
		public void NCERTSolution() throws InterruptedException
		{
			getNCERTSol().get(0).click();
			Thread.sleep(1000);
			test.log(LogStatus.INFO, "Opening NCERT Solutions");
			lp.takeScreenShot();
			Thread.sleep(3000);
			driver.navigate().back();
		}
		
		
		public List<WebElement> getVBQ()
		{
			List<WebElement> VBQ = driver.findElements(By.xpath("//p[contains(text(),'VBQ')]"));
			return VBQ;
		}
		public void VBQ() throws InterruptedException
		{
			getVBQ().get(0).click();
			List<WebElement> AnsTab = driver.findElements(By.xpath("//div[@class='postlogin-card ng-scope']//a[contains(text(),'Answer')]"));
			int size = AnsTab.size();
			System.out.println("Total answers : " + size);
			Thread.sleep(1000);
			
			List<WebElement> SelAns = driver.findElements(By.xpath("//form[@class='form col-sm-9 ng-pristine ng-valid']"));
			List<WebElement> TypeAns = driver.findElements(By.xpath("//textarea[@class='form-control qa-textarea']"));
			int TestArea = TypeAns.size();
			System.out.println(TestArea);
			int ASize = SelAns.size();
			System.out.println(ASize);

			for (int p = 0; p < TestArea; p++)
			{
				int count = p + ASize;
				AnsTab.get(count).click();
				TypeAns.get(p).sendKeys("Done");
				//System.out.println(p + "  done");
				Thread.sleep(1000);
			}
			driver.navigate().back();
		}
		
		public List<WebElement> getHOTS()
		{
			List<WebElement> HOTS = driver.findElements(By.xpath("//p[contains(text(),'HOTS')]"));
			return HOTS;
		}
		public void HOTS() throws InterruptedException
		{
			getHOTS().get(0).click();
			int table = Table().size();
			System.out.println("Table = "+table);
			
			for(int h=0; h<table;h++)
			{
				getPracticeTb().get(0).click();
				getHOTS().get(0).click();
				WebDriverWait wt= new WebDriverWait(driver, 70);
				Table().get(h).click();
				driver.switchTo().frame("fulscr");
				WebElement outline = driver.findElement(By.xpath("//button[@class='component_base std outline']"));
				outline.click();
				
				List<WebElement> outlineDiv = driver.findElements(By.xpath("//div[@class='outline']//div[@class='thumb']"));
				int outSize = outlineDiv.size();
				WebElement NextBtn = driver.findElement(By.xpath("//button[@class='component_base next']"));
				//WebElement PrevBtn= driver.findElement(By.xpath("//button[@class='component_base prev']"));
				System.out.println("Total slides  = " + outSize);
				
				for (int k = 0; k <= outSize - 2; k++) 
				{
					wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='component_container next']//button[@class='component_base next']")));
					NextBtn.click();
					int j= k+1;
					test.log(LogStatus.INFO, "Open"+j+" Video");
					
					Thread.sleep(1000);
					lp.takeScreenShot();
				}

				/*for (int l = 0; l <= outSize - 2; l++) 
				{
					Thread.sleep(1000);
					PrevBtn.click();
					int j= l+1;
					test.log(LogStatus.INFO, "Open"+j+" Video");
					Thread.sleep(1000);
					lp.takeScreenShot();
				}*/
				driver.navigate().back();
			}
		}
		
		
		
		
		
		
		
		
	//.............................................TEST SERVICES......................................................................................
		
		public List<WebElement> getTestTb()
		{
			List<WebElement> TestTb=driver.findElements(By.xpath("//a[@id='test-panel']"));
			return TestTb;
		}
		
		public List<WebElement> getMCQ()
		{
			List<WebElement> MCQ = driver.findElements(By.xpath("//p[contains(text(),'MCQ')]"));
			return MCQ;
		}
		
		public void	MCQ() throws InterruptedException
		{
			getMCQ().get(0).click();
			List<WebElement> TestLevels = driver.findElements(By.xpath("//div[@id='pl-table-cont13']//div[@class='media-body media-middle text-left']"));
			int size = TestLevels.size();
			test.log(LogStatus.INFO, "Number of Levels in  MCQ ="+size);
			System.out.println("Number of Levels in MCQ= "+size);
			WebElement ChoseTest = driver.findElement(By.xpath("//*[@class='btn practise-btn orange ng-scope']"));
			ChoseTest.click();
			WebElement PopMenu = driver.findElement(By.xpath("//div[@class='modal fade ng-scope in']//*[@class='close']"));
			PopMenu.click();
			
			int Questions = driver.findElements(By.xpath("//ul[@class='testq-counter ng-scope']//li[@ng-repeat]")).size();
			for (int s = 0; s <= Questions; s++)
			{
				if (s<4)
				{
					Thread.sleep(2000);
					driver.findElement(By.xpath(" //div[@class='col-sm-12 chapter-list-name']//form//div[1]")).click();
				} 
				else if (s>4) 
				{
					Thread.sleep(2000);
					driver.findElement(By.xpath(" //div[@class='col-sm-12 chapter-list-name']//form//div[2]")).click();
				}
			}
			Thread.sleep(1000);
			WebElement Finish = driver.findElement(By.xpath("//*[@class='btn practise-btn orange ml10 font12 ng-scope']"));
			Finish.click();
			Thread.sleep(1000);
			driver.navigate().back();
		}
		
		
		public List<WebElement> getAdaptiveTest()
		{
			List<WebElement> AdaptiveTest = driver.findElements(By.xpath("//p[contains(text(),'Adaptive Test')]"));
			return AdaptiveTest;
		}
		public void AdaptiveTest() throws InterruptedException
		{
			getAdaptiveTest().get(0).click();
			WebElement StartTest = driver.findElement(By.xpath("//a[@class='btn jawab-btn']"));
			StartTest.click();
			WebDriverWait wt= new WebDriverWait(driver, 40);
			WebElement close = wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal fade ng-scope in']//*[@class='close']")));
			close.click();
			
			 List<WebElement> Questions = driver.findElements(By.xpath("//div[@class='row']//ul[@class='testq-counter ng-scope']//li//span"));
			 int size=Questions.size();
			 test.log(LogStatus.INFO, "Number of questions in Adaptive Test: "+size);
			 System.out.println("Number of questions in Adaptive Test: " +size);
			 
			 for(int b=0; b<=size;b++) 
			 {
					if(b<4) 
					{
					Thread.sleep(4000);
					driver.findElement(By.xpath(" //div[@class='col-sm-12 chapter-list-name']//form//div[3]")).click();
					} 
					else if (b>4) 
					{
					Thread.sleep(2000);
					driver.findElement(By.xpath(" //div[@class='col-sm-12 chapter-list-name']//form//div[2]")).click();
					}
			}
			 driver.findElement(By.xpath("//a[@class='btn practise-btn orange ml10 font12 ng-scope']")).click();
			 System.out.println("Adaptive test complete");
			 Thread.sleep(2000);
			 driver.navigate().back();
			}
			
		public List<WebElement> getPeriodicTest()
		{
			List<WebElement> PeriodicTest = driver.findElements(By.xpath("//i[@class='periodic-test']"));
			return PeriodicTest;
		}
		public void PeriodicTest() throws InterruptedException
		{
			getPeriodicTest().get(0).click();
			
			List<WebElement> Table = driver.findElements(By.xpath("//ul[@class='table-list ng-scope']//a[@id='serviceType.serviceId']"));
			int TotalService =Table.size();
			System.out.println("total number of service under Periodic Test ---" + TotalService);
			/*for(int q=0; q<TotalService; q++)
			{*/
			
			/*getTestTb().get(0).click();
			getPeriodicTest().get(0).click();
		*/	int q=0;
			Thread.sleep(5000);
			Table.get(q).click();
			List<WebElement> Ques = driver.findElements(By.xpath("//*[contains(text(),'View Answer')]"));
			int QuesCount = Ques.size();
			System.out.println("no of questions = " + QuesCount);

			WebElement BackBtn = driver.findElement(By.xpath("//a[contains(text(),'Back')]"));
			BackBtn.click();
			//}
		}
			
		public List<WebElement> getUniformTest()
		{
			List<WebElement> UniformTest = driver.findElements(By.xpath("//i[@class='uniform-sa']"));
			return UniformTest;
		}
		public void UniformTest()
		{
			getUniformTest().get(0).click();
			List<WebElement> Services = driver.findElements(By.xpath("//a[@id='serviceType.serviceId']"));
			int TotalService = Services.size();
			System.out.println("Total Number of Service under Uniform SA Test ---" + TotalService);
			
			for(int ut=0; ut<TotalService; ut++)
			{
			getTestTb().get(0).click();
			getUniformTest().get(0).click();
			
			Services.get(ut).click();
			List<WebElement> Question = driver.findElements(By.xpath("//*[contains(text(),'View Answer')]"));
			int Questioncount = Question.size();
			System.out.println("no of questions = " + Questioncount);
			
			WebElement BackBtn = driver.findElement(By.xpath("//a[@ng-click='goBackToLPTDataboard();']"));
			BackBtn.click();
			}
		}
		
		public List<WebElement> getSolvedPapers()
		{
		List<WebElement> SolvedPapers = driver.findElements(By.xpath("//i[@class='solved-board-papers']"));
		return SolvedPapers;
		}
		public void SolvedPapers() throws InterruptedException
		{
			getSolvedPapers().get(0).click();
			List<WebElement> Services = driver.findElements(By.xpath("//ul[@class='table-list ng-scope']/li"));
			int TotalService = Services.size();
			System.out.println("Total Number of Solved Paper= " + TotalService);
			Thread.sleep(2000);
			Services.get(0).click();
			List<WebElement> ViewAns = driver.findElements(By.xpath("//*[contains(text(),'View Answer')]"));
			int Questions = ViewAns.size();
			System.out.println("No of Questions = " + Questions);
			driver.findElement(By.xpath("//a[@id='endTest']")).click();
			driver.switchTo().alert().accept();
			
			
			Thread.sleep(3000);
			driver.navigate().back();
		}
		
		public List<WebElement> getModelPaper()
		{
			List<WebElement> ModelPapers = driver.findElements(By.xpath("//p[contains(text(), 'Model Paper')]"));
			return ModelPapers;
		}
		public void ModelPapers() throws InterruptedException
		{
			getModelPaper().get(0).click();
			int table = Table().size();
			System.out.println("Table of Content ="+table);
			
			/*for(int a1=0; a1<table; a1++)
			{
			*/	getPracticeTb().get(0).click();
				getModelPaper().get(0).click();
				Thread.sleep(5000);
				Table().get(0).click();
				
				List<WebElement> ViewAns = driver.findElements(By.xpath("//*[contains(text(),'View Answer')]"));
				int Questions = ViewAns.size();
				System.out.println("No. of Questiond ="+Questions);
				Thread.sleep(5000);
				lp.takeScreenShot();
				driver.navigate().back();
			}
			
		public void getLesson()
		{
			Lesson.get(0).click();
			
		}
		public void Lesson() throws InterruptedException
		{
			Lesson.get(0).click();
			Thread.sleep(10000);
			lp.takeFullScreenshot();
			Thread.sleep(5000);
			
			WebDriverWait wt= new WebDriverWait(driver, 80);
			int framePresent = driver.findElements(By.xpath("//iframe[@id='fulscr']")).size();
			int table = LessonTable().size();
			int table_2= Table.size();
			
			System.out.println("Table present = "+table);
			
				if(table==0 && framePresent==0|| table_2==0 && framePresent==0)
					{
					 Thread.sleep(5000);
					 lp.takeScreenShot();
					// driver.navigate().back();
					}
			
				else if(table==0 )
				{
				
				System.out.println("No table");
				driver.switchTo().frame("fulscr");
				wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'OUTLINE')]")));
				driver.findElement(By.xpath("//span[contains(text(),'OUTLINE')]")).click();
				
				int outSize = driver.findElements(By.xpath("//div[@class='outline']//div[@class='thumb']")).size();
				int slides= outSize-2;
				System.out.println("Total slides  = " + outSize);
				//WebElement Next = driver.findElement(By.xpath("//button[@class='component_base next']"));
				//WebElement PrevBtn= driver.findElement(By.xpath("//button[@class='component_base prev']"));
				
				for (int k = 0; k <=slides; k++) 
				{
					
					wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='component_container next']//button[@class='component_base next']")));
					WebElement Next = driver.findElement(By.xpath("//div[@class='component_container next']//button[@class='component_base next']"));
					Next.click();
					int j= k+1;
					test.log(LogStatus.INFO, j+" slide opens");
				
					lp.takeScreenShot();
					driver.navigate().back();
				}
				
				}
			else if(table!=0 || table_2!=0 )
			{
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='table-list']//a[@ng-click]")));
				System.out.println("Table of content : "+table);
				for (int m=0; m<table; ++m) 
				{
					Lesson.get(0).click();
					LessonTable().get(m).click();
					if(table!=0)
					{
						LessonTable().get(m).click();
					}
							driver.switchTo().frame("fulscr");
							wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'OUTLINE')]")));
							driver.findElement(By.xpath("//span[contains(text(),'OUTLINE')]")).click();
							
							
							List<WebElement> outlineDiv = driver.findElements(By.xpath("//div[@class='outline']//div[@class='thumb']"));
							int outSize = outlineDiv.size();
							WebElement Next = driver.findElement(By.xpath("//button[@class='component_base next']"));
							test.log(LogStatus.INFO, "Total slides = "+outSize);
							//WebElement PrevBtn= driver.findElement(By.xpath("//button[@class='component_base prev']"));
							System.out.println("Total slides  = " + outSize);
							
							for (int k = 0; k <= outSize - 2; k++) 
							{
								
								List<WebElement> ResumeBtn = driver.findElements(By.xpath("//button[contains(text(),'YES')]"));
								int ResumePresent = ResumeBtn.size();
								if(ResumePresent!=0)
								{
									ResumeBtn.get(0).click();
								}
								Next.click();
								int j= k+1;
								test.log(LogStatus.INFO, j+" slide Open");
								lp.takeScreenShot();
							}
							driver.navigate().back();
						}
					}
			}

		public List<WebElement> getAnimation()
		{
			List<WebElement> Animation = driver.findElements(By.xpath("//p[contains(text(), 'Animation')]"));
			return Animation;
		}
		public void Animation()
		{
			getAnimation().get(0).click();
			test.log(LogStatus.INFO, "Opens Animation");
			
			int listAnim = driver.findElements(By.xpath("//div[@id='animationtab']//li[@ng-repeat]")).size();
			test.log(LogStatus.INFO, "List of Animation contains "+listAnim+ " Animations");
			lp.takeScreenShot();
			System.out.println("List of Animation contains " +listAnim+ " Animations");
			
			WebDriverWait wt= new WebDriverWait(driver,20);
			wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Other Animation')]")));
			driver.findElement(By.xpath("//a[contains(text(),'Other Animation')]")).click();
			
			int otherAnim = driver.findElements(By.xpath("//div[@id='otheranimationtab']//li[@ng-repeat]")).size();
			test.log(LogStatus.INFO, "Other Animation tab contains "+otherAnim+ " Animations");
			lp.takeScreenShot();
			System.out.println("Other Animation tab contains "+otherAnim+ " Animations");
			driver.navigate().back();
		}
		
		public List<WebElement> getQuickStudy()
		{
			List<WebElement> QuickStudy = driver.findElements(By.xpath("//p[contains(text(),'Quick Study')]"));
			return QuickStudy;
		}
		public void QuickStudy() throws InterruptedException
		{
			getQuickStudy().get(0).click();
			Thread.sleep(1000);
			test.log(LogStatus.INFO, "Opening Quick Study");
			lp.takeScreenShot();
			Thread.sleep(3000);
			driver.navigate().back();
		}
		
		
}
		
		