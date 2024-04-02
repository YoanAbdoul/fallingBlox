package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CouleurTest {
	@Test
	public void testGetCouleurPourAffichage()
	{
		Couleur couleur = Couleur.VIOLET;
		assertEquals(java.awt.Color.MAGENTA, couleur.getCouleurPourAffichage(), "la couleur correspond");
	}
	
	@Test
	public void testGetCouleurAleatoire()
	{
		Couleur couleur = Couleur.getCouleurAleatoire();
		boolean contientCouleur = false;
		for(int i = 0; i < Couleur.values().length; i++)
		{
			if(Couleur.values()[i].equals(couleur))
			{
				contientCouleur = true;
			}
		}
		assertTrue(contientCouleur);
	}
	
	@Test
	public void testGetCouleurParChoix()
	{
		assertEquals(Couleur.ORANGE, Couleur.getCouleurParChoix(1), "la couleur correspond");
	}
	
	@Test
	public void testGetCouleurParDefaut()
	{
		assertEquals(Couleur.ROUGE, Couleur.getCouleurParDefaut(), "la couleur par défaut est bien le ROUGE");
	}
}
