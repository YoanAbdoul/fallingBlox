package fr.eseo.e3.poo.projet.blox;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class FallingBloxVersion2 {
	public static void main(String[] args) {
		FallingBloxVersion2 app = new FallingBloxVersion2();
		
		VuePuits vuePuits = app.selectionDuPuits(args);
		
		app.creationFenetre(vuePuits);
		
		vuePuits.setGravite(new Gravite(vuePuits));
	}
	
	public VuePuits selectionDuPuits(String[] args)
	{
		VuePuits vuePuits;
		if(args.length == 0)
		{
			// Scénario 1 sans arguments
			vuePuits = new VuePuits(new Puits());
		}
		else if(args.length == 1)
		{
			// Scénario 2 avec 1 argument
			int arg1 = Integer.parseInt(args[0]);
			Puits puits = new Puits(Puits.LARGEUR_PAR_DEFAUT, Puits.PROFONDEUR_PAR_DEFAUT, arg1);
			vuePuits = new VuePuits(puits);
		}
		else {
			// Scéanrio 3 avec 2 arguments ( ou plus du coup )
			int arg1 = Integer.parseInt(args[0]);
			int arg2 = Integer.parseInt(args[1]);
			Puits puits = new Puits(Puits.LARGEUR_PAR_DEFAUT, Puits.PROFONDEUR_PAR_DEFAUT, arg1, arg2);
			vuePuits = new VuePuits(puits);
		}
		return vuePuits;
	}
	
	public void creationFenetre(VuePuits vuePuits)
	{
		PanneauInformation panneauPieceSuivante = new PanneauInformation(vuePuits.getPuits());
		
		JFrame maFenetre = new JFrame(this.getClass().getSimpleName());
		
		UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
		
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
	}
}
