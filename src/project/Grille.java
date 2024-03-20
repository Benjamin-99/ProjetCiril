package project;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import javax.imageio.ImageIO;

import front.MyFrame;

import java.io.IOException;
import java.util.Random;

public class Grille {	
	
		 public final static int H = 100;// Hauteur de la grille
		 public final static int L = 100;// largeur de la grille
		 public final static int P = 50; //Propbabilité de propagation de propation
		 public static final Random random = new Random();
		 public final static int nbfeu = random.nextInt(4)+1;
		 private Arbre[][] arbres;
	   	 private MyFrame myFrame;
		
		public Grille()// constructeur qui permet d'initialiser la grille
		{
			 arbres = new Arbre[H][L];
		        for (int i=0; i<H ; i++)
		        {
		            for (int j=0; j<L ; j++)
		            {
		                arbres[i][j] = new Arbre(new Position(i, j));
		                if (i>0)
		                    arbres[i][j].ajouterArbre(arbres[i-1][j]);
		                if (j>0)
		                    arbres[i][j].ajouterArbre(arbres[i][j-1]);
		            }
		        }
		        myFrame = new MyFrame();//instantiation de l'interface
		}
		
		public boolean update(int tour) //modifié l'etat d'un arbre de la grille
	    {
	        boolean fini = true;
	        for (int i=0; i<H ; i++)
	        {
	            for (int j=0; j<L ; j++)
	            {
	                {
	                    if (arbres[i][j].appliqueEffet(tour))
	                        fini = false;
	                }
	            }
	        }
	          return fini;
	    }
		public Arbre[][] getArbres()
	    {
	        return arbres;
	    }

	    public BufferedImage toImage()// affiichage de l'arbre en fonction de son etat
	    {
	        BufferedImage img = new BufferedImage(L*4, H*4, BufferedImage.TYPE_INT_RGB);
	        for (int i=0; i<H ; i++)
	        {
	            for (int j=0; j<L ; j++)
	            {
	                for(int k=0 ; k<4 ; k++)
	                    for(int l=0 ; l<4 ; l++)
	                    {
	                        if (arbres[i][j].getEtat().getClass().equals(Feu.class))
	                            img.setRGB(j*4+l, i*4+k, Color.red.getRGB());
	                        else if (arbres[i][j].getEtat().getClass().equals(Cendre.class))
	                            img.setRGB(j*4+l, i*4+k, Color.gray.getRGB());
	                        else
	                            img.setRGB(j*4+l, i*4+k, Color.green.getRGB());
	                    }
	            }
	        }
	        return img;
	    }
		

	    public void sauvegarderImage(BufferedImage img)// Sauvegarder l'image resultante dans un fichier sous format png
	    {
	        File f = new File("resultat.png");
	        try
	        {
	            ImageIO.write(img, "PNG", f);
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	    }

	    public void updateImage(BufferedImage img)// modifier le visuel d'un arbre en fonction de son etat
	    {
	        myFrame.setImage(img);
	    }

	    public static void main(String[] args)
	    {
	        Grille g = new Grille();// création de la grille 
	       
	        for (int i=0;i<nbfeu;i++)// création du ou des feu(s) initial(s)
	        {
	        Position position = Position.random();
	        g.getArbres()[position.getX()][position.getY()].mettreFeu(-1+i);
	        }
	        
	        boolean continuer = true;
	        BufferedImage img = null;
	        int i=0;
	        while (continuer)// Propagation du feu
	        {
	            if (g.update(i))
	                continuer = false;
	            i++;
	            img = g.toImage();
	            g.updateImage(img);
	        }
	        g.sauvegarderImage(img);
	        System.out.println("nombre de feu: "+nbfeu);// affichage dans la console du nombre de feu inital
	        System.out.println("Simulation terminée.");//affichage dans la console de l'etat du traitement en fin
	    }
	}