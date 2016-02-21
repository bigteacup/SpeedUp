package botpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Village {
	
	public Village(String nom, String url, String x, String y, ArrayList batiments,
			int bois, int argile, int fer, int cereales, int tokenconstruction,
			ArrayList constructionsEnCour, ArrayList batimentsEnFileDAttente, double levelPlaceTournoi, boolean champsFinis, int maxStockDepot, int maxStockSilo) {
		super();
		this.nom = nom;
		this.url = url;
		this.x = x;
		this.y = y;
		this.batiments = batiments;
		this.bois = bois;
		this.argile = argile;
		this.fer = fer;
		this.cereales = cereales;
		this.constructionsEnCour = constructionsEnCour;
		this.batimentsEnFileDAttente = batimentsEnFileDAttente;
		this.tokenconstruction = tokenconstruction;
		this.levelPlaceTournoi=levelPlaceTournoi;
		this.champsFinis=champsFinis;
	}
	

	public Village() {
		super();
	}


	public String getNom() {
		return nom;
	}

	public String getUrl() {
		return url;
	}

	public String getX() {
		return x;
	}

	public String getY() {
		return y;
	}


	public int getBois() {
		return bois;
	}

	public int getArgile() {
		return argile;
	}

	public int getFer() {
		return fer;
	}

	public int getCereales() {
		return cereales;
	}

	public ArrayList getConstructionsEnCour() {
		return constructionsEnCour;
	}

	public ArrayList getBatimentsEnFileDAttente() {
		return batimentsEnFileDAttente;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setX(String x) {
		
		this.x = x/*.substring(1)*/;
	}

	public void setY(String y) {
		this.y = y;
		//this.y = y.substring(0,y.length()-1);
		/*y= y.substring(0, y.length());*/
		
	}
/*
	public void setBatiments(List<WebElement> batiments) {
		this.batiments = batiments;
	}
	public List<WebElement> getBatiments() {
		return batiments;
	}
*/

	public void setBois(int bois) {
		this.bois = bois;
	}

	public void setArgile(int argile) {
		this.argile = argile;
	}

	public void setFer(int fer) {
		this.fer = fer;
	}

	public void setCereales(int cereales) {
		this.cereales = cereales;
	}

	public void setConstructionsEnCour(ArrayList constructionsEnCour) {
		this.constructionsEnCour = constructionsEnCour;
	}

	public void setBatimentsEnFileDAttente(ArrayList batimentsEnFileDAttente) {
		this.batimentsEnFileDAttente = batimentsEnFileDAttente;
	}

	public int getTokenconstruction() {
		return tokenconstruction;
	}


	public void setTokenconstruction(int tokenconstruction) {
		this.tokenconstruction = tokenconstruction;
	}

	public double getLevelPlaceTournoi() {
		return levelPlaceTournoi;
	}


	public void setLevelPlaceTournoi(double levelPlaceTournoi) {
		this.levelPlaceTournoi = levelPlaceTournoi;
	}

	public boolean getChampsFinis() {
		return champsFinis;
	}


	public void setChampsFinis(boolean champsFinis) {
		this.champsFinis = champsFinis;
	}

	public int getMaxStockDepot() {
		return maxStockDepot;
	}


	public void setMaxStockDepot(int maxStockDepot) {
		this.maxStockDepot = maxStockDepot;
	}

	public int getMaxStockSilo() {
		return maxStockSilo;
	}


	public void setMaxStockSilo(int maxStockSilo) {
		this.maxStockSilo = maxStockSilo;
	}

	public int getManqueDeBois() {
		return manqueDeBois;
	}


	public void setManqueDeBois(int manqueDeBois) {
		this.manqueDeBois = manqueDeBois;
	}

	public int getManqueDeArgile() {
		return manqueDeArgile;
	}


	public void setManqueDeArgile(int manqueDeArgile) {
		this.manqueDeArgile = manqueDeArgile;
	}

	public int getManqueDeFer() {
		return manqueDeFer;
	}


	public void setManqueDeFer(int manqueDeFer) {
		this.manqueDeFer = manqueDeFer;
	}

	public int getManqueDeCereales() {
		return manqueDeCereales;
	}


	public void setManqueDeCereales(int manqueDeCereales) {
		this.manqueDeCereales = manqueDeCereales;
	}
	
	
	
	public void setBesoinDeFete(int besoinDeFete) {
		this.besoinDeFete = besoinDeFete;
	}
	public int getBesoinDeFete() {
		return besoinDeFete;	
	}
	
	
	
	public void setVillagePillage(boolean villagePillage) {
		this.villagePillage = villagePillage;
	}
	public boolean getVillagePillage() {
		return villagePillage;	
	}
	
	
	
	public void setVillageCapitale(boolean villageCapitale) {
		this.villageCapitale = villageCapitale;
	}
	public boolean getVillageCapitale() {
		return villageCapitale;	
	}

	
	public void setBesoinDeNpc(boolean besoinDeNpc) {
		this.besoinDeNpc = besoinDeNpc;
	}
	public boolean getBesoinDeNpc() {
		return besoinDeNpc;	
	}
	
	//public void NombreDeMarchands (){}
	public void setBatiments(List<Batiment> batiments) {
		this.batiments = batiments;
	}
	public List<Batiment> getBatiments() {
		return batiments;
	}
	
	
	
	public void setCropDeath(boolean cropDeath) {
		this.cropDeath = cropDeath;
	}
	public boolean getCropDeath() {
		return cropDeath;
	}
	
	
	
	
	
	public boolean getBesoinDeConstruction() {
		return besoinDeConstruction;
	}
	public void setBesoinDeConstruction(boolean besoinDeConstruction) {
		this.besoinDeConstruction = besoinDeConstruction;
	}





	public List<Batiment> getTemplateDuVillage() {
		return batimentsDuTemplateDuVillage;
	}
	public void setTemplateDuVillage(List<Batiment> template) {
		this.batimentsDuTemplateDuVillage = template;
	}
	
	
	
	
	
	
	
	public boolean getBesoinMarche() {
		return besoinMarche;
	}


	public void setBesoinMarche(boolean besoinMarche) {
		this.besoinMarche = besoinMarche;
	}

	
	
	
	
	
	

	public List<Batiment> getBatimentsDuTemplateDuVillage() {
		return batimentsDuTemplateDuVillage;
	}


	public void setBatimentsDuTemplateDuVillage(
			List<Batiment> batimentsDuTemplateDuVillage) {
		this.batimentsDuTemplateDuVillage = batimentsDuTemplateDuVillage;
	}



	

	

	public int getChampMin() {
		return champMin;
	}


	public void setChampMin(int champMin) {
		this.champMin = champMin;
		//if (champMin <= 10 ){
		TeamplatesDeVillages template = new TeamplatesDeVillages();
		List<Batiment> tem = template.etablirTeamplatePourUnVillage(champMin);
		this.setTemplateDuVillage(tem);
		//}
	}




	public int getNombreDeMarchands() {
		return NombreDeMarchands;
	}


	public void setNombreDeMarchands(int nombreDeMarchands) {
		NombreDeMarchands = nombreDeMarchands;
	}




	public int getPhalanges() {
		return phalanges;
	}


	public void setPhalanges(int phalanges) {
		this.phalanges = phalanges;
	}


	public int getEpees() {
		return epees;
	}


	public void setEpees(int epees) {
		this.epees = epees;
	}


	public int getSpy() {
		return spy;
	}


	public void setSpy(int spy) {
		this.spy = spy;
	}


	public int getToutatis() {
		return toutatis;
	}


	public void setToutatis(int toutatis) {
		this.toutatis = toutatis;
	}


	public int getHeduins() {
		return heduins;
	}


	public void setHeduins(int heduins) {
		this.heduins = heduins;
	}


	public int getDruides() {
		return druides;
	}


	public void setDruides(int druides) {
		this.druides = druides;
	}


	public int getColons() {
		return colons;
	}


	public void setColons(int colons) {
		this.colons = colons;
	}



	public ArrayList<Ordre> listeOrdres = new ArrayList();	
	private int manqueDeBois;
	private int manqueDeArgile;
	private int manqueDeFer ;
	private int manqueDeCereales;
	private int maxStockDepot=720000;
	private int maxStockSilo=1200000;
	private String nom;
	private String url;
	private String x;
	private String y;
	//private List<WebElement> batiments;
	private List<Batiment> batiments = new ArrayList<Batiment>();
	private int bois;
	private int argile;
	private int fer;
	private int cereales;
	private ArrayList constructionsEnCour;
	private int tokenconstruction;
	private ArrayList batimentsEnFileDAttente;
	private double levelPlaceTournoi;
	private boolean champsFinis;
	private int besoinDeFete;
	private boolean villagePillage;
	private boolean villageCapitale;
	private boolean besoinDeNpc;
	private boolean besoinMarche;
	private int NombreDeMarchands;
	private int phalanges;
	private int epees;
	private int spy;
	private int toutatis;
	private int heduins;
	private int druides;
	private int colons;
	

	private boolean cropDeath;
	private boolean besoinDeConstruction;
	private List<Batiment> batimentsDuTemplateDuVillage = new ArrayList<Batiment>();
	private int champMin;
	
	
	
	
	
	
	
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

	
	
	
	
	
	
	
	
	void updateRessources(Travian t) {
		
		Village village	= t.villageEnCours();
	
		String bois =t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"l1\"]")).getText().replace(" ", "");
		int stockBois = Integer.parseInt(bois);
		String argile = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"l2\"]")).getText().replace(" ", "");
		int stockArgile = Integer.parseInt(argile);
		String fer = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"l3\"]")).getText().replace(" ", "");
		int stockFer = Integer.parseInt(fer);
		String cereales = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"l4\"]")).getText().replace(" ", "");
		int stockCereales = Integer.parseInt(cereales);

		village.setBois(stockBois);
		village.setArgile(stockArgile);
		village.setFer(stockFer);
		village.setCereales(stockCereales);

		
		String maxDepot = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"stockBarWarehouse\"]")).getText().replace(" ", "");
		int maxStockDepot = Integer.parseInt(maxDepot);
		
		String maxSilo = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"stockBarGranary\"]")).getText().replace(" ", "");
		int maxStockSilo = Integer.parseInt(maxSilo);
		
		village.setMaxStockDepot(maxStockDepot);
		village.setMaxStockSilo(maxStockSilo);

		System.out.println("Update Ressources de : " +village.getNom());
	
}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	void voirListeDeConstruction(Travian t) {
		Village village = t.villageEnCours();
		
		List<WebElement> test = null;
		int constructionEnCours = 0;
		
		try {
		test = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"content\"]/div[2]/div[10]/ul/li"));
		
			
		if (test.size() < 1){
			village.setTokenconstruction(constructionEnCours);
			System.out.println("Pas de construction en cours ");
			}
		
		if (test.size()>= 1) { //(test != null)
			System.out.println(test.size()+" Construction de  deja en cours");
			constructionEnCours = test.size();
			village.setTokenconstruction(constructionEnCours);
			}
		}catch  (Exception e) {village.setTokenconstruction(constructionEnCours);}
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void voirTroupesDuVillage(Travian t){
		//compte.getDriver().get("http://ts4.travian.fr/dorf1.php?newdid=6681&");
		Village village = t.villageEnCours();
		boolean troupesAQuai = false;
		////*[@contains, "Éclairs de Toutatis"]
		try {
		List<WebElement> troupesDuVillage = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"troops\"]/tbody/tr"));
		for (WebElement touta : troupesDuVillage) { 
			boolean troupesPresentes = touta.findElement(By.className("un")).getText().contains("Éclairs de Toutatis");//Éclairs de Toutatis
			int nombreTroupesPresentes = Integer.parseInt(touta.findElement(By.className("num")).getText());
			if (troupesPresentes == true) {village.setVillagePillage(true);}
				if(troupesPresentes && nombreTroupesPresentes >= 10){
					troupesAQuai = true;
				}
			
		
		}//fin for
		}catch(Exception e){}//fin Try
		if (troupesAQuai){
			t.pillage();	
		}
		else {System.out.println("Pas de Troupes -> pas de pillages");}
				
	}//fin
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	void chargerChamps(Travian t) {
		// TODO  Mettre ce code sir la classe Village
		
		Village village = t.villageEnCours(); // pas utilisee ici
		
		//////////////////////////////////////////////////////
		// se replacer sur la bonne page si un module est rester ailleur
		String urlTest = null;
		try {
			urlTest = t.getCompte().getDriver().getCurrentUrl().split(".php")[0].split(".fr/")[1];
		}catch(Exception e){System.out.println("echec urlTest1 ");} 
		
		if (!urlTest.contains("dorf1")){
		t.getCompte().getDriver().get(t.getCompte().getServer()+"dorf1.php"); 
		t.randomsleep.court();
		}
		//////////////////////////////////////////////////////
		
		List<WebElement> listeWebelementChamps = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"rx\"]/area"));
		ArrayList<Integer> listeLevelsChamps = new ArrayList<Integer>();
		ArrayList<String> listeNomsChamps = new ArrayList<String>();
		
		//On verifie que lon est sur la page des champs de ressources
		if (t.getCompte().getDriver().getCurrentUrl().contains("dorf1.php")) {
			
			//On liste les elements necesaires a la comparaison des champs
			int i = 0;
			while (i < 18) {

				String nomChamp = listeWebelementChamps.get(i).getAttribute("alt");
				listeNomsChamps.add(nomChamp);
				listeLevelsChamps.add(Integer.parseInt(listeWebelementChamps.get(i).getAttribute("alt").split("Niveau ")[1]));
				i++;
				if (i == 18){
				System.out.println("Liste des "+ i +" champs : " + listeLevelsChamps+ "");
				}
			}

			//On determine le niveau des champs le plus petit
			t.randomsleep.court();
			champMin = Collections.min(listeLevelsChamps);
			village.setChampMin(champMin);
			if (champMin >= 10){village.setChampsFinis(true);}else{village.setChampsFinis(false);}
			if (champMin > 10){village.setVillageCapitale(true);}else{village.setVillageCapitale(false);}
			System.out.println("Min val: " + champMin);
			}
	}	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
