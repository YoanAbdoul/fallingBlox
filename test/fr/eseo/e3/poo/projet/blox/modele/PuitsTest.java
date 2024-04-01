package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;

public class PuitsTest {
	@Test 
	public void testConstructeurVide()
	{
		Puits puits = new Puits();
		assertEquals(10, puits.getLargeur(), "Largeur correct");
		assertEquals(15, puits.getProfondeur(), "Profondeur correct");
		assertNull(puits.getPieceActuelle(), "Piece Actuelle vide");
		assertNull(puits.getPieceSuivante(), "Piece Suivante vide");
	}
	
	@Test 
	public void testConstructeurValide()
	{
		Puits puits = new Puits(7, 18);
		assertEquals(7, puits.getLargeur(), "Largeur correct");
		assertEquals(18, puits.getProfondeur(), "Profondeur correct");
		assertNull(puits.getPieceActuelle(), "Piece Actuelle vide");
		assertNull(puits.getPieceSuivante(), "Piece Suivante vide");
	}
	
	@Test 
	public void testConstructeurNonValide()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Puits(0, 70);
		});
	}
	
	@Test
	public void testSetPieceSuivante1()
	{
		Puits puits = new Puits();
		OTetromino piece1 = new OTetromino(new Coordonnees(0,0), Couleur.BLEU);
		puits.setPieceSuivante(piece1);
		assertNull(puits.getPieceActuelle(), "Piece Actuelle valide");
		assertEquals(piece1, puits.getPieceSuivante(), "Piece Suivante valide");
	}
	
	@Test
	public void testSetPieceSuivante2()
	{
		Puits puits = new Puits();
		OTetromino piece1 = new OTetromino(new Coordonnees(0,0), Couleur.BLEU);
		ITetromino piece2 = new ITetromino(new Coordonnees(0,0), Couleur.VIOLET);
		puits.setPieceSuivante(piece1);
		puits.setPieceSuivante(piece2);
		assertEquals(piece1, puits.getPieceActuelle(), "Piece Actuelle valide");
		assertEquals(piece2, puits.getPieceSuivante(), "Piece Suivante valide");
	}
}
