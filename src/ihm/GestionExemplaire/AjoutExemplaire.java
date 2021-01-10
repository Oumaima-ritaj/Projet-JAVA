package ihm.GestionExemplaire;

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
import dao_project.ExemplaireDAO;
import objet_Métier.Exemplaire;

public class AjoutExemplaire extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idO;
	private JTextField etat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutExemplaire frame = new AjoutExemplaire();
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
	public AjoutExemplaire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAjouterUnExemplaire = new JLabel("Ajouter un Exemplaire ");
		lblAjouterUnExemplaire.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAjouterUnExemplaire.setForeground(Color.RED);
		lblAjouterUnExemplaire.setBounds(135, 30, 238, 20);
		contentPane.add(lblAjouterUnExemplaire);
		
		JLabel lbltitre = new JLabel("Id d'Oeuvre                :");
		lbltitre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbltitre.setBounds(25, 94, 156, 14);
		contentPane.add(lbltitre);
		
		JLabel lbletat = new JLabel("l'etat de l'exemplaire  :");
		lbletat.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbletat.setBounds(25, 147, 156, 14);
		contentPane.add(lbletat);
		
		idO = new JTextField();
		idO.setBounds(223, 92, 124, 20);
		contentPane.add(idO);
		idO.setColumns(10);
		
		etat = new JTextField();
		etat.setBounds(223, 145, 124, 20);
		contentPane.add(etat);
		etat.setColumns(10);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int idOeuvre =  Integer.parseInt(idO.getText());
					
					ExemplaireDAO emdao = new ExemplaireDAO(Database_Connection.getConnection());
					Exemplaire exp = new Exemplaire(idOeuvre,etat.getText());
					
					if(emdao.add(exp) == true)
					{
					JOptionPane.showMessageDialog(null, " Exemplaire ajouté avec succés !! ");
					MenuGestionExemplaire menu = new MenuGestionExemplaire();
					menu.setVisible(true);
					dispose();
					}else {
						JOptionPane.showMessageDialog(null, " Ajout Exemplaire echoué !! ");
					}
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, " Emprunt n'est pas enregistré !! ");
					e.getStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(266, 216, 71, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(347, 216, 77, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionExemplaire menu = new MenuGestionExemplaire();
				menu.setVisible(true);
				dispose();
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRetour.setBounds(185, 216, 71, 23);
		contentPane.add(btnRetour);
	}
}
