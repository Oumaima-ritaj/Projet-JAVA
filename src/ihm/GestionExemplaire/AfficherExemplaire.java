package ihm.GestionExemplaire;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;


import dao_project.Database_Connection;
import dao_project.ExemplaireDAO;
import objet_Métier.Exemplaire;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AfficherExemplaire extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblAffichageDesExemplaires;
	private JButton btnAfficher;
	private JButton btnRetour;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficherExemplaire frame = new AfficherExemplaire();
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
	public AfficherExemplaire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		

        
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 602, 193);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel modelExem = new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"Id_Exemplaire", "Titre_Oeuvre", "Disponibilite", "Etat_Exemplaire"
				});
		
		table.setModel(modelExem);
		
		lblAffichageDesExemplaires = new JLabel("Affichage Des Exemplaires ");
		lblAffichageDesExemplaires.setForeground(Color.RED);
		lblAffichageDesExemplaires.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAffichageDesExemplaires.setBounds(35, 24, 264, 29);
		contentPane.add(lblAffichageDesExemplaires);
		
		btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ExemplaireDAO exemdao = new ExemplaireDAO(Database_Connection.getConnection());
				ArrayList<Exemplaire> donnees =  exemdao.find();
				String dispo = null;
				
				for(Exemplaire a : donnees)
				{
					if(a.getDispo_Exemp() == 1) dispo = "disponible";
					else dispo = "emprunté ";
				modelExem.addRow(new Object[]{a.getIdExemplaire(), a.getTitreOeuvre(),dispo , a.getEtat_Exemp()});
				}
			}
		});
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAfficher.setBounds(501, 53, 89, 23);
		contentPane.add(btnAfficher);
		
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionExemplaire menu = new MenuGestionExemplaire();
				menu.setVisible(true);
				setVisible(false);
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRetour.setBounds(501, 300, 95, 21);
		contentPane.add(btnRetour);
		table.getColumnModel().getColumn(0).setPreferredWidth(147);
		table.getColumnModel().getColumn(1).setPreferredWidth(128);
		table.getColumnModel().getColumn(2).setPreferredWidth(169);
		table.getColumnModel().getColumn(3).setPreferredWidth(195);
		
	
		
		
		
	}


}
