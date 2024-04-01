package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePuits extends JPanel implements java.beans.PropertyChangeListener{
	public static final int TAILLE_PAR_DEFAUT = 15;
	
	// Le puits fait du 12 x 20
	private int taille; // taille d'un bloc
	private Puits puits;
	
	private VuePiece vuePiece;
	
	private PieceDeplacement pieceDeplacement;
	private PieceRotation pieceRotation;

	public VuePuits(Puits puits, int taille)
	{
		this.puits = puits;
		this.taille = taille;
		
		// ajuster la taille
		super.setPreferredSize(new Dimension(this.taille*puits.getLargeur(), this.taille*puits.getProfondeur()));
		
		this.vuePiece = null;
		
		// ajout des gestionnaires d'événements
		this.puits.addPropertyChangeListener(this);
		this.pieceDeplacement = new PieceDeplacement(this);
		this.addMouseListener(this.pieceDeplacement);
		this.addMouseMotionListener(this.pieceDeplacement);
		this.addMouseWheelListener(this.pieceDeplacement);
		this.pieceRotation = new PieceRotation(this);
		this.addMouseListener(this.pieceRotation);
	}
	
	public VuePuits(Puits puits)
	{
		this(puits, TAILLE_PAR_DEFAUT);
	}

	public int getTaille() {
		return this.taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
		super.setPreferredSize(new Dimension(this.taille*this.puits.getLargeur(), this.taille*this.puits.getProfondeur()));
	}

	public Puits getPuits() {
		return this.puits;
	}

	public void setPuits(Puits puits) {
		// retirer les événements 
		this.puits.removePropertyChangeListener(this);
		this.removeMouseListener(this.pieceDeplacement);
		this.removeMouseMotionListener(this.pieceDeplacement);
		this.removeMouseWheelListener(this.pieceDeplacement);
		this.removeMouseListener(this.pieceRotation);
		
		// changer de puits
		this.puits = puits;
		
		// remettre les événements à jour avec le nouveau puits
		this.puits.addPropertyChangeListener(this);
		this.pieceDeplacement = new PieceDeplacement(this);
		this.addMouseListener(this.pieceDeplacement);
		this.addMouseMotionListener(this.pieceDeplacement);
		this.addMouseWheelListener(this.pieceDeplacement);
		this.pieceRotation = new PieceRotation(this);
		this.addMouseListener(this.pieceRotation);
		
		// actualiser la taille
		super.setPreferredSize(new Dimension(this.taille*this.puits.getLargeur(), this.taille*this.puits.getProfondeur()));
	}
	
	public VuePiece getVuePiece() {
		return vuePiece;
	}

	private void setVuePiece(VuePiece vuePiece) {
		this.vuePiece = vuePiece;
	}
	
	protected void paintComponent(Graphics g)
	{
		// partie pour pouvoir dessiner
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g.create();
		
		// partie qui dessine
		
		// fond blanc
		super.setPreferredSize(new Dimension(this.taille*this.puits.getLargeur(), this.taille*this.puits.getProfondeur()));
		this.setBackground(java.awt.Color.WHITE);
		
		// lignes horizontales
		g2D.setColor(java.awt.Color.LIGHT_GRAY);
		for(int i = 0; i < this.puits.getProfondeur(); i++)
		{
			g2D.drawLine(0, this.taille*i, this.taille*this.puits.getLargeur(), this.taille*i);
		}
		
		// lignes vertocales
		for(int i = 0; i < this.puits.getLargeur(); i++)
		{
			g2D.drawLine(this.taille*i, 0, this.taille*i, this.taille*this.puits.getProfondeur());
		}
		
		// dessiner la VuePiece
		if(!(this.vuePiece == null))
		{
			this.vuePiece.afficherPiece(g2D);
		}
		
		// partie qui libère la mémoire
		g2D.dispose();
	}
	
	public void propertyChange(java.beans.PropertyChangeEvent event)
	{
		if(event.getPropertyName().equals("modification pièce actuelle"))
		{
			this.setVuePiece(new VuePiece((Piece) event.getNewValue(), this.taille));
		}
	}
}
