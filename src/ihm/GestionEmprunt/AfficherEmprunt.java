package ihm.GestionEmprunt;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao_project.Database_Connection;
import dao_project.EmpruntDAO;
import objet_Métier.Emprunt;

public class AfficherEmprunt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficherEmprunt frame = new AfficherEmprunt();
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
	public AfficherEmprunt() {
		setBackground(new Color(102, 204, 153));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 357);
		setLocationRelativeTo(getParent());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 114, 600, 164);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelEm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"id Exemplaire", "Titre", "Nom", "Prenom", "date d'emprunt", "Date Retour Th\u00E9orique", "DateRetour Effective"
				}
			);
		
		
		table = new JTable();
		table.setModel(modelEm);
		table.getColumnModel().getColumn(2).setPreferredWidth(78);
		table.getColumnModel().getColumn(4).setPreferredWidth(97);
		table.getColumnModel().getColumn(5).setPreferredWidth(114);
		table.getColumnModel().getColumn(6).setPreferredWidth(136);
		scrollPane.setViewportView(table);
		
		JLabel lblAfficherEmprunt = new JLabel("Afficher Emprunt  :");
		lblAfficherEmprunt.setForeground(Color.RED);
		lblAfficherEmprunt.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAfficherEmprunt.setBounds(27, 25, 208, 25);
		contentPane.add(lblAfficherEmprunt);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmpruntDAO empdao = new EmpruntDAO(Database_Connection.getConnection());
				ArrayList<Emprunt> emp = empdao.find();
				System.out.println("probléme ");
				for(Emprunt em : emp)
				{
					System.out.println(em);
					modelEm.addRow(new Object[] {em.getId_Emprunt_Exemplaire(),em.getTitre(),em.getNom(),em.getPrenom(),em.getDateEmprunt(),em.getDateRetour_theo(),em.getDateRetour_Eff()});
				}
				System.out.println("modelEM no probleme");
				
			}
		});
		btnAfficher.setForeground(new Color(0, 0, 0));
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAfficher.setBounds(487, 67, 98, 23);
		contentPane.add(btnAfficher);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionEmprunt menu = new MenuGestionEmprunt();
				menu.setVisible(true);
				dispose();
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRetour.setBounds(512, 289, 98, 23);
		contentPane.add(btnRetour);
	}
}
