package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class PanneauInformation extends javax.swing.JPanel implements java.beans.PropertyChangeListener{
	private Puits puits;
	
	private VuePiece vuePiece;
	
	public static final String MODIFICATION_PIECE_SUIVANTE = "modification pièce suivante";
	
	public static final int TAILLE_PAR_DEFAUT = 10;
	
	public PanneauInformation(Puits puits)
	{
		this.puits = puits;
		this.vuePiece = null;
		
		// ajuster la taille
		super.setPreferredSize(new Dimension(70, 70));
		
		this.puits.addPropertyChangeListener(this);
	}
	
	public void propertyChange(java.beans.PropertyChangeEvent event)
	{
		if(event.getPropertyName().equals(MODIFICATION_PIECE_SUIVANTE))
		{
			this.vuePiece = new VuePiece((Piece) event.getNewValue(), 10);
			this.repaint();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		// partie pour pouvoir dessiner
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g.create();
		
		// partie qui dessine
		
		// dessiner la VuePiece
		if(this.vuePiece != null)
		{
			this.vuePiece.afficherPiece(g2D);
		}

		// partie qui libère la mémoire
		g2D.dispose();
	}
}
