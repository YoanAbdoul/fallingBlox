package fr.eseo.e3.poo.projet.blox.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Tas {
	private List<Element> elements;
	private Puits puits;
	
	private java.beans.PropertyChangeSupport pcs;
	
	public static final String DESTRUCTION_LIGNE = "ligne détruite";
	
	public Tas(Puits puits, int nbElements, int nbLignes, Random rand)
	{
		this.puits = puits;
		this.elements = new ArrayList<Element>();
		this.construireTas(nbElements, nbLignes, rand);
		
		this.pcs = new java.beans.PropertyChangeSupport(this);
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
		
		// on détruit les lignes créées par l'ajout d'éléments
		this.destructionDesLignes();
	}
	
	public void destructionDesLignes()
	{
		//création d'un tableau d'entier qui va contenir le nombre de blocs qu'il y a à chaque ligne
		int[] tableauNombreBloc = new int[this.puits.getProfondeur()];
		int ordonnee;
		for(int i = 0; i < this.elements.size(); i++)
		{
			ordonnee = this.elements.get(i).getCoordonnees().getOrdonnee();
			tableauNombreBloc[ordonnee]++;
		}
		
		//on regarde quel ligne est complète via le tableau et on la supprime
		int nombreLignesDetruites = 0;
		for(int i = 0; i < tableauNombreBloc.length; i++)
		{
			if(tableauNombreBloc[i] >= this.puits.getLargeur())
			{
				this.supprimerUneLigne(i);
				nombreLignesDetruites++;
				this.pcs.firePropertyChange(DESTRUCTION_LIGNE, 0, nombreLignesDetruites);
			}
		}
		
		//puis on décale le tas vers le bas pour toutes les lignes effacées
		this.decalerVersLeBas(tableauNombreBloc);
	}
	
	private void decalerVersLeBas(int[] tableauNombreBloc)
	{
		int newOrdonnee;
		for(int i = 0; i < this.elements.size(); i++)
		{
			for(int j = 0; j < tableauNombreBloc.length; j++)
			{
				if(tableauNombreBloc[j] >= this.puits.getLargeur()
				&& this.elements.get(i).getCoordonnees().getOrdonnee() < j)
				{
					newOrdonnee = this.elements.get(i).getCoordonnees().getOrdonnee()+1;
					this.elements.get(i).getCoordonnees().setOrdonnee(newOrdonnee);
				}
			}
		}
	}
	
	public void supprimerUneLigne(int ordonnee)
	{
		// retire chaque élément du Tas de l'abscisse passé en paramètres
		int i = 0;
		int nombreElements = this.elements.size();
		while(i < nombreElements)
		{
			if(this.elements.get(i).getCoordonnees().getOrdonnee() == ordonnee)
			{
				this.elements.remove(i);
				nombreElements--;
			}
			else
			{
				i++;
			}
		}
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
