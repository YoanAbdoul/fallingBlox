package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

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
	public void testConstructeurNonValide1()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Puits(70, 20);
		});
	}
	
	@Test 
	public void testConstructeurNonValide2()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Puits(0, 20);
		});
	}
	
	@Test 
	public void testConstructeurNonValide3()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Puits(10, 70);
		});
	}
	
	@Test 
	public void testConstructeurNonValide4()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Puits(10, 0);
		});
	}
	
	@Test 
	public void testSetLargeurNonValide1()
	{
		Puits puits = new Puits(10,20);
		assertThrows(IllegalArgumentException.class, () -> {
			puits.setLargeur(0);
		});
	}
	
	@Test 
	public void testSetLargeurNonValide2()
	{
		Puits puits = new Puits(10,20);
		assertThrows(IllegalArgumentException.class, () -> {
			puits.setLargeur(65);
		});
	}
	
	@Test 
	public void testSetLargeur()
	{
		Puits puits = new Puits(10,20);
		puits.setLargeur(11);
		assertEquals(puits.getLargeur(), 11, "Le puits a la bonne largeur");
	}
	
	@Test 
	public void testSetProfondeurNonValide1()
	{
		Puits puits = new Puits(10,20);
		assertThrows(IllegalArgumentException.class, () -> {
			puits.setProfondeur(0);
		});
	}
	
	@Test 
	public void testSetProfondeurNonValide2()
	{
		Puits puits = new Puits(10,20);
		assertThrows(IllegalArgumentException.class, () -> {
			puits.setProfondeur(65);
		});
	}
	
	@Test 
	public void testSetProfondeur()
	{
		Puits puits = new Puits(10,20);
		puits.setProfondeur(21);
		assertEquals(puits.getProfondeur(), 21, "Le puits a la bonne largeur");
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
	
	@Test
	public void testSetTas()
	{
		Puits puits = new Puits();
		Tas tas1 = new Tas(puits);
		puits.setTas(tas1);
		assertEquals(tas1, puits.getTas(), "Le puits a le bon tas");
	}
	
	@Test
	public void testGravite1()
	{
		Puits puits = new Puits();
		puits.setPieceSuivante(UsineDePiece.genererTetromino());
		puits.setPieceSuivante(UsineDePiece.genererTetromino());
		puits.gravite();
		assertEquals(new Coordonnees(puits.getLargeur()/2, -3), puits.getPieceActuelle().getElements()[0].getCoordonnees());
	}
	
	@Test
	public void testGravite2()
	{
		Puits puits = new Puits();
		Piece piece = UsineDePiece.genererTetromino();
		puits.setPieceSuivante(piece);
		puits.setPieceSuivante(UsineDePiece.genererTetromino());
		puits.getPieceActuelle().setPosition(5, puits.getProfondeur()-2);
		puits.gravite();
		assertNotEquals(piece, puits.getPieceActuelle(), "La gravité a changé la pièce");
	}
	
	@Test
	public void testToString1()
	{
		Puits puits = new Puits();
		String expected = "Puits : Dimension 10 x 15\n"
				+"Piece Actuelle : <aucune>\n"
				+"Piece Suivante : <aucune>\n";
		assertEquals(puits.toString(), expected, "Le toString est bon");
	}
	
	@Test
	public void testToString2()
	{
		Puits puits = new Puits();
		Piece piece1 = UsineDePiece.genererTetromino();
		Piece piece2 = UsineDePiece.genererTetromino();
		puits.setPieceSuivante(piece1);
		puits.setPieceSuivante(piece2);
		String expected = "Puits : Dimension 10 x 15\n"
				+"Piece Actuelle : "+piece1.toString()
				+"Piece Suivante : "+piece2.toString();
		assertEquals(puits.toString(), expected, "Le toString est bon");
	}
	
	@Test
	public void testPropertyChangeListener()
	{
		Puits puits1 = new Puits(10, 15);
		Puits puits2 = new Puits(10, 16);
		VuePuits vuePuits = new VuePuits(puits1);
		vuePuits.setPuits(puits2);
		assertNotEquals(puits1, vuePuits.getPuits(), "On a bien changé de Puits");
	}
	
	@Test
	public void testChangementPieces()
	{
		Puits puits = new Puits();
		
	}
}
