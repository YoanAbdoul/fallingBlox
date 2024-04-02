package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePiece{
	public static final double MULTIPLIER_TEINTE = 0.3; // ]0,1[
	private final Piece piece;
	private final int taille;
	
	private final java.awt.Color couleur;
	
	public VuePiece(Piece piece, int taille)
	{
		this.piece = piece;
		this.taille = taille;
		
		this.couleur = this.piece.getElements()[0].getCouleur().getCouleurPourAffichage();
	}
	
	public static java.awt.Color teinte(java.awt.Color couleur)
	{
		double r = couleur.getRed();
		double g = couleur.getGreen();
		double b = couleur.getBlue();
		int alpha = couleur.getAlpha();
		
		r = r + (255 - r) * MULTIPLIER_TEINTE;
		g = g + (255 - g) * MULTIPLIER_TEINTE;
		b = b + (255 - b) * MULTIPLIER_TEINTE;
		
		return new java.awt.Color((int) r,(int) g,(int) b, alpha);
	}
	
	public void afficherPiece(java.awt.Graphics2D g2D)
	{
		g2D.setColor(couleur);
		
		for(int i = 1; i < this.piece.getElements().length; i++)
		{
			g2D.fill3DRect(this.piece.getElements()[i].getCoordonnees().getAbscisse()*this.taille
						,this.piece.getElements()[i].getCoordonnees().getOrdonnee()*this.taille
						,this.taille
						,this.taille
						,true);
		}
		
		g2D.setColor(VuePiece.teinte(couleur));
		
		g2D.fill3DRect(this.piece.getElements()[0].getCoordonnees().getAbscisse()*this.taille
				,this.piece.getElements()[0].getCoordonnees().getOrdonnee()*this.taille
				,this.taille
				,this.taille
				,true);
	}
}
