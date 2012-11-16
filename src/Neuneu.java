import java.util.LinkedList;

/**
 * Classe abstraite implémentant l'interface ObjetDessinable et contenant les méthodes
 * générales de tous les types de neuneux
 * 
 * @author Karim
 *
 */

public abstract class Neuneu implements ObjetDessinable{

	public int abscisse;
	public int ordonnee;
	public int energie;
	public String type;
	public int vientDeSeReproduire;
	Loft myLoft;
	ZoneGraphique myZone;

	//Methodes presentes dans cette classe:
	//testNourriture
	//manger
	//testReproduire
	//seReproduire
	//mourir
	//prochaineCase
	//nourritureLaPlusProche
	//neuneuLePlusProche
	//LapinLePlusProche
	
	
		
	
	 
	//la fonction renvoie -10 quand il n'y a pas de nourriture la ou se
	//trouve le neuneu dans le cas contraire l'indice de la nourriture a manger
	//dans listeNourriture
		
	public int testNourriture(){
		int a;
		a=-10;
		int posiX = this.abscisse;
		int posiY = this.ordonnee;
		if (myLoft.listeNourriture.size()!=0){
			for(int k=0; k<myLoft.listeNourriture.size(); k++){
				int nourritureX = 0;
				nourritureX = myLoft.listeNourriture.get(k).abscisse;
				if(nourritureX==posiX){
					//si l'abscisse de la position du neuneu correspond avec
					//l'abscisse de la nourriture courante on teste l'ordonnee
					int nourritureY;
					nourritureY = myLoft.listeNourriture.get(k).ordonnee;
					if(nourritureY==posiY){
						a = k;
					}					
				}				
			}
		}
		return a;
	}
		
	//on appellera la methode manger seulement quand testNourriture donnera
	//un resulat différent de -10 donc si les conditions pour manger seront remplies
		
	public void manger(Nourriture nourriture){						
		if (this.energie<myLoft.energieMax) 
			{this.energie+= nourriture.calorie;}
			if (this.energie>myLoft.energieMax) {
				nourriture.calorie=(this.energie-myLoft.energieMax);
				this.energie = myLoft.energieMax;}
			else if (this.energie<=myLoft.energieMax){
				nourriture.calorie=0;
				//dans ce cas on retire la nourriture
				 myLoft.retirerNourriture(nourriture);
				 myZone.retirerObjet(nourriture); 
				 }
	}

		
	//la fonction renvoie -10 quand il n'y a pas de neuneu la ou se
	//trouve le neuneu dans le cas contraire l'indice de la nourriture a manger
	//dans listeNourriture
	
	public int testReproduire(){
		 	int a		;
			a			=-10;
			int posiX 	=this.abscisse;
			int posiY 	=this.ordonnee;
			if (myLoft.listeNeuneux.size()>0){
				for(int k=(myLoft.listeNeuneux.size()-1); k>-1; k--){		//parcours inverse de la listeNeuneux
					int neuneuX = 0;
					neuneuX = myLoft.listeNeuneux.get(k).abscisse;
					if(neuneuX==posiX){
						//si l'abscisse de la position courante correspond avec
						//l'abscisse de la nourriture on test l'ordonnee
						int neuneuY;
						neuneuY = myLoft.listeNeuneux.get(k).ordonnee;
						if(neuneuY==posiY){
							if (myLoft.listeNeuneux.get(k).type==this.type 						//neuneux de même type
								
								& this.energie>myLoft.energieReproduction 						//assez d'energie
								& myLoft.listeNeuneux.get(k).energie>myLoft.energieReproduction	
								
								& myLoft.listeNeuneux.get(k).vientDeSeReproduire==0				//assez de libido
								& this.vientDeSeReproduire==0){
								a = k;
							}
						}					
					}				
				}
			}
		return a;
		}
			
	
	//fonction qui lance la creation d'un nouveau neuneu de meme type et de meme position que le neuneu d'indice a
		
