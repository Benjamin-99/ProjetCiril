package project;

import java.util.ArrayList;
import java.util.Random;

public class Arbre {// Element de la grille qui permet de materialiser la propagation 
	 private ArrayList <Arbre> voisins;
	    @SuppressWarnings("unused")
		private Position position;
	    private Etat etat;
	    private Random random;
	    private int updated;

	    public Arbre(Position position) // constructeur
	    {
	        this.position = position;
	        this.etat = new Initial(this);
	        voisins = new ArrayList <Arbre> ();
	        random = new Random();
	        this.updated = -1;
	    }

	    public void ajouterArbre(Arbre arbre) // ajouter un arbre aux voisins d'un arbre
	    {
	        if (!voisins.contains(arbre))
	        {
	            voisins.add(arbre);
	            arbre.ajouterArbre(this);
	        }
	    }

	    public boolean appliqueEffet(int tour)
	    {
	        if (this.updated != tour)
	            return etat.appliqueEffet(tour);
	        return true;
	    }

	    public void mettreFeu(int tour) // mettre le feu a un arbre
	    {
	        etat = new Feu(this);
	        this.updated=tour;
	    }

	    public void essaieFeu(int tour) // vérifier si le feu se propage ou pas
	    {
	        if (this.etat.getClass().equals(Initial.class))
	            if (random.nextInt(100)+1 < Grille.P)
	                this.mettreFeu(tour);
	    }

	    public void mettreCendre()// mettre la cendre a un arbre
	    {
	        etat = new Cendre(this);
	    }

	    public ArrayList <Arbre> getVoisins()
	    {
	        return voisins;
	    }

	    public Etat getEtat()
	    {
	        return this.etat;
	    }

	    public int getUpdated()
	    {
	        return this.updated;
	    }

	    public void incrementeUpdated()	// permet de connaitre le nombre de fois que l'arbre est modifié
	    {
	        this.updated++;
	    }
}
