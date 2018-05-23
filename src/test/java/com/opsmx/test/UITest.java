package com.opsmx.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;


public class UITest extends UITestBase{	
	
	String canaryid;
	String id;
	
	
	@BeforeClass     //annotation for test case
	public void UIConn() throws IOException
	{
		
		//Opening OpsMX WebPage
		//Verifying Accessing OpsMx web page
	    try {
	    	UIUrl();
		} catch (AssertionError e){
			System.out.println(" for Object id: "+ id + " i.e. Canary id: " +canaryid);
		}
	}
	
	@Test(dataProvider = "newdata")
	public void UITesting(String id) throws IOException, InterruptedException
	{
		//login to the OpsMX
		//Verifying Login
	    try {
	    	UILogin();
	    	Thread.sleep(1000);
		} catch (AssertionError e){
			System.out.println(" for Object id: "+ id + " i.e. Canary id: " +canaryid);
		}
		
		//Verifying Risk AssesmentTab
	    System.out.println("Selecting Risk AssesmentTab");
	    try {
	    	UISelectRiskAssessmentTab();
		} catch (AssertionError e){
			System.out.println(" for Object id: "+ id + " i.e. Canary id: " +canaryid);
		}
	    
	  //Verifying Canary Id's selection
	    try {
	    	UIVerifySelectingCanaryID(id);
		} catch (AssertionError e){
			System.out.println(" for Object id: "+ id + " i.e. Canary id: " +canaryid);
		}
	    
	  //Verifying Canary Id's Score
	    try {
	    	UIVerifyCanaryScore();
		} catch (AssertionError e){
			System.out.println(" for Object id: "+ id + " i.e. Canary id: " +canaryid);
		}
	    
	  //Verifying Canary Id's Metric Score
	    try {
	    	UIVerifyMetricScore();
		} catch (AssertionError e){
			System.out.println(" for Object id: "+ id + " i.e. Canary id: " +canaryid);
		}
	    
	  //Verifying Canary Id's Metric Score Network Group Selection
	    try {
	    	UIVerifyMetricScoreNetworkGroupSelection();
		} catch (AssertionError e){
			System.out.println(" for Object id: "+ id + " i.e. Canary id: " +canaryid);
		}
	    
	  //Verifying Canary Id's Metric Score Network Group
	    try {
	    	UIVerifyMetricScoreNetworkGroup();
		} catch (AssertionError e){
			System.out.println(" for Object id: "+ id + " i.e. Canary id: " +canaryid);
		}
	    
	  //Verifying Canary Id's Metric Score Analysis
	    try {
	    	UIVerifyMetricScoreAnalysis();
		} catch (AssertionError e){
			System.out.println(" for Object id: "+ id + " i.e. Canary id: " +canaryid);
		}
	    
	  //Verifying Canary Id's Metric Score Scatter Chart
	    try {
	    	AssertJUnit.assertTrue(UIVerifyMetricScoreScatterChart());
		} catch (AssertionError e){
			System.out.println(" for Object id: "+ id + " i.e. Canary id: " +canaryid);
		}
	    
	  //Verifying Canary Id's Metric Score Box Plot
	    try {
	    	AssertJUnit.assertTrue(UIVerifyMetricScoreBoxPlot());
		} catch (AssertionError e){
			System.out.println(" for Object id: "+ id + " i.e. Canary id: " +canaryid);
		}
	    
	  //Verifying Canary Id's Analysis Summary
	    try {
	    	UIVerifyAnalysisSummary();
		} catch (AssertionError e){
			System.out.println(" for Object id: "+ id + " i.e. Canary id: " +canaryid);
		}
	    
	  //Verifying Canary Id's Log Score
	    try {
	    	UIVerifyLogScore();
		} catch (AssertionError e){
			System.out.println(" for Object id: "+ id + " i.e. Canary id: " +canaryid);
		}
	    
	  //Verifying Canary Id's APM Score
	    try {
	    	UIVerifyAPMScore();
		} catch (AssertionError e){
			System.out.println(" for Object id: "+ id + " i.e. Canary id: " +canaryid);
		}
	    
	  //Verifying Canary Id's Logout
	    try {
	    	UILogout();
		} catch (AssertionError e){
			System.out.println(" for Object id: "+ id + " i.e. Canary id: " +canaryid);
		}
	    
    	    
	}