	public void seReproduire(int a){	//s'ils se retrouvent a plusieurs, ils peuvent se reproduire
		
		if (this.type=="Erratique"){
				myLoft.ajouterNeuneu(new Erratique(myLoft.energieInitMin+10*(int)Math.floor(Math.random()*10),
				this.abscisse, this.ordonnee,myLoft,myZone));
				myLoft.listeNeuneux.get(a).vientDeSeReproduire=myLoft.libido;
				this.vientDeSeReproduire=myLoft.libido;
		}
		if (this.type=="Vorace"){
				myLoft.ajouterNeuneu(new Vorace(myLoft.energieInitMin+10*(int)Math.floor(Math.random()*10),
				this.abscisse, this.ordonnee,myLoft,myZone));
				myLoft.listeNeuneux.get(a).vientDeSeReproduire=myLoft.libido;
				this.vientDeSeReproduire=myLoft.libido;
		}
		if (this.type=="Cannibale"){
				myLoft.ajouterNeuneu(new Cannibale(myLoft.energieInitMin+10*(int)Math.floor(Math.random()*10),
				this.abscisse, this.ordonnee,myLoft,myZone));
				myLoft.listeNeuneux.get(a).vientDeSeReproduire=myLoft.libido;
				this.vientDeSeReproduire=myLoft.libido;
		}
		if (this.type=="Lapin"){
				Lapin lapin = new Lapin(myLoft.energieInitMin+10*(int)Math.floor(Math.random()*10),
						this.abscisse, this.ordonnee,myLoft,myZone);
				myLoft.ajouterNeuneu(lapin);
				//myLoft.ajouterLapin(lapin);
				myLoft.listeNeuneux.get(a).vientDeSeReproduire=myLoft.libido;
				this.vientDeSeReproduire=myLoft.libido;
		}
		this.energie-=myLoft.energieReproduction;
		this.vientDeSeReproduire+=myLoft.libido;
	}
		
	
	//fonction qui fait disparaitre le neuneu de la "listeNeuneux" du loft et de la "liste"
	//de la zoneGraphique
	
	public void mourir(){
		
		if (this.energie < myLoft.energieMin)
		{
			myLoft.retirerNeuneu(this);
			myZone.retirerObjet(this);
			if (this.type=="Lapin"){         //On a implémenté la méthode retirerUnLapin de Lapin et retirerLapin de Loft
			((Lapin) this).retirerUnLapin();
			}
		}
	}
	
	
	//fonction donnant la prochaine desination

	public LinkedList<Integer> prochaineCase(int x, int y){ 					
		
		LinkedList<Integer> l = new LinkedList<Integer>();			
		
		int a = 0;
		int b = 0;
			//la on est sur que la distance est differente de 0, donc x ou y different
			//de 0
				
			if(((int)Math.abs(x)+(int)Math.abs(y))!= 0){
				if(((int)Math.abs(x)<=(int)Math.abs(y))){
					//ici la composante de y est la plus forte donc c'est y qui va bouger:
					//si egalite c'est un deplacement suivant y 
					int valeurabs = (int)Math.abs(y);
					 b = (int)(y/valeurabs);					
				}
				else{// maintenant c'est x qui est la plus forte donc c'est elle qui bouge: 
					int valeurabs = (int)Math.abs(x);
					a = (int)(x/valeurabs);
				}				
			}
		l.add(a);
		l.add(b);
		return l ;
	}		
		
		
		
	//fonction qui donne le deplacement necessaire vers la nourriture la plus proche
	
	public LinkedList<Integer> nourritureLaPlusProche(){ 					
		
		LinkedList<Integer> l = new LinkedList<Integer>();
		
		int indexpluspetit=-1;
		int NourrX = -1;
		int NourrY = -1;
		int distance = myLoft.hauteur;
		
		if (myLoft.listeNourriture.size()!=0){
			for(int k=0; k<myLoft.listeNourriture.size(); k++){
				int distanceCourante;
				int dx = (int)((myLoft.listeNourriture.get(k).abscisse -this.abscisse)/10);
				int dy = (int)((myLoft.listeNourriture.get(k).ordonnee -this.ordonnee)/10);
				distanceCourante = (int)(Math.abs(dx)+Math.abs(dy));
			    //distance represente le nombre de pas pour faire la distance courante
			    if(distanceCourante <=distance){
			    	distance = distanceCourante;
			    	indexpluspetit = k;
			    }		
			}
			
			NourrX = ((myLoft.listeNourriture.get(indexpluspetit).abscisse - this.abscisse));
			NourrY = ((myLoft.listeNourriture.get(indexpluspetit).ordonnee - this.ordonnee));
			
			
		}
		
		l.add(indexpluspetit);
		l.add(NourrX);
		l.add(NourrY);
		l.add(distance);
		
		return l;
	}
				
