package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Objects;

import org.junit.jupiter.api.Test;

public class CoordonneesTest {
	
	@Test
	public void testContructeur1()
	{
		Coordonnees point = new Coordonnees(5, 7);
		assertEquals(5, point.getAbscisse(), "constructeur abscisse valide");
		assertEquals(7, point.getOrdonnee(), "constructeur ordonnée valide");
	}
	
	@Test
	public void testSetAbscisse()
	{
		Coordonnees point1 = new Coordonnees(5, 7);
		Coordonnees point2 = new Coordonnees(8, 7);
		point1.setAbscisse(8);
		assertEquals(point1, point2, "abscisse valide");
	}
	
	@Test
	public void testSetOrdonnee()
	{
		Coordonnees point1 = new Coordonnees(5, 7);
		Coordonnees point2 = new Coordonnees(5, 9);
		point1.setOrdonnee(9);
		assertEquals(point1, point2, "ordonnee valide");
	}
	
	@Test
	public void testToString()
	{
		Coordonnees point = new Coordonnees(12, 15);
		assertEquals("(12, 15)", point.toString());
	}
	
	@Test
	public void testEquals1()
	{
		Coordonnees point1 = new Coordonnees(5, 7);
		Coordonnees point2 = new Coordonnees(5, 9);
		assertFalse(point1.equals(point2));
	}
	
	@Test
	public void testEquals2()
	{
		Coordonnees point1 = new Coordonnees(5, 7);
		Coordonnees point2 = new Coordonnees(7, 7);
		assertFalse(point1.equals(point2));
	}
	
	@Test
	public void testEquals3()
	{
		Coordonnees point1 = new Coordonnees(5, 7);
		Couleur couleur = Couleur.BLEU;
		assertFalse(point1.equals(couleur));
	}
	
	@Test
	public void testEquals4()
	{
		Coordonnees point1 = new Coordonnees(5, 7);
		Coordonnees point2 = new Coordonnees(5, 7);
		assertFalse(point1.equals(point2), "coordonnees identiques");
	}
	
	@Test
	public void testEquals5()
	{
		Coordonnees point1 = new Coordonnees(5, 7);
		Coordonnees point2 = null;
		assertFalse(point1.equals(point2));
	}
	
	@Test
	public void testEquals6()
	{
		Coordonnees point1 = new Coordonnees(5, 7);
		assertFalse(point1.equals(point1));
	}
	
	@Test
	public void testHashCode()
	{
		Coordonnees point = new Coordonnees(12, 15);
		assertEquals(point.hashCode(), Objects.hash(point.getAbscisse(), point.getOrdonnee()));
	}
}
