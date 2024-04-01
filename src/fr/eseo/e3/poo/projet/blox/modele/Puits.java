package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Puits {
	public static final int LARGEUR_PAR_DEFAUT = 10; 
	public static final int PROFONDEUR_PAR_DEFAUT = 15;
	
	public static final String MODIFICATION_PIECE_ACTUELLE = "modification pièce actuelle";
	public static final String MODIFICATION_PIECE_SUIVANTE = "modification pièce suivante";
	
	private int largeur;
	private int profondeur;
	
	private Piece pieceActuelle;
	private Piece pieceSuivante;
	
	private java.beans.PropertyChangeSupport pcs;
	
	private Tas tas;
	
	public Puits(int largeur, int profondeur, int nbElments, int nbLignes)
	{
		if(largeur > 15 || largeur < 5 || profondeur > 25 || profondeur < 15)
		{
			throw new IllegalArgumentException("les dimensions du puits ne sont pas respectés");
		}
		this.largeur = largeur;
		this.profondeur = profondeur;
		this.pieceActuelle = null;
		this.pieceSuivante = null;
		
		this.pcs = new java.beans.PropertyChangeSupport(this);
		
		this.tas = new Tas(this, nbElments, nbLignes);
	}
	
	public Puits(int largeur, int profondeur)
	{
		this(largeur, profondeur, 0, 0);
	}
	
	public Puits()
	{
		this(LARGEUR_PAR_DEFAUT, PROFONDEUR_PAR_DEFAUT);
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		if(largeur > 15 || largeur < 5)
		{
			throw new IllegalArgumentException("les dimensions du puits ne sont pas respectés");
		}
		this.largeur = largeur;
	}

	public int getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(int profondeur) {
		if(profondeur > 25 || profondeur < 15)
		{
			throw new IllegalArgumentException("les dimensions du puits ne sont pas respectés");
		}
		this.profondeur = profondeur;
	}

	public Piece getPieceSuivante() {
		return pieceSuivante;
	}

	public Piece getPieceActuelle() {
		return pieceActuelle;
	}

	public void setPieceSuivante(Piece pieceSuivante) {
		if(!(this.pieceSuivante == null))
		{
			pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, this.pieceActuelle, this.pieceSuivante);
			this.pieceActuelle = this.pieceSuivante;
			this.pieceActuelle.setPuits(this);
			this.pieceSuivante.setPosition(this.largeur/2, -4);
		}
		pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, this.pieceSuivante, pieceSuivante);
		this.pieceSuivante = pieceSuivante;
		this.pieceSuivante.setPuits(this);
	}
	
	public Tas getTas() {
		return this.tas;
	}
	
	public void setTas(Tas tas)
	{
		this.tas = tas;
	}
	
	@Override
	public String toString()
	{
		String chaine = "Puits : Dimension "+this.largeur+" x "+15+"\n";
		if(this.pieceActuelle == null)
		{
			chaine += "Piece Actuelle : <aucune>\n";
		}
		else
		{
			chaine += "Piece Actuelle : "+this.pieceActuelle.toString();
		}
		if(this.pieceSuivante == null)
		{
			chaine += "Piece Suivante : <aucune>\n";
		}
		else
		{
			chaine += "Piece Suivante : "+this.pieceSuivante.toString();
		}
		return chaine;
	}
	
	public void addPropertyChangeListener(java.beans.PropertyChangeListener listener)
	{
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(java.beans.PropertyChangeListener listener)
	{
		pcs.removePropertyChangeListener(listener);
	}
}
