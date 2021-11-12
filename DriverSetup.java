package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class DriverSetup {
	
		

		private static WebDriver driver;

		 public  WebDriver getWebDriver(int browserChoice) {
			
			
			if(browserChoice==1) {
				launchChromeBrowser();
			}else if(browserChoice==2) { 
				launchFireFoxBrowser();
			}else {
				launchEdgeBrowser();
			}
			return driver;
		 }

		//To Launch Chrome Browser
		private static void launchChromeBrowser() {
			// TODO Auto-generated method stub
			String chromeDriverPath=System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver=new ChromeDriver();
			
		}
		//To Launch FireFox Browser
			 private static void launchFireFoxBrowser() {
				// TODO Auto-generated method stub
				
				String firefoxDriverPath=System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
				driver=new FirefoxDriver();
			}


		//To launch Edge Browser
		private static void launchEdgeBrowser() {
			// TODO Auto-generated method stub
			String edgeDriverPath = System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe";
			System.setProperty("webdriver.edge.driver", edgeDriverPath);
			driver = new EdgeDriver();
		}

		//To Close the Driver
		public void closeDriver(WebDriver driver) {
			// TODO Auto-generated method stub
			driver.close();
		}



		}

			

