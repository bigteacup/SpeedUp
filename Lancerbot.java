package botpackage;
import java.*;
import java.awt.AWTException;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




	public class Lancerbot extends Thread  {
		
		private static Randomsleep randomsleep = new Randomsleep();
		public static boolean actif = true;
		static WebDriver driver;
		static Attaque attaque = new Attaque();
		static ArrayList<Attaque> listeAttaques = new ArrayList<Attaque>();
	Travian travian;
	Fenetre tfenetre;
	Lancerbot bot; 

		
		public void lancerbot(Lancerbot bot) {
			this.bot = bot;
			tfenetre = new Fenetre(bot);
			
		}


	public static void main(String[] args) throws AWTException, IOException  { 
		Lancerbot botStart = new Lancerbot();
		botStart.lancerbot(botStart);
					
				}
				
				
				
				
				
				
				
		
		
	
public static void arreter(){
	actif = false;
	
}

public WebDriver setDriver(WebDriver driver) {
	driver = this.driver;
	return driver;
	
	
}





public void lancerTravian(){
	travian = new Travian(bot);
	travian.allume = true;
	System.out.println(travian.getName());
    System.out.println(travian.getState());
	if (!travian.isAlive()){
		travian.start();
		System.out.println(travian.getName());
	    System.out.println(travian.getState());
		
	}/*else {travian= new Travian();
	travian.start();
	System.out.println(travian.getName());
    System.out.println(travian.getState());
}*/
	
	
}

public void reprendreTravian(){
		System.out.println(travian.getName());
    System.out.println(travian.getState());
	
		travian.resume();
		System.out.println(travian.getName());
	    System.out.println(travian.getState());
		
	}
	


public void eteindreTravian(){
	if (travian.isAlive()){
	//	travian.stop();
		travian.allume = false;
		
		System.out.println("********* Arret Demande ************ Arret Demande ************** Arret Demande *************");
		//travian.notify();
		
		//travian.stop();
		//try {travian.getCompte().getDriver().close();}catch (Exception e) {}
	//	try {travian.getCompte().getDriver().quit();}catch (Exception e) {}

	//System.out.println(travian.getName());
    //System.out.println(travian.getState());
	 

    
    
/*	// Attente de la fin du thread
	try {
		travian.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//travian.getThreadGroup().destroy();*/
    }
		

	

	
}


public void attaque(){
	try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}
	 travian.suspend();

	Verifierdate verifDate = new Verifierdate(travian, attaque, listeAttaques);
verifDate.start();

System.out.println(verifDate.getName());
System.out.println(verifDate.getState());


//	randomsleep.court();
try {	
Attaque attaque1 = new Attaque(travian,verifDate);
attaque1.start();
listeAttaques.add(attaque1);
 //try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}

		 	randomsleep.court();
Attaque attaque2 = new Attaque(travian,verifDate);
attaque2.start();
listeAttaques.add(attaque2);
// try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}

randomsleep.court();
Attaque attaque3 = new Attaque(travian,verifDate);
attaque3.start();
listeAttaques.add(attaque3);
// try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}


randomsleep.court();
Attaque attaque4 = new Attaque(travian,verifDate);
attaque4.start();
listeAttaques.add(attaque4);
// try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}

Attaque attaque5 = new Attaque(travian,verifDate);
attaque5.start();
listeAttaques.add(attaque5);
 //try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}

randomsleep.court();
Attaque attaque6 = new Attaque(travian,verifDate);
attaque6.start();
listeAttaques.add(attaque6);
// try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}

randomsleep.court();
Attaque attaque7 = new Attaque(travian,verifDate);
attaque7.start();
listeAttaques.add(attaque7);
// try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}
 

randomsleep.court();
Attaque attaque8 = new Attaque(travian,verifDate);
attaque8.start();
listeAttaques.add(attaque8);
// try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}
}catch (Exception e){}

//	randomsleep.court();

//	for(Attaque attaque : listeAttaques){
	//	attaque.bouttons.get(0).submit();
	
//	}
	
	
}

















public static void copyFullRecursive(File source, File dest) throws IOException
{
    if (source.isDirectory())
    {
        File dir = new File(dest, source.getName());
        dir.mkdir();
        
        File[] list = source.listFiles();
        if (list != null)
            for (File fic : list)
                copyFullRecursive(fic, dir);
    }
    else
    {
        Files.copy(source.toPath(), new File(dest, source.getName()).toPath());
    }
}

	/** copie le fichier source dans le fichier resultat
	 * retourne vrai si cela réussit
	 */
	public static boolean copyFile(File source, File dest){
		try{
			// Declaration et ouverture des flux
			java.io.FileInputStream sourceFile = new java.io.FileInputStream(source);
	 
			try{
				java.io.FileOutputStream destinationFile = null;
	 
				try{
					destinationFile = new FileOutputStream(dest);
	 
					// Lecture par segment de 0.5Mo 
					byte buffer[] = new byte[512 * 1024];
					int nbLecture;
	 
					while ((nbLecture = sourceFile.read(buffer)) != -1){
						destinationFile.write(buffer, 0, nbLecture);
					}
				} finally {
					destinationFile.close();
				}
			} finally {
				sourceFile.close();
			}
		} catch (IOException e){
			e.printStackTrace();
			return false; // Erreur
		}
	 
		return true; // Résultat OK  
	
}


	}
	