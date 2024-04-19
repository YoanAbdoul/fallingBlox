package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.JTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.LTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.STetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.TTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ZTetromino;

import java.util.Random;

public class UsineDePiece {
	public static final int ALEATOIRE_COMPLET = 0;
	public static final int ALEATOIRE_PIECE = 1;
	public static final int CYCLIC = 2;

	public static final int NOMBRE_COULEUR = 7;
	public static final int NOMBRE_TYPE_TETROMINO = 7;
	
	public static final int ABSCISSE_PAR_DEFAUT = 2;
	public static final int ORDONNEE_PAR_DEFAUT = 3;
	
	private static int etat = CYCLIC;
	private static int nombreCycle = 0;
	
	private UsineDePiece(){}
	
	public static void setMode(int mode)
	{
		if(mode != CYCLIC)
		{
			nombreCycle = 0;
		}
		etat = mode%3;
	}
	
	
	public static Tetromino genererTetromino()
	{
		Tetromino tetromino;
		Random random = new Random();
		if(etat == ALEATOIRE_COMPLET)
		{
			tetromino = choisirTetromino(random.nextInt(NOMBRE_TYPE_TETROMINO), Couleur.getCouleurAleatoire());
		}
		else if(etat == ALEATOIRE_PIECE)
		{
			tetromino = choisirTetromino(random.nextInt(NOMBRE_TYPE_TETROMINO));
		}
		else
		{
			tetromino = choisirTetromino(nombreCycle%NOMBRE_TYPE_TETROMINO);
			nombreCycle++;
		}
		return tetromino;
	}
	
	private static Tetromino choisirTetromino(int choix, Couleur couleur)
	{
		Tetromino tetromino;
		switch(choix)
		{
			case 0:
				tetromino = new OTetromino(new Coordonnees(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT), couleur);
				break;
			case 1:
				tetromino = new ITetromino(new Coordonnees(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT), couleur);
				break;
			case 2:
				tetromino = new TTetromino(new Coordonnees(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT), couleur);
				break;
			case 3:
				tetromino = new LTetromino(new Coordonnees(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT), couleur);
				break;
			case 4:
				tetromino = new JTetromino(new Coordonnees(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT), couleur);
				break;
			case 5:
				tetromino = new ZTetromino(new Coordonnees(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT), couleur);
				break;
			default:
				tetromino = new STetromino(new Coordonnees(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT), couleur);
				break;
		}
		return tetromino; 
	}
	
	private static Tetromino choisirTetromino(int choix)
	{
		Tetromino tetromino;
		switch(choix)
		{
			case 0:
				tetromino = new OTetromino(new Coordonnees(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT), Couleur.ROUGE);
				break;
			case 1:
				tetromino = new ITetromino(new Coordonnees(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT), Couleur.ORANGE);
				break;
			case 2:
				tetromino = new TTetromino(new Coordonnees(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT), Couleur.BLEU);
				break;
			case 3:
				tetromino = new LTetromino(new Coordonnees(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT), Couleur.VERT);
				break;
			case 4:
				tetromino = new JTetromino(new Coordonnees(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT), Couleur.JAUNE);
				break;
			case 5:
				tetromino = new ZTetromino(new Coordonnees(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT), Couleur.CYAN);
				break;
			default:
				tetromino = new STetromino(new Coordonnees(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT), Couleur.VIOLET);
				break;
		}
		return tetromino;
	}
}
