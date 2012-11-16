import java.awt.Graphics;
import java.awt.Color;

/**
 * Un Cannibale est un Vorace qui se déplace pour manger de la nourriture
 * ou des neuneux
 * 
 * @author Karim
 *
 */
public class Cannibale extends Vorace {
	
	public Cannibale(int e, int abs, int ord, Loft l, ZoneGraphique z){
		super(e,abs,ord,l,z);
		type = "Cannibale";
		//System.out.println("Cannible né !!");
	}
	
	//le cannibale se deplace suivant la distance min vers la nourriture ou un neuneu
	public void seDeplacer(){
		
		int depx = 0;
		int depy = 0;
		
		if ((this.neuneuLePlusProche().get(0)>-1) & (Math.abs(this.neuneuLePlusProche().get(3))< Math.abs(this.neuneuLePlusProche().get(3)))){
		depx = this.neuneuLePlusProche().get(1);
		depy = this.neuneuLePlusProche().get(2);
		}
		else{
		depx = this.neuneuLePlusProche().get(1);
		depy = this.neuneuLePlusProche().get(2);	
		}
		
		int x = this.prochaineCase(depx,depy).get(0);
		int y = this.prochaineCase(depx,depy).get(1);
		
		if((this.abscisse+10*x)<myLoft.largeur & (this.abscisse+10*x)>0 
				& (this.abscisse+10*y)<myLoft.hauteur & (this.abscisse+10*y)>0 
				& this.energie>myLoft.energiePas){
				this.abscisse += 10*x;
				this.ordonnee += 10*y;
				this.energie -= myLoft.energiePas;
			}		
	}	
		
	//dans le cas ou il mange un neuneu, celui-ci doit disparaire du jeu
	public void mangerNeuneu(Neuneu neuneu){						
		if (this.energie<myLoft.energieMax) 
			{this.energie+= neuneu.energie;}
			if (this.energie>myLoft.energieMax) {
				neuneu.energie=(this.energie-myLoft.energieMax);
				this.energie = myLoft.energieMax;}
			else if (this.energie<=myLoft.energieMax){
				neuneu.energie=0;
				//dans ce cas on retire la nourriture
				 myLoft.retirerNeuneu(neuneu);
				 //System.out.println("Une neuneu vient d'etre mangé !!");
				 myZone.retirerObjet(neuneu); 
				 //System.out.println("Une neuneu vient de disparaitre !!");
				 }
	}
	public void dessinerObjet(Graphics g){
		g.setColor(Color.green);
		g.fillOval(this.abscisse, this.ordonnee, 10, 10);
	}
	
}

