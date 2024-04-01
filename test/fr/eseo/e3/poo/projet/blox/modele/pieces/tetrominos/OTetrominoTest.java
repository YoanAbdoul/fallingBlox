package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class OTetrominoTest {
	@Test
	public void testConstructeur()
	{
		OTetromino otetromino = new OTetromino(new Coordonnees(6,5), Couleur.CYAN);
		Element[] elements = new Element[4];
		elements[0] = new Element(6, 5, Couleur.CYAN);
		elements[1] = new Element(7, 5, Couleur.CYAN);
		elements[2] = new Element(6, 4, Couleur.CYAN);
		elements[3] = new Element(7, 4, Couleur.CYAN);
		assertEquals(elements[0], otetromino.getElements()[0]);
		assertEquals(elements[1], otetromino.getElements()[1]);
		assertEquals(elements[2], otetromino.getElements()[2]);
		assertEquals(elements[3], otetromino.getElements()[3]);
	}
	
	@Test
	public void testSetElements()
	{
		OTetromino otetromino = new OTetromino(new Coordonnees(76,0), Couleur.VIOLET);
		otetromino.setElements(new Coordonnees(6,5), Couleur.CYAN);
		Element[] elements = new Element[4];
		elements[0] = new Element(6, 5, Couleur.CYAN);
		elements[1] = new Element(7, 5, Couleur.CYAN);
		elements[2] = new Element(6, 4, Couleur.CYAN);
		elements[3] = new Element(7, 4, Couleur.CYAN);
		assertEquals(elements[0], otetromino.getElements()[0]);
		assertEquals(elements[1], otetromino.getElements()[1]);
		assertEquals(elements[2], otetromino.getElements()[2]);
		assertEquals(elements[3], otetromino.getElements()[3]);
	}
	
	@Test
	public void testSetPosition()
	{
		OTetromino otetromino = new OTetromino(new Coordonnees(76,0), Couleur.CYAN);
		otetromino.setPosition(6,5);
		Element[] elements = new Element[4];
		elements[0] = new Element(6, 5, Couleur.CYAN);
		elements[1] = new Element(7, 5, Couleur.CYAN);
		elements[2] = new Element(6, 4, Couleur.CYAN);
		elements[3] = new Element(7, 4, Couleur.CYAN);
		assertEquals(elements[0], otetromino.getElements()[0]);
		assertEquals(elements[1], otetromino.getElements()[1]);
		assertEquals(elements[2], otetromino.getElements()[2]);
		assertEquals(elements[3], otetromino.getElements()[3]);
	}
	
	@Test
	public void testEquals()
	{
		OTetromino otetromino = new OTetromino(new Coordonnees(6,5), Couleur.CYAN);
		String chaine = "OTetromino :\n";
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 2; j++)
				chaine += "\t("+(6+j)+", "+(5-i)+") - CYAN\n";
		assertEquals(otetromino.toString(),chaine);
	}
}
