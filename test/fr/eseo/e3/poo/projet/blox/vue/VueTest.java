package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Classe uniquement pour moi et m'habituer à l'utilisation de JFrame
public class VueTest {
	public VueTest() {}
	
	public static void main(String[] args) {
		VueTest.testFocus();
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
	
	public static void testFocus()
	{
		JFrame frame = new JFrame("KeyPress Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        JPanel panel = new JPanel();
        frame.add(panel);
        
        panel.setFocusable(true); // Permet à notre panel de recevoir le focus pour écouter les événements de clavier
        
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                System.out.println("Touche Escape pressée !");
            }
        });
        
        //frame.requestFocus();
        
        frame.setVisible(true);
	}
}
