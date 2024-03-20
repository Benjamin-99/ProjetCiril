package project;

import java.util.Random;

public class Position {// emplacement dans la grille
	  private int x;// axe verticale
	    private int y;//axe horizontale

	    public Position(int x, int y)
	    {
	        this.x = x;
	        this.y = y;
	    }

	    public int getX()
	    {
	        return this.x;
	    }

	    public int getY()
	    {
	        return this.y;
	    }

	    public static Position random()//determiner une position aléatoirement
	    {
	        Random random = new Random();
	        int x = random.nextInt(Grille.H);
	        int y = random.nextInt(Grille.L);
	        return new Position(x, y);
	    }
}
