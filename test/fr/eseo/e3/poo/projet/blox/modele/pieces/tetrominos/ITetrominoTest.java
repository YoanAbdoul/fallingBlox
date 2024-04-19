package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

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
	
	@Test
	public void testToString()
	{
		ITetromino itetromino = new ITetromino(new Coordonnees(5, 5), Couleur.CYAN);
		String expected = "ITetromino :\n"
				+"\t(5, 5) - CYAN\n"
				+"\t(5, 6) - CYAN\n"
				+"\t(5, 3) - CYAN\n"
				+"\t(5, 4) - CYAN\n";
		assertEquals(expected, itetromino.toString(), "Le ToString foncitonne");
	}
	
	@Test
	public void testSetPosition()
	{
		ITetromino itetromino = new ITetromino(new Coordonnees(2, 3), Couleur.CYAN);
		itetromino.setPosition(5, 5);
		String expected = "ITetromino :\n"
				+"\t(5, 5) - CYAN\n"
				+"\t(5, 6) - CYAN\n"
				+"\t(5, 3) - CYAN\n"
				+"\t(5, 4) - CYAN\n";
		assertEquals(expected, itetromino.toString(), "La position est bien ordonnée");
	}
	
	@Test
	public void testGetSetPuits()
	{
		ITetromino itetromino = new ITetromino(new Coordonnees(2, 3), Couleur.CYAN);
		Puits puits = new Puits();
		itetromino.setPuits(puits);
		assertEquals(puits, itetromino.getPuits(), "Le puits est bien le même");
	}
	
	@Test
	public void testDeplacerDe1()
	{
		ITetromino itetromino = new ITetromino(new Coordonnees(2, 3), Couleur.CYAN);
		assertThrows(IllegalArgumentException.class, () -> {
			itetromino.deplacerDe(2, 0);
		});
	}
	
	@Test
	public void testDeplacerDe2()
	{
		ITetromino itetromino = new ITetromino(new Coordonnees(2, 3), Couleur.CYAN);
		assertThrows(IllegalArgumentException.class, () -> {
			itetromino.deplacerDe(0, 2);
		});
	}
	
	@Test
	public void testDeplacerDe3()
	{
		ITetromino itetromino = new ITetromino(new Coordonnees(2, 3), Couleur.CYAN);
		assertThrows(IllegalArgumentException.class, () -> {
			itetromino.deplacerDe(0, -1); 
		});
	}
	
	@Test
	public void testDeplacerDe4()
	{
		ITetromino itetromino = new ITetromino(new Coordonnees(5, 5), Couleur.CYAN);
		try {
			itetromino.deplacerDe(0, 0);
		} catch (BloxException e) {}
		String expected = "ITetromino :\n"
				+"\t(5, 5) - CYAN\n"
				+"\t(5, 6) - CYAN\n"
				+"\t(5, 3) - CYAN\n"
				+"\t(5, 4) - CYAN\n";
		assertEquals(expected, itetromino.toString(), "Le déplacement est OK");
	}
	
	@Test
	public void testDeplacerDe5()
	{
		Puits puits = new Puits(10, 15);
		ITetromino itetromino = new ITetromino(new Coordonnees(5, 13), Couleur.CYAN);
		itetromino.setPuits(puits);
		assertThrows(BloxException.class, () -> {
			itetromino.deplacerDe(0, 1); 
		});
	}
	
	@Test
	public void testDeplacerDe6()
	{
		Puits puits = new Puits(10, 15);
		ITetromino itetromino = new ITetromino(new Coordonnees(0, 13), Couleur.CYAN);
		itetromino.setPuits(puits);
		assertThrows(BloxException.class, () -> {
			itetromino.deplacerDe(-1, 0); 
		});
	}
	
	@Test
	public void testDeplacerDe7()
	{
		Puits puits = new Puits(10, 15);
		ITetromino itetromino = new ITetromino(new Coordonnees(9, 13), Couleur.CYAN);
		itetromino.setPuits(puits);
		assertThrows(BloxException.class, () -> {
			itetromino.deplacerDe(1, 0); 
		});
	}
	
	@Test
	public void testDeplacerDe8()
	{
		Puits puits = new Puits(10, 15, 39, 4);
		ITetromino itetromino = new ITetromino(new Coordonnees(9, 5), Couleur.CYAN);
		itetromino.setPuits(puits);
		assertThrows(BloxException.class, () -> {
			for(int i = 0; i < 5; i++)
				itetromino.deplacerDe(0, 1); 
		});
	}
	
	@Test
	public void testTourner1()
	{
		ITetromino itetromino = new ITetromino(new Coordonnees(5, 5), Couleur.CYAN);
		try {
			itetromino.tourner(true);
		} catch (BloxException e) {}
		String expected = "ITetromino :\n"
				+"\t(5, 5) - CYAN\n"
				+"\t(4, 5) - CYAN\n"
				+"\t(7, 5) - CYAN\n"
				+"\t(6, 5) - CYAN\n";
		assertEquals(expected, itetromino.toString(), "La rotation est OK");
	}
	
	@Test
	public void testTourner2()
	{
		Puits puits = new Puits(10, 15);
		ITetromino itetromino = new ITetromino(new Coordonnees(0, 13), Couleur.CYAN);
		itetromino.setPuits(puits);
		assertThrows(BloxException.class, () -> {
			itetromino.tourner(true); 
		});
	}
	
	@Test
	public void testTourner3()
	{
		Puits puits = new Puits(10, 15);
		ITetromino itetromino = new ITetromino(new Coordonnees(9, 13), Couleur.CYAN);
		itetromino.setPuits(puits);
		assertThrows(BloxException.class, () -> {
			itetromino.tourner(false); 
		});
	}
	
	@Test
	public void testTourner4()
	{
		Puits puits = new Puits(10, 15);
		ITetromino itetromino = new ITetromino(new Coordonnees(5,5), Couleur.CYAN);
		itetromino.setPuits(puits);
		try {
			itetromino.tourner(true);
			for(int i = 0; i < 9; i++)
			{
				itetromino.deplacerDe(0, 1);
			}
		} catch (BloxException e) {}
		assertThrows(BloxException.class, () -> {
			itetromino.tourner(true); 
		});
	}
	
	@Test
	public void testTourner5()
	{
		Puits puits = new Puits(10, 15, 39, 4);
		ITetromino itetromino = new ITetromino(new Coordonnees(5,5), Couleur.CYAN);
		itetromino.setPuits(puits);
		try {
			itetromino.tourner(true);
			for(int i = 0; i < 5; i++)
			{
				itetromino.deplacerDe(0, 1);
			}
		} catch (BloxException e) {}
		assertThrows(BloxException.class, () -> {
			itetromino.tourner(true); 
		});
	}
	
	@Test
	public void testDeplacerVersLeBas1()
	{
		Puits puits = new Puits(10, 15);
		ITetromino itetromino = new ITetromino(new Coordonnees(5, 5), Couleur.CYAN);
		itetromino.deplacerVersLeBas(puits.getTas());
		String expected = "ITetromino :\n"
				+"\t(5, 13) - CYAN\n"
				+"\t(5, 14) - CYAN\n"
				+"\t(5, 11) - CYAN\n"
				+"\t(5, 12) - CYAN\n";
		assertEquals(expected, itetromino.toString(), "Le déplacement est OK");
	}
	
	@Test
	public void testDeplacerVersLeBas2()
	{
		Puits puits = new Puits(10, 15, 39, 4);
		ITetromino itetromino = new ITetromino(new Coordonnees(5, 5), Couleur.CYAN);
		itetromino.deplacerVersLeBas(puits.getTas());
	}
	
}
