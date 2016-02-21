package botpackage;


import java.util.ArrayList;
import java.util.List;

public  class   TeamplatesDeVillages {
	
	/*
	batimentsALancer.add("B�timent Principal");
	batimentsALancer.add("D�p�t de ressources");
	batimentsALancer.add("Silo de c�r�ales");
	batimentsALancer.add("Place du march�");
	batimentsALancer.add("Moulin");
	batimentsALancer.add("Boulangerie");
	batimentsALancer.add("Acad�mie");
	batimentsALancer.add("Caserne");B�cheron �curie
	*///
	
	
	//correspondances de noms
	static	 String bois ="B�cheron";
	static String cereale = "Ferme";
	static String fer= "fer";
	static String terre= "argile";
	static String grande_ecurie = "Grande �curie";
	static String grande_caserne= "Grande caserne";
	static String place_tournoi= "Place du tournoi";
	static String place_rassemblement= "Place de rassemblement";
	static String boulangerie= "Boulangerie";
	static String moulin= "Moulin";
	static String scierie= "Scierie";
	static String poterie= "Usine de Poteries"; 
	static String fonderie= "Fonderie";
	static String cachette= "Cachette";
	static String pieges = "Fabricant de pi�ges";
	static String residence = "R�sidence";
	static String atelier= "Atelier";
	static String hotel_de_ville= "H�tel de Ville";//H�tel de Ville
	static String ambassade = "Ambassade";
	static String mur = "Palissade";
	static String palais = "Palais";
	static String silo ="Silo de c�r�ales";
	static String depot ="D�p�t de ressources";
	static String batiment_principal ="B�timent Principal";
	static String empty = "Site de construction";
	static String marche = "Place du march�";
	static String academie = "Acad�mie";	
	static String caserne = "Caserne";
	static String tailleur = "Tailleur de Pierres";
	static String grandSilo = "Grand silo de c�r�ales";
	static String grandDepot = "Grand d�p�t de ressources";
 
 
	 List<Batiment> listeDeBatimentsDuTeamplate1 = new ArrayList();
	 List<Batiment> listeDeBatimentsDuTeamplate2 = new ArrayList();
	 List<Batiment> listeDeBatimentsDuTeamplate3 = new ArrayList();
	 List<Batiment> listeDeBatimentsDuTeamplate4 = new ArrayList();
	
	
	public TeamplatesDeVillages() {
	
		 listeDeBatimentsDuTeamplate1.add(new Batiment(batiment_principal, 5));
		 listeDeBatimentsDuTeamplate1.add(new Batiment(silo, 5));
		 listeDeBatimentsDuTeamplate1.add(new Batiment(depot, 5));
		 listeDeBatimentsDuTeamplate1.add(new Batiment(residence, 5));
		 listeDeBatimentsDuTeamplate1.add(new Batiment(marche, 3));
		 listeDeBatimentsDuTeamplate1.add(new Batiment(poterie, 5));
		 listeDeBatimentsDuTeamplate1.add(new Batiment(scierie, 5));
		 listeDeBatimentsDuTeamplate1.add(new Batiment(fonderie, 5));
		 listeDeBatimentsDuTeamplate1.add(new Batiment(moulin, 5));
		 listeDeBatimentsDuTeamplate1.add(new Batiment(boulangerie, 5));
		 
		 
		 listeDeBatimentsDuTeamplate2.add(new Batiment(moulin, 2));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(batiment_principal, 10));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(silo, 11));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(depot, 11));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(poterie, 5));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(scierie, 5));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(fonderie, 5));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(moulin, 5));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(boulangerie, 5));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(residence, 10));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(marche, 5));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(caserne, 3));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(palais, 10));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(tailleur, 5));
		 
		 
		 listeDeBatimentsDuTeamplate3.add(new Batiment(batiment_principal, 15));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(silo, 13));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(depot, 13));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(residence, 10));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(moulin, 4));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(poterie, 5));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(scierie, 5));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(fonderie, 5));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(boulangerie, 5));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(marche, 12));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(caserne, 5));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(academie, 10));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(palais, 20));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(tailleur, 20));
		 		 

		 listeDeBatimentsDuTeamplate4.add(new Batiment(poterie, 5));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(scierie, 5));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(fonderie, 5));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(moulin, 5));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(boulangerie, 5));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(batiment_principal, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(silo, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(depot, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(marche, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(academie, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(hotel_de_ville, 14));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(caserne, 10));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(place_rassemblement, 10));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(palais, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(tailleur, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(grandSilo, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(grandDepot, 20));
		 

	}



	public List<Batiment> getListeDeBatimentsDuTeamplate1() {
		return listeDeBatimentsDuTeamplate1;
	}
	public void setListeDeBatimentsDuTeamplate1(List<Batiment> listeDeBatimentsDuTeamplate1) {
		this.listeDeBatimentsDuTeamplate1 = listeDeBatimentsDuTeamplate1;
	}
	
	
	
	
	
	
	public List<Batiment> getListeDeBatimentsDuTeamplate2() {
		return listeDeBatimentsDuTeamplate2;
	}
	public void setListeDeBatimentsDuTeamplate2(List<Batiment> listeDeBatimentsDuTeamplate2) {
		this.listeDeBatimentsDuTeamplate2 = listeDeBatimentsDuTeamplate2;
	}
	
	
	
	
	
	
	public List<Batiment> getListeDeBatimentsDuTeamplate3() {
		return listeDeBatimentsDuTeamplate3;
	}
	public void setListeDeBatimentsDuTeamplate3(
			List<Batiment> listeDeBatimentsDuTeamplate3) {
		this.listeDeBatimentsDuTeamplate3 = listeDeBatimentsDuTeamplate3;
	}

	
	
	
	
	
	public List<Batiment> getListeDeBatimentsDuTeamplate4() {
		return listeDeBatimentsDuTeamplate4;
	}
	public void setListeDeBatimentsDuTeamplate4(
			List<Batiment> listeDeBatimentsDuTeamplate4) {
		this.listeDeBatimentsDuTeamplate4 = listeDeBatimentsDuTeamplate4;
	}



	public List<Batiment> etablirTeamplatePourUnVillage(int champMin) {
		if (champMin <= 4 ){return listeDeBatimentsDuTeamplate1;}
		if (champMin <= 8 && champMin >4){return listeDeBatimentsDuTeamplate2;}
		if (champMin < 10 && champMin > 7){return listeDeBatimentsDuTeamplate3;}
		if (champMin == 10){return listeDeBatimentsDuTeamplate4;}
		if (champMin > 10){return listeDeBatimentsDuTeamplate4;}
		return null;


	
	
	
	
	
	
	}
}
