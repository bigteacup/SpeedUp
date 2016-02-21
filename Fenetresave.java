package botpackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.colorchooser.ColorChooserComponentFactory;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.plaf.ColorChooserUI;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.google.common.util.concurrent.Service.Listener;



public class Fenetresave extends JFrame {
//
//	JFrame fenetre = new JFrame();
//	private JButton boutonOn = new JButton("On");
//	private JButton boutonOff = new JButton("Off");
//	private JPanel jpane = new JPanel(new GridBagLayout());//new BorderLayout()
//	Console console ;
//	public JCheckBox pillageBox = new JCheckBox("Pillage");
//	private JCheckBox faireDefilerBox = new JCheckBox("Faire defiler");
//	public JCheckBox faireFetes = new JCheckBox("Faire Fetes");
//	private JCheckBox faireConstruire = new JCheckBox("Construire");
//	private JTextField compte = new JTextField("toto");
//	private JTextField motDePasse = new JTextField("1234");
//	JTabbedPane tabbedPane;
//	JScrollPane panels2 ;
//	JPanel panel2 = new JPanel();
//	GridBagConstraints c = new GridBagConstraints();
//	int i2 = 0;
//	
//	
//	
//	
//	
//	public Fenetresave(Lancerbot bot) {
//		console = new Console(bot);
//		faireFenetre(bot);
//		
//		//faireFenetre2(bot);
//	}
//
//
//    protected JPanel makePanel(String text) {
//    	JPanel panel = new JPanel();
//        GridBagLayout panelGridbag = new GridBagLayout();
//        panel.setLayout(panelGridbag);
//        panel.setBackground(Color.GREEN);  
//  
//        return panel;
//    }
//    
//    
//    
//    
//    public JPanel JpaneVillage(Village v){
//    	
//    	JPanel vPane= new JPanel();
//    	
//    	//vPane.setLayout(new GridLayout(vPane, GridLayout.X_AXIS));
//    	//villageGridBagConstraint.gridx = 0;
//    //	 villageGridBagConstraint .insets = new Insets(5, 5, 5, 5);
//      //	villageGridBagConstraint.fill =GridBagConstraints.BOTH;
// 	vPane.setBackground(Color.RED);
//  	
// 	JPanel subPane= new JPanel();
// 	subPane.setBackground(ColorUIResource.CYAN);
// 		String text= v.getNom() ;
//    	JLabel name = new JLabel(text);
//		subPane.add(name);
//		
//    	//////////////////////////////////////////////
//    	JPanel subPane1= new JPanel();
//    	subPane1.setBackground(ColorUIResource.YELLOW);
//    		String textBois = Integer.toString(v.getBois()) ;
//    		JLabel nameBois = new JLabel(textBois);
//    		int actuelBois =v.getBois();
//    		int fmaxBois = v.getMaxStockDepot();//v.getMaxStockDepot()
//    		JSlider spinBois =new JSlider(0, fmaxBois, actuelBois);
//    		spinBois.setPaintLabels(true);
//    		subPane1.add(spinBois);
//    		subPane1.add(nameBois);
//    		
//    	JPanel subPane2= new JPanel();
//    	subPane2.setBackground(ColorUIResource.MAGENTA);
//    		String textArgile = Integer.toString(v.getArgile()) ;
//			JLabel nameArgile = new JLabel(textArgile);
//			int actuelArgile =v.getArgile();
//			int fmaxArgile = v.getMaxStockDepot();//v.getMaxStockDepot()
//			JSlider spinArgile =new JSlider(0, fmaxArgile, actuelArgile);
//			spinArgile.setPaintLabels(true);
//			subPane2.add(spinArgile);
//			subPane2.add(nameArgile);
//    	
//    	JPanel subPane3= new JPanel();
//    		subPane3.setBackground(ColorUIResource.green);
//    		String textFer = Integer.toString(v.getFer()) ;
//    		JLabel nameFer = new JLabel(textFer);
//    		int actuelFer =v.getFer();
//    		int fmaxFer = v.getMaxStockDepot();//v.getMaxStockDepot()
//    		JSlider spinFer =new JSlider(0, fmaxFer, actuelFer);
//    		spinFer.setPaintLabels(true);
//    		subPane3.add(spinFer);
//    		subPane3.add(nameFer);
//    		
//        JPanel subPane4= new JPanel();
//        subPane4.setBackground(ColorUIResource.ORANGE);
//        	String textCereales = Integer.toString(v.getCereales()) ;
//    		JLabel nameCereales = new JLabel(textCereales);
//    		int actuelCereales =v.getCereales();
//    		int fmaxCereales = v.getMaxStockSilo();//v.getMaxStockDepot()
//    		JSlider spinCereales =new JSlider(0, fmaxCereales, actuelCereales);
//     	   	spinCereales.setMinorTickSpacing(10000);
//     	   	spinCereales.setMajorTickSpacing(80000);
//     	    spinCereales.setPaintTicks(true);
//    		spinCereales.setLabelTable(spinCereales.createStandardLabels(100000));
//    		spinCereales.setPaintLabels(true);
//    		subPane4.add(spinCereales);
//    		subPane4.add(nameCereales);
//    		
//    /*	spin3.setMaximum(v.getMaxStockDepot());
//    	spin3.setMinimum(0);
//    	spin3.setValue(v.getFer());
//    	   spin3.setMinorTickSpacing(2);
//    	   spin3.setMajorTickSpacing(10);
//    	    spin3.setPaintTicks(true);
//    	    spin3.setPaintLabels(true);*/
//
//    	    // We'll just use the standard numeric labels for now...
//    	 //   spinCereales.setLabelTable(spinCereales.createStandardLabels(10));
//	
//    		//JPanel p = new JPanel();
//    	//   vPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
//    	
//	
//    	
//    	vPane.add(subPane);
//    	vPane.add(subPane1);
//    	vPane.add(subPane2);
//    	vPane.add(subPane3);
//    	vPane.add(subPane4);
//    	   vPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
//    //	vPane.setBorder(BorderFactory.createRaisedSoftBevelBorder(); //createLineBorder(Color.black));
//		return vPane;
// 	
//    	
//    }
//    
//    
//public void boutVil(Lancerbot bot){
//	
//	JPanel vPanelistconteneur = new JPanel();
//	GridBagLayout villageGridBag = new GridBagLayout();
//	GridBagConstraints villageGridBagConstraint = new GridBagConstraints();
//	vPanelistconteneur.setLayout(villageGridBag);
//	vPanelistconteneur.setBackground(Color.PINK);
////	vPanelistconteneur.setSize(getWidth()/2, getHeight()/2);
//	//villageGridBagConstraint .insets = new Insets(5, 5, 5, 5);
//	//vPanelistconteneur.add(vPane);
//	
//	int i = 1;
//	for (Village v : bot.travian.getListeDeVillages()){
//		villageGridBagConstraint.gridy = i;
//		villageGridBagConstraint.gridx = 0;
//		villageGridBagConstraint.fill = GridBagConstraints.BOTH;
//		vPanelistconteneur.setBorder(BorderFactory.createLineBorder(Color.black));
//		vPanelistconteneur.add(JpaneVillage(v),villageGridBagConstraint);
//
//		
//		i++;
///*
//	c.gridx = GridBagConstraints.NONE;
//	c.gridwidth=0;
//	c.weightx=0;
//	c.weighty = 0;
//	c.gridx = 0;
//	c.gridy = 5+i;
//	*/
//	
//	}
//	c.gridx = 0;
//	c.gridy = i2;
//	panel2.add(vPanelistconteneur, c);
//
//	i2++;
//}
//
//
//public void faireFenetre(Lancerbot bot) {
//	fenetre.setContentPane(jpane);
//	fenetre.setSize(800, 600);
//	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	this.setLocationRelativeTo(null);
//	// jpane.setLayout(new BorderLayout());
//	
//	
//	
//
//	// BOUTONS ET CASES A COCHER
//	
//	c.fill = GridBagConstraints.BOTH;
//	c.gridx = 0;
//	c.gridy = 0;
//	
//	c.weightx=0;
//	c.weighty = 0;
//	jpane.add(boutonOn, c);
//	
//	c.gridx = 0;
//	c.gridy = 1;
//	jpane.add(boutonOff,c);
//	
//
//
//	
//////////////////////////////////////////////
//	c.gridx = GridBagConstraints.RELATIVE;
//	c.gridy = 0;
//	pillageBox.setSelected(true);
//	jpane.add(pillageBox,c);
//	pillageBox.addActionListener(new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			/*if (pillageBox.isSelected()) {bot.travian.commuterPillage();}//bot.travian.pillage = true;
//			if (!pillageBox.isSelected()) {bot.travian.commuterPillage();}//bot.travian.pillage = false;
//			//System.out.println(bot.travian.pillage);*/
//		}
//		});
//	
//	c.gridx = GridBagConstraints.RELATIVE;
//	c.gridy = 0;
//	faireFetes.setSelected(true);
//	jpane.add(faireFetes,c);
//	faireFetes.addActionListener(new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {/*
//			// TODO Auto-generated method stub
//			if (faireFetes.isSelected()) {bot.travian.commuterFete();}//boutVil(bot);
//			if (!faireFetes.isSelected()) {bot.travian.commuterFete();}*/
//		}
//		});
//	
//	
//
//	c.gridx = GridBagConstraints.RELATIVE;
//	c.gridy = 0;
//	jpane.add(faireConstruire,c);
//	
//
//	//MENU CLIC DROIT
//	JPopupMenu menu = new JPopupMenu();
//	JMenuItem it = new JMenuItem("Menu");
//	
//	JMenuItem it2 = new JMenuItem("action1");
//	JMenuItem it3 = new JMenuItem("Action2");
//	menu.add(it);
//	menu.addSeparator();
//	menu.add(it2);
//	menu.add(it3);
//	menu.addSeparator();
//	jpane.setComponentPopupMenu(menu);
//	jpane.add(menu);
//	
///////////////////////////////////////////////////////////////////////////////////////////	
//	 // LES TABS
//	
//	tabbedPane = new JTabbedPane();
//	tabbedPane.setBackground(Color.BLUE);
//
//	
////////////////////////////////////////////////////////////////////////////
////////////////////////////////console
//	 JPanel panel1 = new JPanel(new GridBagLayout());
//
//c.fill = GridBagConstraints.BOTH;
//c.gridx = 0;
//c.gridy = 0;
//c.gridwidth=100;
//c.weightx=10;
//c.weighty = 10;
//panel1.add(new JScrollPane(console.consoleColored()), c);
//
//
//c.fill = GridBagConstraints.NONE;
//c.gridx =0;
//c.gridy = 1;
//c.gridwidth=0;
//c.weightx=0;
//c.weighty = 0;
//panel1.add(faireDefilerBox,c);
//faireDefilerBox.setSelected(true);
//console.setFaireDefiler(true);
//faireDefilerBox.addActionListener(new ActionListener() {
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if (faireDefilerBox.isSelected()) {console.setFaireDefiler(true);}
//		if (!faireDefilerBox.isSelected()) {console.setFaireDefiler(false);}
//	}
//});
//
//
//	tabbedPane.addTab("Console", null, panel1,"Affiche la Console");
//	tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
//////////////////////////////////////////////////////////////
//	///// Les Vpane de Villages
//
//	panel2 =makePanel("Panel #2");
//	 panels2 = new JScrollPane(panel2);
//	tabbedPane.addTab("Villages", null, panels2, "Donnees Villages");
//	tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
//	
//
////////////////////////////////////////////////////////////
///////////
//	JComponent panel3 = makePanel("Panel #3");
//	tabbedPane.addTab("Tab 3", null, panel3, "Does nothing");
//	tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
//////////////
//
//	
//	c.fill = GridBagConstraints.BOTH;
//	c.gridx = 0;
//	c.gridy = 4;
//	c.gridwidth=5;
//	c.weightx=10;
//	c.weighty = 1;
//	tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
//	fenetre.add(tabbedPane, c);
//	
//	
//	///Formulaire nom et mdp
//	c.fill = GridBagConstraints.RELATIVE;
//	c.gridx =0;
//	c.gridy = 5;
//	c.gridwidth=0;
//	c.weightx=0;
//	c.weighty = 0;
//	
//	jpane.add(compte, c);
//	
//	c.fill = GridBagConstraints.RELATIVE;
//	c.gridx =1;
//	c.gridy = 5;
//	c.gridwidth=0;
//	c.weightx=0;
//	c.weighty = 0;
//	jpane.add(motDePasse, c);
//	
//	
//	fenetre.setVisible(true);
/////////////////////////////////////////////////////////////////////////////////////////	
//	//fenetre.pack();
//	pack();
//	
//	
//
//
//	
//	
//	
//	
//	
//	//////
//	boutonOn.addMouseListener(new MouseListener() {
//		
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void mousePressed(MouseEvent e) {
//			// TODO Auto-generated method stub
//			try {
//			if (bot.travian.allume == false){
//			bot.lancerTravian();
//			}
//			}catch (Exception e1){bot.lancerTravian();}
//		//	System.out.println(bot.getName());
//		//    System.out.println(bot.getState());
//		}
//		
//		@Override
//		public void mouseExited(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void mouseEntered(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//
//			
//		}
//		
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//	});
//	////////////
//	boutonOff.addMouseListener(new MouseListener() {
//		
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void mousePressed(MouseEvent e) {
//			// TODO Auto-generated method stub
//			//travian.currentThread().interrupt();
//			bot.eteindreTravian();
//		}
//		
//		@Override
//		public void mouseExited(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void mouseEntered(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//			
//		}
//	});
//	
//} 
















































































































































































/*
OLD CONSOLE JtextAERA PAS DE COULEUR SYNTHAXIQUE
//////////////////////////////////////////////////
public void console() {

	
  
	
	
	
    console = new JTextArea();
  //  console.setLayout(new BorderLayout());
    
  //  console.setLineWrap(true);
    console.setFont(new Font("monospaced",Font.PLAIN,12));
    console.setBackground(Color.BLACK);
    console.setForeground(Color.LIGHT_GRAY);
    

    System.setOut(new PrintStream(new OutputStream() {
         private StringBuilder sb = new StringBuilder();

      ///   
         @Override
         public void write(int b) throws IOException {   
       sb.append((char)b);
    
       /// ////       
       console.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
			}
			@Override
			public void changedUpdate(DocumentEvent e) {

			}});
		////
       
       
       ////////raw motor
              if (b == '\n' ) {
            	  String str = sb.toString();
            	  
            //	  if(str.toString().contains("Connexion")){console.setForeground(Color.pink);console.setVisible(true);}else{console.setForeground(Color.LIGHT_GRAY);console.setVisible(true);}
                   console.append(sb.toString());
                   sb.setLength(0);
                  
                   
                   if(console.getDocument().getDefaultRootElement().getElementCount() > 1000){
                	   
                   int end = console.getDocument().getDefaultRootElement().getElement(0).getEndOffset();
                   try {
            		console.getDocument().remove(0, end);
                   		} catch (BadLocationException e) {e.printStackTrace();}
                   } 
                  
                   
                   if (faireDefiler){
                   console.setCaretPosition(console.getDocument().getLength());
                   
                   }
                   }
  
              }

    }));
    

 
    
//    new Timer(1000, new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//              System.out.println("System.out.println");
//         }
//    }).start();
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

*/








//
//
//	
//
//
//JFrame fenetre2 = new JFrame();
//private JButton boutonOn2 = new JButton("On");
//private JButton boutonOff2 = new JButton("Off");
//private JPanel jpane3 = new JPanel(new GridBagLayout());//new BorderLayout()
//private JTextArea console2;
//private JCheckBox pillageBox2 = new JCheckBox("Pillage");
//private JCheckBox faireDefilerBox2 = new JCheckBox("Faire defiler");
//private JCheckBox faireFetes2 = new JCheckBox("Faire Fetes");
//private JCheckBox faireConstruire2 = new JCheckBox("Construire");
//private boolean faireDefiler2 = false;
//
//
//
//
//public void faireFenetre2(Lancerbot bot) {
//	
//	JFrame fenetre2 = new JFrame();
//    JLayeredPane jpane2 = new JLayeredPane();
//    fenetre2.add(jpane2, BorderLayout.CENTER);
//	
//	
//	//fenetre.setContentPane(jpane);
//   
//    JLabel label2 = new JLabel("LABEL", JLabel.CENTER);
//    label2.setBounds(200, 200, 200, 200);
//    label2.setOpaque(true);
//    label2.setBackground(Color.cyan);
//    jpane2.add(label2,1);
//
//    JPanel subLayer2 = new JPanel(new BorderLayout());
//    JLabel subLabel2 = new JLabel("SUBLABEL", JLabel.CENTER);
//    subLabel2.setBounds(50, 50, 50, 50);
//    subLabel2.setOpaque(true);
//    subLabel2.setBackground(Color.yellow);
//    subLayer2.add(subLabel2, BorderLayout.SOUTH);
//    jpane2.add(subLabel2, 2);
//	
//	
//	
//	
//	fenetre2.setSize(600, 600);
//	fenetre2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//
//	GridBagConstraints c = new GridBagConstraints();
//	c.fill = GridBagConstraints.NONE;
//	c.gridx = 0;
//	c.gridy = 0;
//	
//	c.weightx=0;
//	c.weighty = 0;
//	boutonOn2.setBounds(0,0, 60, 60);
//	jpane2.add(boutonOn2, 2);
//	
//	c.gridx = 0;
//	c.gridy = 1;
//	boutonOff2.setBounds(40,0, 60, 60);
//	jpane2.add(boutonOff2, 3);
//	
//////////////
//	c.gridx = GridBagConstraints.RELATIVE;
////	c.gridx =1;
//	c.gridy = 0;
//	pillageBox2.setBounds(40,40, 40, 40);
//	jpane2.add(pillageBox2);
//	
//	c.gridx = GridBagConstraints.RELATIVE;
//	//c.gridx = 2;
//	c.gridy = 0;
//	faireFetes2.setBounds(40,40, 40, 40);
//	jpane2.add(faireFetes2);
//	
//	c.gridx = GridBagConstraints.RELATIVE;
//	c.gridy = 0;
//	faireConstruire2.setBounds(40,40, 40, 40);
//	jpane2.add(faireConstruire2);
//	
////////////////////////////////////////////////////////////////////	////////
////////////////////////////////	console
//
//
//
//
//
//	console2();
//
//	c.fill = GridBagConstraints.BOTH;
//	c.gridx = 0;
//	c.gridy = 2;
//	c.gridwidth=100;
//	c.weightx=10;
//	c.weighty = 10;
//	console2.setBounds(400,400, 800, 400);
//	jpane2.add(new JScrollPane(console2), c);
//	
//	
//	c.fill = GridBagConstraints.NONE;
//	//c.gridx = GridBagConstraints.RELATIVE;
//	c.gridy = 3;
//	c.gridwidth=0;
//	c.weightx=0;
//	c.weighty = 0;
//	faireDefilerBox2.setBounds(0,0, 60, 60);
//	jpane2.add(faireDefilerBox2,c);
//
//	
//	fenetre2.setVisible(true);
/////////////////////////////////////////////////////////////////////////////////////////	
//	//fenetre.pack();
//	pack();
//	
//	
//	faireDefilerBox2.addActionListener(new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			if (faireDefilerBox2.isSelected()) {faireDefiler2 = true;}
//			if (!faireDefilerBox2.isSelected()) {faireDefiler2 = false;}
//		}
//	});
//	//faireDefiler. setLocationRelativeTo(console); 
//	
//	
//	
//	
//	
//	
//	//////
//	boutonOn2.addMouseListener(new MouseListener() {
//		
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void mousePressed(MouseEvent e) {
//			// TODO Auto-generated method stub
//			try {
//			if (bot.travian.allume == false){
//			bot.lancerTravian();
//			}
//			}catch (Exception e1){bot.lancerTravian();}
//		//	System.out.println(bot.getName());
//		//    System.out.println(bot.getState());
//		}
//		
//		@Override
//		public void mouseExited(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void mouseEntered(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//
//			
//		}
//		
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//	});
//	////////////
//	boutonOff2.addMouseListener(new MouseListener() {
//		
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void mousePressed(MouseEvent e) {
//			// TODO Auto-generated method stub
//			//travian.currentThread().interrupt();
//			bot.eteindreTravian();
//		}
//		
//		@Override
//		public void mouseExited(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void mouseEntered(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//			
//		}
//	});
//	
//} 
//
//
//
//
//
////////////////////////////////////////////////////
//public void console2() {
//
//
//
//
//
//
//console2 = new JTextArea();
////  console.setLayout(new BorderLayout());
//
//console2.setLineWrap(true);
//console2.setFont(new Font("monospaced",Font.PLAIN,12));
//console2.setBackground(Color.BLACK);
//console2.setForeground(Color.LIGHT_GRAY);
//
//GridBagConstraints c = new GridBagConstraints();
//System.setOut(new PrintStream(new OutputStream() {
//private StringBuilder sb2 = new StringBuilder();
//
//
//@Override
//public void write(int b) throws IOException {   
//sb2.append((char)b);
//
//if (b == '\n' ) {
//console2.append(sb2.toString());
//sb2.setLength(0);
//
//
//if(console2.getDocument().getDefaultRootElement().getElementCount() > 1000){
//
//int end = console2.getDocument().getDefaultRootElement().getElement(0).getEndOffset();
//try {
//console2.getDocument().remove(0, end);
//} catch (BadLocationException e) {e.printStackTrace();}
//} 
//
//
//if (faireDefiler2){
//console2.setCaretPosition(console2.getDocument().getLength());
//
//}
//}
//
//}
//
//}));
//
//
//
//
//}
//
//


}
