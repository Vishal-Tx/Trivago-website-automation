package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
	public  static Properties readPropertiesFile() 
	{
		
        FileInputStream fis = null;
        try 
        {
        	String filePath=System.getProperty("user.dir")+"\\Resources\\Config.properties";
            fis = new FileInputStream(filePath);
        }
        catch (FileNotFoundException e1) 
        {
             e1.printStackTrace();
        }
        Properties prop = new Properties();
        try 
        {
            prop.load(fis);
        } 
        catch (IOException e)
        {
           
            e.printStackTrace();
        }
        return prop;
	}

	
	
}
