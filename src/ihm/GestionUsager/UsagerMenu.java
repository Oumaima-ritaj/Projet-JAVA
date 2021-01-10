package ihm.GestionUsager;

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

public class UsagerMenu extends JFrame {

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
					UsagerMenu frame = new UsagerMenu();
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
	public UsagerMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.DARK_GRAY);
		 setLocationRelativeTo(this.getParent()); 
		
		JButton btnAjouterUsager = new JButton("Ajouter Usager");
		btnAjouterUsager.setForeground(Color.BLUE);
		btnAjouterUsager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterUsager ajouterUser = new AjouterUsager();
				ajouterUser.setVisible(true);
				dispose();
			}
		});
		btnAjouterUsager.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAjouterUsager.setBounds(134, 40, 152, 30);
		contentPane.add(btnAjouterUsager);
		
		JButton btnAfficherUsager = new JButton("Afficher Usager");
		btnAfficherUsager.setForeground(Color.BLUE);
		btnAfficherUsager.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAfficherUsager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfficherUsager affich = new AfficherUsager();
				affich.setVisible(true);
				dispose();
			}
		});
		btnAfficherUsager.setBounds(134, 101, 152, 30);
		contentPane.add(btnAfficherUsager);
		
		JButton btnChercherUsager = new JButton("Chercher Usager");
		btnChercherUsager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChercherUsager cherche = new ChercherUsager();
				cherche.setVisible(true);
				dispose();
			}
		});
		btnChercherUsager.setForeground(Color.BLUE);
		btnChercherUsager.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChercherUsager.setBounds(134, 161, 152, 30);
		contentPane.add(btnChercherUsager);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRetour.setBounds(311, 227, 89, 23);
		contentPane.add(btnRetour);
	}

}
