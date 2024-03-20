package front;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import project.Grille;


@SuppressWarnings("serial")
public class MyFrame extends JFrame
{
    public MyFrame (BufferedImage image)// initialisation de l'interface avec l'image
    {
        Image contentPane = new Image(image);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(contentPane);
        this.setSize(4*Grille.H+500, 4*Grille.L+200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public MyFrame ()// initialisation de l'interface par défaut
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(4*Grille.L+50, 4*Grille.H+50);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void setImage(BufferedImage image)// modifier l'image dans la grille
    {
        Image contentPane = new Image(image);
        this.setContentPane(contentPane);
        this.revalidate();
        this.repaint();
    }
}
