package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Score;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

@SuppressWarnings("serial")
public class PanneauInformation extends javax.swing.JPanel implements java.beans.PropertyChangeListener{
	private Puits puits;
	
	private VuePiece vuePiece;
	
	public static final String MODIFICATION_PIECE_SUIVANTE = "modification pièce suivante";
	
	public static final int TAILLE_PAR_DEFAUT = 10;
	
	private Score score;
	
	public PanneauInformation(Puits puits)
	{
		this.puits = puits;
		this.vuePiece = null; 
		
		// ajuster la taille
		super.setPreferredSize(new Dimension(TAILLE_PAR_DEFAUT*7, TAILLE_PAR_DEFAUT*7));
		
		this.puits.addPropertyChangeListener(this);
		this.puits.getTas().addPropertyChangeListener(this);
		
		// ajout score
		this.score = new Score();
	}
	
	public void propertyChange(java.beans.PropertyChangeEvent event)
	{
		if(event.getPropertyName().equals(MODIFICATION_PIECE_SUIVANTE))
		{
			this.vuePiece = new VuePiece((Piece) event.getNewValue(), TAILLE_PAR_DEFAUT);
			this.repaint();
		}
		if(event.getPropertyName().equals(Tas.DESTRUCTION_LIGNE))
		{
			this.score.ajoutAuScore((int) event.getNewValue());
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
		
		// dessiner le score 
		g2D.setColor(java.awt.Color.BLACK);
		g2D.drawString("Score : "+this.score.getScore(), TAILLE_PAR_DEFAUT*1, TAILLE_PAR_DEFAUT*7);

		// partie qui libère la mémoire
		g2D.dispose();
	}
}
