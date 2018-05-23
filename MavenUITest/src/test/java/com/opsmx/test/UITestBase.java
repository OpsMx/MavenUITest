package com.opsmx.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

public class UITestBase{
	public WebDriver driver=null;
	
	public void UIUrl() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("/home/ubuntu/testscripts/scripts/automation_testscripts/MavenUITest/src/test/java/com/opsmx/test/datadriven.properties");
		
		prop.load(file);
		
		// Creating Driver object for firefox browser
		// This line tells your test where to find the firefox driver, which is the "glue"
	    // between Selenium and the firefox installation on your machine
		
	    System.setProperty("webdriver.gecko.driver", "/home/ubuntu/testscripts/scripts/automation_testscripts/MavenUITest/geckodriver"); 	
		// Start a new firefox browser instance and maximize the browser window
		driver=new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.get(prop.getProperty("url"));
	    System.out.println("OpsMx Page Launched");
		
	}
	
	public void UILogin() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("/home/ubuntu/testscripts/scripts/automation_testscripts/MavenUITest/src/test/java/com/opsmx/test/datadriven.properties");
		
		prop.load(file);
		//login into OpsMx
		driver.findElement(By.id("emailid")).sendKeys(prop.getProperty("Emailid"));
		driver.findElement(By.id("pass")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath("//*[@id='login']/div[2]/div/form/button")).click();

		System.out.println("Login Successfull");
	}
	

	@DataProvider(name="newdata")
	public static Object[] dp() throws IOException
	{
		//Providing list of Canary Id's from the "id.txt" file to run the test cases for
		FileReader file = new FileReader("/home/ubuntu/testscripts/scripts/automation_testscripts/MavenUITest/src/test/java/com/opsmx/test/id.txt");
		BufferedReader reader = new BufferedReader(file);
		
		List<String> ids = new ArrayList<String>();
		String line = null;
		while ((line = reader.readLine()) != null) 
	        {
	            ids.add(line);
	        }
		 reader.close();
	     //Converting list of id's into an array.
		 Object[] id = ids.toArray(new String[ids.size()]);
	     return id;
			
	 }

	public void UILogout()
	{
		//Finding number of the links in the header 
	    WebElement links=driver.findElement(By.xpath("/html/body/div/header/div"));
	    //System.out.println(links.findElements(By.tagName("a")).size());
	
	    //Selecting "RISK ASSESSMENT" from all link names in header block
	    //Iterating through all the links that are present in the header block
	     for (int i=0; i<links.findElements(By.tagName("a")).size(); i++ )
	     {
	    	     //Finding the link with the name "RISK ASSESSMENT" and clicking it
	         if(links.findElements(By.tagName("a")).get(i).getText().contains("ADMIN"))
	         {
	        	 	links.findElements(By.tagName("a")).get(i).click();
	        	 	break;
	        	 	
	         } 
	     	    
	     }
		
		driver.findElement(By.xpath("//*[@id=\"nav\"]/li[4]/ul/li/a")).click();
		System.out.println("Logout Successfull");
	}

}
