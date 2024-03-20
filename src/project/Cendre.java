package project;

public class Cendre implements Etat{// etat d'un arbre
	
	@SuppressWarnings("unused")
	private Arbre arbre;

	    public Cendre(Arbre arbre)
	    {
	        this.arbre = arbre;
	    }

	    public boolean appliqueEffet(int tour)
	    {
	        return false;
	    }
}
