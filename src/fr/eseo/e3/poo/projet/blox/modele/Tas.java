package fr.eseo.e3.poo.projet.blox.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Tas {
	private List<Element> elements;
	private Puits puits;
	
	public Tas(Puits puits, int nbElements, int nbLignes, Random rand)
	{
		this.puits = puits;
		this.elements = new ArrayList<Element>();
		this.construireTas(nbElements, nbLignes, rand);
	}
	
	public Tas(Puits puits, int nbElements, int nbLignes)
	{
		this(puits, nbElements, nbLignes, new Random());
	}
	
	public Tas(Puits puits, int nbElements)
	{
		this(puits, nbElements, nbElements/puits.getLargeur()+1);
	}
	
	public Tas(Puits puits)
	{
		this(puits, 0);
	}
	
	public Puits getPuits(){
		return this.puits;
	}
	
	public List<Element> getElements(){
		return this.elements;
	}
	
	private void construireTas(int nbElements, int nbLignes, Random rand)
	{
		if(nbElements != 0 && nbElements >= (this.puits.getLargeur()*nbLignes))
		{
			throw new IllegalArgumentException("tas impossible à générer");
		}
		int nbElementPlaces = 0;
		while(nbElementPlaces < nbElements)
		{
			int ordonnee = this.puits.getProfondeur() - (rand.nextInt(nbLignes)+1);
			int abscisse = rand.nextInt(this.puits.getLargeur());
			if(!this.elementExists(abscisse, ordonnee))
			{
				int indiceCouleur = rand.nextInt(Couleur.values().length);
				this.elements.add(new Element(abscisse, ordonnee, Couleur.getCouleurParChoix(indiceCouleur)));
				nbElementPlaces++;
			}
		}
	}
	
	public boolean elementExists(int abscisse, int ordonnee)
	{
		boolean elementExists = false;
		int i = 0;
		Element element;
		while(!elementExists && i < this.elements.size())
		{
			element = this.elements.get(i);
			if(element.getCoordonnees().equals(new Coordonnees(abscisse, ordonnee)))
			{
				elementExists = true;
			}
			i++;
		}
		return elementExists;
	}
	
	public void ajouterElements(Piece piece)
	{
		for(int i = 0; i < piece.getElements().length; i++)
		{
			this.elements.add(piece.getElements()[i]);
		}
	}
}