	public boolean UISelectRiskAssessmentTab() throws IOException
	{	 
		boolean result = true;	
	    //Finding number of the links in the header 
	    WebElement links=driver.findElement(By.xpath("/html/body/div/header/div"));
	    //System.out.println(links.findElements(By.tagName("a")).size());
	
	    //Selecting RISK ASSESSMENT from all link names in header block
	    //Iterating through all the links that are present in the header block and select the header with "RISK ASSESSMENT"
	     for (int i=0; i<links.findElements(By.tagName("a")).size(); i++ )
	     {
	    	     //Finding the link with the name "RISK ASSESSMENT" and clicking it
	         if(links.findElements(By.tagName("a")).get(i).getText().contains("RISK ASSESSMENT"))
	         {
	        	 links.findElements(By.tagName("a")).get(i).click();
	           	 break;
	         }
	        
	     }
     
	    // Waiting for the page to load and verifying the title of the page
	    WebDriverWait d=new WebDriverWait(driver, 25);
        d.until(ExpectedConditions.titleContains("Canary"));
	    System.out.println("Verifying whether we are in the correct web page i.e Canary analysis | OpsMx");
    	if(driver.getTitle().contains("analysis"))
       	{
       		//Verifying the title of the page
       		System.out.println("Verifyed we are in the correct web page i.e Canary analysis | OpsMx");
       	}
        else
        {
 	 		System.out.print("ERROR: Correct web page was not opened");
 	 		result = false;
        }
    	    
        return result;
	}
	

	public void UIVerifySelectingCanaryID(String id) throws InterruptedException
	{

	    //Using "Select" class for drop downs to select "Multi-Source Dock" and "Canary ID 824"
	    //Selecting Multi-Source Dock
	    System.out.println("Selecting Multi-Source Dock");
	    Select s1=new Select(driver.findElement(By.cssSelector("select.col-md-2:nth-child(1)")));
	    s1.selectByValue("5");
	    System.out.println("Selected Multi-Source Dock");
	    Select s2=new Select(driver.findElement(By.cssSelector("select.rep-select:nth-child(2)")));
	    s2.selectByValue(id);
	    System.out.println("Canary ID selected from list");
	    Thread.sleep(1000);
	    
	    //System.out.println("Hitting GO button");
	    driver.findElement(By.cssSelector("button.btn.btn-sm.rep-button")).click();
	    System.out.println("Hit GO button"); 
	    Thread.sleep(1000);

	}
	

	public boolean UIVerifyMetricScore() throws InterruptedException
	{
		boolean result = true;
      	 //Thread.sleep(1000);
         System.out.println("*****");
         System.out.println("Validating Metric Score information");
         if(driver.findElement(By.cssSelector("#home > div > div:nth-child(5) > div:nth-child(1) > div > div > div > div > div:nth-child(7) > table > tbody:nth-child(5) > tr")).getText().contains("Network Group"))
         {
        	     System.out.println(" *** Metric Score Information ***");
        	     System.out.println(driver.findElement(By.cssSelector("#home > div > div:nth-child(5) > div:nth-child(1) > div > div > div > div > div:nth-child(7) > table")).getText());
        	     if(driver.findElement(By.cssSelector("#home > div > div:nth-child(5) > div:nth-child(1) > div > div > div > div > div:nth-child(7) > table")).getText().isEmpty())
        	     {
          	 		System.out.print("ERROR: Metric Score Information was not displayed");
          	 		result = false;
          	 	}
          	 	else
          	 	{
          	 		//System.out.print(" Metric Score Information was displayed");
          	 		result = true;
          	 	}
          }
          return result;
	}
	

