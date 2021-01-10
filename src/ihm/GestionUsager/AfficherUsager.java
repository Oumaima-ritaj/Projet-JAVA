package ihm.GestionUsager;


import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao_project.Database_Connection;
import dao_project.UsagerDAO;
import objet_Métier.Usager;

import java.awt.BorderLayout;
import javax.swing.ListSelectionModel;
import java.util.Collection;

import javax.swing.table.AbstractTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 

public class AfficherUsager extends JFrame {

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
					AfficherUsager frame = new AfficherUsager();
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
	public AfficherUsager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(10, 88, 613, 188);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelU = new DefaultTableModel(
				new Object[][] {},
				new String[] {"Id Usager", "nom", "prenom", "CIN", "CNE"}
			    );
		
//	    UsagerDAO userDAO = new UsagerDAO(Database_Connection.getConnection());
//	    ArrayList<Usager> user = userDAO.find(); 
//				for(Usager a : user)
//				{
//					modelU.addRow(new Object[] {a.getIdUsager(),a.getNomUsager(),a.getPrenomUsager(),a.getCINUsager(),a.getCNEUsager()});;
//				}
				
				
		table = new JTable();
		table.setModel(modelU);
		table.getColumnModel().getColumn(1).setPreferredWidth(118);
		table.getColumnModel().getColumn(2).setPreferredWidth(109);
		table.getColumnModel().getColumn(3).setPreferredWidth(157);
		table.getColumnModel().getColumn(4).setPreferredWidth(147);
		scrollPane.setViewportView(table);
		
		JLabel lblLaListeDes = new JLabel("La liste des Adh\u00E9rents dans notre biblioth\u00E9que");
		lblLaListeDes.setForeground(Color.RED);
		lblLaListeDes.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLaListeDes.setBounds(27, 23, 387, 23);
		contentPane.add(lblLaListeDes);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("_______________________________________________________________________");
				System.out.println(" le nombre des lignes : "+modelU.getRowCount());
				  modelU.setRowCount(0);
				System.out.println(" le nombre des lignes : "+modelU.getRowCount());
				  System.out.println("affichage de la liste");
				  UsagerDAO userDAO = new UsagerDAO(Database_Connection.getConnection());
				  System.out.println(" j'ai passé la connecxion et le statement et touttttt ");
				    ArrayList<Usager> user = userDAO.find(); 
				    
				 if(user == null) {
				    	System.out.println("nulllll ");
				  }
				for(Usager a : user)
			{
		         	modelU.addRow(new Object[] {a.getIdUsager(),a.getNomUsager(),a.getPrenomUsager(),a.getCINUsager(),a.getCNEUsager()});
		        }
				System.out.println(" le nombre des lignes : "+modelU.getRowCount());
				System.out.println("_______________________________________________________________________");
		                                               }
		});
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAfficher.setBounds(512, 54, 89, 23);
		contentPane.add(btnAfficher);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsagerMenu menu = new UsagerMenu();
				menu.setVisible(true);
				dispose();
			}	
		});
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRetour.setBounds(512, 287, 89, 23);
		contentPane.add(btnRetour);
		
		JButton btnIdUsager = new JButton("Id Usager");
		btnIdUsager.setBounds(10, 57, 89, 23);
		contentPane.add(btnIdUsager);
		
		
		
	}
}