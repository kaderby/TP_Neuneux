import java.awt.Graphics;
import java.awt.Color;

/**
 * Un Vorace est un Erratique qui se déplace en cherchant la nourriture 
 * 
 * @author Karim
 *
 */

public class Vorace extends Erratique {
	
	
	
	public Vorace(int e, int abs, int ord, Loft l, ZoneGraphique z){	
		super(e,abs,ord,l,z);
		type="Vorace";
	
	}
	

//le vorace se deplace pour trouver de la nourriture	
	public void seDeplacer(){
		
		int depx = this.nourritureLaPlusProche().get(1);
		int depy = this.nourritureLaPlusProche().get(2);
		
		int x = this.prochaineCase(depx,depy).get(0);
		int y = this.prochaineCase(depx,depy).get(1);
		//System.out.println("destinationX " + x);
		//System.out.println("destinationY " + y);
		
		
		if((this.abscisse+10*x)<myLoft.largeur & (this.abscisse+10*x)>0 
			& (this.abscisse+10*y)<myLoft.hauteur & (this.abscisse+10*y)>0 
			& this.nourritureLaPlusProche().get(0)>-1
			& this.energie>myLoft.energiePas){
			this.abscisse += 10*x;
			this.ordonnee += 10*y;
			this.energie -= myLoft.energiePas;
		}		
	}	
	
	
	//fonction manger qui gere la consommation complete ou non de la nourriure sur une case
	
//	public void manger(Nourriture nourriture){						
//		if (this.energie<myLoft.energieMax) 
//			{this.energie+= nourriture.calorie;}
//			if (this.energie>myLoft.energieMax) {
//				nourriture.calorie=0;				
//				this.energie = myLoft.energieMax;
//				myLoft.retirerNourriture(nourriture);
//				myZone.retirerObjet(nourriture); 
//				}
//			else if (this.energie<=myLoft.energieMax){
//				nourriture.calorie=0;
//				//dans ce cas on retire la nourriture
//				 myLoft.retirerNourriture(nourriture);
//				 myZone.retirerObjet(nourriture);
//				 }
//	}

	public void dessinerObjet(Graphics g){
		g.setColor(Color.black);
		g.fillOval(this.abscisse, this.ordonnee, 10, 10);// position en x de l'objet
	}

	
}
