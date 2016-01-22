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
				
				if (village.getChampsFinis() == false){
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
					int manqueCereales = village.getMaxStockDepot() - village.getCereales() ;
					village.setManqueDeCereales(manqueCereales);
					
					if(manqueB || manqueA || manqueF || manqueC){
					
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
					
				}
	
	
}
	
	
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
	
	
	public void envoyerMarchands(Village villageBis, Village village) {

		
		
	} 
	
	public void evacuerSurplusCereales(Travian t, Village village, ArrayList<Village> listeDeVillages ) {
	try {
		if (((village.getCereales() >= village.getMaxStockSilo()/100*90))&&(village.getVillageCapitale()==false)) {
			t.getCompte().getDriver().findElement(By.xpath("//*[contains(@class, 'marketWhite')]")).click();
			t.randomsleep.court();
		/*	try {	if (!t.getCompte().getDriver().getCurrentUrl().equals(t.getCompte().getServer()+"build.php?t=5&id=32")){
				t.getCompte().getDriver().findElement(By.xpath("//*[contains(@href, 'build.php?t=5&id=32')]")).click();
				t.randomsleep.court();//ici test de connerie pour GitHub
				}}catch(Exception e){System.out.println("Echec selection tab du marche ");}*/
		//t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"r4\"]")).clear();
		t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"r4\"]")).sendKeys("750");
		t.randomsleep.court();
		t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"addRessourcesLink4\"]")).click();
		t.randomsleep.court();
		t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"x2\"]/option[3]")).click();
		t.randomsleep.court();
		
		 //if (cap en neg){ village a envoyer}
		  //else { 
		int pourcentageDeCereales = 10;
		boolean continuer = true;
		String villageCibleNom = "nompardefault";
		   for (Village villageCible : listeDeVillages) {
			   if (villageCible.getCereales() <= villageCible.getMaxStockSilo()/100*pourcentageDeCereales){
				 villageCibleNom = villageCible.getNom(); 
				 continuer = false;
				 }
			   else pourcentageDeCereales = pourcentageDeCereales+10;
		   } 
		t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"enterVillageName\"]")).sendKeys(villageCibleNom);
		t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"enabledButton\"]/div/div[2]")).click();
		t.randomsleep.court();
		t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"enabledButton\"]/div/div[2]")).click();
		
		}		
	}catch(Exception e){System.out.println("Echec evacuation cereales marche, Pas de marche ? ");}
	}
}