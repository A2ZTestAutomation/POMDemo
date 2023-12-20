package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase_old {

	public static WebDriver driver;
	public static Properties prop;
	public TestBase_old() {
		prop = new Properties();
		String path = System.getProperty("user.dir") 
				+ "//src//test//resources//configFiles//config.properties";
		FileInputStream fin;
		 try {
			fin = new FileInputStream(path);
			prop.load(fin);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void initialize() {
		String strBrowser = prop.getProperty("browser");
		//Singleton Pattern
		if(driver==null) {
			if(strBrowser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}
			else if(strBrowser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}
}
