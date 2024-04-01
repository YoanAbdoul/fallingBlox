package fr.eseo.e3.poo.projet.blox.controleur;

import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacementTest {
	public PieceDeplacementTest() {}
	
	public static void main(String[] args) {
		PieceDeplacementTest test = new PieceDeplacementTest();
		test.testDeplacement();
	}
	
	public void testDeplacement()
	{
		JFrame maFenetre = new JFrame("Déplacements");
		VuePuits vuePuits = new VuePuits(new Puits());
		
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());

		maFenetre.setSize(15*18,15*20+38);
		maFenetre.setResizable(false);
		maFenetre.setLocationRelativeTo(null);
		
		maFenetre.add(vuePuits);
		maFenetre.setVisible(true);
	}
}
