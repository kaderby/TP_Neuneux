
/**
 * La classe qui contient le main
 * 
 * @author Karim
 *
 */

public class Saison1 {
	
	//rouge 	Erratique
	//noir 		Vorace
	//vert 		Cannibale
	//rose 		Lapin
	
	//orange 	Nourriture
	//bleu 		Alcool
	
		
//-------------------------------------------------
// PARAMETRES DE LA SAISON
	
	////////////////////////////////////////////////////
	//Les Neuneux

//	static int 	nombreLofteurs 			= 100; 	
//	static float proportionErratique 	= .3f;
//	static float proportionVorace 		= .3f;
//	static float proportionCannibale 	= 0.2f;
//	static float proportionLapin 		= 0.2f;
//	
//	static int dem = 25;					//Nombre de Neuneux initial
	
	static int nombreErratique 	= 1;
	static int nombreVorace 	= 0;
	static int nombreCannibale 	= 0;
	static int nombreLapin 		= 0;
	static int dem = nombreErratique + nombreVorace + nombreCannibale + nombreLapin;
	
	static int energieMinInitiale = 200; 
	
	static int e_min=10;					//Energie Minimale sinon mourir
	static int e_max=100;					//Energie Minimale sinon excedant d'energie
	static int e_prod=10;					//Energie de reproduction
	static int e_pas=2;						//Energie fournie dans un pas
	
	static int lib = 20;					//Temps de (re) prise de Libido
	
	static int taille=400;					//Taille
						
	////////////////////////////////////////////////////
	//La Nourriture et Alcool
	static int q_nour=350;					//Quantité de Nourriture initiale
	static int q_alcool=0;					//Quantité d'Alcool initiale
		
	
	////////////////////////////////////////////////////
	static int enMin = 200;					//Energie minimale lors de l'initialisation "+10*random()*10"
											
	static int vie_loft=1000;				//Durée de vie du loft

//FIN PARAMETRAGE
//-------------------------------------------------
	
	
		