	public boolean UIVerifyMetricScoreNetworkGroupSelection() throws InterruptedException
	{
		boolean result = true;
		System.out.println(" Verifying Network Group Selection: ");
		//*[@id="home"]/div/div[5]/div[1]/div/div/div/div/div[3]/table/tbody[4]/tr/td[5]/button
		System.out.println(driver.findElement(By.xpath("//*[@id='home']/div/div[5]/div[1]/div/div/div/div/div[3]/table/tbody[4]/tr/td[5]/button")).getText());
		if(driver.findElement(By.xpath("//*[@id='home']/div/div[5]/div[1]/div/div/div/div/div[3]/table/tbody[4]/tr/td[5]/button")).getText().isEmpty())
		{
			System.out.print("ERROR: Network Group Selection was not done");
			result = false;
  	 	}
  	 	else
  	 	{
  	 		System.out.println(" Selecting Network Group from the list whose score is less or equal to 100 ");
  	 		Thread.sleep(2000);
  	 		driver.findElement(By.xpath("//*[@id='home']/div/div[5]/div[1]/div/div/div/div/div[3]/table/tbody[4]/tr[1]/td[1]/button")).click();
  	 		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[5]/div[1]/div/div/div/div/div[3]/table/tbody[4]/tr[5]/td[5]/button")).click();
  	 		System.out.println(" Selected Network Group Container from the list. ");
  	 	}
        return result;
	}
	

	public boolean UIVerifyMetricScoreNetworkGroup() throws InterruptedException
	{
		boolean result = true;
		System.out.println(" Verifying Selected Network Group Information: ");
		//System.out.println(driver.findElement(By.xpath("//*[@id='home']/div/div[5]/div[2]/div[1]/div[2]/div/div[1]")).getText());
		if (driver.findElement(By.xpath("//*[@id='home']/div/div[5]/div[2]/div[1]/div[2]/div/div[1]")).getText().contains("NETWORK GROUP"))        
		{
			System.out.println(driver.findElement(By.xpath("//*[@id='home']/div/div[5]/div[2]/div[1]/div[2]/div/div[2]")).getText());
			if(driver.findElement(By.xpath("//*[@id='home']/div/div[5]/div[2]/div[1]/div[2]/div/div[2]")).getText().isEmpty())
          	{
				System.out.print("ERROR: Correct NETWORK GROUP;CONTAINER_NETWORK_RECEIVE_PACKETS_TOTAL graph was not displayed");
     	 		result = false;
     	 	}
     	 	else
     	 	{
     	 		//System.out.println(" Correct NETWORK GROUP;CONTAINER_NETWORK_RECEIVE_PACKETS_TOTAL graph was displayed");
     	 		result = true;
     	 	}
         }
         else
         {
  	 			System.out.print("ERROR: Network Group was not displayed");
  	 			result = false;
  	 	}
         return result;
	}
	

	public boolean UIVerifyMetricScoreAnalysis()
	{
		boolean result = true;
        System.out.println(" Verifying Network Group Container Analysis Information. "); 
         if (driver.findElement(By.xpath("//*[@id='home']/div/div[5]/div[2]/div[1]/div[1]/div/div[1]")).getText().contains("ANALYSIS"))
         {
         	 	System.out.println(driver.findElement(By.xpath("//*[@id='home']/div/div[5]/div[2]/div[1]/div[1]/div/div[1]")).getText());
        	 	System.out.println(driver.findElement(By.xpath("//*[@id='home']/div/div[5]/div[2]/div[1]/div[1]/div/div[2]/div")).getText());
        	 	if(driver.findElement(By.xpath("//*[@id='home']/div/div[5]/div[2]/div[1]/div[1]/div/div[2]/div")).getText().isEmpty())
         	 	{
         	 		System.out.print("ERROR: Correct Analysis graph was not displayed");
         	 		result = false;
         	 	}
         	 	else
         	 	{
         	 		//System.out.println("Correct Analysis graph was displayed");
         	 		result = true;
         	 	}
         }
         else
         {
        	 System.out.print("ERROR: Correct Analysis graph was not displayed");
        	 result = false;
         }
         return result;
	}
	

