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

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import net.miginfocom.swing.MigLayout;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;



public class Fenetre extends JFrame {

	JFrame fenetre = new JFrame();
	private JButton boutonOn = new JButton("On");
	private JButton boutonOff = new JButton("Off");
	private JPanel jpane = new JPanel();//new BorderLayout()
	Console console ;
	public JCheckBox pillageBox = new JCheckBox("Pillage");
	public JCheckBox faireDefilerBox = new JCheckBox("Faire defiler");
	public JCheckBox faireFetes = new JCheckBox("Faire Fetes");
	public JCheckBox evacuerRessourcesBox = new JCheckBox("evacuerRessources");
	public JCheckBox faireConstruireBox = new JCheckBox("Construire");
	private JTextField nomDeComptej = new JTextField("Drap-housse");
	private JTextField motDePassej = new JTextField("6dst5rhx");
	private JTextField serveurj = new JTextField("http://ts20.travian.fr/");
	private JButton boutonPasserLattente = new JButton("Passer l'attente");
	





	public Fenetre(Lancerbot bot) throws IOException {
		serveurj.setColumns(10);
		console = new Console(bot);
		faireFenetre(bot);

		//faireFenetre2(bot);
	}


	public void faireFenetre(Lancerbot bot) throws IOException {
		fenetre.setContentPane(jpane);
		fenetre.setSize(800, 600);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jpane.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[fill][fill][fill][][grow][fill]"));
		jpane.add(boutonOn, "cell 0 0,grow");









		//////
		boutonOn.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					if (bot.travian.allume == false){
						String serveur = serveurj.getText();
						String nomDeCompte = nomDeComptej.getText();
						String motDePasse = motDePassej.getText();
						bot.lancerTravian(serveur, nomDeCompte, motDePasse );
					}
				}catch (Exception e1){
					String serveur = serveurj.getText();
					String nomDeCompte = nomDeComptej.getText();
					String motDePasse = motDePassej.getText();
					bot.lancerTravian(serveur, nomDeCompte, motDePasse );}
				//	System.out.println(bot.getName());
				//    System.out.println(bot.getState());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			
		});
		jpane.add(nomDeComptej, "cell 1 0,growx");

		JPanel panel_2 = new JPanel();
		jpane.add(panel_2, "cell 3 0 2 2,alignx left,aligny center");
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_2.add(pillageBox);
		pillageBox.setSelected(true);
		
		panel_2.add(faireFetes);
		faireFetes.setSelected(true);
		
		panel_2.add(faireConstruireBox);
		faireConstruireBox.setSelected(true);
		
		panel_2.add(evacuerRessourcesBox);
		evacuerRessourcesBox.setSelected(true);
		faireFetes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {/*
																																	// TODO Auto-generated method stub
																																	if (faireFetes.isSelected()) {bot.travian.commuterFete();}//boutVil(bot);
																																	if (!faireFetes.isSelected()) {bot.travian.commuterFete();}*/
			}
		});
		pillageBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*if (pillageBox.isSelected()) {bot.travian.commuterPillage();}//bot.travian.pillage = true;
																																	if (!pillageBox.isSelected()) {bot.travian.commuterPillage();}//bot.travian.pillage = false;
																																	//System.out.println(bot.travian.pillage);*/
			}
		});
		jpane.add(boutonOff, "cell 0 1,grow");
		////////////
		boutonOff.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				//travian.currentThread().interrupt();
				bot.eteindreTravian();
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub


			}
		});
		jpane.add(motDePassej, "cell 1 1,growx");
		
		jpane.add(boutonPasserLattente, "cell 0 2");
		boutonPasserLattente.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				//travian.currentThread().interrupt();
				bot.annulerPause();
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub


			}
		});
		
		
		
		
		jpane.add(serveurj, "cell 1 2,growx");
		jpane.add(faireDefilerBox, "cell 4 5");
		faireDefilerBox.setSelected(true);
		faireDefilerBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (faireDefilerBox.isSelected()) {console.setFaireDefiler(true);}
				if (!faireDefilerBox.isSelected()) {console.setFaireDefiler(false);}
			}
		});


		//////////////////////////////////////////////////////////////////////////
		//////////////////////////////console



		JScrollPane scrollPane = new JScrollPane(console.consoleColored());
		jpane.add(scrollPane, "cell 0 4 5 1,grow");
		console.setFaireDefiler(true);


		fenetre.setVisible(true);


	} 
}
