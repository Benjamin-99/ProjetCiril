package project;

import java.util.Iterator;

public class Feu implements Etat{// Etat d'un arbre
	 private Arbre arbre;

	    public Feu(Arbre arbre)
	    {
	        this.arbre = arbre;
	    }

	    public boolean appliqueEffet(int tour)//propagation du feu chez ses voisins
	    {
	        @SuppressWarnings("rawtypes")
			Iterator iterateur = arbre.getVoisins().iterator();
	        while (iterateur.hasNext())
	        ((Arbre)iterateur.next()).essaieFeu(tour);
	        this.arbre.mettreCendre();
	        return true;
	    }
}
