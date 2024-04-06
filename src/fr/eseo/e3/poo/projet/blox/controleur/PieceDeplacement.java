package fr.eseo.e3.poo.projet.blox.controleur;

import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;



public class PieceDeplacement extends java.awt.event.MouseAdapter{
	private VuePuits vuePuits;
	private Puits puits;
	
	private int colonne = -1;
	
	public PieceDeplacement(VuePuits vuePuits)
	{
		this.vuePuits = vuePuits;
		this.puits = this.vuePuits.getPuits();
	}
	
	public void mouseMoved(java.awt.event.MouseEvent event)
	{
		if(!(this.puits.getPieceActuelle() == null))
		{
			if(this.colonne == -1)
			{
				this.colonne = event.getXOnScreen()/this.vuePuits.getTaille();
			}
			else if(this.colonne != event.getXOnScreen()/this.vuePuits.getTaille())
			{
				if(this.colonne < event.getXOnScreen()/this.vuePuits.getTaille())
				{
					try {
						this.puits.getPieceActuelle().deplacerDe(1, 0);
					}
					catch(BloxException e){}
				}
				else
				{
					try {
						this.puits.getPieceActuelle().deplacerDe(-1, 0);
					}
					catch(BloxException e){}
				}
				this.colonne = event.getXOnScreen()/this.vuePuits.getTaille();
			}
		}
		this.vuePuits.repaint();
	}
	
	public void mouseEntered(java.awt.event.MouseEvent event)
	{
		// Normalement ici nous devons Réinitialiser la colonne
		// Or le code de mouseMoved prend déjà en compte cette possibilité d'après les tests
	}
	
	public void mouseWheelMoved(java.awt.event.MouseWheelEvent event)
	{
		if(!(this.puits.getPieceActuelle() == null))
		{
			if(event.getWheelRotation() > 0)
			{
				try {
					this.puits.getPieceActuelle().deplacerDe(0, 1);
				}
				catch(BloxException e)
				{
					
				}
			}
		}
		this.vuePuits.repaint();
	}
	
	public void mouseClicked(java.awt.event.MouseEvent event)
	{
		if(SwingUtilities.isMiddleMouseButton(event))
		{
			this.puits.getPieceActuelle().deplacerVersLeBas(this.puits.getTas());
		}
		this.vuePuits.repaint();
	}
	
}
