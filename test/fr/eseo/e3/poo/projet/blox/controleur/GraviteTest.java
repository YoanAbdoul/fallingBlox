package fr.eseo.e3.poo.projet.blox.controleur;

import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class GraviteTest {
	public GraviteTest() {}
	
	public static void main(String[] args) {
		GraviteTest test = new GraviteTest();
		test.testDeplacement();
	}
	
	public void testDeplacement()
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
		
		vuePuits.setGravite(new Gravite(vuePuits));
		
	}
}