	//fonction qui donne le deplacement necessaire vers le neuneu la plus proche			
	
	public LinkedList<Integer> neuneuLePlusProche(){ 					
		
		LinkedList<Integer> l = new LinkedList<Integer>();
		
		int indexpluspetit=-1;
		int NeuneuX = -1;
		int NeuneuY = -1;
		int distance = myLoft.hauteur;
		
		if (myLoft.listeNeuneux.size()>1){
				for(int k=(myLoft.listeNeuneux.size()-1); k>-1; k--){
					int dx = (int)((myLoft.listeNeuneux.get(k).abscisse -this.abscisse)/10);
					int dy = (int)((myLoft.listeNeuneux.get(k).ordonnee -this.ordonnee)/10);
					int distanceCourante = (int)(Math.abs(dx)+Math.abs(dy));
				    //distance represente le nombre de pas pour faire la distance courante
				    if(distanceCourante<distance & myLoft.listeNeuneux.indexOf(this)!= k 
				    	& myLoft.listeNeuneux.get(k).vientDeSeReproduire==0){	
				    distance = distanceCourante;
				    indexpluspetit = k;    
				    }				  
				    
				}			
				if(indexpluspetit!=-1){ 
				NeuneuX = ((myLoft.listeNeuneux.get(indexpluspetit).abscisse - this.abscisse));
				NeuneuY = ((myLoft.listeNeuneux.get(indexpluspetit).ordonnee - this.ordonnee));	
				}
				
		}
		
		
		l.add(indexpluspetit);
		l.add(NeuneuX);
		l.add(NeuneuY);
		l.add(distance);		
		return l;
		
	}			
				
	//fonction qui donne le deplacement necessaire vers le lapin la plus proche
	
	public LinkedList<Integer> lapinLePlusProche(){
		
		LinkedList<Integer> l = new LinkedList<Integer>();
		
		int indexpluspetit=-1;
		int LapinX = -1;
		int LapinY = -1;
		int distance = myLoft.hauteur;
		
		if (myLoft.listeLapins.size()>1){
				for(int k=(myLoft.listeNeuneux.size()-1); k>-1; k--){
					int dx = (int)((myLoft.listeNeuneux.get(k).abscisse -this.abscisse)/10);
					int dy = (int)((myLoft.listeNeuneux.get(k).ordonnee -this.ordonnee)/10);
					int distanceCourante = (int)(Math.abs(dx)+Math.abs(dy));
				    //distance represente le nombre de pas pour faire la distance courante
				    if(distanceCourante<distance & myLoft.listeNeuneux.get(k).type=="Lapin" 
				    	& myLoft.listeNeuneux.indexOf(this)!=k & myLoft.listeNeuneux.get(k).vientDeSeReproduire==0){	
				    distance = distanceCourante;
				    indexpluspetit = k;    
				    }				  
				    
				}				
				if(indexpluspetit!=-1){ 
				LapinX = ((myLoft.listeNeuneux.get(indexpluspetit).abscisse - this.abscisse));
				LapinY = ((myLoft.listeNeuneux.get(indexpluspetit).ordonnee - this.ordonnee));	
				}
				
		}
		
		
		l.add(indexpluspetit);
		l.add(LapinX);
		l.add(LapinY);
		l.add(distance);		
		return l;
		
	}

		public  int getAbscisse(){
			return this.abscisse;
			
		}
		
		public void setAbscisse(int e){
			
			this.abscisse = e;
		}
		
		public  int getOrdonnee(){
			return this.ordonnee;
			
		}
		
		public void setOrdonnee(int e){
			
			this.ordonnee = e;
		}	
}
