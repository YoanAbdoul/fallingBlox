package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;

public class STetrominoTest {
	@Test
	public void testToString()
	{
		STetromino piece = new STetromino(new Coordonnees(6, 5), Couleur.VIOLET);
		String expected = "STetromino :\n"
				+"\t(6, 5) - VIOLET\n"
				+"\t(5, 5) - VIOLET\n"
				+"\t(6, 4) - VIOLET\n"
				+"\t(7, 4) - VIOLET\n";
		assertEquals(expected, piece.toString());
	}
}
