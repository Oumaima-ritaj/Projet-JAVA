package ihm.GestionEmprunt;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTable;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao_project.Database_Connection;
import dao_project.EmpruntDAO;
import objet_Métier.Emprunt;

public class ChercherEmprunt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField IdAdherent;
	private JTextField IdExemp;
	private JButton btnRetour;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChercherEmprunt frame = new ChercherEmprunt();
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
	public ChercherEmprunt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 300);
		setTitle("Chercher Emprunt");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 172, 496, 41);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelem = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id Exemplaire", "Id Usager", "date d'emprunt", "Date Retour Th\u00E9orique", "DateRetour Effective"
				}
			);
		
		
		table = new JTable();
		table.setModel(modelem);
		table.getColumnModel().getColumn(2).setPreferredWidth(137);
		table.getColumnModel().getColumn(3).setPreferredWidth(152);
		table.getColumnModel().getColumn(4).setPreferredWidth(183);
		scrollPane.setViewportView(table);
		
		IdAdherent = new JTextField();
		IdAdherent.setBounds(154, 70, 171, 23);
		contentPane.add(IdAdherent);
		IdAdherent.setColumns(10);
		
		JButton btnChercherEmprunt = new JButton("Chercher");
		btnChercherEmprunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EmpruntDAO empdao = new EmpruntDAO(Database_Connection.getConnection());
				Emprunt em = empdao.findByUser(Integer.parseInt(IdExemp.getText()),Integer.parseInt(IdAdherent.getText()));	
				if(em != null)
				{
				modelem.addRow(new Object[] {em.getId_Emprunt_Exemplaire(),em.getId_Emprunt_Usager(),em.getDateEmprunt(),em.getDateRetour_theo(),em.getDateRetour_Eff()});
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Emprunt n'existe pas !! ");
				}
				
		   }
		});
		btnChercherEmprunt.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChercherEmprunt.setBounds(298, 119, 99, 23);
		contentPane.add(btnChercherEmprunt);
		
		IdExemp = new JTextField();
		IdExemp.setBounds(154, 36, 171, 23);
		contentPane.add(IdExemp);
		IdExemp.setColumns(10);
		
		JLabel lblIdAdhrant = new JLabel("Id Adh\u00E9rant   :");
		lblIdAdhrant.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdAdhrant.setBounds(34, 71, 99, 19);
		contentPane.add(lblIdAdhrant);
		
		JLabel lblExemp = new JLabel("Id Exemplaire :");
		lblExemp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExemp.setBounds(34, 37, 99, 19);
		contentPane.add(lblExemp);
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionEmprunt menu = new MenuGestionEmprunt();
				menu.setVisible(true);
				dispose();
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRetour.setBounds(417, 120, 89, 23);
		contentPane.add(btnRetour);
	}
}