void chargerBatiments(Travian t){
		
		if (!t.getCompte().getDriver().getCurrentUrl().contains("dorf2.php")) {
			t.randomsleep.court();
			t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf2.php");
			t.randomsleep.court();
			}
		
		Village village = t.villageEnCours();
		List<WebElement> listeDesBatiments = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"clickareas\"]/area"));
		//on cree une lsite temporaire poure lenvoyer au village une fois la liste complete.
		List<Batiment> listeDesBatimentsVillage = new ArrayList(); 
		
		
		for (WebElement webBatiment : listeDesBatiments) {
			//on intialise les varible
			String nomBatiment = null;
			int levelBatiment = 0;
			String slotBatiment = null;
			boolean trouver = false;
			
			//on les remplis
			try{
			 nomBatiment = webBatiment.getAttribute("alt").split(" <span")[0];
			 levelBatiment = Integer.parseInt(webBatiment.getAttribute("alt").split("<span class=\"level\">Niveau ")[1].split("</span>")[0]);
			 //reperer conctructions en cours 
			 if (webBatiment.getAttribute("alt").contains("Amélioration en cours")){
				int enCoursVersLevel = Integer.parseInt(webBatiment.getAttribute("alt").split("Amélioration en cours vers le niveau ")[1].split("</span>")[0]);
				 levelBatiment = enCoursVersLevel;
				 
			 }
			 slotBatiment = webBatiment.getAttribute("href").split("id=")[1];
			 // si un slot est vide : on le nomme
			}catch (Exception e){
				nomBatiment = webBatiment.getAttribute("alt");
				levelBatiment = 0;
				slotBatiment = webBatiment.getAttribute("href").split("id=")[1];
			}
			
			
			//pour chaque batiment du village on regarde si le batiment y est. Sil y est on ne fait rien et on passe au suivant
			try {
				
			for (Batiment batiment : village.getBatiments()){
				
				if (batiment.getNomBatiment().equals(nomBatiment) && batiment.getSlotBatiment().equals(slotBatiment)){
					trouver=true;
					batiment.setLevelBatiment(levelBatiment);
					break;
					
				}
			}
				
			}catch (Exception e ){trouver=false;}
			//si le batiment ny est pas on le met dans la liste temporaire
			if (trouver==false){
				Batiment newBatiment = new Batiment();
				newBatiment.setNomBatiment(nomBatiment);
				newBatiment.setSlotBatiment(slotBatiment);
				newBatiment.setLevelBatiment(levelBatiment);
				listeDesBatimentsVillage.add(newBatiment);
				
				//on envois la liste terminee au village concerne
				village.setBatiments(listeDesBatimentsVillage);
			
			}
			}
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void monterChamps(Travian t) {
	// TODO  Mettre ce code sir la classe Village
	Village village = t.villageEnCours();

	List<WebElement> listeWebelementChamps = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"rx\"]/area"));
	int token = village.getTokenconstruction();

	if (token < 2 ){
		try { //secu anti rechargement
			//Lancer construction champs
			// trouver lien du premier plus petit
			int g = 0;
			while (g < 18) {
				//on met a jour le token apres une eventuelle construction
				village.voirListeDeConstruction(t);
				token = village.getTokenconstruction();
				//on reverifie le token pour pas boucler plus que necessaire
				if (token < 2 ){
					//On recharge la liste apres un eventuel rechargement
					listeWebelementChamps = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"rx\"]/area")); 
					int lien = Integer.parseInt(listeWebelementChamps.get(g).getAttribute("alt").split("Niveau ")[1]); //bug ici au retour
					//String lienNom = listeWebelementChamps.get(g).getAttribute("alt").split("Niveau ")[0];

					//System.out.println("valeur g : " + g);

					///test ressources///////////////////////////////////////////////////////////////////////
					WebElement tagUnderConstruction = null ;
					try{
						tagUnderConstruction = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"village_map\"]/div["+(g+1)+"][contains(@class, 'underConstruction')]"));
					}catch  (Exception e) {}
					if (lien == champMin && tagUnderConstruction == null) {
						boolean retrytoken = false;
						int boisNecessaire = 0;
						int argileNecessaire = 0;
						int ferNecessaire = 0;
						int cerealesNecessaire = 0;
						System.out.println("try lien==chamPmin : " + lien + " et : "+ champMin); 

						//survol souris du champs = a champMin
						Actions builder = new Actions(t.getCompte().getDriver());
						builder.moveToElement(listeWebelementChamps.get(g));		
						builder.perform();
						t.randomsleep.court();

						//choper le tableau des ressources necessaires pour le champs en cours
						List<WebElement> ressourcesNecessaires = listeWebelementChamps.get(g+1).findElements(By.xpath("//*[@class='showCosts']/span"));

						//	System.out.println("valeur ressourcesnecessaire "+ ressourcesNecessaires.get(0).getText());
						//	System.out.println("valeur ressourcesnecessaire "+ ressourcesNecessaires.get(1).getText());
						//	System.out.println("valeur ressourcesnecessaire "+ ressourcesNecessaires.get(2).getText());
						//	System.out.println("valeur ressourcesnecessaire "+ ressourcesNecessaires.get(3).getText());

						//correction bug de MouseHover
						if (ressourcesNecessaires.get(0).getText().isEmpty()) {retrytoken = true;}
						if (retrytoken == true) {	
							System.out.println("Retry hover");
							Actions retry = new Actions(t.getCompte().getDriver());
							retry.moveToElement(listeWebelementChamps.get(g));		
							retry.perform();
							t.randomsleep.court();
							ressourcesNecessaires = listeWebelementChamps.get(g).findElements(By.xpath("//*[@class='showCosts']/span"));
							//	System.out.println("valeur ressourcesnecessaire "+ ressourcesNecessaires.get(0).getText());
							//	System.out.println("valeur ressourcesnecessaire "+ ressourcesNecessaires.get(1).getText());
							//	System.out.println("valeur ressourcesnecessaire "+ ressourcesNecessaires.get(2).getText());
							//	System.out.println("valeur ressourcesnecessaire "+ ressourcesNecessaires.get(3).getText());
							retrytoken = false;
						}

						if (retrytoken == false){					
							//Parse 	
							boisNecessaire = Integer.parseInt(ressourcesNecessaires.get(0).getText());
							argileNecessaire = Integer.parseInt(ressourcesNecessaires.get(1).getText());
							ferNecessaire = Integer.parseInt(ressourcesNecessaires.get(2).getText());
							cerealesNecessaire = Integer.parseInt(ressourcesNecessaires.get(3).getText());
							System.out.println("parse ok");
						}
						// On fait la comparaison des ressources avec le stock du village en cours
						//Village2 village = villageEnCours();
						village.updateRessources(t);
						int stockBois = village.getBois();
						int stockArgile = village.getArgile();
						int stockFer = village.getFer();
						int stockCereales = village.getCereales();

						//si ressources ok 
						if (stockBois >= boisNecessaire&& stockArgile >= argileNecessaire&& stockFer >= ferNecessaire&& stockCereales >= cerealesNecessaire) {
							System.out.println("ressource ok");
							// go la page
							listeWebelementChamps.get(g).click();
							t.randomsleep.court();
							//trouver le bouton vert
							WebElement bouttonvert = null;
							try {
								bouttonvert = t.getCompte().getDriver().findElement(By.xpath("//button[@class=\"green build\"]"));
							}catch  (Exception e) {
								System.out.println("Bouton vert non present => Batiment en cour probable");
								t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf1.php");
								t.randomsleep.classic();
								break;//non teste
							}
							//cliquer sur le bouton vert
							t.randomsleep.classic();
							if (bouttonvert != null){
								bouttonvert.click();
								System.out.println("Lancement d'un Champs de (valeur g) "+ g + " (g-1) sur le Slot " + (g+1) + "");
								t.randomsleep.court();}


						} else {
							System.out.println("ressource manquante");}
					} //fin if lien== champMin
					g++;
				}//fin if token de verification
				else {System.out.println("2 Champs lance");
				break;}
			}// fin while g <18
		}catch(Exception e){System.out.println("Les Retours Pillage cause un echec");}
	}// fin if token <2
	village.voirListeDeConstruction(t);

}//fin monterchamps

