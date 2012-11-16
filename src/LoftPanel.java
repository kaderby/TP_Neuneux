//package com.objet.lofteurs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

/**
 * un panneau de dessin pour le loft
 * 
 * @author moreau
 *
 */
class LoftPanel extends JPanel {
	/**
	 * référence sur la liste des objets à dessiner
	 */
	private LinkedList<ObjetDessinable> listeObjets;
	
	/**
	 * constructeur
	 * 
	 * @param listeObjets référence sur la liste des objets (gérée par la ZoneGraphique)
	 */
	public LoftPanel(LinkedList<ObjetDessinable> listeObjets) {
		this.listeObjets = listeObjets;
	}
	
	/**
	 * on redéfinit la méthode paint() : elle se contente d'appeler les méthodes
	 * dessinerObjet() de la liste d'objets dessinables
	 */
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		//creation d'un fond blanc
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//cretion des lignes pour donner le rendu de case à l'ecran
		g.setColor(Color.black);
		for(int k=1;k<100;k++){
		g.drawLine(0, 10*k, 5000, 10*k); 
		}
		for(int k=1;k<100;k++){
		g.drawLine(10*k, 0, 10*k, 2000);
		}
		
		// on redessine tout
		for (ObjetDessinable x : listeObjets) {
			x.dessinerObjet(g);
		}
	}
}
