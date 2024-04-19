
package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
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
		
		this.puits = null;
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
		int deltaX = abscisse - this.elements[0].getCoordonnees().getAbscisse();
		int deltaY = ordonnee - this.elements[0].getCoordonnees().getOrdonnee();
		this.deplacerDeAdmin(deltaX, deltaY);
		
		// ancienne façon de faire 
//		Coordonnees origine = new Coordonnees(abscisse, ordonnee);
//		for(int i = 0; i < this.elements.length; i++)
//		{
//			this.elements[i].setCoordonnees(origine);
//		}
//		this.deplacementOrigine(origine);
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
	
	public void deplacerDe(int deltaX, int deltaY) throws BloxException
	{
		if(Math.abs(deltaX) > 1 || deltaY < 0 || deltaY > 1)
		{
			throw new IllegalArgumentException("déplacement interdit");
		}
		
		// on regarde si on déplace la pièce vers une position impossible avant de lancer une Exception
		int problem = this.deplacerDeBloxException(deltaX, deltaY);
		if(problem == 1)
		{
			throw new BloxException("déplacement interdit", BloxException.BLOX_COLLISION);
		}
		else if(problem == 2)
		{
			throw new BloxException("déplacement interdit", BloxException.BLOX_SORTIE_PUITS);
		}
		
		for(int i = 0; i < this.elements.length; i++){
			this.elements[i].deplacerDe(deltaX, deltaY);
		}
	}
	
	private int deplacerDeBloxException(int deltaX, int deltaY)
	{
		int problem = 0;

		// on regarde si le déplacment créé un problème 
		if(this.puits != null) {
			for(int i = 0; i < this.elements.length; i++){
				int abscisseFutur = this.elements[i].getCoordonnees().getAbscisse()+deltaX;
				int ordonneeFutur = this.elements[i].getCoordonnees().getOrdonnee()+deltaY;
				if(this.puits.getTas().elementExists(abscisseFutur, ordonneeFutur)
					|| ordonneeFutur >= this.puits.getProfondeur()){
					problem = 1;
				}
				else if(abscisseFutur >= this.puits.getLargeur()
					|| abscisseFutur < 0){
					problem = 2;
				}
			}
		}
		
		return problem;
	}
	
	private void deplacerDeAdmin(int deltaX, int deltaY)
	{
		for(int i = 0; i < this.elements.length; i++)
		{
			this.elements[i].deplacerDe(deltaX, deltaY);
		}
	}
	
	public void tourner(boolean sensHoraire) throws BloxException
	{
		int abscisseDeBase = this.elements[0].getCoordonnees().getAbscisse();
		int ordonneeDeBase = this.elements[0].getCoordonnees().getOrdonnee();
		
		// on regarde si le déplacment créé un problème 
		int problem = 0;
		if(this.puits != null)
		{
			problem = this.tournerBloxException(sensHoraire);
		}
		if(problem == 1)
		{
			throw new BloxException("déplacement interdit", BloxException.BLOX_COLLISION);
		}
		else if(problem == 2)
		{
			throw new BloxException("déplacement interdit", BloxException.BLOX_SORTIE_PUITS);
		}
		
		// deplacement vers l'origine
		this.deplacerDeAdmin(-abscisseDeBase, -ordonneeDeBase);
		
		// rotation
		int x;
		int y;
		if(!sensHoraire){
			for(int i = 1; i < this.elements.length; i++){
				x = this.elements[i].getCoordonnees().getAbscisse();
				y = this.elements[i].getCoordonnees().getOrdonnee();
				this.elements[i].setCoordonnees(new Coordonnees(y, -x));
			}
		}else {
			for(int i = 1; i < this.elements.length; i++){
				x = this.elements[i].getCoordonnees().getAbscisse();
				y = this.elements[i].getCoordonnees().getOrdonnee();
				this.elements[i].setCoordonnees(new Coordonnees(-y, x));
			}
		}
		
		// retour à la position de base
		this.deplacerDeAdmin(abscisseDeBase, ordonneeDeBase);
	}
	
	private int tournerBloxException(boolean sensHoraire)
	{
		int problem = 0;
		
		int abscisseDeBase = this.elements[0].getCoordonnees().getAbscisse();
		int ordonneeDeBase = this.elements[0].getCoordonnees().getOrdonnee();
		
		// on regarde si on déplace la pièce vers une position impossible avant de lancer une Exception
		int abscisseFutur;
		int ordonneeFutur; 
		int temp;
		
		for(int i = 0; i < this.elements.length; i++)
		{
			abscisseFutur = this.elements[i].getCoordonnees().getAbscisse() - abscisseDeBase;
			ordonneeFutur = this.elements[i].getCoordonnees().getOrdonnee() - ordonneeDeBase;
			temp = abscisseFutur;
			if(!sensHoraire)
			{
				abscisseFutur = ordonneeFutur;
				ordonneeFutur = -temp;
			}
			else
			{
				abscisseFutur = -ordonneeFutur;
				ordonneeFutur = temp;
			}
			abscisseFutur = abscisseFutur + abscisseDeBase;
			ordonneeFutur = ordonneeFutur + ordonneeDeBase;
			
			if(this.puits.getTas().elementExists(abscisseFutur, ordonneeFutur)
				|| ordonneeFutur >= this.puits.getProfondeur()){
				problem = 1;
			}
			else if(abscisseFutur >= this.puits.getLargeur()
				|| abscisseFutur < 0){
				problem = 2;
			}
		}
		
		return problem;
	}
	
	public void deplacerVersLeBas()
	{
		boolean peutAllerEnBas = true;
		int i;
		int abscisseAChecker;
		int ordonneeAChecker;
		while(peutAllerEnBas && this.puits != null)
		{
			i = 0;
			while(peutAllerEnBas && i < this.elements.length)
			{
				abscisseAChecker = this.elements[i].getCoordonnees().getAbscisse();
				ordonneeAChecker = this.elements[i].getCoordonnees().getOrdonnee()+1;
				if(this.checkCollision(abscisseAChecker, ordonneeAChecker))
				{
					peutAllerEnBas = false;
				}
				i++;
			}
			if(peutAllerEnBas)
			{
				this.deplacerDeAdmin(0, 1);
			}
		}
	}
	
	public boolean deplacementPossible(int abscisse, int ordonnee)
	{
		boolean deplacementPossible = true;
		
		int ancienAbscisse = this.elements[0].getCoordonnees().getAbscisse();
		int ancienOrdonnee = this.elements[0].getCoordonnees().getOrdonnee();
		
		this.setPosition(abscisse, ordonnee);
		
		for(int i = 0; i < this.elements.length; i++)
		{
			int abscisseFutur = this.elements[i].getCoordonnees().getAbscisse();
			int ordonneeFutur = this.elements[i].getCoordonnees().getOrdonnee();
			if(this.checkCollision(abscisseFutur, ordonneeFutur))
			{
				deplacementPossible = false;
			}
		}
		
		this.setPosition(ancienAbscisse, ancienOrdonnee);
		
		return deplacementPossible;
	}
	
	/*
	 * return un tableau de Coordonnees correpondant au positionnement de la pièce si elle était déplacée
	 * tout en bas du tableau
	 */
	public Coordonnees[] positionBas()
	{
		int abscisseDeBase = this.elements[0].getCoordonnees().getAbscisse();
		int ordonneeDeBase = this.elements[0].getCoordonnees().getOrdonnee();
		
		this.deplacerVersLeBas();
		
		Coordonnees[] tableauCoordonnees = new Coordonnees[this.elements.length];
		for(int i = 0; i < this.elements.length; i++)
		{
			int abscisse = this.elements[i].getCoordonnees().getAbscisse();
			int ordonnee = this.elements[i].getCoordonnees().getOrdonnee();
			tableauCoordonnees[i] = new Coordonnees(abscisse, ordonnee);
		}
		
		this.setPosition(abscisseDeBase, ordonneeDeBase);
		
		return tableauCoordonnees;
	}
	
	public boolean checkCollision(int abscisse, int ordonnee)
	{
		boolean haveACollision = false;
		if(this.puits.getTas().elementExists(abscisse, ordonnee)
			|| ordonnee >= this.puits.getProfondeur()
			|| abscisse >= this.puits.getLargeur()
			|| abscisse < 0)
		{
			haveACollision = true;
		}
		return haveACollision;
	}
}
