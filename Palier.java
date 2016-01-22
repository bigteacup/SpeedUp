package botpackage;


public class Palier {
//	private StrategieConstruction strategieConstruction;
	private int palier1Min = 4;
	private int palier1Max = 7;
	
	private int palier2Min = 7;
	private int palier2Max = 10;
	
	private int palier3Min = 10;
	private int palier3Max = 10;	
	
	private int palierNumero;
	public Palier() {
	//	super();
		
	//	StrategieConstruction strategieConstruction = new StrategieConstruction();
		Travian construireBatiments = new Travian();
	}
	
	
	
		public int palier(int champMin) {
		// TODO Auto-generated method stub
		if (champMin >= palier1Min && champMin < palier1Max ){//strategieConstruction.strategieConstruction(4);
			System.out.println("Override champs => palier 1 ["+champMin+"] atteint => Construction Batiment" );
		return palierNumero = 1;
		}
		
		if (champMin >= palier2Min && champMin < palier2Max ){//strategieConstruction.strategieConstruction(7);
			System.out.println("Override champs => palier 2 ["+champMin+ "] atteint => Construction Batiment" );
		return palierNumero=2;
		}
		
		if (champMin >= palier3Min){//strategieConstruction.strategieConstruction(10);
			System.out.println("Override champs => palier 3 ["+champMin+ "] atteint => Construction Batiment" );
		return palierNumero=3;
		}
		
		
		return palierNumero;
		
		
		
		
		}
	}
	
	


/*
NomClasse objet = new NomClasse();
objet.m�thode();







*/