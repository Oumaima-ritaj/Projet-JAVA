package ihm.GestionOeuvre;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ihm.Menu;

import java.awt.Color;

public class MenuOeuvre extends JFrame {

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
					MenuOeuvre frame = new MenuOeuvre();
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
	public MenuOeuvre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ajouter Oeuvre");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterOeuvre ajouterOe = new AjouterOeuvre();
				ajouterOe.setVisible(true);
				
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(131, 40, 150, 31);
		contentPane.add(btnNewButton);
		
		JButton btnAfficher = new JButton("Afficher Oeuvre");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AfficherOeuvre affich = new AfficherOeuvre();
			affich.setVisible(true);
			setVisible(false);
			}
		});
		btnAfficher.setForeground(Color.BLUE);
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAfficher.setBounds(131, 99, 150, 31);
		contentPane.add(btnAfficher);
		
		JButton btnChercher = new JButton("Chercher Oeuvre");
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChercherOeuvre cherche = new ChercherOeuvre();
				cherche.setVisible(true);
				setVisible(false);
			}
		});
		btnChercher.setForeground(Color.BLUE);
		btnChercher.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChercher.setBounds(131, 157, 150, 31);
		contentPane.add(btnChercher);
		
		JButton btnRetour = new JButton("Retour ");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				setVisible(false);
			}
		});
		btnRetour.setForeground(Color.BLACK);
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRetour.setBounds(320, 227, 89, 23);
		contentPane.add(btnRetour);
	}

}
