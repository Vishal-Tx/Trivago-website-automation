package testcases;


	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.PrintStream;
	import java.util.Scanner;
	import org.openqa.selenium.WebDriver;
	import pages.findhotel;
	import utilities.AccessProperties;
	import utilities.DriverSetup;
	public class findhoteltest {

		public static void main(String[] args) throws InterruptedException, IOException {
			// TODO Auto-generated method stub
			
			@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			int browserChoice;
			String url=AccessProperties.getUrl();
		    DriverSetup d=new DriverSetup();
		   
		    //Select the browser
		    System.out.println("Select any one of the browser from below\n 1:Chrome 2:Firefox 3:edge"); 
			System.out.println("Enter your choice:");
			browserChoice=sc.nextInt();
			
			System.out.println("All the Logs are redirected to output.txt");
			//To Save the console Log Into file
			System.setOut(new PrintStream(new FileOutputStream("Resources//output.txt")));
		    WebDriver driver=d.getWebDriver(browserChoice);
			driver.get(url);
			driver.manage().window().maximize();
			//To access the methods from the FindHotelAvailability Class
			findhotel obj = new findhotel();  
				obj.Search_City(driver);
							
				obj.Check_IN_OUT(driver);
							
				obj.NoOfPersons(driver);
						
				obj.Search(driver);
				
				obj.SortByRating(driver);
				
				obj.GetHotels(driver);
					
				obj.IsDesending(driver);
			
				obj.close(driver);

			
		}
	}


