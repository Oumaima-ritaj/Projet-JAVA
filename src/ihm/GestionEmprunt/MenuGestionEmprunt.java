package ihm.GestionEmprunt;


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
import javax.swing.JLabel;


public class MenuGestionEmprunt extends JFrame {

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
					MenuGestionEmprunt frame = new MenuGestionEmprunt();
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
	public MenuGestionEmprunt() {
		setBackground(Color.DARK_GRAY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gestion Emprunt");
		setBounds(100, 100, 552, 296);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAjoutEmprunt = new JButton("Ajout Emprunt");
		btnAjoutEmprunt.setForeground(Color.BLACK);
		btnAjoutEmprunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjoutEmprunt ajoutEm = new AjoutEmprunt();
				ajoutEm.setVisible(true);
				dispose();
			}
		});
		btnAjoutEmprunt.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAjoutEmprunt.setBounds(10, 125, 149, 30);
		contentPane.add(btnAjoutEmprunt);
		
		JButton btnAfficherEmprunt = new JButton("Afficher Emprunt");
		btnAfficherEmprunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfficherEmprunt affiche = new AfficherEmprunt();
				affiche.setVisible(true);
				dispose();
			}
		});
		btnAfficherEmprunt.setForeground(Color.BLACK);
		btnAfficherEmprunt.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAfficherEmprunt.setBounds(374, 125, 149, 30);
		contentPane.add(btnAfficherEmprunt);
		
		JButton btnChercherEmprunt = new JButton("Chercher Emprunt");
		btnChercherEmprunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChercherEmprunt cherche = new ChercherEmprunt();
				cherche.setVisible(true);
				dispose();
			}
		});
		btnChercherEmprunt.setForeground(Color.BLACK);
		btnChercherEmprunt.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChercherEmprunt.setBounds(192, 125, 149, 30);
		contentPane.add(btnChercherEmprunt);
		
		JButton btnRetour = new JButton("Retour ");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
			    dispose();
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRetour.setBounds(447, 233, 89, 23);
		contentPane.add(btnRetour);
		
		JLabel lblNewLabel = new JLabel("Gestion des emprunt vous permet d'enregister les differents action sur les emprunts");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 79, 503, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblGrerVosEmprunts = new JLabel("G\u00E9rer vos emprunts avec s\u00E9curit\u00E9 :");
		lblGrerVosEmprunts.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGrerVosEmprunts.setBounds(10, 45, 257, 30);
		contentPane.add(lblGrerVosEmprunts);
	}

}
