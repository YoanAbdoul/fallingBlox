package fr.eseo.e3.poo.projet.blox.modele;

public class Score {
	private int score;
	public static final int SCORE_PAR_DEFAUT = 0;
	public static final int AJOUT_PAR_DEFAUT = 10;
	
	public Score(int score)
	{
		this.score = score;
	}
	
	public Score()
	{
		this(SCORE_PAR_DEFAUT);
	}
	
	public void ajoutAuScore()
	{
		this.score += AJOUT_PAR_DEFAUT;
	}
	
	public void ajoutAuScore(int multiplicateur)
	{
		this.score += AJOUT_PAR_DEFAUT*multiplicateur;
	}
	
	public int getScore()
	{
		return this.score;
	}
}
