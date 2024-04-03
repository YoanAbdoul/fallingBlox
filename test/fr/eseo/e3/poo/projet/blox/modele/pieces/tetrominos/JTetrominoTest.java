package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;

public class JTetrominoTest {
	@Test
	public void testToString()
	{
		JTetromino piece = new JTetromino(new Coordonnees(6, 5), Couleur.JAUNE);
		String expected = "JTetromino :\n"
				+"\t(6, 5) - JAUNE\n"
				+"\t(5, 5) - JAUNE\n"
				+"\t(6, 3) - JAUNE\n"
				+"\t(6, 4) - JAUNE\n";
		assertEquals(expected, piece.toString());
	}
}
