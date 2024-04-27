package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;

import fr.eseo.e3.poo.projet.blox.controleur.ControleurClavier;
import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

@SuppressWarnings("serial")
public class VuePuits extends JPanel implements java.beans.PropertyChangeListener{
	public static final int TAILLE_PAR_DEFAUT = 40;
	
	// Le puits fait du 12 x 20
	private int taille; // taille d'un bloc
	private Puits puits;
	
	private VuePiece vuePiece;
	private final VueTas vueTas;
	
	private PieceDeplacement pieceDeplacement;
	private PieceRotation pieceRotation;
	private Gravite gravite;
	
	private ControleurClavier controleurClavier;

	public static final String MODIFICATION_PIECE_ACTUELLE = "modification pièce actuelle";
	public static final String MODIFICATION_PIECE_SUIVANTE = "modification pièce suivante";

	public VuePuits(Puits puits, int taille)
	{
		this.puits = puits;
		this.taille = taille;
		this.setBackground(Color.WHITE); 
		// ajuster la taille
		super.setPreferredSize(new Dimension(this.taille*puits.getLargeur(), this.taille*puits.getProfondeur()));
		
		this.vuePiece = null;
		this.vueTas = new VueTas(this);
		
		// ajout des gestionnaires d'événements
		this.puits.addPropertyChangeListener(this);
		this.pieceDeplacement = new PieceDeplacement(this);
		this.addMouseListener(this.pieceDeplacement);
		this.addMouseMotionListener(this.pieceDeplacement);
		this.addMouseWheelListener(this.pieceDeplacement);
		this.pieceRotation = new PieceRotation(this);
		this.addMouseListener(this.pieceRotation);
		this.gravite = null;
		this.controleurClavier = new ControleurClavier(this);
		this.addKeyListener(this.controleurClavier);
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
		this.removeKeyListener(this.controleurClavier);
		
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
		this.controleurClavier = new ControleurClavier(this);
		this.addKeyListener(this.controleurClavier);
		
		// actualiser la taille
		super.setPreferredSize(new Dimension(this.taille*this.puits.getLargeur(), this.taille*this.puits.getProfondeur()));
	}
	
	public VuePiece getVuePiece() {
		return vuePiece;
	}

	private void setVuePiece(VuePiece vuePiece) {
		this.vuePiece = vuePiece;
	}
	
	public VueTas getVueTas() {
		return vueTas;
	}
	
	public Gravite getGravite() 
	{
		return this.gravite;
	}
	
	public void setGravite(Gravite gravite) 
	{
		this.gravite = gravite;
	}
	
	protected void paintComponent(Graphics g)
	{
		// partie pour pouvoir dessiner
		super.paintComponent(g);
				
		Graphics2D g2D = (Graphics2D)g.create();
		
		g2D.setColor(Color.WHITE);
		g2D.fillRect(0, 0, (int)getPreferredSize().getWidth(),(int) getPreferredSize().getHeight());
		
		// partie qui dessine
		
		// fond blanc
		super.setPreferredSize(new Dimension(this.taille*this.puits.getLargeur(), this.taille*this.puits.getProfondeur()));
		
		// lignes horizontales
		g2D.setColor(java.awt.Color.LIGHT_GRAY);
		for(int i = 0; i < this.puits.getProfondeur()+1; i++)
		{
			g2D.drawLine(0, this.taille*i, this.taille*this.puits.getLargeur(), this.taille*i);
		}
		
		// lignes verticales
		for(int i = 0; i < this.puits.getLargeur()+1; i++)
		{
			g2D.drawLine(this.taille*i, 0, this.taille*i, this.taille*this.puits.getProfondeur());
		}
		
		// dessiner la VuePiece
		if(this.vuePiece != null)
		{
			this.vuePiece.afficherPiecePlusFantome(g2D);
		}
		
		// dessiner la VueTas
		if(this.vueTas != null)
		{
			this.vueTas.afficher(g2D);
		}

		// partie qui libère la mémoire
		g2D.dispose();
	}
	
	public void propertyChange(java.beans.PropertyChangeEvent event)
	{
		if(event.getPropertyName().equals(MODIFICATION_PIECE_ACTUELLE))
		{
			this.setVuePiece(new VuePiece((Piece) event.getNewValue(), this.taille));
		}
	}
}
