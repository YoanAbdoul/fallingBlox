package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;

public interface Piece {
	public Element[] getElements();
	public void setPosition(int abscisse, int ordonnee);
	public Puits getPuits();
	public void setPuits(Puits puits);
	public void deplacerDe(int deltaX, int deltaY) throws BloxException;
	public void tourner(boolean sensHoraire) throws BloxException;
	
	public void deplacerVersLeBas(Tas tas);
}
