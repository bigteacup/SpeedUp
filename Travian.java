package botpackage;
import java.*;
import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

import org.apache.commons.collections.MapIterator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;

import com.thoughtworks.selenium.webdriven.commands.GetText;

public class Travian extends Thread {
	Travian t = this;
	private Compte compte;
//	private Compte2 compte;
	//private Palier palier;
	//private int StrategieConstruction strategieConstruction; 
	private ArrayList<Village> listeDeVillages = new ArrayList();
	Randomsleep randomsleep = new Randomsleep();
	private Marche marche = new Marche();
	
	int compteurDeBoot = 1;
	int echecDeBoot;
	List<WebElement> donneesGlobales;
	List<WebElement> donneesRessources;
	List<WebElement> donneesRessourcesPourcentage;
	List<WebElement> donneesPointsDeCulture;
	int numeroDePhoto = 0;

	//TeamplatesDeVillages template = new TeamplatesDeVillages();
	public boolean allume = false;
	//public boolean pillage = true;
	//public boolean fete = true;
	Lancerbot bot;	
	private  AtomicReference<Thread> currentThread = new AtomicReference<Thread>();
/*	@Override
	public boolean isInterrupted() {
		return super.isInterrupted();
	}	
	*/
	
	private WebDriver driver;
	
	Hero hero = new Hero();
	
	
	public Travian(Lancerbot bot, String serveur, String nomDeCompte, String motDePasse) {
		super();
		this.bot = bot;
		System.setProperty("webdriver.chrome.driver", "\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		compte = new Compte(driver);
		compte.setServer(serveur);
		compte.setUserName(nomDeCompte);
		compte.setPassWord(motDePasse);
		

		
		
	}
	
	public void run() {
		while (allume) {
					principale();
			System.out.println("dans le while");
		}
		System.out.println("sortie du run");
		try {t.getCompte().getDriver().close();}catch (Exception e) {}
		try {t.getCompte().getDriver().quit();}catch (Exception e) {}

		System.out.println(t.getName());
	    System.out.println(t.getState());
	    System.out.println("********* Bot eteind ************");
	}
	
	
	public void arreter(){
		Thread.currentThread().interrupt();
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public WebDriver driverEnCour() {
		WebDriver driverEnCour = compte.getDriver() ;
		return driverEnCour;
		
	}
	public Compte getCompte() {
		return compte;
		
	}
	public ArrayList<Village> getListeDeVillages(){
		return listeDeVillages;
		
		
	}

	private void principale()  {
		////pour PROFIL CHROME
	//	System.setProperty("webdriver.chrome.driver", "\\chromedriver.exe");
	//	ChromeOptions options = new ChromeOptions();
	//	options.addArguments("user-data-dir=/ProfilChromePourBot/MasterProfile");
		//C:/Users/timseven/AppData/Local/Google/Chrome/User Data/
		
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium2.45\\chrome\\chromedriver.exe");
		//		driver = new ChromeDriver();//new ChromeDriver();


		if (allume){
		try {
		boot();
		} catch (Exception e) {
			System.out.println("Echec boot");
			echecDeBoot++;
			restartSurErreure();
		}
		
		while (allume) {
			
		try {
			eviterSurvey();
		}catch (Exception e) {System.out.println("Echec eviterSurvey");
		}
		randomsleep.court();
		if (allume == false){break;}
		
		try {
				listerVillages();
			} catch (Exception e) {
				System.out.println("Echec listerVillages");
				echecDeBoot++;
				restartSurErreure();
				
		}
		if (allume == false){break;}
		randomsleep.court();
		try {
			majVillagesPlus();
			} catch (Exception e) {System.out.println("Echec MajVillagePlus et NPC");
			}
	
			randomsleep.court();
			if (allume == false){break;}
			
			//t.fonderVillage();
	/*	
			
		//	t.construireBatiments();
	
			
		*/		
			try {
				
				rotationVillage();			
				} catch (Exception e) {System.out.println("Echec rotation");
				echecDeBoot++;
				restartSurErreure();
				}
				randomsleep.court();
				if (allume == false){break;}
				
			try {
				aventureHero();			
				} catch (Exception e) {System.out.println("Echec gestionHero2");
				}
				randomsleep.court();
				if (allume == false){break;}
				
				
				
		//	try {
		//		t.cadeaux();
		//		} catch (Exception e) {System.out.println("Echec cadeaux");}
				
				
				
				if (allume == false){break;}
				
				// Incrementation des compteurs apres un tour reussi
				compteurDeBoot++;
				echecDeBoot = 0;
				
				// Reglage de l'attente entre deux boucles
		//	randomsleep.lent();	
				
			randomsleep.treslent();
		//	randomsleep.court();
			
			System.out.println("******************************************************************************************************");
			System.out.println("**********REBOOT*******************REBOOT*******************REBOOT************************************");
			System.out.println("******************************************************************************************************");
			if (allume == false){break;}
			try {
				boot();
				System.out.println("Reboot : " + compteurDeBoot);
			} catch (Exception e) {System.out.println("Echec Reboot : " + compteurDeBoot);
			echecDeBoot++;
			restartSurErreure();}

			// t.clearListes();
		}
		
		}
	}
	
	public Set<Cookie> getCookies() {
		
		Set<Cookie> cookies=null;
		try
		{
		cookies=driver.manage().getCookies();
		}
		catch(Throwable e)
		{
		System.err.println("Error While getting Cookies: "+ e.getMessage());}
		return cookies;
	}

	
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void boot() {
		// compte.getDriver().get(compte.getServer());
		// Open
		compte.getDriver().get(compte.getServer()+"dorf1.php");
		randomsleep.court();
		try {
			// Name
			compte.getDriver().findElement(By.name("name")).clear();
			compte.getDriver().findElement(By.name("name")).sendKeys(compte.getUserName());
			randomsleep.court();
			// Pass
			compte.getDriver().findElement(By.name("password")).clear();
			compte.getDriver().findElement(By.name("password")).sendKeys(compte.getPassWord());
			randomsleep.court();
			// Clic
			compte.getDriver().findElement(By.name("s1")).click();
			randomsleep.court();
			
		} catch (Exception e) {
			System.out.println("deja connecte");
			
		}
		
	}
	public void bootDriver(WebDriver driver) {
		// compte.getDriver().get(compte.getServer());
		// Open
		
		
		driver.get(compte.getServer()+"dorf1.php");
		randomsleep.court();
		try {
			// Name
			driver.findElement(By.name("name")).clear();
			driver.findElement(By.name("name")).sendKeys(compte.getUserName());
			randomsleep.court();
			// Pass
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(compte.getPassWord());
			randomsleep.court();
			// Clic
			driver.findElement(By.name("s1")).click();
			randomsleep.court();
			
		} catch (Exception e) {
			System.out.println("deja connecte");
			
		}
	}
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	private void restartSurErreure() {
		prendrePhoto("restartSurErreure");
				
		randomsleep.court();
		
		
		try {
		compte.getDriver().close();
		compte.getDriver().quit();
		
		System.out.println("**************************************************************************");
		System.out.println("***************   BUG erreur 404 : REDEMARRAGE   *************************");
		System.out.println("**************  (Ou un boulet joue en meme temps que le bot) *************");
		System.out.println("**************************************************************************");
		
			if(echecDeBoot <= 4){
			randomsleep.lent();}
			else {System.out.println("Ca merde trop --> Attente longue");randomsleep.treslent();}
			//Travian2.main.t.quit();

		System.out.println("Reboot : " + compteurDeBoot);
			//boot();
			//compte.setDriver(new ChromeDriver());
			principale();
			
			
		}catch (Exception e) {
			
			System.out.println("**************************************************************************");
			System.out.println("***************   BUG navigateur ferme ! : REDEMARRAGE   *****************");
			System.out.println("**************************************************************************");
			
			if(echecDeBoot <= 4){
			randomsleep.court();}
			else {System.out.println("Ca merde trop --> Attente courte");randomsleep.court();}
			//Travian2.main.t.quit();

		System.out.println("Reboot : " + compteurDeBoot);
			//boot();
		//compte.setDriver(new ChromeDriver());
		compte.getDriver().quit();
		principale();
			
			
		}

	}

	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private void listerVillages() {
		compte.getDriver().get(compte.getServer()+"dorf1.php"); //a virer apres correction de monter village echec
		
		List<WebElement> urls = compte.getDriver().findElements(By.xpath("//*[@id=\"sidebarBoxVillagelist\"]/div[2]/div[2]/ul/li/a"));
		List<WebElement> coordxy = compte.getDriver().findElements(By.cssSelector("span.coordinateX"));

		for (WebElement url : urls) {
			String stringUrl = url.getAttribute("href");
			boolean trouver = false;
			for (Village village : listeDeVillages) {
				String vUrl = village.getUrl();
				if (vUrl.split("php")[1].equals(stringUrl.split("php")[1])) {
					trouver = true;
					break;
				}

			}
			if (!trouver) {
				Village newVillage = new Village();
				newVillage.setUrl(stringUrl);
				newVillage.setNom(url.findElement(By.className("name")).getText());// .replaceAll("\n", "").replaceAll(" ",
									// "").replaceAll ("\\s+$",""));

				// try {
				// newVillage.setX(findElement(By.cssSelector("#sidebarBoxVillagelist > div.sidebarBoxInnerBox > div.innerBox.content > ul > li > a > span > span.coordinateX")).getText());
				// newVillage.setX(url.findElement(
				// By.xpath("//*[@class=\"coordinateX\"]")).getText());
				// newVillage.setY(url.findElement(
				// By.xpath("//span[text()='|']")).getText());
				// newVillage.setX(url.findElement(By.xpath("//*[@class=\"coordinateX\"]")).getText());
				// newVillage.setY(url.findElement(By.xpath("//span[text()='|']")).getText());
				// newVillage.setX(url.findElement(By.xpath("//*[@class=\"coordinateX\"]")).getText());
				// newVillage.setY(url.findElement(By.xpath("//span[text()='|']")).getText());
				// newVillage.setX(url.findElement(By.xpath("//*[@id=\"sidebarBoxVillagelist\"]/div[2]/div[2]/ul/li/a")).getText());
				// [contains(text(), 'Country')]
				// newVillage.setY(findElement(By.cssSelector("span.coordinateX")).getText());
				// } catch (Exception e) {
				// e.printStackTrace();
				// }

				listeDeVillages.add(newVillage);
				
			}
			
		}
		System.out.println("Nombre de Villages = " + listeDeVillages.size());
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////////////////////////////////


	

	// /////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * private void clearListes(){ listeWebelementChamps.clear();
	 * listeLevelsChamps.clear(); listeNomsChamps.clear();
	 * System.out.println("clear." );
	 * 
	 * }
	 */
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///// ////// ////    ///// /////////// / ///////////////////////////////////////////////////////////////////////////////////////////////
	////// //// ////// /////// ////////// /// /////////////////////////////////////////////////////////////////////////////////////////////
	/////// // ////// //////// ///////// // // ////////////////////////////////////////////////////////////////////////////////////////////
	//////// //////    /////// / / / // /////// /////////////////////////////////////////////////////////////////////////////////////////////
	//On determine le village en cours.
	public Village villageEnCours() {
		for (Village village : listeDeVillages) {
			String ici = compte.getDriver().findElement(By.xpath("//*[@id=\"villageNameField\"]")).getText();
			String labas = village.getNom();
			if (labas.equals(ici)) {
				//System.out.println("Villages en cours : " + village.getNom());
				return village;
			}
		}
		return null;
		
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////////////////

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
/*	private void prendreDecision(){			
	//Override si champs termine ou palier
		palier = new Palier();
		strategieConstruction = new StrategieConstruction();
	int	palierStrat = palier.palier(champMin);
		return strategieConstruction(palierStrat);	
		
	
}	*/
	public void rotationVillage() {
		for(Village village : listeDeVillages ){
			
			
			if (allume == false){break;}
			if (besoinDePasserSurLeVillage(village) == 1 ){
				randomsleep.classic();
			if (village != villageEnCours()){
			compte.getDriver().get(village.getUrl());
			System.out.println("=============================== Changement de village : "+village.getNom()+" ===============================");
			
			}
			//TODO Remonter chargerchamp pour rendre le NPC effectif des la premiere co
			village.updateRessources(t);
			if (allume == false){break;}
			village.voirListeDeConstruction(t);
			if (allume == false){break;}
			village.chargerChamps(t);
			if (allume == false){break;}
			if (village.getBesoinDeNpc() == true && village.getVillageCapitale()==true){
			npcNegatif();
			}
			
			if (allume == false){break;}
			if (village.getTokenconstruction() < 2 && bot.tfenetre.faireConstruireBox.isSelected()){
			gestionBatiments();
			}else{System.out.println("construction Desactivees...");}
			
			if (allume == false){break;}
			marche.etablirBesoinEnRessources(t, village, listeDeVillages);
			
			if (allume == false){break;}
			if (bot.tfenetre.evacuerRessourcesBox.isSelected()){
			marche.evacuerSurplusRessources(t, village, listeDeVillages);
			}else{System.out.println("Evacuation ressources Desactives...");}
			
			try { 
				if (allume == false){break;}
				if(bot.tfenetre.pillageBox.isSelected()){
				village.voirTroupesDuVillage(t);
				}else{System.out.println("Pillages Desactives...");}
			}catch(Exception e){System.out.println("Echec pillage ");}
			
			try { 
				if (allume == false){break;}
			if(bot.tfenetre.faireFetes.isSelected()){
				if (village.getChampMin() >= 10 && village.getBesoinDeFete() == 1){ 
				if (village.getBois() >= 6400 && village.getArgile() >= 6650 && village.getFer() >= 5940 && village.getCereales() >= 1340 ){
						village.lancerFete(t);
				} else {System.out.println("[Fete] Pas assez de ressources pour faire une fete");}
				} else {System.out.println("[Fete] Pas besoin de fete ou pas d'hotel de ville");}
			}else {System.out.println("[Fete] fetes Desactivees...");}
			}catch(Exception e){System.out.println("echec fete ");}
		
		}//fin for
		}
	}
	
	private int heureServer(){ //heure serveur non precise pour lancer les fetes sans spammer a chaque tour de bot
	int	heure = Integer.parseInt(compte.getDriver().findElement(By.xpath("//*[@id=\"tp1\"]")).getText().split(":")[0]);
	return heure;
		
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	private void gestionBatiments() {
		Village village =villageEnCours();
		village.EssayerConstruireBatiments(t, village);


	}	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*public boolean commuterPillage(){
		if(pillage==true){pillage=false;System.out.println("Pillage ["+pillage+"]");}
		else {pillage=true;System.out.println("Pillage ["+pillage+"]");}
		return pillage;
		
		
	}
	
	public boolean commuterFete(){
		if(fete==true){fete=false;System.out.println("Fetes ["+fete+"]");}
		else {fete=true;System.out.println("Fetes ["+fete+"]");}
		return fete;
		
	}*/
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
		
		
		


		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void gestionHero() {
		//Hero hero = new Hero();
		String heroSurVillage;
		WebElement lienHero = compte.getDriver().findElement(By.xpath("//*[@id=\"heroImageButton\"]"));
		Actions builder = new Actions(compte.getDriver());
		builder.moveToElement(lienHero);		
		builder.perform();
		randomsleep.court();
		heroSurVillage = compte.getDriver().findElement(By.xpath("//*[@class=\"tip-contents\"]")).getText().split("rattachement ")[1].split("\\.")[0];//("rattachement de ")
		hero.setVillageAffecte(heroSurVillage);
		String villageHero = hero.getVillageAffecte();
		Village village = villageEnCours();
		//for(Village2 village : listeDeVillages){
			if (village.getNom().equals(villageHero)) {
				
	
		//updateRessources(); //update le village en cours : a develloper
		int stockbois = village.getBois();
		int stockargile = village.getArgile();
		int stockfer = village.getFer();
		int stockcereales = village.getCereales();
		
		HashMap<String, Integer> stockbafc = new HashMap<String, Integer>();
		stockbafc.put("bois", stockbois);
		stockbafc.put("argile", stockargile);
		stockbafc.put("fer", stockfer);
		stockbafc.put("cereales", stockcereales);

		/* System.out.println("Before Sorting:");
	      Set set = stockbafc.entrySet();
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	           Map.Entry me = (Map.Entry)iterator.next();
	           System.out.print(me.getKey() + ": ");
	           System.out.println(me.getValue());
	      }*/
	      Map<String, Integer> map = sortByValues(stockbafc); 
	     // System.out.println("After Sorting:");
	      	 Set set1 = map.entrySet();
	         Set set2 = map.entrySet();
	         Iterator iterator1 = set1.iterator();
	         Iterator iterator2 = set2.iterator();
	         Map.Entry min = (Map.Entry)iterator2.next();
	         String min2 = min.getKey().toString();
	         
	         
	         ////Si la prod du hero est differente, on la corrige
	         if (!hero.getModeProduction().equals(min2)){
	         	hero.setModeProduction(min.getKey().toString());
	         	
	         	String token = hero.getModeProduction();
	         	String token2 = null;
	         
	         	if (token.equals("bois")) {token2 = "1";}
	         	if (token.equals("argile")) {token2  = "2";}
	         	if (token.equals("fer")) { token2   = "3";}
	         	if (token.equals("cereales")) {token2  = "4";}
	         	
	    		compte.getDriver().get(compte.getServer()+"hero_inventory.php");
	    		randomsleep.court();
	    		compte.getDriver().findElement(By.xpath("//*[@class=\"openCloseSwitchBar\"]")).click();
	    		randomsleep.court();
	         		compte.getDriver().findElement(By.xpath("//*[@id=\"resourceHero"+token2 +"\"]")).click();
					randomsleep.court();
					compte.getDriver().findElement(By.xpath("//*[@id=\"saveHeroAttributes\"]/div/div[2]")).click();
					randomsleep.court();
	         System.out.println("Hero boost : " + min.getKey().toString());
	        while(iterator1.hasNext()) {
	           Map.Entry me2 = (Map.Entry)iterator1.next();
	           System.out.print(("|" + me2.getKey() + ": " + me2.getValue() + "|")); 
	        }
	        System.out.println(""); 
	        compte.getDriver().get(compte.getServer()+"dorf1.php");
	           randomsleep.court(); 
	         	}else {System.out.println("Hero boost deja  la bonne ressource : " +hero.getModeProduction()) ;}

			}
			else{System.out.println("Hero sur un autre village : "+ hero.getVillageAffecte());} //a corriger : renvoyer le village ffecter au lieu du village en cours
			
			//on replace le curseur sur une zone neutre
			Actions builder2 = new Actions(compte.getDriver());
			builder.moveByOffset(0, 50);		
			builder.perform();
	}
		
		
	
	private void aventureHero(){
		int aventureTempsRestant = 110;
		//boolean estPresent;
		WebElement lienAventures;
		int heure1 = 0;
		randomsleep.court();
		try {lienAventures = compte.getDriver().findElement(By.xpath("//*[contains(@class, 'adventureWhite')]"));//button-container addHoverClick//*[@class=\"speechBubbleContent\"]
		}catch  (Exception e) {lienAventures= null; System.out.println("Pas de quetes :( ");} //deprecated
		
		if (lienAventures != null ){ 
			randomsleep.court();
			//*[@class=\"layoutButton adventureWhite green  \"]
			WebElement bouttonQuete = compte.getDriver().findElement(By.xpath("//*[contains(@class, 'adventureWhite')]"));
			Actions hover = new Actions(compte.getDriver());
			hover.moveToElement(bouttonQuete);		
			hover.perform();
			randomsleep.court();
			try {
				heure1 = Integer.parseInt(compte.getDriver().findElement(By.xpath("//*[@class=\"text elementText\"]")).getText().split("dans ")[1].split(":")[0]);
			
			
			if (heure1 <= aventureTempsRestant){
			
			compte.getDriver().findElement(By.xpath("//*[contains(@class, 'adventureWhite')]")).click();
			randomsleep.court();
			WebElement heure;
			String h = null;
				try { heure = compte.getDriver().findElement(By.xpath("//*[@id=\"timer1\"]"));
				h = heure.getText().split(":")[0];
				int h2 = Integer.parseInt(h);
				if (h2 <= aventureTempsRestant) {
				compte.getDriver().findElement(By.xpath("//*[@class=\"gotoAdventure arrow\"]")).click();
				randomsleep.court();
				compte.getDriver().findElement(By.xpath("//*[@id=\"start\"]/div/div[2]")).click();
				System.out.println(" Quete lance : dead line dans moins de " + h + " heures" );
				randomsleep.court();
				}
				}catch  (Exception e) {System.out.println("Quetes Annoncee non presente ou Hero Absent  : Echec ");}
			
			
			}
			}catch  (Exception e) {System.out.println("Pas de quetes :(");}
		}
		
		
		
		
		
		
		
	}
	


////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void fonderVillage() throws AWTException{ // resuce de voirttoupesduvillage
	/*boolean	colonAQuai = false;
		try {
			List<WebElement> colonsDuVillage = compte.getDriver().findElements(By.xpath("//*[@id=\"troops\"]/tbody/tr"));
			for(WebElement colon : colonsDuVillage) {
				boolean colonsPresents = colon.findElement(By.className("un")).getText().contains("Colon");//Colons
				int nombreColonsPresents = Integer.parseInt(colon.findElement(By.className("num")).getText());
				if (colonsPresents && nombreColonsPresents >=3){*/
					
					compte.getDriver().get(compte.getServer()+"karte.php");
					
					WebElement lienHero = compte.getDriver().findElement(By.xpath("//*[@id=\"heroImageButton\"]"));
					
					Actions builder = new Actions(compte.getDriver());
					builder.moveToElement(lienHero,400, 370);		
					builder.perform();
					builder.click();
					builder.perform();
					WebElement lienimage = compte.getDriver().findElement(By.xpath("//*[@id=\"tileDetails\"]/div[1]"));
					builder.moveToElement(lienimage,100, 270);
					builder.perform();
					builder.click();
					builder.perform();
					
					///builder.sendKeys()
					//Robot robot;
					//robot = new Robot();
					//robot.keyPress(KeyEvent.VK_ESCAPE);
					//System.in.read('\n');
					//lienimage.sendKeys(Keys.ESCAPE);
				
					
					
	/*			}
			}
			
		}catch (Exception e){System.out.println("FonderVillage echec");}*/
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Module de chargement des frigos a chaque appel de la fonction
	
	public List<String> chargerfrigo() {
		  //On liste la liste principal de pillage
		List<WebElement> frigosPremiereListe = compte.getDriver().findElements(By.xpath("//*[@id=\"list1386\"]//tbody/tr"));
		
		//on liste les IDs des frigo a cause du rechargement de page qui detruit des Webelements  
		List<String> frigoIds = new ArrayList<>();
		 for (WebElement frigoId: frigosPremiereListe){
			 if (frigoId.getAttribute("id").contains("slot-row")) {
		 frigoIds.add(frigoId.getAttribute("id"));}}
		return frigoIds;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//Tri et lancement des pillages sur les frigos
	public void pillage () {
		  randomsleep.court(); 
		compte.getDriver().get(compte.getServer()+"build.php?tt=99&id=39");
		  randomsleep.court(); 
		  //todo : listes de listes de pillages
		//List<WebElement> raidListes = compte.getDriver().findElements(By.xpath("//*[@id=\"list568\"]"));  //*[@id=\"raidList\"]/div
		  

		  
 
		 //On remet les IDs des frigo a jours a cause du rechargement de page
		 for (String frigoIdString : chargerfrigo()){
						WebElement	frigo = compte.getDriver().findElement(By.xpath("//*[@id=\""+frigoIdString+"\"]"));
						
				//on recherche les croix rouge pour les enlever		
				try {
					if (!frigo.findElement(By.xpath("td[6]/img[1]")).getAttribute("alt").contains("sans perte.")){		 //[contains(@class, 'iReport')]
						frigo.findElement(By.xpath("td[7]")).click();
						randomsleep.court();
						frigo.findElement(By.xpath("//*[@id=\"lid\"]")).click();											//input[contains(@class, 'check')]         //input[@type= 'checkbox']
						randomsleep.court();
						List<WebElement> listeDoptions = frigo.findElements(By.xpath("//*[@id=\"lid\"]/option"));
						for (WebElement option : listeDoptions) {
							if (option.getText().contains("Pertes")) {
								option.click();
							}
						}
						randomsleep.court();
						frigo.findElement(By.xpath("//*[@id=\"save\"]/div/div[2]")).click();
						randomsleep.court();
						
						}
					//on catch les elememts vide
					}catch (Exception e) {/*System.out.print("un vide");*/}
								
				}
		 //on click tout cocher
		compte.getDriver().findElement(By.xpath("//*[@id=\"raidListMarkAll1386\"]")).click();
		randomsleep.court();
		
		
		if(compteurDeBoot % 1 == 0){
			compte.getDriver().findElement(By.xpath("//*[text()[contains( .,'lancer pillage')]]")).click();
			System.out.println(compteurDeBoot + " --> Pillage --> MODE IMPRUDENT (Multiple de 1)"  );
		}
		
		else {
		//On decoche si il y a deja une attaque en cours : MODE PRUDENT
		int compteurDeFrigoSansAttaque=0;
		
		for (String frigoIdString : chargerfrigo()){
			try {
				if(compte.getDriver().findElement(By.xpath("//*[@id=\""+frigoIdString+"\"]//*[@class=\"attack att2\"]")).isDisplayed()){
					/*System.out.println("Deja une attaque sur " + frigoIdString);*/
					compte.getDriver().findElement(By.xpath("//*[@id=\""+frigoIdString+"\"]//*[@type=\"checkbox\"]")).click();
				}
			}catch (Exception e) {
				compteurDeFrigoSansAttaque++;
				//System.out.println("Pas dattaque en cours sur " + frigoIdString);
				}
		 }
		
			if (compteurDeFrigoSansAttaque >= 6){
		//on lance la liste de pillage
		compte.getDriver().findElement(By.xpath("//*[text()[contains( .,'lancer pillage')]]")).click();
		System.out.println("Lancement sur " + compteurDeFrigoSansAttaque + "Frigos");
		System.out.println(compteurDeBoot + " --> Pillage --> MODE prudent"  );
			}
		}
		randomsleep.court();
		
		
		
		
		
	/////////////////////////////////////////////////	
	//	MODE 1 lancement prudent puis un Imprudent :
	/*	
		//Si le compteur est impair on lance en mode prudent
		if(compteur % 2 != 0) {
		//On decoche si il y a deja une attaque en cours : MODE PRUDENT
		for (String frigoIdString : chargerfrigo()){
			try {
				if(compte.getDriver().findElement(By.xpath("//*[@id=\""+frigoIdString+"\"]//*[@class=\"attack att2\"]")).isDisplayed()){
					//System.out.println("Deja une attaque sur " + frigoIdString);
					compte.getDriver().findElement(By.xpath("//*[@id=\""+frigoIdString+"\"]//*[@type=\"checkbox\"]")).click();
				}
			}catch (Exception e) {System.out.println("Pas dattaque en cours sur " + frigoIdString);}
		 }
		//on lance la liste de pillage
		randomsleep.court();
		compte.getDriver().findElement(By.xpath("//*[text()[contains( .,'lancer pillage')]]")).click();
		System.out.println(compteur + " --> Pillage --> MODE PRUDENT (Impair)" );
		randomsleep.court();
		}
		
	//	//Si le compteur est pair on lance en Mode Imprudent
	//	if (compteur % 2 == 0){
	//		//On lance de force 
	//	}
			
		//on lance la liste de pillage
		else { 
		compte.getDriver().findElement(By.xpath("//*[text()[contains( .,'lancer pillage')]]")).click();
		System.out.println(compteur + " --> Pillage --> MODE IMPRUDENT (Pair)"  );
		randomsleep.court();
		}
	*/	
	/////////////////////////////////////////////////////////////////////////////////////////////////	
		
	}
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////		
/////////////////////////////////////////////////////////////////////////////////////////////////		
/////////////////////////////////////////////////////////////////////////////////////////////////		
	private HashMap sortByValues(HashMap map) { 
	       List list = new LinkedList(map.entrySet());
	       // Defined Custom Comparator here
	       Collections.sort(list, new Comparator() {
	            public int compare(Object o1, Object o2) {
	               return ((Comparable) ((Map.Entry) (o1)).getValue())
	                  .compareTo(((Map.Entry) (o2)).getValue());
	            }
	       });

	       // Here I am copying the sorted list in HashMap
	       // using LinkedHashMap to preserve the insertion order
	       HashMap sortedHashMap = new LinkedHashMap();
	       for (Iterator it = list.iterator(); it.hasNext();) {
	              Map.Entry entry = (Map.Entry) it.next();
	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       return sortedHashMap;
	  }
	
/////////////////////////////////////////////////////////////////////////////////////////////////		
/////////////////////////////////////////////////////////////////////////////////////////////////		
/////////////////////////////////////////////////////////////////////////////////////////////////		
/////////////////////////////////////////////////////////////////////////////////////////////////		
/////////////////////////////////////////////////////////////////////////////////////////////////		
	  
	  private void cadeaux() {
		  
		  
		  
		  compte.getDriver().findElement(By.xpath("//*[@id=\"sidebarBoxQuestachievements\"]/div[2]/div[2]/form/div")).click();
		  randomsleep.court();
		  try{
			  WebElement quete1Active = compte.getDriver().findElement(By.xpath("//*[@id=\"achievementRewardList\"]/div[3]"));//*[@id=\"achievementRewardList\"]/div[3]/a/div[1]//*[@id=\"achievementRewardList\"]/div[3]
			  randomsleep.court();
			  quete1Active.click();
			  randomsleep.court();
			//WebElement  lien = compte.getDriver().findElement(By.className("button-content")).getText().contains("Récompense");//*[@id="button5533e89cab960"]/div/div[2]
		  }catch (Exception e) {
				System.out.println("Pas de Cadeaux 1");} 
		  
	  }
	  
	  private void surveillanceHero(){
		  
		  
	  }
	  
	  /////////////////////////////////////////////////////////////////////////////////////////////
	  ////////////////////////////////////////////////////////////////////////////////////////////
	  
	  private void majVillagesPlus(){
		  Village village = villageEnCours();
		  

		  randomsleep.court();

		  //donnees globlales
		  				// compte.getDriver().get("http://ts4.travian.fr/dorf3.php");
		  try {
		  		compte.getDriver().findElements(By.xpath("//button[contains(@class, 'layoutButton overviewWhite green')]")).get(1).click();  // si dans une alliance
		  }catch (Exception e){compte.getDriver().findElements(By.xpath("//button[contains(@class, 'layoutButton overviewWhite green')]")).get(0).click(); } //sans alliance
		  		randomsleep.court();
		  		donneesGlobales = compte.getDriver().findElements(By.xpath("//*[@id=\"overview\"]/tbody/tr"));
		  			randomsleep.court();
		  			determinerBesoinDeConstructions();
		 // 	compte.getDriver().get("http://ts4.travian.fr/dorf3.php?s=2");
		  	//	donneesRessources = compte.getDriver().findElements(By.xpath("//*[@id=\"ressources\"]/tbody"));
		  		
		  randomsleep.court();
		  
		  
		  //donnees ressources
		  // compte.getDriver().get("http://ts4.travian.fr/dorf3.php");
		  compte.getDriver().findElement(By.xpath("//a[contains(@id, 'villageOverViewTab2')]")).click();
		  randomsleep.court();
		  donneesRessources = compte.getDriver().findElements(By.xpath("//*[@id=\"ressources\"]/tbody/tr"));
		  randomsleep.court();
		  	updateRessourcesPlus(t);
		  	
		  // 	compte.getDriver().get("http://ts4.travian.fr/dorf3.php?s=2");
		  //	donneesRessources = compte.getDriver().findElements(By.xpath("//*[@id=\"ressources\"]/tbody"));

		  randomsleep.court();
		  
		  
		  
		  //donnees pourcentage
		  
		  			//	compte.getDriver().get("http://ts4.travian.fr/dorf3.php?s=3");
		  		compte.getDriver().findElement(By.xpath("//a[contains(@id, 'villageOverViewTab3')]")).click();
		  		randomsleep.court();
		  		donneesRessourcesPourcentage = compte.getDriver().findElements(By.xpath("//*[@id=\"warehouse\"]/tbody/tr"));
		  		randomsleep.court();
		  		determinerBesoinDeNpc();
		  		
		  randomsleep.court();
		  
		  //donnees culturepoint
		  
	  		//compte.getDriver().findElement(By.xpath("//button[contains(@class, 'layoutButton overviewWhite green  ')]")).click();
	  		randomsleep.court();
	  		compte.getDriver().findElement(By.xpath("//*[@id=\"villageOverViewTab4\"]")).click();
	  		randomsleep.court();
		  		donneesPointsDeCulture = compte.getDriver().findElements(By.xpath("//*[@id=\"culture_points\"]/tbody/tr"));
		  		
		  randomsleep.court();
		  
		  determinerBesoinDeFetes();
		  
		  
		  
		  
	  }
	  
	  
		void updateRessourcesPlus(Travian t) {
			int i = 0;
			for (Village village	: listeDeVillages){
				if (village.getUrl().contains(donneesRessources.get(i).findElement(By.xpath("//*[@id=\"ressources\"]/tbody/tr["+ (i+1) +"]/td[1]/a")).getAttribute("href").split("php")[1])){
					village.setBois(Integer.parseInt(compte.getDriver().findElement(By.xpath("//*[@id=\"ressources\"]/tbody/tr["+ (i+1) +"]/td[2]")).getText().replace(".", "")));
					village.setArgile(Integer.parseInt(compte.getDriver().findElement(By.xpath("//*[@id=\"ressources\"]/tbody/tr["+ (i+1) +"]/td[3]")).getText().replace(".", "")));
					village.setFer(Integer.parseInt(compte.getDriver().findElement(By.xpath("//*[@id=\"ressources\"]/tbody/tr["+ (i+1) +"]/td[4]")).getText().replace(".", "")));
					village.setCereales(Integer.parseInt(compte.getDriver().findElement(By.xpath("//*[@id=\"ressources\"]/tbody/tr["+ (i+1) +"]/td[5]")).getText().replace(".", "")));
					village.setNombreDeMarchands(Integer.parseInt(compte.getDriver().findElement(By.xpath("//*[@id=\"ressources\"]/tbody/tr["+ (i+1) +"]/td[6]")).getText().split("/")[0].replaceAll("\\W", "")));
					//String pageSource = compte.getDriver().findElement(By.id("lum")).getAttribute("innerHTML");
					//String elemHtml = driver.findElement(By.id(“someId”)).getAttribute(“innerHTML”);
					//String pageSource = compte.getDriver().getPageSource() ;
					//String page1 = pageSource;//split("vil fc")[1];
					//System.out.println(""+ pageSource);
				//	JavascriptExecutor executor = (JavascriptExecutor)compte.getDriver();
				//	 String text= (String) executor.executeScript("document.getElementById('versionInfo').innerHTML");
					//village.setMaxStockDepot(Integer.parseInt(pageSource.split("80000")[0].toString()));
					System.out.println("Village: " +village.getNom()+ ":  Bois : " +village.getBois()+ " Argile : " +village.getArgile()+ " Fer : " +village.getFer()+ " Cereales : " +village.getCereales()+" Marchands Dispos : "+village.getNombreDeMarchands());
					i++;
		//TODO charger depot silot par pagesource et analyse de page ou par souris hover
					//	String maxDepot = t.getCompte().getDriver().findElement(By.xpath("/html/body/div[2]/div")).getText().replace(" ", "");
				//	int maxStockDepot = Integer.parseInt(maxDepot);
					
			/*		//survol souris du champs = a champMin
					Actions builder = new Actions(t.getCompte().getDriver());
					builder.moveToElement(listeWebelementChamps.get(g));		
					builder.perform();
					t.randomsleep.court();

					//choper le tableau des ressources necessaires pour le champs en cours
					List<WebElement> ressourcesNecessaires = listeWebelementChamps.get(g+1).findElements(By.xpath("//*[@class='showCosts']/span"));

					//	System.out.println("valeur ressourcesnecessaire "+ ressourcesNecessaires.get(0).getText());
					//	System.out.println("valeur ressourcesnecessaire "+ ressourcesNecessaires.get(1).getText());
					//	System.out.println("valeur ressourcesnecessaire "+ ressourcesNecessaires.get(2).getText());
					//	System.out.println("valeur ressourcesnecessaire "+ ressourcesNecessaires.get(3).getText());*/
					////////////////////////////////////
					////////////////////////////////////
					/*
					
					String maxDepot = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"stockBarWarehouse\"]")).getText().replace(" ", "");
					int maxStockDepot = Integer.parseInt(maxDepot);
					
					String maxSilo = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"stockBarGranary\"]")).getText().replace(" ", "");
					int maxStockSilo = Integer.parseInt(maxSilo);
					
					village.setMaxStockDepot(maxStockDepot);
					village.setMaxStockSilo(maxStockSilo);

					System.out.println("Update Ressources de : " +village.getNom());
				
				*/
					
					
					
				}
				
			}

		
		
		}
	  
	  
	  
	  
	  
	  
	  
	  private void npcNegatif() {
		
		  randomsleep.court();
		 

			 compte.getDriver().findElement(By.xpath("//button[contains(@class, 'marketWhite')]")).click();
			 randomsleep.court();
			 compte.getDriver().findElement(By.xpath("//div[contains(@class, 'favorKey0')]")).click();
			 randomsleep.court();
			 compte.getDriver().findElement(By.xpath("//button[contains(@value, 'Échange de ressources')]")).click();
			 randomsleep.court();
			 compte.getDriver().findElement(By.xpath("//*[@id=\"m2[3]\"]")).clear();
			 compte.getDriver().findElement(By.xpath("//*[@id=\"m2[3]\"]")).sendKeys("1200000");
			 randomsleep.court();
			 compte.getDriver().findElement(By.xpath("//button[contains(@value, 'Distribuer les ressources restantes.')]")).click();
			 randomsleep.court();
			 //randomsleep.court();
			 compte.getDriver().findElement(By.xpath("//button[contains(@id, 'npc_market_button')]")).click();
			 System.out.println("Npc pour eviter la famine");
			 randomsleep.court();
			
		 
		 
		 
				

	  }
	  
	  ////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  ////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  ////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  private void determinerBesoinDeFetes() {
		 int besoinDeFete = 0;
		 int i = 0;
		 
	
		 for (Village village : listeDeVillages) {
			 besoinDeFete = 0;
			 try{
				 if (village.getUrl().contains(donneesPointsDeCulture.get(i).findElement(By.xpath("//*[@id=\"culture_points\"]/tbody/tr["+ (i+1) +"]/td[1]/a")).getAttribute("href").split("php")[1]) && donneesPointsDeCulture.get(i).findElement(By.xpath("//*[@id=\"culture_points\"]/tbody/tr["+ (i+1) +"]/td[3]/a/span")).getText().equals("•") ) {
			 besoinDeFete = 1;
			 village.setBesoinDeFete(besoinDeFete);
			 i++;
			 }
		 
				 else {village.setBesoinDeFete(besoinDeFete);
				 i++;	
				 }
				 
			 }
			 catch (Exception e) {i++; village.setBesoinDeFete(besoinDeFete);}
		  }
		 }
	  /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  
	  private void determinerBesoinDeConstructions() {
		  int i = 0;
		  		  
		for (Village village : listeDeVillages) {
		  if (village.getUrl().contains(donneesGlobales.get(i).findElement(By.xpath("//*[@id=\"overview\"]/tbody/tr["+ (i+1) +"]/td[1]/a")).getAttribute("href").split("php")[1])){
			  	  village.setTokenconstruction(donneesGlobales.get(i).findElements(By.xpath("//*[@id=\"overview\"]/tbody/tr["+ (i+1) +"]/td[3]/a/img")).size());
				  i++;
			  }
			  
		  }
		int resteAConstruire = 0;
		 for (Village village : listeDeVillages){
			 resteAConstruire = 0;
			// village.setBesoinDeConstruction(true);// premiere connection pas de liste de batiment chargee... donc on autorise
			 for (Batiment batiment : village.getBatiments()){
				 
				 for (Batiment tempBat : village.getTemplateDuVillage()){
				 if (batiment.getNomBatiment().equals(tempBat.getNomBatiment())){
					 if(batiment.getLevelBatiment() < tempBat.getLevelBatiment()){
						 resteAConstruire++;
					 }
				 }
				 }
				 
			 }
			 if (resteAConstruire < 1 && !village.getBatiments().isEmpty() ){
				 village.setBesoinDeConstruction(false);
				 System.out.println(village.getNom()+" : Template Fini");
				 resteAConstruire = 0;
			 }else {
				 village.setBesoinDeConstruction(true);
				 System.out.println(village.getNom()+" : Template Non Fini");
				 resteAConstruire = 0;
				 }
		 }
		/* if (resteAConstruire > 0){
			 village.setBesoinDeConstruction(true);
			 }else{
				 village.setBesoinDeConstruction(false);
				 }*/
		 
		  
	  }
	  
	  
	  /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  private void determinerBesoinDeNpc() {
		//npcNegatif();
			 int delaisAvantFamineOuDebordement  = 9999;
			 boolean enNegatif;
			 int i = 0;
			 String texte = "famine";

			 			 
			 
			 for (Village village : listeDeVillages){
				 
				

			//	 if (donneesRessourcesPourcentage.get(i).findElement(By.xpath("//*[@id=\"warehouse\"]/tbody/tr["+ (i+1) +"]/td[5]")).getText().contains("-")) {}
				
				 
				 
				 
				 if ( village.getUrl().contains(donneesRessourcesPourcentage.get(i).findElement(By.xpath("//*[@id=\"warehouse\"]/tbody/tr["+(i+1)+"]/td[1]/a")).getAttribute("href").split("php")[1] ) ){
					 
					try{ delaisAvantFamineOuDebordement  = Integer.parseInt(donneesRessourcesPourcentage.get(i).findElement(By.xpath("//*[@id=\"warehouse\"]/tbody/tr["+ (i+1) +"]/td[7]")).getText().split(":")[0]);
						try { enNegatif = donneesRessourcesPourcentage.get(i).findElement(By.xpath("//*[@id=\"warehouse\"]/tbody/tr[" +(i+1)+ "]/td[7]//*[contains(@class, 'crit')]")).isDisplayed();}catch (Exception e){
						enNegatif=false;}
						if (enNegatif==true){texte="Famine";}else{texte="Debordement";}
							if (delaisAvantFamineOuDebordement < 1 && enNegatif==true ) {
								village.setBesoinDeNpc(true);
								System.out.println(village.getNom() +": Delais avant "+texte+" : "+delaisAvantFamineOuDebordement+" En Negatif = "+enNegatif );
								i++;
								}else {
									village.setBesoinDeNpc(false);
									System.out.println(village.getNom() +": Delais avant "+texte+" : "+delaisAvantFamineOuDebordement+" En Negatif = "+enNegatif );
									i++;
								  }
						}catch (Exception e) {
							String string100pourcent = donneesRessourcesPourcentage.get(i).findElement(By.xpath("//*[@id=\"warehouse\"]/tbody/tr["+ (i+1) +"]/td[6]")).getText().replaceAll("\\W", "");
							
							
							if (string100pourcent.contains("100")){
								texte="Debordement";
								enNegatif=false;
								village.setBesoinDeNpc(false);
								System.out.println(village.getNom() +": Delais avant "+texte+" : *En Debordement* En Negatif = "+enNegatif );
								i++;
								}
							else{
								texte="Famine Veritable";
								enNegatif=true;
								village.setBesoinDeNpc(true);
								village.setCropDeath(true);
								System.out.println(village.getNom() +": Delais avant "+texte+" : *En CropDeath* En Negatif = "+enNegatif );
								
								i++;
								}
						}
					 
						
					 

				 }
			 }
	  }

	  	  
	  /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  //determiner le besoin de se connecter au village
	  private int besoinDePasserSurLeVillage(Village village) {
		  int besoin = 0;
		  int besoin2 = 0;
		  
		  if (village.getChampsFinis() == false && village.getTokenconstruction() < 2 
				  || village.getBesoinDeFete() == 1 
				  || village.getVillageCapitale() == true 
				  || village.getVillagePillage() == true 
				  || village.getCropDeath() == true 
				  || village.getTokenconstruction() < 2 && village.getBesoinDeConstruction() == true
				  || village.getCereales() >= village.getMaxStockSilo()*90/100 
			  	  || compteurDeBoot == 1)	{
			  besoin = 1;
		  }
		  
		  if ( besoin == 1 ) {
			  besoin2 = 1;
		  }
		  
		  return besoin2 ;
		  
	  }
	  
	  
	  
	  /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  private void eviterSurvey() {
		  try {
			  prendrePhoto("Connexion");
			  randomsleep.court();
		 boolean boutonContinuer = compte.getDriver().findElement(By.xpath("//*[@id=\"sysmsg\"]/p[1]/a")).isDisplayed();
		  randomsleep.court();
		  if (boutonContinuer == true) {
			  prendrePhoto("ifboutonContinueregaltrue");
			  compte.getDriver().findElement(By.xpath("//*[@id=\"sysmsg\"]/p[1]/a")).click();
			  System.out.println("Eviter Sondage fait");
		  }
		  }catch (Exception e) {
			  System.out.println("Pas de sondage a eviter");
		  }
		  
	  }
	  
	  private void prendrePhoto(String nom) {
		  numeroDePhoto++;
		  
		  String[] repertoire = new java.io.File("\\test").list();
	    //////////////
		  for (int i=0; i<repertoire.length; i++)
	        {
	            // Afficher le nom de chaque élément
	            System.out.println(repertoire[i]);
	        }
		///////////
		  
	     //trouver nom equivalent et incrementer
	   	       for (int i=0; i<repertoire.length; i++)
	        {
	          // if (repertoire[i].split("\\.")[0].equals(nom)  || repertoire[i].split("\\.")[0].split("\\-")[0].equals(nom) && Integer.parseInt (repertoire[i].split("\\.")[0].split("\\-")[1]) <= numeroDePhoto  ) 
	   	    	   {
	        //	   numeroDePhoto = Integer.parseInt (repertoire[i].split("\\.")[0].split("\\-")[1]);
	        	   //// numeroDePhoto++;
	        	   }
	           
	           //if (Integer.parseInt (repertoire[i].split("\\.")[0].split("\\-")[1]) == numeroDePhoto) {numeroDePhoto++;}
	           if (numeroDePhoto > 30) { numeroDePhoto = 0;
	        	/*   try {
	        		   FileUtils.forceDelete(new File("c:\\test\\"+nom+"-"+numeroDePhoto+".jpg"));}catch (Exception e) {
	   		  			System.out.println("supression ratee");
	   		  		}*/
	        	   }
	        }
		  
	   	       
	   ////////////
		  try {
	  File scrFile = ((TakesScreenshot)compte.getDriver()).getScreenshotAs(OutputType.FILE); 
	  FileUtils.copyFile(scrFile, new File("\\test\\"+nom+"-"+numeroDePhoto+".jpg"));
		  		}catch (Exception e) {
		  			System.out.println("Photo ratee");
		  		}
	  } 
	  
	  
	  
	  /*
	   * 
	   * 			// se replacer sur la bonne page si un module est rester ailleur
			if (!compte.getDriver().getCurrentUrl().contains("dorf1.php")){
				
			compte.getDriver().get("http://ts4.travian.fr/dorf1.php"); //a virer apres correction de monter village echec
			randomsleep.court();
			}
	   */
	  
	  
	  
	  
	  
	  
	  
	  
	  
		
		
		//int modificateur = 0;
		

	/*	if (stockbois < (stockargile-(stockargile*(25/100))) && stockbois < (stockfer-(stockfer*(25/100)))  && stockbois < (stockcereales-(stockcereales*(25/100)))){
			compte.getDriver().findElement(By.xpath("//*[@id=\"resourceHero1\"]")).click();
			randomsleep.court();
			compte.getDriver().findElement(By.xpath("//*[@id=\"saveHeroAttributes\"]/div/div[2]")).click();
			hero.setModeProduction(1);
			randomsleep.court();
			System.out.println("c1 : " +(stockargile-(stockargile*(25/100))));
		}*/
		
		
		//for (int a : stockbafc){
		//	if (a < stockbafc){} 
			
		
	///////////////////////////////////////////////////////////////////////////////////////////////////	
	///////////////////////////////////////////////////////////////////////////////////////////////////	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////	
	///////////////////////////////////////////////////////////////////////////////////////////////////	
	

        

}

