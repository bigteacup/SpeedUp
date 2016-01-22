package botpackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


class Account {
	
public String serverURL = "http://ts2.travian.fr/";	
public String login = "Bing";
public String password = "go25hk6t";


public static WebDriver driver =new FirefoxDriver() ;
	
public String pillageVillage = "";
public String pillage = "";
public String ListName = "";
}