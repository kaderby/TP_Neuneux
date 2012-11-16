import java.awt.Graphics;
import java.awt.Color;

public class Lapin extends Neuneu {

/**
 * Un Lapin est un Neuneu qui se déplace pour s'accoupler avec
 * le Lapin le plus proche
 * 
 * @author Karim
 *
 */	
	
	public Lapin(int e, int abs, int ord, Loft l, ZoneGraphique z){        
		energie=e;
		type ="Lapin";
		abscisse = abs;
		ordonnee = ord;
		vientDeSeReproduire = l.libido;
	    myLoft = l;
	    myZone=z;
	    z.ajouterObjet(this); //l'ajout ds listeneuneux et listeLapins se fait das le main et dans se reproduire
	    l.ajouterLapin(this);
	}
	
	
	public void seDeplacer(){ 		//ils cherchent surtout un partenaire pour se reproduire
		if (this.lapinLePlusProche().get(0) != -1){
		int depx = this.lapinLePlusProche().get(1);
		int depy = this.lapinLePlusProche().get(2);
		
		int x = this.prochaineCase(depx,depy).get(0);
		int y = this.prochaineCase(depx,depy).get(1);
		//System.out.println("destinationX " + x);
		//System.out.println("destinationY " + y);
				
			if((this.abscisse+10*x)<myLoft.largeur & (this.abscisse+10*x)>0 
				& (this.abscisse+10*y)<myLoft.hauteur & (this.abscisse+10*y)>0 
				& this.lapinLePlusProche().get(0)>-1
				& this.energie>myLoft.energiePas){
				this.abscisse += 10*x;
				this.ordonnee += 10*y;
				this.energie -= myLoft.energiePas;
			}		
		}
		
		else{
			int a=  10 * (int) Math.floor( Math.random()*(3)-1);
			int b=  10 * (int) Math.floor( Math.random()*(3)-1);
			
			if (a != 0 || b != 0)
			{		
			int h = this.abscisse+a;
			int v = this.ordonnee+b;
			
			
			if((Math.abs(a)+ Math.abs(b)< 20) & (h<myLoft.largeur && h>0) & (v<myLoft.hauteur && v>0)
					& this.energie>myLoft.energiePas){
				this.abscisse = h;
				this.ordonnee = v;
				this.energie -= myLoft.energiePas;
				
				}
			}
		}
		
	}
	
	
	public void retirerUnLapin(){ 	//sert a caster dans la methode mourir de neuneu
		myLoft.retirerLapin(this);
	}
	
	public void dessinerObjet(Graphics g){
		g.setColor(Color.pink);
		//g.fillOval(this.abscisse, this.ordonnee, 10, 10); // position en x de l'objet
	    g.fillRoundRect(this.abscisse, this.ordonnee, 10, 10, 10, 10); 
	}
	
}