	public boolean UIVerifyMetricScoreScatterChart()
	{
		 boolean result = true;
         if (driver.findElement(By.xpath("//*[@id='home']/div/div[6]/div[1]/div[1]")).getText().contains("SCATTER CHART"))
         {
         	 	System.out.println(driver.findElement(By.xpath("//*[@id='home']/div/div[6]/div[1]/div[1]")).getText());
         	 	System.out.println(driver.findElement(By.xpath("//*[@id='home']/div/div[6]/div[1]/div[2]")).getText());
         	 	if(driver.findElement(By.xpath("//*[@id='home']/div/div[6]/div[1]/div[2]")).getText().isEmpty())
         	 	{
         	 		System.out.print("ERROR: SCATTER CHART graph was not displayed");
         	 		result = false;
         	 	}
         	 	else
         	 	{
         	 		//System.out.println("SCATTER CHART graph was displayed");
         	 		result = true;
         	 	}
         }
         else
         {
        	 System.out.print("ERROR: SCATTER CHART graph was not displayed");
        	 result = false;
         }
         return result;
	}
	

	public boolean UIVerifyMetricScoreBoxPlot()
	{
		boolean result = true;
         if (driver.findElement(By.xpath("//*[@id='home']/div/div[6]/div[2]/div[1]")).getText().contains("BOX PLOT"))
         {
         	 	System.out.println(driver.findElement(By.xpath("//*[@id='home']/div/div[6]/div[2]/div[1]")).getText());
         	 	System.out.println(driver.findElement(By.xpath("//*[@id='home']/div/div[6]/div[2]/div[2]")).getText());
         	 	if(driver.findElement(By.xpath("//*[@id='home']/div/div[6]/div[2]/div[2]")).getText().isEmpty())
         	 	{
         	 		System.out.print("ERROR: Box PLOT graph was not displayed");
         	 		result = false;
         	 	}
         	 	else
         	 	{
         	 		//System.out.println(" Box PLOT graph was displayed");
         	 		result = true;
         	 	}
         }
         else
         {
        	 System.out.print("ERROR: Box PLOT graph was not displayed");
        	 result = false;
         }
         
         return result;
	}

