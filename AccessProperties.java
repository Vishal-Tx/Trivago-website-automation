package utilities;

import java.util.Properties;

public class AccessProperties {

static Properties prop=ReadPropertiesFile.readPropertiesFile();
    
	public static  String getUrl()
	{
			return prop.getProperty("url");
	}
	public static String getChromeProperty()
	{
			return prop.getProperty("chrome");
	}
	public static String getFirefoxProperty()
	{
			return prop.getProperty("firefox");
	}
	public static String getEdgeProperty()
	{
			return prop.getProperty("edge");
	}

}
