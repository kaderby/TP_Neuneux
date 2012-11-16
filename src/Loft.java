	import java.util.LinkedList;

/**
 * Classe qui contient les informations sur l'état du Loft
 * 
 * @author Karim
 *
 */
	
public class Loft {
	
	public int hauteur;
	public int largeur;
	public int energieMin;
	public int energieMax;
	public int energieReproduction;
	public int energiePas;
	public int vieLoft; 				//duree de vie du loft
	public int quantiteNourriture;
	public int quantiteAlcool;
	public int demographie; 			//initiale
	
	public int libido; 					//retard de la (re)prise de libido
	public int energieInitMin; 			//Initialisation de l'energie des lofteurs
	
	//les listes servent à stocker les objets de maniere dynamique
	public LinkedList<Neuneu> listeNeuneux; //contient tous les neuneus
	public LinkedList<Lapin> listeLapins;
	public LinkedList<Nourriture> listeNourriture;
	public LinkedList<Alcool> listeAlcool;
	
	
	public Loft(int taille, int e_min, int e_max, int e_prod, int e_pas, int vie_loft, 
				int q_nour, int q_alcool, int dem, int lib, int enMin )
	{
		hauteur = taille;
		largeur = taille;
		energieMin = e_min;
		energieMax=e_max;
		energieReproduction = e_prod;
		energiePas = e_pas;		
		vieLoft = vie_loft;
		quantiteNourriture = q_nour;
		quantiteAlcool = q_alcool;
		demographie = dem;
		libido = lib;
		energieInitMin = enMin;
		
		//instanciation des listes:
		listeNeuneux = new LinkedList<Neuneu>();
		listeLapins = new LinkedList<Lapin>();
		listeNourriture = new LinkedList<Nourriture>();
		listeAlcool = new LinkedList<Alcool>();
		
		
		
		
	}
	
	
	//differentes methodes qui permettront de gerer les listes
	
	
	public void ajouterNeuneu(Neuneu neuneu)
	{
		listeNeuneux.add(neuneu);
	}
	
	public void retirerNeuneu(Neuneu neuneu)
	{
		listeNeuneux.remove(neuneu);
	}
	
	public void ajouterLapin(Lapin lapin)
	{
		listeLapins.add(lapin);
	}
	
	public void retirerLapin(Lapin lapin)
	{
		listeLapins.remove(lapin);
	}
	
	public void ajouterNourriture(Nourriture nourriture)
	{
		listeNourriture.add(nourriture);
	}
	
	public void retirerNourriture(Nourriture nourriture)
	{
		listeNourriture.remove(nourriture);
	}
	
	public void ajouterAlcool(Alcool alcool)
	{
		listeAlcool.add(alcool);
	}
	
	public void retirerAlcool(Alcool alcool)
	{
		listeAlcool.remove(alcool);
	}
	
	
	
	
}
