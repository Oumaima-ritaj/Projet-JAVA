package ihm.GestionEmprunt;

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
import dao_project.EmpruntDAO;
import objet_Métier.Emprunt;

public class AjoutEmprunt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id_adherant;
	private JTextField id_exemplaire;
	private JTextField date_emprunt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutEmprunt frame = new AjoutEmprunt();
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
	public AjoutEmprunt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Enregistrer un emprunt");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnregistrerUnEmprunt = new JLabel("Enregistrer un Emprunt");
		lblEnregistrerUnEmprunt.setForeground(Color.RED);
		lblEnregistrerUnEmprunt.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEnregistrerUnEmprunt.setBounds(111, 23, 199, 28);
		contentPane.add(lblEnregistrerUnEmprunt);
		
		JLabel lblNewLabel = new JLabel("ID Adh\u00E9rant        :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(35, 88, 126, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Exemplaire      :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(35, 133, 126, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date d'Emprunt  :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(35, 175, 126, 14);
		contentPane.add(lblNewLabel_2);
		
		id_adherant = new JTextField();
		id_adherant.setBounds(213, 89, 110, 20);
		contentPane.add(id_adherant);
		id_adherant.setColumns(10);
		
		id_exemplaire = new JTextField();
		id_exemplaire.setBounds(213, 130, 110, 20);
		contentPane.add(id_exemplaire);
		id_exemplaire.setColumns(10);
		
		date_emprunt = new JTextField();
		date_emprunt.setBounds(213, 172, 110, 20);
		contentPane.add(date_emprunt);
		date_emprunt.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					EmpruntDAO emdao = new EmpruntDAO(Database_Connection.getConnection());
					
					int idUsager =  Integer.parseInt(id_adherant.getText());
					int idexemplaire = Integer.parseInt(id_exemplaire.getText());
					
					Emprunt em = new Emprunt(idexemplaire,idUsager,date_emprunt.getText());
					if(emdao.add(em) == true)
					{
					JOptionPane.showMessageDialog(null, " Emprunt ajouté avec succés !! ");
					MenuGestionEmprunt menu = new MenuGestionEmprunt();
					menu.setVisible(true);
					setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, " Ajout emprunt echoué !! ");
					}
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, " Emprunt n'est pas enregistré !! ");
					e.getStackTrace();
				}
			}
		});
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnValider.setForeground(new Color(0, 0, 0));
		btnValider.setBounds(267, 216, 71, 23);
		contentPane.add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnnuler.setBounds(348, 216, 76, 23);
		contentPane.add(btnAnnuler);
		
		JLabel lblYyyymmdd = new JLabel("YYYY-MM-DD");
		lblYyyymmdd.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblYyyymmdd.setBounds(338, 176, 65, 14);
		contentPane.add(lblYyyymmdd);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuGestionEmprunt menu = new MenuGestionEmprunt();
				menu.setVisible(true);
				dispose();
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRetour.setBounds(186, 216, 71, 23);
		contentPane.add(btnRetour);
		
	}
}
