package botpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Compte2 {
	private String server = "http://ts2.travian.fr/";
//	private String server = "http://tx3.travian.fr/";
	private String userName = "Bing";
	private String passWord = "jjjjjjj";
	//private WebDriver driver = new FirefoxDriver();
	//private String server = "http://ts4.travian.fr/";
//	private String userName = "Bing";
	//private String passWord = "jjjjj";
	private WebDriver driver;
	
	public String getServer() {
		return server;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public  WebDriver getDriver() {
		return driver;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public  void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public Compte2() {
		super();
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium2.45\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
}