/* } */

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
public boolean construireBatiments(String batimentAConstruire, int levelVoulu, Travian t){
	t.randomsleep.court();
	
//	if (!compte.getDriver().getCurrentUrl().contains("dorf2.php")) {compte.getDriver().get(compte.getServer() + "dorf2.php");}
	//randomsleep.court();
	Village village = t.villageEnCours();
	updateRessources(t);
	

	
	int boisNecessaire = 0;
	int argileNecessaire = 0;
	int ferNecessaire = 0;
	int cerealesNecessaire = 0;
	boolean possibleOuPas = true;
	

	
	
	List<WebElement> listeDesBatiments = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"clickareas\"]/area"));
	List<Batiment> batimentsDeLaPage = new ArrayList<Batiment>();
	//WebElement areaBatiment;
	
	
	
	for (WebElement webBatiment : listeDesBatiments ){
		try {
		String nom = webBatiment.getAttribute("alt").split(" <span")[0];
		int level = Integer.parseInt(webBatiment.getAttribute("alt").split("<span class=\"level\">Niveau ")[1].split("</span>")[0]);
		String slot = webBatiment.getAttribute("href").split("id=")[1];
		
		Batiment batiment = new Batiment(nom, level, slot);
		batimentsDeLaPage.add(batiment);
		
		}catch (Exception e){
			String nom = webBatiment.getAttribute("alt");
			int level = 0;
			String slot = webBatiment.getAttribute("href").split("id=")[1];
			String alt = webBatiment.getAttribute("alt");
			
			Batiment batiment = new Batiment(nom, level, slot, alt);
			batimentsDeLaPage.add(batiment);
		}
		
		}
	////////////////////////////////////////////
	
	
	for(Batiment construire1 : batimentsDeLaPage) {
		//listeDesBatiments = compte.getDriver().findElements(By.xpath("//*[@id=\"clickareas\"]/area"));
		if (construire1.getNomBatiment().contains(batimentAConstruire)){
			int level = construire1.getLevelBatiment();
			
			if (level < levelVoulu && village.getTokenconstruction() < 2){
				
				//Parse
				try {
					
					listeDesBatiments = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"clickareas\"]/area"));
					for (WebElement as : listeDesBatiments){////////////////////////////////ici go to stale, recgargement de page souci
						
						//voirListeDeConstruction(t);
											
						if (as.getAttribute("alt").contains(construire1.getNomBatiment())   &&   as.getAttribute("href").split("id=")[1].contains(construire1.getSlotBatiment())   &&   village.getTokenconstruction() < 2  ){
				 boisNecessaire = Integer.parseInt(as.getAttribute("alt").split("r1\" src=\"img/x.gif\" />")[1].split("</span>")[0].trim());
				 argileNecessaire = Integer.parseInt(as.getAttribute("alt").split("r2\" src=\"img/x.gif\" />")[1].split("</span>")[0].trim());
				 ferNecessaire = Integer.parseInt(as.getAttribute("alt").split("r3\" src=\"img/x.gif\" />")[1].split("</span>")[0].trim());
				 cerealesNecessaire = Integer.parseInt(as.getAttribute("alt").split("r4\" src=\"img/x.gif\" />")[1].split("</span>")[0].trim());
				 System.out.println("[construireBatiment]parse ok");
						
				
				// on fais la comparaison des ressources avec le stock du village en cours
				updateRessources(t);
				int stockBois = village.getBois();
				int stockArgile = village.getArgile();
				int stockFer = village.getFer();
				int stockCereales = village.getCereales();
				//si ressources ok 
				if (stockBois >= boisNecessaire&& stockArgile >= argileNecessaire&& stockFer >= ferNecessaire&& stockCereales >= cerealesNecessaire) {
					System.out.println("[construireBatiment] Ressources ok");
					// go la page
					as.click();
					t.randomsleep.court();
					
					//si cest un marche ou autre cliquer le bon tab
					try {	
					List<WebElement> listeDesTabs = t.getCompte().getDriver().findElements(By.xpath("//*[@class=\"tabItem\"]"));
					for(WebElement tabGestion : listeDesTabs){
						
						if(tabGestion.getText().contains("Gestion")){
						tabGestion.click();
						t.randomsleep.court();
						break;
					}
						
					}
					}catch (Exception e){System.out.println("bug :)");}
					
					//cliquer sur le bouton vert
					WebElement bouttonvert = null;
					try {
					bouttonvert = t.getCompte().getDriver().findElement(By.xpath("//button[@class=\"green build\"]"));
					}catch  (Exception e) {
						System.out.println("[construireBatiment] Bouton vert non present => Champ en cour probable");
						possibleOuPas = false;
						t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf2.php");
						t.randomsleep.classic();
						break;
					}
					
					if (bouttonvert != null){
					bouttonvert.click();
					System.out.println("[construireBatiment] Lancement "+batimentAConstruire);
					possibleOuPas = true;
					t.randomsleep.court();
					listeDesBatiments = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"clickareas\"]/area"));
					break;
					}	
				} else { System.out.println("[construireBatiment] Pas assez de Ressources pour faire un/une "+batimentAConstruire);}
					}	
						}//break;}
				}catch (Exception e){System.out.println("[construireBatiment] Batiment de niveau deja en construction ou deja au level demande "+ batimentAConstruire );voirListeDeConstruction(t);}
				
				} else {
					System.out.println("[construireBatiment] "+batimentAConstruire+" deja a 20");
					possibleOuPas = false;}
				
				
				}
				
			}
		voirListeDeConstruction(t);
		return possibleOuPas;
		
}



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
public void lancerFete(Travian t){  // a modifier : regarder avant les recap pour voir si une fete est deja lancee... sinon ca clic pour rien
	t.randomsleep.court();
	t.getCompte().getDriver().get(t.getCompte().getServer()+"dorf2.php");
	t.randomsleep.court();
	
	try {
	List<WebElement> listeDesBatiments = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"clickareas\"]/area"));
	int hotelNonPresent = 1;
	
	for (WebElement batiment : listeDesBatiments){
		if (batiment.getAttribute("alt").contains("Hôtel de Ville")){
			hotelNonPresent = 0;
			batiment.click();
			
			t.randomsleep.court();
			
			//on fait une liste des boutons de lancement de fete
			List<WebElement> boutons = null;
			try {
			boutons = t.getCompte().getDriver().findElements(By.xpath("//*[@value=\"influence\"]"));
			}catch(Exception e){System.out.println("[Fete] Erreure de listage des boutons Fete ");} 
			
			//on verifie si des boutons de lancement de fetes sont present
			if (boutons.size() > 0) {
			//on tente une grande fete d'abord
			try {
				if(boutons.get(1).getText().contains("influence")){
					boutons.get(1).click();
					System.out.println("[Fete] Grande fete lancee");
					t.randomsleep.court();
				}
				}catch(Exception e){}
				//puis sinon on tente une ptite fete
			try {	
				if(boutons.get(0).getText().contains("influence")){
					boutons.get(0).click();
					System.out.println("[Fete] Petite fete lancee");
					t.randomsleep.court();
					}
			}catch(Exception e){}
			
			}
			else {System.out.println("[Fete] Une Fete Est Deja en cours");}
			
			break;
		}	
		
	}
	if (hotelNonPresent == 1 ){System.out.println("[Fete] Pas D'hotel de ville");}
	}catch(Exception e){System.out.println("[Fete] echec lancer fete interne");} 
	
	//on retourne sur la page des champs pour le village suivant
	t.randomsleep.court();
	t.getCompte().getDriver().get(t.getCompte().getServer()+"dorf1.php");
	t.randomsleep.court();
	
	
	
	
	
	
}	
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
	
	
	
		
	
	
	public void EssayerConstruireBatiments(Travian t, Village village ){
		if (champMin <  10 ){
		monterChamps(t);
		}
		
		if (village.getTokenconstruction() < 2 && village.getChampMin() <=10 || village.getTokenconstruction() < 2 && village.getVillageCapitale() == true){
			chargerBatiments(t);
//	try {
		for (int i=0; i <=1 && village.getTokenconstruction() < 2 ;i++){
			//chargerBatiments(t);
		for (Batiment batimentDuteamplate : village.getTemplateDuVillage()){
			for (Batiment batimentDuVillage : village.getBatiments()) {
				if (village.getTokenconstruction() < 2){
				if (batimentDuVillage.getNomBatiment().equals(batimentDuteamplate.getNomBatiment())){
					if (batimentDuVillage.getLevelBatiment() < batimentDuteamplate.getLevelBatiment() ){
					construireBatiments(batimentDuteamplate.getNomBatiment(), batimentDuteamplate.getLevelBatiment(), t);
					
				}
			}
		  }
		
	}
		}
	//	}catch (Exception e) {System.out.println(": Batiment absent sur  palier 1");}
		}
	}
	
}


	public ArrayList<Ordre> getListeOrdres() {
		return listeOrdres;
	}


	public void setListeOrdres(ArrayList<Ordre> listeOrdres) {
		this.listeOrdres = listeOrdres;
	}
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
