package ihm.GestionEmprunt;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
     
     class fenetre extends JFrame implements ItemListener
     {
          private String  []  fct_emprunt = {"AfficherEmprunt", "AjoutEmprunt", "ChercherEmprunt"};  
          private JComboBox boite;
          Container c;

          public fenetre()
          {
              setTitle("Bibliotheque");
              setSize(300, 300);
              c = getContentPane();
              c.setLayout( new FlowLayout() );
              boite = new JComboBox(fct_emprunt);
              c.add(boite);
              boite.addItemListener(this);
              setDefaultCloseOperation(3);
        }
          
         public void itemStateChanged(ItemEvent i)
         {
              int choix = boite.getSelectedIndex();
              
              switch(choix)
              {
                   case 0:
                   System.out.println("AfficherEmprunt");
                   break;
                         
                  case 1:
                	  System.out.println("AjoutEmprunt");
                  break;
                  
                  default :
                	  System.out.println("ChercherEmprunt");
                  break;
                  
                 }
         }
    }
             
    public class comboemprunt
    {
         public static void main(String [] args)
         {
        	 fenetre f = new fenetre();
               f.setVisible(true);
         }
    }


