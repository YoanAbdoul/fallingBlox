package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public abstract class Tetromino implements Piece{
	private Element[] elements;
	private Puits puits;
	
	public Tetromino(Coordonnees coordonnees, Couleur couleur)
	{
		this.elements = new Element[4];
		for(int i = 0; i < this.elements.length; i++)
		{
			this.elements[i] = new Element(coordonnees, couleur);
		}
		this.deplacementOrigine(coordonnees);
	}
	
	public Element[] getElements() {
		return elements;
	}
	
	@Override
	public String toString()
	{
		String chaine = this.getClass().getSimpleName()+" :\n";
		for(int i = 0; i < this.elements.length; i++)
		{
			chaine += "\t"+this.elements[i].toString()+"\n";
		}
		return chaine;
	}
	
	public void setPosition(int abscisse, int ordonnee)
	{
		Coordonnees origine = new Coordonnees(abscisse, ordonnee);
		for(int i = 0; i < this.elements.length; i++)
		{
			this.elements[i].setCoordonnees(origine);
		}
		this.deplacementOrigine(origine);
	}
	
	abstract protected void setElements(Coordonnees coordonnees, Couleur couleur);
	abstract protected void deplacementOrigine(Coordonnees coordonnees);
	
	public Puits getPuits()
	{
		return this.puits;
	}
	
	public void setPuits(Puits puits)
	{
		this.puits = puits;
	}
	
	public void deplacerDe(int deltaX, int deltaY)
	{
		if(Math.abs(deltaX) > 1 || deltaY < 0 || deltaY > 1)
		{
			throw new IllegalArgumentException("déplacement interdit");
		}
		for(int i = 0; i < this.elements.length; i++)
		{
			this.elements[i].deplacerDe(deltaX, deltaY);
		}
	}
	
	private void deplacerDeAdmin(int deltaX, int deltaY)
	{
		for(int i = 0; i < this.elements.length; i++)
		{
			this.elements[i].deplacerDe(deltaX, deltaY);
		}
	}
	
	public void tourner(boolean sensHoraire)
	{
		// deplacement vers l'origine
		int abscisseDeBase = this.elements[0].getCoordonnees().getAbscisse();
		int ordonneeDeBase = this.elements[0].getCoordonnees().getOrdonnee();
		this.deplacerDeAdmin(-abscisseDeBase, -ordonneeDeBase);
		
		// rotation
		int x;
		int y;
		if(!sensHoraire)
		{
			for(int i = 1; i < this.elements.length; i++)
			{
				x = this.elements[i].getCoordonnees().getAbscisse();
				y = this.elements[i].getCoordonnees().getOrdonnee();
				this.elements[i].setCoordonnees(new Coordonnees(y, -x));
			}
		}
		else
		{
			for(int i = 1; i < this.elements.length; i++)
			{
				x = this.elements[i].getCoordonnees().getAbscisse();
				y = this.elements[i].getCoordonnees().getOrdonnee();
				this.elements[i].setCoordonnees(new Coordonnees(-y, x));
			}
		}
		
		// retour à la position de base
		this.deplacerDeAdmin(abscisseDeBase, ordonneeDeBase);
	}
}
