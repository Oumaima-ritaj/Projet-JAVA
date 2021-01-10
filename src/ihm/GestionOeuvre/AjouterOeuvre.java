package ihm.GestionOeuvre;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao_project.Database_Connection;
import dao_project.OeuvreDAO;
import objet_Métier.Oeuvre;

public class AjouterOeuvre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField titre;
	private JTextField auteur;
	private JTextField nbr_Exemp_Oeu;
	private JTextField categorie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterOeuvre frame = new AjouterOeuvre();
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
	public AjouterOeuvre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAjoutDunOeuvre = new JLabel("Ajout d'un oeuvre");
		lblAjoutDunOeuvre.setForeground(Color.RED);
		lblAjoutDunOeuvre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAjoutDunOeuvre.setBounds(22, 11, 139, 23);
		contentPane.add(lblAjoutDunOeuvre);
		
		JLabel lblTitre = new JLabel("Titre                              :");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitre.setBounds(10, 56, 158, 19);
		contentPane.add(lblTitre);
		
		JLabel lblNewLabel_1 = new JLabel("Auteur                          :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 86, 158, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAuteur = new JLabel("Nombre d'exemplaire    :");
		lblAuteur.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAuteur.setBounds(10, 121, 158, 23);
		contentPane.add(lblAuteur);
		
		JLabel lblNewLabel_4 = new JLabel("Cat\u00E9gorie                      :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 155, 158, 23);
		contentPane.add(lblNewLabel_4);
		
		titre = new JTextField();
		titre.setBounds(213, 56, 117, 20);
		contentPane.add(titre);
		titre.setColumns(10);
		
		auteur = new JTextField();
		auteur.setBounds(213, 89, 117, 20);
		contentPane.add(auteur);
		auteur.setColumns(10);
		
		nbr_Exemp_Oeu = new JTextField();
		nbr_Exemp_Oeu.setBounds(213, 123, 117, 20);
		contentPane.add(nbr_Exemp_Oeu);
		nbr_Exemp_Oeu.setColumns(10);
		
		categorie = new JTextField();
		categorie.setBounds(213, 157, 117, 20);
		contentPane.add(categorie);
		categorie.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					// appele du model 
					OeuvreDAO userdao = new OeuvreDAO(Database_Connection.getConnection());
					// 
					int nbrEx =  Integer.parseInt(nbr_Exemp_Oeu.getText());
					Oeuvre oeu = new Oeuvre(titre.getText(),auteur.getText(),nbrEx,categorie.getText());
					if(userdao.add(oeu) == true)
					{
					JOptionPane.showMessageDialog(null, " Oeuvre ajouté avec succés !! ");
					MenuOeuvre menu = new MenuOeuvre();
					menu.setVisible(true);
					setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, " Ajout oeuvre echoué !! ");
					}
					}catch(Exception e)
					{
						e.getStackTrace();
					}
			}
		});
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnValider.setBounds(216, 227, 76, 23);
		contentPane.add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnnuler.setBounds(297, 227, 76, 23);
		contentPane.add(btnAnnuler);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuOeuvre menu = new MenuOeuvre();
				menu.setVisible(true);
			dispose();
			}
		});
		btnRetour.setBounds(130, 227, 76, 23);
		contentPane.add(btnRetour);
	}

}
