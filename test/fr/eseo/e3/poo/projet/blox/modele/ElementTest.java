package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Objects;

import org.junit.jupiter.api.Test;

public class ElementTest {
	
	@Test
	public void testConstructeur1()
	{
		Element element = new Element(new Coordonnees(12, 15));
		assertEquals("(12, 15) - ROUGE", element.toString());
	}
	
	@Test
	public void testConstructeur2()
	{
		Element element = new Element(new Coordonnees(12, 15), Couleur.ROUGE);
		assertEquals("(12, 15) - ROUGE", element.toString());
	}
	
	@Test
	public void testConstructeur3()
	{
		Element element = new Element(12, 15);
		assertEquals("(12, 15) - ROUGE", element.toString());
	}
	
	@Test
	public void testConstructeur4()
	{
		Element element = new Element(12, 15, Couleur.ROUGE);
		assertEquals("(12, 15) - ROUGE", element.toString());
	}
	
	@Test
	public void testToString()
	{
		Element element = new Element(new Coordonnees(12, 15), Couleur.VIOLET);
		assertEquals("(12, 15) - VIOLET", element.toString(), "toString() fonctionne");
	}
	
	@Test
	public void testGettersSetters()
	{
		Element element = new Element(12, 15, Couleur.CYAN);
		element.setCoordonnees(new Coordonnees(2, 9));
		element.setCouleur(Couleur.VIOLET);
		assertEquals(new Coordonnees(2, 9), element.getCoordonnees(), "coordonnees valides");
		assertEquals(Couleur.VIOLET, element.getCouleur(), "couleur valide");
	}
	
	@Test
	public void testHashCode()
	{
		Element element = new Element(12, 15, Couleur.JAUNE);
		assertEquals(element.hashCode(), Objects.hash(element.getCoordonnees(), element.getCouleur()));
	}
	
	@Test
	public void testEquals1()
	{
		Element element1 = new Element(1, 0, Couleur.VERT);
		assertTrue(element1.equals(element1));
	}
	
	@Test
	public void testEquals2()
	{
		Element element1 = new Element(1, 0, Couleur.VERT);
		Element element2 = null;
		assertFalse(element1.equals(element2));
	}
	
	@Test
	public void testEquals3()
	{
		Element element1 = new Element(1, 0, Couleur.VERT);
		Couleur couleur = Couleur.VERT;
		assertFalse(element1.equals(couleur));
	}
	
	@Test
	public void testEquals4()
	{
		Element element1 = new Element(1, 0, Couleur.VERT);
		Element element2 = new Element(new Coordonnees(1, 0), Couleur.VERT);
		assertTrue(element1.equals(element2));
	}
	
	@Test
	public void testEquals5()
	{
		Element element1 = new Element(1, 0, Couleur.VERT);
		Element element2 = new Element(new Coordonnees(0, 0), Couleur.VERT);
		assertFalse(element1.equals(element2));
	}
	
	@Test
	public void testEquals6()
	{
		Element element1 = new Element(1, 0, Couleur.VERT);
		Element element2 = new Element(new Coordonnees(1, 0), Couleur.VIOLET);
		assertFalse(element1.equals(element2));
	}
	
	@Test
	public void testEquals7()
	{
		Element element1 = new Element(1, 0, Couleur.VERT);
		Element element2 = new Element(new Coordonnees(0, 0), Couleur.VIOLET);
		assertFalse(element1.equals(element2));
	}
}
