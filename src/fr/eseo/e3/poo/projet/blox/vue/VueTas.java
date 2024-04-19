package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Tas;

public class VueTas {
	public static final double MULTIPLIER_NUANCE = 0.4; // ]0,1[
	
	private final VuePuits vuePuits;
	
	private final Tas tas;
	private int taille;
	
	public VueTas(VuePuits vuePuits, int taille)
	{
		this.vuePuits = vuePuits;
		this.taille = taille;
		this.tas = this.vuePuits.getPuits().getTas();
	}
	
	public VueTas(VuePuits vuePuits)
	{ 
		this(vuePuits, vuePuits.getTaille());
	}
	
	public static java.awt.Color nuance(java.awt.Color couleur)
	{
		double r = couleur.getRed();
		double g = couleur.getGreen();
		double b = couleur.getBlue();
		
		r = (int)( r * (1 - MULTIPLIER_NUANCE));
		g = (int)(g * (1 - MULTIPLIER_NUANCE));
		b = (int)(b * (1 - MULTIPLIER_NUANCE));
		
		return new java.awt.Color((int) r,(int) g,(int) b);
	}
	
	public void afficher(java.awt.Graphics2D g2D)
	{
		for(int i = 0; i < this.tas.getElements().size(); i++)
		{
			Element element = this.tas.getElements().get(i);
			g2D.setColor(VueTas.nuance(element.getCouleur().getCouleurPourAffichage()));
			g2D.fill3DRect(element.getCoordonnees().getAbscisse()*this.taille
						,element.getCoordonnees().getOrdonnee()*this.taille
						,this.taille
						,this.taille
						,false);
		}
	}
	
	public VuePuits getVuePuits()
	{
		return this.vuePuits;
	}
}
