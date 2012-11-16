import java.awt.Graphics;
import java.awt.Color;

/**
 * Il s'agit d'unités d'énergie à la disposition des neuneux
 * 
 * @author Karim
 *
 */

public class Nourriture implements ObjetDessinable {

	public int abscisse;
	public int ordonnee;
	public int calorie;
	ZoneGraphique myZone;

	
public Nourriture(int cal, int abs, int ord, ZoneGraphique z) {
	this.calorie=cal;
	this.abscisse = abs;
	this.ordonnee = ord;
	myZone = z;
	z.ajouterObjet(this);
}


public void dessinerObjet(Graphics g){
	g.setColor(Color.orange);
	g.fillRect(this.abscisse, this.ordonnee, 10, 10); // position en x de l'objet
}


}
