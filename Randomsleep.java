package botpackage;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
public class Randomsleep  {
	
	
//	WebDriver driver;
//	WebDriverWait wait = new WebDriverWait(driver,120);
	
	
	
	//heure /date
	private void date() {
	Date maDate = new Date(); 
	//affichage: 
	System.out.println(maDate.toString()); 
	}
	
	
	
	//classic
	private static final int MIN_VALUE1 = 2000;
	private static final int MAX_VALUE1 = 10000;
	public void classic() 
    {
        Random random = new Random();
        int myRandomNumber = random.nextInt(MAX_VALUE1 - MIN_VALUE1) + MIN_VALUE1;
        System.out.println("[Attente :" + myRandomNumber+"]");
      try {  Thread.sleep(myRandomNumber);} catch (Exception e){e.printStackTrace();}
    }
    
	//trescourt
	
	private static final int MIN_VALUE5 = 600;
	private static final int MAX_VALUE5 = 814;
    public void tcourt()
    {
        Random random = new Random();
        int myRandomNumber = random.nextInt(MAX_VALUE5 - MIN_VALUE5) + MIN_VALUE5;
        System.out.println("[Attente : " + myRandomNumber+ "]");
        try {  Thread.sleep(myRandomNumber);} catch (Exception e){e.printStackTrace();}
    }
	
	//court
	private static final int MIN_VALUE2 = 1000;
	private static final int MAX_VALUE2 = 3000;
    public boolean court()
    {
    	//wait.until(ExpectedConditions.elementToBeClickable(By.className("button-content")));
        Random random = new Random();
        int myRandomNumber = random.nextInt(MAX_VALUE2 - MIN_VALUE2) + MIN_VALUE2;
        System.out.println("[Attente : " + myRandomNumber+"]");
        
        try {  Thread.sleep(myRandomNumber);} catch (InterruptedException e){System.out.println("Pause annulee");return true;}
		return false;
    }
    
    
    
    //lent
	private static final int MIN_VALUE3 = 60000*4;
	private static final int MAX_VALUE3 = 60000*11;
    public void lent() 
    {
        Random random = new Random();
        int myRandomNumber = random.nextInt(MAX_VALUE3 - MIN_VALUE3) + MIN_VALUE3;
        date();
        System.out.println("Attente de : " + myRandomNumber/1000/60 +"minutes " + (myRandomNumber/1000-(myRandomNumber/1000/60)*60) + "sec. et le chiffre de base en milliseconde " +myRandomNumber);
        try {  Thread.sleep(myRandomNumber);} catch (Exception e){e.printStackTrace();}
    }
    
    
    
  //treslent
	private static final int MIN_VALUE4 = 1500000;
	private static final int MAX_VALUE4 = 3000000;
    public void treslent() 
    {
        Random random = new Random();
        int myRandomNumber = random.nextInt(MAX_VALUE4 - MIN_VALUE4) + MIN_VALUE4;
        date();
        System.out.println("Attente :" + myRandomNumber/1000/60 +"minutes " + (myRandomNumber/1000-(myRandomNumber/1000/60)*60) + "sec. et le chiffre de base en milliseconde " +myRandomNumber);
        try {  Thread.sleep(myRandomNumber);} catch (Exception e){e.printStackTrace();}
    }
    
    //Special
	//classic
	private static final int MIN_VALUE6 = 6000;
	private static final int MAX_VALUE6 = 10000;
	public void specialclassic() 
    {
        Random random = new Random();
        int myRandomNumber = random.nextInt(MAX_VALUE1 - MIN_VALUE1) + MIN_VALUE1;
        System.out.println("[Attente :" + myRandomNumber+"]");
      try {  Thread.sleep(myRandomNumber);} catch (Exception e){e.printStackTrace();}
    }
    


////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////



}
