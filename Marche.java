package botpackage;

import java.util.ArrayList;

import org.openqa.selenium.By;

public class Marche {

	public Marche() {

	}

	public static void main(String[] args) {


	}


	// TODO Auto-generated catch block
	public void etablirBesoinEnRessources(Travian t, Village village, ArrayList<Village> listeDeVillages) {
		String nouveauVillage = "Nouveau village";

		//if (village.getChampsFinis() == false){
		boolean manqueB = village.getBois() <= village.getMaxStockDepot()/100*30;
		int manqueBois = village.getMaxStockDepot() - village.getBois() ;
		village.setManqueDeBois(manqueBois);

		boolean manqueA = village.getArgile() <= village.getMaxStockDepot()/100*30;
		int manqueArgile = village.getMaxStockDepot() - village.getArgile() ;
		village.setManqueDeArgile(manqueArgile);

		boolean manqueF = village.getFer() <= village.getMaxStockDepot()/100*30;
		int manqueFer = village.getMaxStockDepot() - village.getFer() ;
		village.setManqueDeFer(manqueFer);

		boolean manqueC = village.getCereales() <= village.getMaxStockSilo()/100*30;
		int manqueCereales = village.getMaxStockSilo() - village.getCereales() ;
		village.setManqueDeCereales(manqueCereales);

		/*	if(manqueB || manqueA || manqueF || manqueC){

				int pourcentage = 90 ;
				boolean continuer = true;

				//	if (listeDeVillages.size() > 1 ){
				while (continuer == true){
					if (listeDeVillages.size() <= 1 ){continuer=false;break;}
					for(Village villageBis : listeDeVillages){

						if(villageBis.getChampsFinis() == true){
							boolean tropBois = villageBis.getBois() >= villageBis.getMaxStockDepot()/100*pourcentage;
							boolean tropArgile = villageBis.getArgile() >= villageBis.getMaxStockDepot()/100*pourcentage;
							boolean tropFer = villageBis.getFer() >= villageBis.getMaxStockDepot()/100*pourcentage;
							boolean tropCereales = villageBis.getCereales() >= villageBis.getMaxStockSilo()/100*pourcentage;	

							if (tropBois && tropArgile && tropFer && tropCereales){
								//marche2(t, village, listeDeVillages);
								continuer = false;
								break;
							}

						}
					}

					pourcentage = pourcentage-10;
					if (pourcentage <= 10 ) {continuer =false; break;}
				}

			}
			//	}	
		 */
	}







////iunutilise
	public void marche2(Travian t, Village village, ArrayList<Village> listeVillage) {

		try {
			if (((village.getCereales() >= village.getMaxStockSilo()/100*90))&&(village.getVillageCapitale()==false)) {
				t.getCompte().getDriver().findElement(By.xpath("//*[contains(@class, 'marketWhite')]")).click();
				t.randomsleep.court();
				/*	try {	if (!t.getCompte().getDriver().getCurrentUrl().equals(t.getCompte().getServer()+"build.php?t=5&id=32")){
					t.getCompte().getDriver().findElement(By.xpath("//*[contains(@href, 'build.php?t=5&id=32')]")).click();
					t.randomsleep.court();
					}}catch(Exception e){System.out.println("Echec selection tab du marche ");}*/
				//t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"r4\"]")).clear();
				t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"r4\"]")).sendKeys("99999");
				t.randomsleep.court();
				t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"addRessourcesLink4\"]")).click();
				t.randomsleep.court();
				t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"x2\"]/option[3]")).click();
				t.randomsleep.court();
				t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"enterVillageName\"]")).sendKeys("1 Village");
				t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"enabledButton\"]/div/div[2]")).click();
				t.randomsleep.court();
				t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"enabledButton\"]/div/div[2]")).click();

			}		
		}catch(Exception e){System.out.println("Echec evacuation cereales marche ");}
	}













	////////dans la page marche
	public int updateNombreDeMarchandsDispo(Travian t){ 
		String nombreMarchandDispoString = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"build\"]/div[2]/div[10]/span")).getText().replaceAll("\\W", "");
		int nombreMarchandDispoInteger = Integer.valueOf(nombreMarchandDispoString); 
		return nombreMarchandDispoInteger;
	}
	public int updateQuantiteMaxTransporteParMarchand(Travian t){
		String quantiteMaxParMarchandString = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"addRessourcesLink4\"]")).getText().replaceAll("\\W", "");
		int quantiteMaxParMarchandInteger = Integer.valueOf(quantiteMaxParMarchandString);
		return quantiteMaxParMarchandInteger;
	}








	///////////////////////////////////////////////
	public void evacuerSurplusRessources(Travian t, Village village, ArrayList<Village> listeDeVillages ) {
		village.listeOrdres.clear();

		try {
			//Maj 
			village.updateRessources(t);
			//test des ressources
			int pourcentage = 85; //pourcentage de remplissage au dela duquel s'executer
			int pourcentageNePasLaisserLeVillageSourceEnDessousDe = 75;
			boolean tropBois = village.getBois() >= village.getMaxStockDepot()/100*pourcentage;
			boolean tropArgile = village.getArgile() >= village.getMaxStockDepot()/100*pourcentage;
			boolean tropFer = village.getFer() >= village.getMaxStockDepot()/100*pourcentage;
			boolean tropCereales = village.getCereales() >= village.getMaxStockSilo()/100*pourcentage;
			//on trouve combien de ressources necessite d'etre evacuee
			int nombreDeBesoin = 0 ; // on remet a zero //par default
			if (tropBois){nombreDeBesoin++;}
			if (tropArgile){nombreDeBesoin++;}
			if (tropFer){nombreDeBesoin++;}
			if (tropCereales){nombreDeBesoin++;}

			if(nombreDeBesoin >= 1 ){
				t.getCompte().getDriver().findElement(By.xpath("//*[contains(@class, 'marketWhite')]")).click();
				t.randomsleep.court();

				//maj
				int marchandsDisponibles = updateNombreDeMarchandsDispo(t);
				int quantite = updateQuantiteMaxTransporteParMarchand(t);

				
				if (marchandsDisponibles > 0 ){
				
				//On alloue le nombre de marchands par type de ressources
				int marchandsAllouesParRessource = marchandsDisponibles/nombreDeBesoin;

				//on fait une liste//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				if(tropBois){
					t.randomsleep.tcourt(); //test
					int i=0;
					//on s'assure de ne pas envoyer plus de tant de pourcents d'une ressources
					int marchandsAllouesPourBois = marchandsAllouesParRessource;
					while (marchandsAllouesPourBois*quantite > village.getMaxStockDepot()/100*pourcentageNePasLaisserLeVillageSourceEnDessousDe){
						marchandsAllouesPourBois--;
					}
					//
					String nomOrdre = "bois";
					Ordre ordreDeBois = new Ordre(); 
					village.listeOrdres.add(ordreDeBois);
					ordreDeBois.setNomOrdre(nomOrdre);
					ordreDeBois.setNombreDeClic(marchandsAllouesPourBois);

				}

				if(tropArgile){
					t.randomsleep.tcourt(); //test
					int i=0;
					//on s'assure de ne pas envoyer plus de tant de pourcents d'une ressources
					int marchandsAllouesPourArgile = marchandsAllouesParRessource;
					while (marchandsAllouesPourArgile*quantite > village.getMaxStockDepot()/100*pourcentageNePasLaisserLeVillageSourceEnDessousDe){
						marchandsAllouesPourArgile--;
					}
					//
					String nomOrdre = "argile";
					Ordre ordreDeArgile = new Ordre(); 
					village.listeOrdres.add(ordreDeArgile);
					ordreDeArgile.setNomOrdre(nomOrdre);
					ordreDeArgile.setNombreDeClic(marchandsAllouesPourArgile);

				}

				if(tropFer){
					t.randomsleep.tcourt(); //test
					int i=0;
					//on s'assure de ne pas envoyer plus de tant de pourcents d'une ressources
					int marchandsAllouesPourFer = marchandsAllouesParRessource;
					while (marchandsAllouesPourFer*quantite > village.getMaxStockDepot()/100*pourcentageNePasLaisserLeVillageSourceEnDessousDe){
						marchandsAllouesPourFer--;
					}
					//
					String nomOrdre = "fer";
					Ordre ordreDeFer = new Ordre(); 
					village.listeOrdres.add(ordreDeFer);
					ordreDeFer.setNomOrdre(nomOrdre);
					ordreDeFer.setNombreDeClic(marchandsAllouesPourFer);


				}

				if(tropCereales){
					t.randomsleep.tcourt(); //test
					int i=0;
					//on s'assure de ne pas envoyer plus de tant de pourcents d'une ressources
					int marchandsAllouesPourCereales = marchandsAllouesParRessource;
					while (marchandsAllouesPourCereales*quantite > village.getMaxStockSilo()/100*pourcentageNePasLaisserLeVillageSourceEnDessousDe){
						marchandsAllouesPourCereales--;
					}
					//
					String nomOrdre = "cereales";
					Ordre ordreDeCereales = new Ordre(); 
					village.listeOrdres.add(ordreDeCereales);
					ordreDeCereales.setNomOrdre(nomOrdre);
					ordreDeCereales.setNombreDeClic(marchandsAllouesPourCereales);

				}

				envoyerMarchandsSelectionDuVillageCible(t, village, listeDeVillages, quantite);


				}
			}

		}catch(Exception e){System.out.println("Echec evacuation cereales marche, Pas de marche ? ");}
	}




	//Selection du village cible pour chaque ordre
	public void envoyerMarchandsSelectionDuVillageCible(Travian t, Village village, ArrayList<Village> listeDeVillages, int quantite) {
		//if (cap en neg){ village a envoyer}
		//else { 
		int pourcentage = 10; //on par du bas, ne pas toucher svp
		boolean continuer = true;
		String villageCibleNom = "nompardefault";
		String savePourFin = villageCibleNom;



		//
		for(Ordre ordre : village.listeOrdres){
			continuer = true;
			while (continuer == true){
				int ressource = 0;
				int maxDepotSilo = 0; 
				int manqueDeCetteRessource =0;

				for (Village villageCible : listeDeVillages) {
					if(ordre.getNomOrdre() == "bois"){ ressource = villageCible.getBois(); maxDepotSilo = villageCible.getMaxStockDepot();  manqueDeCetteRessource = villageCible.getManqueDeBois(); }
					if(ordre.getNomOrdre() == "argile"){ressource = villageCible.getArgile();maxDepotSilo = villageCible.getMaxStockDepot();manqueDeCetteRessource = villageCible.getManqueDeArgile();}
					if(ordre.getNomOrdre() == "fer"){ressource = villageCible.getFer();maxDepotSilo = villageCible.getMaxStockDepot();manqueDeCetteRessource = villageCible.getManqueDeFer();}
					if(ordre.getNomOrdre() == "cereales"){ressource = villageCible.getCereales();maxDepotSilo = villageCible.getMaxStockSilo();manqueDeCetteRessource = villageCible.getManqueDeCereales(); }

					if (!villageCible.getNom().equals(village.getNom())){
						if (ressource <= maxDepotSilo/100*pourcentage &&  manqueDeCetteRessource > ordre.getNombreDeClic()*quantite ){
							villageCibleNom = villageCible.getNom();
							ordre.setVillageCible(villageCibleNom);
							continuer = false;
							break;
						}
						if (pourcentage == 100){continuer=false;}
						else pourcentage = pourcentage+10;

					}
				}  
			}
		}
		if(!villageCibleNom.equals(savePourFin)){
			envoyerMarchandsCliquage(t, village, listeDeVillages, quantite);
		}
	}


		// cliquer en regroupant les Ordre ayant la meme cible
	public void envoyerMarchandsCliquage(Travian t, Village village, ArrayList<Village> listeDeVillages, int quantite) {
		int typeDeRessource =0; 
		String cible = "null";

		for (Village villageCiblebis : listeDeVillages){
			for(Ordre ordre : village.listeOrdres){
				if(ordre.getVillageCible().equals(villageCiblebis.getNom())){
					cible = ordre.getVillageCible();

					if (ordre.getNomOrdre().equals("bois")){ typeDeRessource = 1; }
					if (ordre.getNomOrdre().equals("argile")){ typeDeRessource = 2; }
					if (ordre.getNomOrdre().equals("fer")){ typeDeRessource = 3; }
					if (ordre.getNomOrdre().equals("cereales")){ typeDeRessource = 4; }
					//on clic autant de fois que de marchands attribués
					int i = 0;
					while( i < ordre.getNombreDeClic()){
						t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"addRessourcesLink"+typeDeRessource +"\"]")).click();
						i++;

						t.randomsleep.tcourt();}
				}

			}
			if (!cible.equals("null")){
				envoyerMarchands(t, cible);}

		}

	}




	//fonction envoyer sur une cible
	public void envoyerMarchands(Travian t, String villageCibleNom) {
		String savePourFin = "nompardefault";

		if(!villageCibleNom.equals(savePourFin)){
			/////mode envoyer en plusieur fois
			t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"x2\"]/option[1]")).click();
			t.randomsleep.tcourt();
			//nom du village receveur
			t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"enterVillageName\"]")).sendKeys(villageCibleNom);
			t.randomsleep.tcourt();
			t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"enabledButton\"]/div/div[2]")).click();
			t.randomsleep.court();
			t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"enabledButton\"]/div/div[2]")).click();
			System.out.println("Envoyer Ressources : "+ " envoi : "+ " de type "+ " sur "  +villageCibleNom);
		}
	}










	/*




		




	 */














} 







