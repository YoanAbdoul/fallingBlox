package fr.eseo.e3.poo.projet.blox;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class FallingBloxVersion1 {
	public static void main(String[] args) {
		VuePuits vuePuits;
		// Scénario 1 sans arguments
		if(args.length == 0)
		{
			vuePuits = new VuePuits(new Puits());
		}
		
		// Scénario 2 avec 1 argument
		else if(args.length == 1)
		{
			vuePuits = new VuePuits(new Puits(Puits.LARGEUR_PAR_DEFAUT, Puits.PROFONDEUR_PAR_DEFAUT, Integer.parseInt(args[0])));
		}
		
		// Scéanrio 3 avec 2 arguments ( ou plus du coup )
		else {
			vuePuits = new VuePuits(new Puits(Puits.LARGEUR_PAR_DEFAUT, Puits.PROFONDEUR_PAR_DEFAUT, Integer.parseInt(args[0]), Integer.parseInt(args[1])));
		}
		
		PanneauInformation panneauPieceSuivante = new PanneauInformation(vuePuits.getPuits());
		
		JFrame maFenetre = new JFrame("Falling Blox");
		
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererTetromino());
		
		vuePuits.getPuits().getPieceActuelle().setPosition(3, 1);

		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//maFenetre.setSize(15*18,15*20+38);
		maFenetre.setSize(20*18,20*20+38);
		
		maFenetre.setResizable(false);
		maFenetre.setLocationRelativeTo(null);
		
		maFenetre.add(vuePuits);
		maFenetre.add(panneauPieceSuivante, BorderLayout.EAST);
		maFenetre.setVisible(true);
		
		vuePuits.setGravite(new Gravite(vuePuits));
	}
}
