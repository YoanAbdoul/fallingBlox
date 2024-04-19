package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;

public class UsineDePieceTest {
	
	@Test
	public void testGenererCyclic()
	{
		UsineDePiece.setMode(UsineDePiece.CYCLIC);
		Tetromino piece1 = UsineDePiece.genererTetromino();
		assertEquals("OTetromino",piece1.getClass().getSimpleName());
		Tetromino piece2 = UsineDePiece.genererTetromino();
		assertEquals("ITetromino",piece2.getClass().getSimpleName());
		Tetromino piece3 = UsineDePiece.genererTetromino();
		assertEquals("TTetromino",piece3.getClass().getSimpleName());
		Tetromino piece4 = UsineDePiece.genererTetromino();
		assertEquals("LTetromino",piece4.getClass().getSimpleName());
		Tetromino piece5 = UsineDePiece.genererTetromino();
		assertEquals("JTetromino",piece5.getClass().getSimpleName());
		Tetromino piece6 = UsineDePiece.genererTetromino();
		assertEquals("ZTetromino",piece6.getClass().getSimpleName());
		Tetromino piece7 = UsineDePiece.genererTetromino();
		assertEquals("STetromino",piece7.getClass().getSimpleName());
		Tetromino piece8 = UsineDePiece.genererTetromino();
		assertEquals("OTetromino",piece8.getClass().getSimpleName());
	}
	
	
	@Test
	public void testGenererAleatoirePiece1()
	{
		UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
		Tetromino piece1 = UsineDePiece.genererTetromino();
		while(!piece1.getClass().getSimpleName().equals("OTetromino"))
			piece1 = UsineDePiece.genererTetromino();
		assertEquals(piece1.getElements()[0].getCouleur(), Couleur.ROUGE);
		Tetromino piece2 = UsineDePiece.genererTetromino();
		while(!piece2.getClass().getSimpleName().equals("ITetromino"))
			piece2 = UsineDePiece.genererTetromino();
		assertEquals(piece2.getElements()[0].getCouleur(), Couleur.ORANGE);
		Tetromino piece3 = UsineDePiece.genererTetromino();
		while(!piece3.getClass().getSimpleName().equals("TTetromino"))
			piece3 = UsineDePiece.genererTetromino();
		assertEquals(piece3.getElements()[0].getCouleur(), Couleur.BLEU);
		Tetromino piece4 = UsineDePiece.genererTetromino();
		while(!piece4.getClass().getSimpleName().equals("LTetromino"))
			piece4 = UsineDePiece.genererTetromino();
		assertEquals(piece4.getElements()[0].getCouleur(), Couleur.VERT);
		
		
	}
	
	@Test
	public void testGenererAleatoirePiece2()
	{
		Tetromino piece5 = UsineDePiece.genererTetromino();
		while(!piece5.getClass().getSimpleName().equals("JTetromino"))
			piece5 = UsineDePiece.genererTetromino();
		assertEquals(piece5.getElements()[0].getCouleur(), Couleur.JAUNE);
		Tetromino piece6 = UsineDePiece.genererTetromino();
		while(!piece6.getClass().getSimpleName().equals("ZTetromino"))
			piece6 = UsineDePiece.genererTetromino();
		assertEquals(piece6.getElements()[0].getCouleur(), Couleur.CYAN);
		Tetromino piece7 = UsineDePiece.genererTetromino();
		while(!piece7.getClass().getSimpleName().equals("STetromino"))
			piece7 = UsineDePiece.genererTetromino();
		assertEquals(piece7.getElements()[0].getCouleur(), Couleur.VIOLET);
	}
	
	@Test
	public void testGenererAleatoireComplet1()
	{
		// le but est de passer par chaque branche
		UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
		Tetromino piece1 = UsineDePiece.genererTetromino();
		while(!piece1.getClass().getSimpleName().equals("OTetromino"))
			piece1 = UsineDePiece.genererTetromino();
		assertNotNull(piece1);
		Tetromino piece2 = UsineDePiece.genererTetromino();
		while(!piece2.getClass().getSimpleName().equals("ITetromino"))
			piece2 = UsineDePiece.genererTetromino();
		assertNotNull(piece2);
		Tetromino piece3 = UsineDePiece.genererTetromino();
		while(!piece3.getClass().getSimpleName().equals("TTetromino"))
			piece3 = UsineDePiece.genererTetromino();
		assertNotNull(piece3);
		Tetromino piece4 = UsineDePiece.genererTetromino();
		while(!piece4.getClass().getSimpleName().equals("LTetromino"))
			piece4 = UsineDePiece.genererTetromino();
		assertNotNull(piece4);
		
	}
	
	@Test
	public void testGenererAleatoireComplet2()
	{
		Tetromino piece5 = UsineDePiece.genererTetromino();
		while(!piece5.getClass().getSimpleName().equals("JTetromino"))
			piece5 = UsineDePiece.genererTetromino();
		assertNotNull(piece5);
		Tetromino piece6 = UsineDePiece.genererTetromino();
		while(!piece6.getClass().getSimpleName().equals("ZTetromino"))
			piece6 = UsineDePiece.genererTetromino();
		assertNotNull(piece6);
		Tetromino piece7 = UsineDePiece.genererTetromino();
		while(!piece7.getClass().getSimpleName().equals("STetromino"))
			piece7 = UsineDePiece.genererTetromino();
		assertNotNull(piece7);
	}
	
}
