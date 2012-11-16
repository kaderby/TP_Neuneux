import java.awt.Color;
import java.awt.Graphics;

/**
 * Il s'agit d'unités d'énergie comme la nourriture
 * 
 * @author Karim
 *
 */

public class Alcool implements ObjetDessinable {

	
	public int abscisse;
	public int ordonnee;
	public int calorie;
	ZoneGraphique myZone;
	
	
	public Alcool(int cal, int abs, int ord, ZoneGraphique z) {
		this.calorie=cal;
		this.abscisse = abs;
		this.ordonnee = ord;
		myZone = z;
		z.ajouterObjet(this);
	}


	public void dessinerObjet(Graphics g){
		g.setColor(Color.blue);
		g.fillRect(this.abscisse, this.ordonnee, 10, 10); // position en x de l'objet
	}
}

