package pages;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.google.common.collect.Ordering;
import utilities.CaptureScreenshot;

public class findhotel {
	List<Double> ratingsList = new ArrayList<Double>();  //For storing all hotel ratings
	public void Search_City(WebDriver driver) throws InterruptedException
	{
		WebElement searchBox = driver.findElement(By.id("querytext"));
		searchBox.sendKeys("Mumbai");
		Thread.sleep(2000);
	}
	private static String GetDateAfter(int noOfDays)
	{
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd"); 
		
		//To fetch the current date using calendar class
		Calendar c = Calendar.getInstance(); 
		
		//To add noOfdays to current date 
		c.add(Calendar.DATE, noOfDays);	
		
		//returns the date format with n noOfdays from current date 
		return date.format(c.getTime());   
		
	}
	public void Check_IN_OUT(WebDriver driver)
	{
		try
		{
			WebElement dateObj = driver.findElement(By.xpath("//span[text()=\"Check in\"]"));
			dateObj.click();
			
			//by using GetDateAfter it written a genetic method to fetch date after n noOfDays from current date
			//we wanted to select check-in-date after one week from current date so we are passing noOfdays as 7
			String checkInDateStr = GetDateAfter(7);
			
			//we are booking only for one day so check-out-date is after 8 days from current date
			String checkOutDateStr = GetDateAfter(8);
			
			//There are two cal-month classes. One for check-in and another for check-out
			List<WebElement> cal = driver.findElements(By.className("cal-month")); 
			
			WebElement checkInDate =cal.get(0).findElement(By.xpath("//td//time[@datetime='"+checkInDateStr+"']"));
			//Select the check-in-date and click it
			checkInDate.click();		
			WebElement checkOutDate =cal.get(1).findElement(By.xpath("//td//time[@datetime='"+checkOutDateStr+"']"));
			//Select the check-in-date and click it
			checkOutDate.click();
		}
		catch(Exception e)
		{
			System.out.println("Received exception in method Check_IN_OUT"+ e);
		}
	}
	public void NoOfPersons(WebDriver driver) throws IOException, InterruptedException
	{
		//Change adults and rooms to 1
		WebElement noOfAdults = driver.findElement(By.id("adults-input"));
		//Keys.chord(Keys.CONTROL, "a") this is used to override the value, if we directly use sendKeys then it appends to the exist value
		// Suppose room already 1 and if we use only sendKeys(1) the input will be come 11 so that is why we use chord to override the value
		noOfAdults.sendKeys(Keys.chord(Keys.CONTROL, "a"), "1");
		WebElement noOfRooms = driver.findElement(By.id("rooms-input"));
		noOfRooms.sendKeys(Keys.chord(Keys.CONTROL, "a"), "1");
		
		//Clicking on the apply button we need to get the footer class and click on apply button
		WebElement el = driver.findElement(By.className("guest-selector__footer"));
		el.findElement(By.xpath("//button[@data-role='applyConfigBtn']")).click();
	}
				
	public void Search(WebDriver driver) throws IOException
	{
		//Finally click on search button
		driver.findElement(By.className("search-button__label")).click();
	}
	public void SortByRating(WebDriver driver) throws InterruptedException, IOException
	{
		//Sort by Rating only
		WebElement sortbydrop= driver.findElement(By.id("mf-select-sortby"));
		Select sort = new Select(sortbydrop);
		sort.selectByIndex(4);
	}
	public void GetHotels(WebDriver driver) throws InterruptedException, IOException
	{
		try
		{
			int k=1;
			boolean hasNextPage = true;
			do
			{
				
				Thread.sleep(5000);
				
				//Capturing the Screenshot 
				//To access the capture screenshot method
				CaptureScreenshot.takeScreenshot(driver, "HotelPage" +k++);
				
				//Get the list of hotel name,price and rating displayed in the page
				List<WebElement> listOfHotels = driver.findElements(By.xpath("//span[@data-qa='item-name']"));  
				List<WebElement> prices = driver.findElements(By.xpath("//strong[@data-qa='recommended-price']"));
				List<WebElement> listOfRatings = driver.findElements(By.xpath("//span[@itemprop='ratingValue']"));
				
				//Iterate through all the hotels and print the details
				for(int i=0;i<listOfHotels.size();i++) 
				{
					String hotelName = listOfHotels.get(i).getText();
					String price = prices.get(i).getText().substring(1);
					double hotelRating = Double.parseDouble(listOfRatings.get(i).getText());
					System.out.println("Hotel Name: "+hotelName);
					System.out.println("Price: "+price);
					ratingsList.add(hotelRating);
				}
				//This is to check if the next button exist in the page, click only if exists otherwise terminate as we reach the end of the pages
				if(!driver.findElements(By.xpath("//button[contains(@class, 'btn--next')]")).isEmpty())
				{
					WebElement el = driver.findElement(By.xpath("//button[contains(@class, 'btn--next')]"));
					el.click();
					
				}
				else
					hasNextPage = false;
				
				
			}while(hasNextPage);
		}
		catch(Exception e)
		{
			System.out.println("Received exception in method GetHotels"+ e);
		}
	}
	

	public void IsDesending(WebDriver driver) throws InterruptedException
	{
		try
		{
			boolean sorted = Ordering.natural().isOrdered(ratingsList);
			if(sorted)
			{
				System.out.println("Rating is in descending order");
				System.out.println("Test case passed");
			}
			//this is used to check if the elements in a rating list are ordered by descending or not
			else       
			{
				System.out.println("Rating is not in descending order");
				System.out.println("Test case failed");
			}
		}
		catch(Exception e)
		{
			System.out.println("Received exception in method Is Desending"+ e);
		}
	}
	public void close(WebDriver driver)
	{
		//close the browser
		driver.close();
	}
}

		