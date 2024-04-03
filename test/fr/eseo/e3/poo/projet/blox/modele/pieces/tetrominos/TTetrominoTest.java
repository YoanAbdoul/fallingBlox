package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;

public class TTetrominoTest {
	@Test
	public void testToString()
	{
		TTetromino piece = new TTetromino(new Coordonnees(6, 5), Couleur.BLEU);
		String expected = "TTetromino :\n"
				+"\t(6, 5) - BLEU\n"
				+"\t(7, 5) - BLEU\n"
				+"\t(5, 5) - BLEU\n"
				+"\t(6, 6) - BLEU\n";
		assertEquals(expected, piece.toString());
	}
}
