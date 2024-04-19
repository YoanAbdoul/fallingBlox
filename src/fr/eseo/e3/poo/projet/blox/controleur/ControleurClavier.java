package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class ControleurClavier extends KeyAdapter{
	
	private VuePuits vuePuits;
	private Puits puits;
	
	public ControleurClavier(VuePuits vuePuits)
	{
		super();
		this.vuePuits = vuePuits;
		this.puits = this.vuePuits.getPuits();
	}
	
	@Override
	public void keyPressed(KeyEvent event)
	{
		int toucheEntree = event.getKeyCode();
		switch(toucheEntree)
		{
			// gestion des déplacements 
			case KeyEvent.VK_DOWN:
				this.puits.gravite();
				break;
			case KeyEvent.VK_LEFT:
				try {
					this.puits.getPieceActuelle().deplacerDe(-1, 0);
				} catch (BloxException e) {}
				break;
			case KeyEvent.VK_RIGHT:
				try {
					this.puits.getPieceActuelle().deplacerDe(1, 0);
				} catch (BloxException e) {}
				break;
			// gestion des rotations
			case KeyEvent.VK_R:
				try {
					this.puits.getPieceActuelle().tourner(true);
				} catch (BloxException e) {}
				break;
			case KeyEvent.VK_E:
				try {
					this.puits.getPieceActuelle().tourner(false);
				} catch (BloxException e) {}
				break;
			// gestion du déplacement direct tout en bas 
			case KeyEvent.VK_Z:
				// changement entre pièce actuelle et pièce suivante
				this.puits.changementPieces();
				break;
			// gestion du changement de pièce 
			case KeyEvent.VK_SPACE:
				this.puits.getPieceActuelle().deplacerVersLeBas();
				break;
			default:
				break;
		}
		this.vuePuits.repaint();
	}
}
