package fr.eseo.e3.poo.projet.blox.controleur;

import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotationTest {
	public PieceRotationTest() {}
	
	public static void main(String[] args) {
		PieceRotationTest test = new PieceRotationTest();
		test.testDeplacement();
	}
	
	public void testDeplacement()
	{
		JFrame maFenetre = new JFrame("Rotations");
		VuePuits vuePuits = new VuePuits(new Puits());
		
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		
		vuePuits.getPuits().getPieceActuelle().setPosition(5, 5);

		maFenetre.setSize(15*18,15*20+38);
		maFenetre.setResizable(false);
		maFenetre.setLocationRelativeTo(null);
		
		maFenetre.add(vuePuits);
		maFenetre.setVisible(true);
	}
}
