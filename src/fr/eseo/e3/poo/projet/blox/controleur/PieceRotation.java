package fr.eseo.e3.poo.projet.blox.controleur;

import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotation extends java.awt.event.MouseAdapter{
	private VuePuits vuePuits;
	private Puits puits;
	
	public PieceRotation(VuePuits vuePuits)
	{
		this.vuePuits = vuePuits;
		this.puits = this.vuePuits.getPuits();
	}
	
	public void mouseClicked(java.awt.event.MouseEvent event)
	{
		if(SwingUtilities.isLeftMouseButton(event))
		{
			this.puits.getPieceActuelle().tourner(false);
		}
		else if(SwingUtilities.isRightMouseButton(event))
		{
			this.puits.getPieceActuelle().tourner(true);
		}
	}
}
