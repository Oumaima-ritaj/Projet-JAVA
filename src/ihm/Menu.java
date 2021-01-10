package ihm;

import java.awt.EventQueue;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ihm.GestionEmprunt.MenuGestionEmprunt;
import ihm.GestionExemplaire.MenuGestionExemplaire;
import ihm.GestionOeuvre.MenuOeuvre;
import ihm.GestionUsager.UsagerMenu;
import java.awt.Color;
import javax.swing.JLabel;

public class Menu extends JFrame {

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
					Menu frame = new Menu();
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
	public Menu() {
		setBackground(Color.DARK_GRAY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 389);
		setTitle("Le Menu Principal");
		 setLocationRelativeTo(this.getParent()); 
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGestionUsager = new JButton("Gestion Usager");
		btnGestionUsager.setBackground(Color.LIGHT_GRAY);
		btnGestionUsager.setForeground(Color.BLACK);
		btnGestionUsager.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionUsager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsagerMenu menuUser = new UsagerMenu();
				menuUser.setVisible(true);
				dispose();
			}
		});
		btnGestionUsager.setBounds(56, 168, 169, 28);
		contentPane.add(btnGestionUsager);
		
		JButton btnGestionOeuvre = new JButton("Gestion Oeuvre");
		btnGestionOeuvre.setBackground(Color.LIGHT_GRAY);
		btnGestionOeuvre.setForeground(Color.BLACK);
		btnGestionOeuvre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuOeuvre menuO = new MenuOeuvre();
				menuO.setVisible(true);
				dispose();
			}
		});
		btnGestionOeuvre.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionOeuvre.setBounds(336, 168, 169, 28);
		contentPane.add(btnGestionOeuvre);
		
		JButton btnGestionExemplaire = new JButton("Gestion Exemplaire");
		btnGestionExemplaire.setBackground(Color.LIGHT_GRAY);
		btnGestionExemplaire.setForeground(Color.BLACK);
		btnGestionExemplaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionExemplaire menuEx = new MenuGestionExemplaire();
				menuEx.setVisible(true);
				dispose();
			}
		});
		btnGestionExemplaire.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionExemplaire.setBounds(336, 251, 169, 28);
		contentPane.add(btnGestionExemplaire);
		
		JButton btnGestionEmprunt = new JButton("Gestion Emprunt");
		btnGestionEmprunt.setBackground(Color.LIGHT_GRAY);
		btnGestionEmprunt.setForeground(Color.BLACK);
		btnGestionEmprunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionEmprunt MenuEM = new MenuGestionEmprunt();
				MenuEM.setVisible(true);	
				dispose();
			}
		});
		btnGestionEmprunt.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGestionEmprunt.setBounds(56, 251, 169, 28);
		contentPane.add(btnGestionEmprunt);
		
		JLabel lblBienvenueDans = new JLabel("Bienvenue dans Biblioth\u00E9que ENSAH");
		lblBienvenueDans.setForeground(Color.LIGHT_GRAY);
		lblBienvenueDans.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBienvenueDans.setBounds(125, 91, 309, 28);
		contentPane.add(lblBienvenueDans);
		

	}
}
