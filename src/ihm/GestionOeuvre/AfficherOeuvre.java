package ihm.GestionOeuvre;


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
import dao_project.OeuvreDAO;
import objet_Métier.Oeuvre;

public class AfficherOeuvre extends JFrame {

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
					AfficherOeuvre frame = new AfficherOeuvre();
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
	public AfficherOeuvre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAffichageDesOuvrages = new JLabel("Affichage des Ouvrages de la biblioth\u00E9que");
		lblAffichageDesOuvrages.setForeground(Color.RED);
		lblAffichageDesOuvrages.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAffichageDesOuvrages.setBounds(138, 24, 353, 35);
		contentPane.add(lblAffichageDesOuvrages);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 137, 544, 214);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Id", "Titre Oeuvre", "Auteur Oeuvre", "Nombre d'exemplaire", "Nombre disponible", "Categorie "
				}
			);
		
		table = new JTable();
		table.setModel(modelo);
		
		
		scrollPane.setViewportView(table);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OeuvreDAO oeudao = new OeuvreDAO(Database_Connection.getConnection());
				ArrayList<Oeuvre> oeu = oeudao.find();
				for(Oeuvre a : oeu)
				{
					modelo.addRow(new Object[] {a.getIdOeuvre(),a.getTitreOeuvre(),a.getAuteurOeuvre(),a.getNbrExemplOeuvre(),a.getNbrDispOeuvre(),a.getCategorieOeuvre()});
				}

				
			}
		});
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAfficher.setBounds(261, 89, 106, 23);
		contentPane.add(btnAfficher);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuOeuvre menuo = new MenuOeuvre();
				dispose();
				menuo.setVisible(true);
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRetour.setBounds(480, 362, 89, 23);
		contentPane.add(btnRetour);
	}
}
