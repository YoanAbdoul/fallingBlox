package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import javax.swing.Timer;

public class Gravite implements java.awt.event.ActionListener{
	private Timer timer;
	
	private final VuePuits vuePuits;
	private final Puits puits;
	
	public static final int PERIODICITE_PAR_DEFAUT = 3000; // 3s
	private int periodicite;
	
	public Gravite(VuePuits vuePuits)
	{
		this.vuePuits = vuePuits;
		this.puits = this.vuePuits.getPuits();
		this.periodicite = PERIODICITE_PAR_DEFAUT;
		
		this.timer = new Timer(this.periodicite, this);
		this.timer.start();
	}

	public int getPeriodicite() {
		return periodicite;
	}

	public void setPeriodicite(int periodicite) {
		this.periodicite = periodicite;
		this.timer.setDelay(this.periodicite);
		this.timer.restart();
	}
	
	public void actionPerformed(java.awt.event.ActionEvent event)
	{
		this.puits.gravite();
		this.vuePuits.repaint();
	}
}
