package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;

public class VueTasTest {
	public VueTasTest(){}
	
	public static void main(String[] args) {
		
		VueTasTest vue = new VueTasTest();
		vue.testTas();
	}
	
	private void testTas()
	{
		JFrame maFenetre = new JFrame("Test Tas");
		VuePuits vuePuits = new VuePuits(new Puits(Puits.LARGEUR_PAR_DEFAUT, Puits.PROFONDEUR_PAR_DEFAUT, 25));
		
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());

		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		maFenetre.setSize(15*18,15*20+38);
		maFenetre.setResizable(false);
		maFenetre.setLocationRelativeTo(null);
		
		maFenetre.add(vuePuits);
		maFenetre.setVisible(true);
	}
}