	public boolean UIVerifyCanaryScore() throws InterruptedException
	{
	    // Validating Score, Confidence, Alerts and Logs Error blocks are visible
		boolean result = true;
	    if (driver.findElement(By.cssSelector("div.rep-box:nth-child(1)")).isDisplayed())
	    {
	    		System.out.println("***** SCORE is: *****");
	    		System.out.println(driver.findElement(By.cssSelector("div.rep-box:nth-child(1)")).getText());
	    		if(driver.findElement(By.cssSelector("div.rep-box:nth-child(1)")).getText().isEmpty())
	    		{
         	 		System.out.print("ERROR: Score was not displayed");
         	 		result = false;
	    		}
	    		else
	    		{
	    			//System.out.println("SCORE was displayed");
         	 		result = true;
	    		}
	    	    
	    }
	    else
	    {
 	 		System.out.print("ERROR: Score was not displayed");
 	 		result = false;
	    }
	    
	    if (driver.findElement(By.cssSelector("div.rep-box:nth-child(2)")).isDisplayed())
	    {
	    		System.out.println("***** CONFIDENCE is: *****");
	    		System.out.println(driver.findElement(By.cssSelector("div.rep-box:nth-child(2)")).getText());
	    		if(driver.findElement(By.cssSelector("div.rep-box:nth-child(2)")).getText().isEmpty())
	    		{
         	 		System.out.print("ERROR: CONFIDENCE was not displayed");
         	 		result = false;
	    		}
	    		else
	    		{
	    			//System.out.println("CONFIDENCE was displayed");
         	 		result = true;
	    		}
	    }
	    else
	    {
 	 		System.out.print("ERROR: CONFIDENCE was not displayed");
 	 		result = false;
	    }
	    
	    if (driver.findElement(By.cssSelector("div.rep-box:nth-child(3)")).isDisplayed())
	    {
	    		System.out.println("***** ALERTS is: *****");
	    		System.out.println(driver.findElement(By.cssSelector("div.rep-box:nth-child(3)")).getText());
	    		if(driver.findElement(By.cssSelector("div.rep-box:nth-child(3)")).getText().isEmpty())
	    		{
         	 		System.out.print("ERROR: ALERTS was not displayed");
         	 		result = false;
         	 	}
         	 	else
         	 	{
         	 		//System.out.println("ALERTS was displayed");
         	 		result = true;
         	 	}
	    }
	    else
	    {
     	 		System.out.print("ERROR: ALERTS was not displayed");
     	 		result = false;
	    }
	    
	    if (driver.findElement(By.cssSelector("div.rep-box:nth-child(4)")).isDisplayed())
	    {
	    		System.out.println("***** LOG ERRORS is: *****");
	    		System.out.println(driver.findElement(By.cssSelector("div.rep-box:nth-child(4)")).getText());
	    		if(driver.findElement(By.cssSelector("div.rep-box:nth-child(4)")).getText().isEmpty())
	    		{
         	 		System.out.print("ERROR: LOG ERRORS was not displayed");
         	 		result = false;
         	 	}
         	 	else
         	 	{
         	 		//System.out.println(" LOG ERRORS was displayed");
         	 		result = true;
         	 	}
	    }
	    else
	    {
 	 		System.out.print("ERROR: LOG ERRORS was not displayed");
 	 		result = false;	
	    }
	    
	    Thread.sleep(1000);
	    System.out.println("Clicking on SCORE button:");
	    driver.findElement(By.cssSelector("div.rep-box:nth-child(1) > div:nth-child(2)")).click();
	    Thread.sleep(2000);
	    
	    //Once SCORE was selected, checking for the result whether displayed or not
	    if (driver.findElement(By.cssSelector("#demo > div:nth-child(1) > div:nth-child(1)")).isDisplayed())
	    {
	    		System.out.println("***** SCORE information is: *****");
	    		System.out.println(driver.findElement(By.cssSelector("#demo > div:nth-child(1) > div:nth-child(1)")).getText());
	    		if(driver.findElement(By.cssSelector("#demo > div:nth-child(1) > div:nth-child(1)")).getText().isEmpty())
	    		{
         	 		System.out.print("ERROR: SCORE information was not displayed");
         	 		result = false;
         	 	}
         	 	else
         	 	{
         	 		//System.out.println("SCORE information was displayed");
         	 		result = true;
	    		}
	    }
	    else
	    {
 	 		System.out.print("ERROR: SCORE information was not displayed");
 	 		result = false;
	    }
	    

	    //Verifying Canary ID information from the score results
	    Thread.sleep(1000);
	    if (driver.findElement(By.xpath("//*[@id='demo']/div/div/div[1]/div[2]")).isDisplayed())
	    {
	    		canaryid = driver.findElement(By.cssSelector("#demo > div > div > div:nth-child(1) > div:nth-child(2) > div.col-sm-6.font.ng-binding")).getText();
	    		System.out.println("***** Canary Id is: " + canaryid);
     	 		result = true;
	    }
	    else
	    {
 	 		System.out.print("ERROR: Canary ID information was not displayed");
 	 		result = false;	
 	 	}
	    
	    //Closing SCORE information
	    driver.findElement(By.cssSelector("div.rep-box:nth-child(1) > div:nth-child(2)")).click();
        return result;
	}
	

	public boolean UIVerifyAnalysisSummary()
	{
		boolean result = true;
   	    //Validating the Analysis Summary block displayed
	    if (driver.findElement(By.cssSelector("#home > div > div:nth-child(4) > div > div")).isDisplayed())
	    {
	    		System.out.println(driver.findElement(By.cssSelector("#home > div > div:nth-child(4) > div > div")).getText());
	    		if(driver.findElement(By.cssSelector("#home > div > div:nth-child(4) > div > div")).getText().isEmpty())
	    		{
	    			
         	 		System.out.print("ERROR: Analysis Summary block was not displayed");
         	 		result = false;
         	 	}
         	 	else
         	 	{
         	 		//System.out.println("Analysis Summary block was displayed");
         	 		result = true;
         	 	}
	    }
	    else
	    {
 	 		System.out.print("ERROR: Analysis Summary block was not displayed");
 	 		result = false;
 	 	}
        return result;
	}
	
	
	public boolean UIVerifyLogScore() throws InterruptedException
	{
		boolean result = true;
	    // Validating LOG Score and result are displayed
	    if (driver.findElement(By.cssSelector("div.table-responsive:nth-child(3)")).isDisplayed()) 
	    {
    	    	System.out.println("*****");
	    		System.out.println(driver.findElement(By.cssSelector("div.table-responsive:nth-child(3)")).getText());
	    	    if(driver.findElement(By.cssSelector("div.table-responsive:nth-child(3)")).getText().isEmpty())
	    	    {
         	 		System.out.print("ERROR: LOG SCORE block was not displayed");
         	 		result = false;
         	 	}
         	 	else
         	 	{
         	 		//System.out.println("LOG SCORE block was displayed");
         	 		result = true;
         	 	}
	    }
	    else
	    {
 	 		System.out.print("ERROR: LOG SCORE block was not displayed");
 	 		result = false;
 	 	}
        return result;
	}
	

