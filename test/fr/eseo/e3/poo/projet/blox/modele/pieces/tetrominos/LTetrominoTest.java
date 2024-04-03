package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;

public class LTetrominoTest {
	@Test
	public void testToString()
	{
		LTetromino piece = new LTetromino(new Coordonnees(6, 5), Couleur.VERT);
		String expected = "LTetromino :\n"
				+"\t(6, 5) - VERT\n"
				+"\t(7, 5) - VERT\n"
				+"\t(6, 3) - VERT\n"
				+"\t(6, 4) - VERT\n";
		assertEquals(expected, piece.toString());
	}
}
