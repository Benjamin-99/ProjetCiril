package project;

public class Initial implements Etat {// Etat d'un arbre
	   @SuppressWarnings("unused")
	private Arbre arbre;

	    public Initial(Arbre arbre)
	    {
	        this.arbre = arbre;
	    }

	    public boolean appliqueEffet(int tour)
	    {
	        return false;
	    }

}
