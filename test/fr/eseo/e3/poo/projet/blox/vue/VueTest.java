package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

// Classe uniquement pour moi et m'habituer à l'utilisation de JFrame
public class VueTest {
	public VueTest() {}
	
	public static void main(String[] args) {
		VueTest vueTest = new VueTest();
		vueTest.parametresFenetre();
		
		try {
			for(int i = 0; i < 10; i++)
			{
				if(i > 3)
				{
					throw new Exception(""+i);
				}
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void nordSudEstOuest()
	{
		JFrame maFenetre = new JFrame("le titre");
		JLabel monEtiquetteN = new JLabel("NORTH");
		JLabel monEtiquetteE = new JLabel("EAST");
		JLabel monEtiquetteC = new JLabel("CENTER");
		maFenetre.add(monEtiquetteN, BorderLayout.NORTH);
		maFenetre.add(monEtiquetteE, BorderLayout.EAST);
		maFenetre.add(monEtiquetteC);
		
		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		maFenetre.setVisible(true);
	}
	
	public void parametresFenetre()
	{
		// Instancie la fenetre
		JFrame maFenetre = new JFrame("le titre");

		// Modifie la taille de la fenetre
		maFenetre.setSize(400,300);
		
		// taille non modifiable par l'utilisateur 
		maFenetre.setResizable(false);
		
		// contrer la fenetre au milieu de l'écran 
		maFenetre.setLocationRelativeTo(null);
		
		// affiche la fenetre
		maFenetre.setVisible(true);
	}
}
