package ihm.GestionExemplaire;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ihm.Menu;

public class MenuGestionExemplaire extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGestionExemplaire frame = new MenuGestionExemplaire();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuGestionExemplaire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAjouterExemplaire = new JButton("Ajouter Exemplaire");
		btnAjouterExemplaire.setForeground(Color.BLUE);
		btnAjouterExemplaire.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAjouterExemplaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjoutExemplaire ajoutEx = new AjoutExemplaire();
				ajoutEx.setVisible(true);	
				dispose();
				
			}
		});
		btnAjouterExemplaire.setBounds(124, 30, 165, 30);
		contentPane.add(btnAjouterExemplaire);
		
		JButton btnChercherExemplaire = new JButton("Chercher Exemplaire");
		btnChercherExemplaire.setForeground(Color.BLUE);
		btnChercherExemplaire.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChercherExemplaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ChercherExemplaire cherche = new ChercherExemplaire();
				cherche.setVisible(true);
				dispose();
				
			}
		});
		btnChercherExemplaire.setBounds(124, 88, 165, 30);
		contentPane.add(btnChercherExemplaire);
		
		JButton btnAfficherExemplaire = new JButton("Afficher Exemplaire");
		btnAfficherExemplaire.setForeground(Color.BLUE);
		btnAfficherExemplaire.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAfficherExemplaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AfficherExemplaire affiche = new AfficherExemplaire();
				affiche.setVisible(true);
				dispose();
			}
		});
		btnAfficherExemplaire.setBounds(124, 144, 165, 30);
		contentPane.add(btnAfficherExemplaire);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnRetour.setForeground(Color.BLACK);
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRetour.setBounds(299, 227, 125, 23);
		contentPane.add(btnRetour);
	}
}
