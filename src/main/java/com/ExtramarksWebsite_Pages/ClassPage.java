package com.ExtramarksWebsite_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class ClassPage extends BasePage
	{
		
		public ClassPage(WebDriver dr, ExtentTest t)
		{
		super(dr, t);
		}
	
	public int getTotalSub()
	{
		 List<WebElement> SubjectLinks=driver.findElements(By.xpath("//div[@class='postlogin-card ng-scope']//a[@href]"));
		 int links = SubjectLinks.size();
		 //System.out.println("Total Subjects: "+links);
		 return links;
		 
	}
	public List<WebElement> getSubjectLinks()
	{
		 List<WebElement> SubjectsLinks=driver.findElements(By.xpath("//div[@class='postlogin-card ng-scope']//a[@href]"));
		 return SubjectsLinks;
				 
	}

	
}
