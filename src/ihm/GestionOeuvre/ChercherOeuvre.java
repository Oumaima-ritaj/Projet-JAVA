package ihm.GestionOeuvre;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao_project.Database_Connection;
import dao_project.OeuvreDAO;
import objet_Métier.Oeuvre;

public class ChercherOeuvre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChercherOeuvre frame = new ChercherOeuvre();
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
	public ChercherOeuvre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 190, 588, 61);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"Id", "Titre Oeuvre", "Auteur Oeuvre", "Nombre d'exemplaire", "Nombre disponible", "Categorie "
				}
			);
		
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Chercher Ouvrage");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(25, 22, 203, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblIdDouvrage = new JLabel("Id d'ouvrage      :");
		lblIdDouvrage.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdDouvrage.setBounds(36, 83, 123, 25);
		contentPane.add(lblIdDouvrage);
		
		textField = new JTextField();
		textField.setBounds(182, 86, 151, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnChercher = new JButton("Chercher");
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OeuvreDAO oeudao = new OeuvreDAO(Database_Connection.getConnection());
				Oeuvre oeu = oeudao.findById(Integer.parseInt(textField.getText()));
				
				modelo.addRow(new Object[] {oeu.getIdOeuvre(),oeu.getTitreOeuvre(),oeu.getAuteurOeuvre(),oeu.getNbrExemplOeuvre(),oeu.getNbrDispOeuvre(),oeu.getCategorieOeuvre()});
				
			}
		});
		btnChercher.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChercher.setBounds(98, 144, 123, 23);
		contentPane.add(btnChercher);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuOeuvre menuo = new MenuOeuvre();
				dispose();
				menuo.setVisible(true);
			}
		});
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRetour.setBounds(481, 272, 89, 23);
		contentPane.add(btnRetour);
	}

}
