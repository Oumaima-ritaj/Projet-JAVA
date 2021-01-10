package ihm.GestionUsager;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao_project.Database_Connection;
import dao_project.UsagerDAO;
import objet_Métier.Usager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChercherUsager extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblChercherUnAdhrent;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JButton btnChercher;
	private JTextField nom;
	private JTextField prenom;
	private JLabel lblChercherParId;
	private JButton btnRetour;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChercherUsager frame = new ChercherUsager();
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
	public ChercherUsager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 206, 598, 55);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelu = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id Usager", "nom", "prenom", "CIN", "CNE"
				}
			);
		

		
		table = new JTable();
		table.setModel(modelu);
		scrollPane.setViewportView(table);
		
		lblChercherUnAdhrent = new JLabel("Chercher un Adh\u00E9rent");
		lblChercherUnAdhrent.setForeground(Color.RED);
		lblChercherUnAdhrent.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChercherUnAdhrent.setBounds(223, 29, 175, 21);
		contentPane.add(lblChercherUnAdhrent);
		
		lblNom = new JLabel("Nom         :");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNom.setBounds(173, 85, 68, 14);
		contentPane.add(lblNom);
		
		lblPrenom = new JLabel("Prenom    :");
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrenom.setBounds(173, 119, 80, 14);
		contentPane.add(lblPrenom);
		
		btnChercher = new JButton("chercher");
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelu.setRowCount(0);
		   UsagerDAO userDAO = new UsagerDAO(Database_Connection.getConnection());  
		   Usager r = userDAO.findByName(nom.getText(), prenom.getText()); 
		   
		   if(r != null)
		   { modelu.addRow(new Object[] {r.getIdUsager(),r.getNomUsager(),r.getPrenomUsager(),r.getCINUsager(),r.getCNEUsager()});}
		   if(r.getIdUsager()== 0)
		   { JOptionPane.showMessageDialog(null, " Usager n'existe pas !! "); }
		}
		});
		btnChercher.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChercher.setBounds(457, 157, 106, 23);
		contentPane.add(btnChercher);
		
		nom = new JTextField();
		nom.setBounds(279, 83, 119, 20);
		contentPane.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(279, 117, 119, 21);
		contentPane.add(prenom);
		prenom.setColumns(10);
		
		lblChercherParId = new JLabel("!chercher par ID");
		lblChercherParId.setForeground(Color.RED);
		lblChercherParId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblChercherParId.setBounds(457, 30, 130, 23);
		contentPane.add(lblChercherParId);
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsagerMenu menu = new UsagerMenu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRetour.setBounds(478, 292, 89, 23);
		contentPane.add(btnRetour);
	}
}
