package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Element {
	private Coordonnees coordonnees;
	private Couleur couleur;
	
	public Element(Coordonnees coordonnees)
	{
		this.coordonnees = coordonnees;
		this.couleur = Couleur.getCouleurParDefaut();
	}
	
	public Element(int abscisse,int ordonnee)
	{
		this.coordonnees = new Coordonnees(abscisse, ordonnee);
		this.couleur = Couleur.getCouleurParDefaut();
	}
	
	public Element(Coordonnees coordonnees, Couleur couleur)
	{
		this.coordonnees = coordonnees;
		this.couleur = couleur;
	}
	
	public Element(int abscisse,int ordonnee, Couleur couleur)
	{
		this.coordonnees = new Coordonnees(abscisse, ordonnee);
		this.couleur = couleur;
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	
	@Override
	public String toString()
	{
		return this.getCoordonnees().toString()+" - "+this.couleur.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(coordonnees, couleur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		return Objects.equals(coordonnees, other.coordonnees) && couleur == other.couleur;
	}
	
	public void deplacerDe(int deltaX, int deltaY)
	{
		this.coordonnees.setAbscisse(this.coordonnees.getAbscisse()+deltaX);
		this.coordonnees.setOrdonnee(this.coordonnees.getOrdonnee()+deltaY);
	}
}
