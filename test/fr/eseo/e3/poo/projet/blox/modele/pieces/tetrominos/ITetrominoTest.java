package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class ITetrominoTest {
	@Test
	public void testConstructeur()
	{
		ITetromino itetromino = new ITetromino(new Coordonnees(6,5), Couleur.CYAN);
		Element[] elements = new Element[4];
		elements[0] = new Element(6, 5, Couleur.CYAN);
		elements[1] = new Element(6, 6, Couleur.CYAN);
		elements[2] = new Element(6, 3, Couleur.CYAN);
		elements[3] = new Element(6, 4, Couleur.CYAN);
		assertEquals(elements[0], itetromino.getElements()[0]);
		assertEquals(elements[1], itetromino.getElements()[1]);
		assertEquals(elements[2], itetromino.getElements()[2]);
		assertEquals(elements[3], itetromino.getElements()[3]);
	}
	
	@Test
	public void testSetElements()
	{
		ITetromino itetromino = new ITetromino(new Coordonnees(76,0), Couleur.VIOLET);
		itetromino.setElements(new Coordonnees(6,5), Couleur.CYAN);
		Element[] elements = new Element[4];
		elements[0] = new Element(6, 5, Couleur.CYAN);
		elements[1] = new Element(6, 6, Couleur.CYAN);
		elements[2] = new Element(6, 3, Couleur.CYAN);
		elements[3] = new Element(6, 4, Couleur.CYAN);
		assertEquals(elements[0], itetromino.getElements()[0]);
		assertEquals(elements[1], itetromino.getElements()[1]);
		assertEquals(elements[2], itetromino.getElements()[2]);
		assertEquals(elements[3], itetromino.getElements()[3]);
	}
	
	
	@Test
	public void testTournerHoraire()
	{
		ITetromino itetromino = new ITetromino(new Coordonnees(5, 5), Couleur.CYAN);
		try {
			itetromino.tourner(true);
		} catch (BloxException e) {}
		Element[] elements = new Element[4];
		elements[0] = new Element(5, 5, Couleur.CYAN);
		elements[1] = new Element(4, 5, Couleur.CYAN);
		elements[2] = new Element(7, 5, Couleur.CYAN);
		elements[3] = new Element(6, 5, Couleur.CYAN);
		assertEquals(elements[0], itetromino.getElements()[0]);
		assertEquals(elements[1], itetromino.getElements()[1]);
		assertEquals(elements[2], itetromino.getElements()[2]);
		assertEquals(elements[3], itetromino.getElements()[3]);
	}
	
	@Test
	public void testTournerAntiHoraire()
	{
		ITetromino itetromino = new ITetromino(new Coordonnees(5, 5), Couleur.CYAN);
		try {
			itetromino.tourner(false);
		} catch (BloxException e) {}
		Element[] elements = new Element[4];
		elements[0] = new Element(5, 5, Couleur.CYAN);
		elements[1] = new Element(6, 5, Couleur.CYAN);
		elements[2] = new Element(3, 5, Couleur.CYAN);
		elements[3] = new Element(4, 5, Couleur.CYAN);
		assertEquals(elements[0], itetromino.getElements()[0]);
		assertEquals(elements[1], itetromino.getElements()[1]);
		assertEquals(elements[2], itetromino.getElements()[2]);
		assertEquals(elements[3], itetromino.getElements()[3]);
	}
	
}
