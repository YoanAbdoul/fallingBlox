package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.awt.Color;
import java.awt.Graphics2D;

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
	
	public static Color teinte(Color couleur)
	{
		double r = couleur.getRed();
		double g = couleur.getGreen();
		double b = couleur.getBlue();
		int alpha = couleur.getAlpha();
		
		r = r + (255 - r) * MULTIPLIER_TEINTE;
		g = g + (255 - g) * MULTIPLIER_TEINTE;
		b = b + (255 - b) * MULTIPLIER_TEINTE;
		
		return new Color((int) r,(int) g,(int) b, alpha);
	}
	
	public static Color teinteFantome(Color couleur)
	{
		double r = couleur.getRed();
		double g = couleur.getGreen();
		double b = couleur.getBlue();
		double alpha = couleur.getAlpha();
		
		alpha /= 2;
		
		return new Color((int) r,(int) g,(int) b, (int) alpha);
	}
	
	public void afficherPiece(Graphics2D g2D)
	{
		// dessin de la pièce normale
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
	
	public void afficherPiecePlusFantome(Graphics2D g2D)
	{
		// dessin de la pièce fantôme
		Coordonnees[] tableauCoordonneesFantome = this.piece.positionBas();
		g2D.setColor(VuePiece.teinteFantome(couleur));
		for(int i = 0; i < tableauCoordonneesFantome.length; i++)
		{
			g2D.fill3DRect(tableauCoordonneesFantome[i].getAbscisse()*this.taille
					,tableauCoordonneesFantome[i].getOrdonnee()*this.taille
					,this.taille
					,this.taille
					,true);
		}
		
		// dessin de la pièce normale
		this.afficherPiece(g2D);
	}
}
