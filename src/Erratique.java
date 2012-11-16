import java.awt.Graphics;
import java.awt.Color;

/**
 * Un Erratique est un Neuneu qui se déplace aléatoirement
 * 
 * @author Karim
 *
 */

public class Erratique extends Neuneu {
     
	
	
	public Erratique(int e, int abs, int ord, Loft l, ZoneGraphique z){        
		energie=e;
		type ="Erratique";
		abscisse = abs;
		ordonnee = ord;
	    vientDeSeReproduire = l.libido;
		myLoft = l;
	    myZone=z;
	    
	    z.ajouterObjet(this);	//l'ajout ds listeneuneux se fait das le main et dans se reproduire
	    
	    
	}
	
	//fonction de deplacement aleatoire du neuneu
	public void seDeplacer(){ 	
		
		int a=  10 * (int) Math.floor( Math.random()*(3)-1);
		int b=  10 * (int) Math.floor( Math.random()*(3)-1);
		
		if (a != 0 || b != 0)
		{		
		int h = this.abscisse+a;
		int v = this.ordonnee+b;
		
		
		if((Math.abs(a)+ Math.abs(b)< 20) 	
			& (h<myLoft.largeur && h>0) & (v<myLoft.hauteur && v>0)	& this.energie>myLoft.energiePas){
			this.abscisse = h;
			this.ordonnee = v;
			this.energie -= myLoft.energiePas;
			
			}
		}	
	}
	
	 
	public void dessinerObjet(Graphics g){
		g.setColor(Color.red);
		g.fillOval(this.abscisse, this.ordonnee, 10, 10); 
	}
	
}
