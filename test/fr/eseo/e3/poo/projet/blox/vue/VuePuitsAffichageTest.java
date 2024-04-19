package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;

public class VuePuitsAffichageTest {
	public VuePuitsAffichageTest(){}
	
	public static void main(String[] args) {
		
		VuePuitsAffichageTest vue = new VuePuitsAffichageTest();
		vue.testConstructeurPuits();
		vue.testConstructeurPuitsTaille();
	}
	
	private void testConstructeurPuits()
	{
		JFrame maFenetre = new JFrame("Puits");
		VuePuits vuePuits = new VuePuits(new Puits());
		
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		
		vuePuits.repaint();

		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		maFenetre.setSize(15*18,15*20+38);
		maFenetre.setResizable(false);
		maFenetre.setLocationRelativeTo(null);
		
		maFenetre.add(vuePuits);
		maFenetre.setVisible(true);
	}
	
	
	private void testConstructeurPuitsTaille()
	{
		JFrame maFenetre = new JFrame("Puits et taille");
		VuePuits vuePuits = new VuePuits(new Puits(), 20);
		
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		
		vuePuits.repaint();
		
		
		
		maFenetre.setSize(20*18,20*20+38);
		maFenetre.setResizable(false);
		maFenetre.setLocationRelativeTo(null);
		
		maFenetre.add(vuePuits);
		maFenetre.setVisible(true);
	}
}