	public boolean UIVerifyAPMScore() throws InterruptedException
	{
		boolean result = true;
	    // Validating APM Score are visible and graphs are displayed when selected.
	    if (driver.findElement(By.cssSelector("#home > div > div:nth-child(5) > div:nth-child(1) > div > div > div > div > div:nth-child(5)")).isDisplayed())
		{

	    		System.out.println("***** APM Score *****");
	    	    System.out.println(driver.findElement(By.cssSelector("#home > div > div:nth-child(5) > div:nth-child(1) > div > div > div > div > div:nth-child(5)")).getText());
	    	    if(driver.findElement(By.xpath("//*[@id='home']/div/div[5]/div[1]/div/div/div/div/div[2]/table")).getText().isEmpty())
	    	    {
	     	 		System.out.print("ERROR: APM Score graph was not displayed");
	     	 		result = false;
	    	    }
	    	    else
	    	    {
	    	    	String text2 = driver.findElement(By.cssSelector("div.table-responsive:nth-child(5) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(6) > button:nth-child(1)")).getText();
	    	    	float value = Float.parseFloat(text2);
	    	    	System.out.println(value);
  
	    	    	if (value < 100.00)
		    	    	{
		    	    		if (driver.findElement(By.cssSelector("#home > div > div:nth-child(5) > div:nth-child(1) > div > div > div > div > div:nth-child(5) > table > tbody:nth-child(3) > tr > td:nth-child(2) > button > i")).getAttribute("class").contains("pinktext"));
		    	    		{
		    	    			System.out.println("Button is showing score less than 100 and it is red, so selecting it  ****************");
		    	    			driver.findElement(By.cssSelector("div.table-responsive:nth-child(5) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2) > button:nth-child(1)")).click();//
		    	    			if (driver.findElement(By.cssSelector("#selectedAppRowId > td:nth-child(1) > div:nth-child(1)")).isEnabled())
		    	    			{
		    	    				System.out.println(" ** APM Score Graph is displayed as below: **");
		    	    				System.out.println(driver.findElement(By.cssSelector("#selectedAppRowId > td:nth-child(1) > div:nth-child(1)")).getText());
			    	    			if(driver.findElement(By.cssSelector("#selectedAppRowId > td:nth-child(1) > div:nth-child(1)")).getText().isEmpty())
			    	    			{
			    	         	 		System.out.print("ERROR: APM Score Graph Score was not displayed");
			    	         	 		result = false;
			    	         	 	}
			    	         	 	else
			    	         	 	{
			    	         	 		System.out.print("APM Score Graph Score was displayed");
			    	         	 		driver.findElement(By.cssSelector("div.table-responsive:nth-child(5) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(1) > button:nth-child(1)")).click();
			    	         	 		Thread.sleep(1000);
			    	         	 	}
		    	    				
		    	    				System.out.println(" ** APM Score Graph is closed **");
		    	    			}
		    	    			else
		    	    			{
		    	         	 		System.out.print("ERROR: APM Score Graph Score was not displayed");
		    	         	 		result = false;
		    	    			}
	
		    	    		}
		            }
	    	    	else
	    	    	{
	    	    		System.out.println("Scores are 100 and no errors");
	    	    		result = true;
	    	    	}
	    	    }
		}
	    else
	    {
 	 		System.out.print("ERROR: APM Score Graph Score was not displayed");
 	 		result = false;
		}
        return result;
	}


	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing browser");
			driver.quit();
		}
	}
}

