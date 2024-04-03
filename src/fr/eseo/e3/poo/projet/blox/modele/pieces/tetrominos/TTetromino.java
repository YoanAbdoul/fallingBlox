package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;

public class TTetromino extends Tetromino{
	public TTetromino(Coordonnees coordonnees, Couleur couleur)
	{
		super(coordonnees, couleur);
	}
	
	protected void setElements(Coordonnees coordonnees, Couleur couleur)
	{
		for(int i = 0; i < 4; i++)
		{
			super.getElements()[i].setCouleur(couleur);
		}
		this.deplacementOrigine(coordonnees);
	}
	
	protected void deplacementOrigine(Coordonnees coordonnees)
	{
		// changement des coordonnées de chaque élément par rapport au point d'origine
		super.getElements()[0].setCoordonnees(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee()));
		super.getElements()[1].setCoordonnees(new Coordonnees(coordonnees.getAbscisse()+1, coordonnees.getOrdonnee()));
		super.getElements()[2].setCoordonnees(new Coordonnees(coordonnees.getAbscisse()-1, coordonnees.getOrdonnee()));
		super.getElements()[3].setCoordonnees(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee()+1));
	}
}
