package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Random;

public enum Couleur {
	ROUGE(java.awt.Color.RED),
	ORANGE(java.awt.Color.ORANGE),
	BLEU(java.awt.Color.BLUE),
	VERT(java.awt.Color.GREEN),
	JAUNE(java.awt.Color.YELLOW),
	CYAN(java.awt.Color.CYAN),
	VIOLET(java.awt.Color.MAGENTA);
	
	private final java.awt.Color couleurPourAffichage;
	
	private Couleur(java.awt.Color couleurPourAffichage) 
	{
		this.couleurPourAffichage = couleurPourAffichage;
	}
	
	public java.awt.Color getCouleurPourAffichage()
	{
		return this.couleurPourAffichage;
	}
	
	public static Couleur getCouleurAleatoire()
	{
		Random random = new Random();
		Couleur[] couleurs = Couleur.values();
		return couleurs[random.nextInt(7)];
	}
	
	public static Couleur getCouleurParChoix(int choix)
	{
		Couleur[] couleurs = Couleur.values();
		return couleurs[choix%7];
	}
	
	public static Couleur getCouleurParDefaut()
	{
		return Couleur.ROUGE;
	}
}
