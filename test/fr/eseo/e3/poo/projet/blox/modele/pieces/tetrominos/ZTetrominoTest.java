package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;

public class ZTetrominoTest {
	@Test
	public void testToString()
	{
		ZTetromino piece = new ZTetromino(new Coordonnees(6, 5), Couleur.CYAN);
		String expected = "ZTetromino :\n"
				+"\t(6, 5) - CYAN\n"
				+"\t(7, 5) - CYAN\n"
				+"\t(5, 4) - CYAN\n"
				+"\t(6, 4) - CYAN\n";
		assertEquals(expected, piece.toString());
	}
}
