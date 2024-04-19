package fr.eseo.e3.poo.projet.blox.controleur;

import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class ControleurClavierTest {
	public ControleurClavierTest() {}
	
	public static void main(String[] args) {
		ControleurClavierTest test = new ControleurClavierTest();
		test.testControleurClavier();
	}
	
	public void testControleurClavier()
	{
		JFrame maFenetre = new JFrame("Gravité");
		VuePuits vuePuits = new VuePuits(new Puits());
		
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		
		vuePuits.getPuits().getPieceActuelle().setPosition(3, 1);

		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		maFenetre.setSize(15*18,15*20+38);
		//maFenetre.setResizable(false);
		maFenetre.setLocationRelativeTo(null);
		
		maFenetre.add(vuePuits);
		maFenetre.setVisible(true);
		
		//maFenetre.addKeyListener(new ControleurClavier());
		vuePuits.setFocusable(true);
		vuePuits.addKeyListener(new ControleurClavier(vuePuits));
		
		//vuePuits.setGravite(new Gravite(vuePuits));
		
	}
}
