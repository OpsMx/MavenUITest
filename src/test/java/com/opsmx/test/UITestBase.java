package com.opsmx.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;


public class UITestBase{
	private static final String DATA_CONFIG_FILE="datadriven.properties";
	private static final String GECKO_CONFIG_FILE="geckodriver";
	private static final String BID_CONFIG_FILE="id.txt";
			
	public WebDriver driver=null;
	static InputStream inputStream;
	
	public Properties prop;
	public void UIUrl() throws IOException
	{
	 try{
	  
	  prop=new Properties();
	  inputStream=getClass().getClassLoader().getResourceAsStream(DATA_CONFIG_FILE);
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + DATA_CONFIG_FILE + "' not found in the classpath");
		}	
		// Creating Driver object for firefox browser
		// This line tells your test where to find the firefox driver, which is the "glue"
	    // between Selenium and the firefox installation on your machine
		
	    System.setProperty("webdriver.gecko.driver", GECKO_CONFIG_FILE); 	
		// Start a new firefox browser instance and maximize the browser window
		driver=new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.get(prop.getProperty("url"));
	    System.out.println("OpsMx Page Launched");
	 } catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		
	}
	
	public void UILogin() throws IOException
	{
		
	 try{
		  prop=new Properties();
		  inputStream=getClass().getClassLoader().getResourceAsStream(DATA_CONFIG_FILE);
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + DATA_CONFIG_FILE + "' not found!");
			}	
		//login into OpsMx
		driver.findElement(By.id("emailid")).sendKeys(prop.getProperty("Emailid"));
		driver.findElement(By.id("pass")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath("//*[@id='login']/div[2]/div/form/button")).click();

		System.out.println("Login Successfull");
	 } catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
	}
	

	@DataProvider(name="newdata")
	public static Object[] dp() throws IOException
	{
		BufferedReader reader;
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream(BID_CONFIG_FILE);
		if (is != null) {
			InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
			reader = new BufferedReader(streamReader);
		} else {
			throw new FileNotFoundException("property file '" + BID_CONFIG_FILE + "' not found!");
		}	
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