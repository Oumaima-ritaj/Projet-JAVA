package ihm.GestionExemplaire;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import dao_project.Database_Connection;
import dao_project.ExemplaireDAO;
import objet_Métier.Exemplaire;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ChercherExemplaire extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblChercherExemplaire;
	private JTextField titre;
	private JLabel lblTitreDouvrage;
	private JButton btnChercher;
	private JButton btnRetour;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChercherExemplaire frame = new ChercherExemplaire();
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
	public ChercherExemplaire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 215, 505, 68);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelex = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Id_Exemplaire", "Titre_Oeuvre", "Disponibilite", "Etat_Exemplaire"
				}
			);
		
		table = new JTable();
		table.setModel(modelex);
		scrollPane.setViewportView(table);
		
		lblChercherExemplaire = new JLabel("Chercher Exemplaire");
		lblChercherExemplaire.setForeground(Color.RED);
		lblChercherExemplaire.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChercherExemplaire.setBounds(189, 32, 195, 36);
		contentPane.add(lblChercherExemplaire);
		
		titre = new JTextField();
		titre.setBounds(258, 111, 162, 20);
		contentPane.add(titre);
		titre.setColumns(10);
		
		lblTitreDouvrage = new JLabel("Titre d'Ouvrage        :");
		lblTitreDouvrage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitreDouvrage.setBounds(74, 110, 162, 19);
		contentPane.add(lblTitreDouvrage);
		
		btnChercher = new JButton("Chercher");
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExemplaireDAO exemdao = new ExemplaireDAO(Database_Connection.getConnection());
				ArrayList<Exemplaire> emd = exemdao.findByTitle(titre.getText());
				String dispo = null;
				for(Exemplaire em : emd)
				{
				if(em.getDispo_Exemp() == 1) dispo = "disponible";
				else dispo = "emprunté ";
				modelex.addRow(new Object[] {em.getIdExemplaire(),em.getTitreOeuvre(),dispo,em.getEtat_Exemp()});
		       	}
			}
		});
		btnChercher.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChercher.setBounds(213, 165, 115, 30);
		contentPane.add(btnChercher);
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionExemplaire menu = new MenuGestionExemplaire();
				menu.setVisible(true);
				setVisible(false);
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRetour.setBounds(418, 305, 100, 23);
		contentPane.add(btnRetour);
	}

}