	public static void main(String[] args) {
		
		int taille_reduite = (int)(taille/10);
		ZoneGraphique zone = new ZoneGraphique("Contemplez la vie au Loft !", 100+taille);
	    Loft loft = new Loft(taille, e_min, e_max, e_prod, e_pas, vie_loft, q_nour, q_alcool, dem, lib, enMin );
		 
//-------------------------------------------------
//Initialisation du jeu avec les neuneux et la nourriture/alcool
	    
	    
//		for (int i=0, d= 0 ; i<nombreLofteurs && d<dem ; i++) { //tend vers une repartition selon les proportions .. §§§§§
//			double x = Math.random();
//			if (x<proportionVorace) {
//				loft.ajouterNeuneu(new Vorace(enMin+10*(int)Math.floor(Math.random()*10),
//						10*(int)Math.floor(Math.random()*taille_reduite),
//						10*(int)Math.floor(Math.random()*taille_reduite),loft,zone));
//						d++;
//			}
//			else {
//				x -= proportionVorace;
//				if (x<proportionErratique) {
//					loft.ajouterNeuneu(new Erratique(enMin+10*(int)Math.floor(Math.random()*10),
//							10*(int)Math.floor(Math.random()*taille_reduite),
//							10*(int)Math.floor(Math.random()*taille_reduite),loft,zone));
//							d++;
//					
//				}
//				else {
//					x -= proportionErratique;
//					if (x<proportionCannibale) {
//					loft.ajouterNeuneu(new Cannibale(enMin+10*(int)Math.floor(Math.random()*10),
//							10*(int)Math.floor(Math.random()*taille_reduite),
//							10*(int)Math.floor(Math.random()*taille_reduite),loft,zone));
//							d++;
//					}
//					else {
//						x -= proportionCannibale;
//						if (x<proportionLapin){
//							Lapin lapin = new Lapin(enMin+10*(int)Math.floor(Math.random()*10),
//									10*(int)Math.floor(Math.random()*taille_reduite),
//									10*(int)Math.floor(Math.random()*taille_reduite),loft,zone);
//									d++;
//							loft.ajouterNeuneu(lapin);
//							loft.ajouterLapin(lapin);
//						}						
//					}
//				}
//			}
//		}
	    
	    for (int i=0; i<nombreErratique ; i++){
			loft.ajouterNeuneu(new Erratique(enMin+10*(int)Math.floor(Math.random()*10),
					10*(int)Math.floor(Math.random()*taille_reduite),
					10*(int)Math.floor(Math.random()*taille_reduite),loft,zone));					
		}
	    for (int i=0; i<nombreVorace ; i++){
			loft.ajouterNeuneu(new Vorace(enMin+10*(int)Math.floor(Math.random()*10),
					10*(int)Math.floor(Math.random()*taille_reduite),
					10*(int)Math.floor(Math.random()*taille_reduite),loft,zone));					
		}
	    for (int i=0; i<nombreCannibale ; i++){
			loft.ajouterNeuneu(new Cannibale(enMin+10*(int)Math.floor(Math.random()*10),
					10*(int)Math.floor(Math.random()*taille_reduite),
					10*(int)Math.floor(Math.random()*taille_reduite),loft,zone));					
		}
	    for (int i=0; i<nombreLapin ; i++){
	    	Lapin lapin = new Lapin(enMin+10*(int)Math.floor(Math.random()*10),
					10*(int)Math.floor(Math.random()*taille_reduite),
					10*(int)Math.floor(Math.random()*taille_reduite),loft,zone);					
			loft.ajouterNeuneu(lapin);
			loft.ajouterLapin(lapin);					
		}	
		
		

		////////////////////////////////////////////////////
		
		for (int k =0; k<q_nour; k++){
			loft.ajouterNourriture(new Nourriture(10,
					10*(int)Math.floor(Math.random()*taille_reduite),
					10*(int)Math.floor(Math.random()*taille_reduite),zone));
		}
		 
		for (int k =0; k<q_alcool; k++){
			loft.ajouterAlcool(new Alcool(10,
					10*(int)Math.floor(Math.random()*taille_reduite),
					10*(int)Math.floor(Math.random()*taille_reduite),zone));
		}
		
//fin d'initialisation
//----------------------------------------------------
				
		 
		 //DEBUT DU JEU DU JOU 1 JUSQU AU DERNIER JOUR = DUREE DE VIE DU LOFT
		 for (int k=1; k<(vie_loft+1); k++){
			 	 
			 
			 for(int i=0; i<loft.listeNeuneux.size();i++){
				 
				 //on test s'il y a de la Nourriture
				 int a =loft.listeNeuneux.get(i).testNourriture();
				 			 
				 if(a >=0){
					//là on sait que le Neuneu se trouve où il y a de la nourriture:
					 loft.listeNeuneux.get(i).manger(loft.listeNourriture.get(a));
				 }
				 
				 //on teste s'il y a reproduction
				 int b =loft.listeNeuneux.get(i).testReproduire(); 
				 if(b >=0 & b!=i){
						//là on sait que le Neuneu se trouve avec un AUTRE neuneu de même type
						 loft.listeNeuneux.get(i).seReproduire(b);
						 //System.out.println("UN NEUNEU VIENT DE NAITRE !!");
					 }
				 
				 
				 //se deplacer s'il en a encore l'énergie.. avec differenciation de la strategie du neuneu
				 //suivant le type de neuneu
				 
				 if (loft.listeNeuneux.get(i).type=="Erratique"){
					 ((Erratique) loft.listeNeuneux.get(i)).seDeplacer();	
				}
				if (loft.listeNeuneux.get(i).type=="Vorace"){ 
					((Vorace) loft.listeNeuneux.get(i)).seDeplacer();	
				}
				
				if (loft.listeNeuneux.get(i).type=="Lapin"){
					((Lapin) loft.listeNeuneux.get(i)).seDeplacer();
				}
				
				 //augmenter la libido
				 if (loft.listeNeuneux.get(i).vientDeSeReproduire>0) loft.listeNeuneux.get(i).vientDeSeReproduire-=1;
				 
				//on va tester la presence d'un autre neuneu
				 loft.listeNeuneux.get(i).mourir();
				 
				 if (loft.listeNeuneux.get(i).type=="Cannibale"){
						((Cannibale) loft.listeNeuneux.get(i)).seDeplacer();
						if(loft.listeNeuneux.get(i).neuneuLePlusProche().get(3) == 0){
							int m = loft.listeNeuneux.get(i).neuneuLePlusProche().get(0);
							if(loft.listeNeuneux.get(m).type != "Cannibale" || loft.listeNeuneux.get(m).vientDeSeReproduire != 0){
							((Cannibale) loft.listeNeuneux.get(i)).mangerNeuneu(loft.listeNeuneux.get(m));
							}
						}
											 
					}
				 }
			 
			 
			 //on repeind les objets pour donner l'impression de dyamisme à chaque passage dans la boucle 
			 zone.repaint();
			 
		//COMMENT 
		 try {
             Thread.sleep(200);
             } catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
             }		 
		 }	
			
	}		

}
