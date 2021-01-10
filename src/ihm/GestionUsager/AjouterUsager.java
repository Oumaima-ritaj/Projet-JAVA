package ihm.GestionUsager;

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
import dao_project.UsagerDAO;
import objet_Métier.Usager;

public class AjouterUsager extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField CIN;
	private JTextField CNE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterUsager frame = new AjouterUsager();
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
	public AjouterUsager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomLabel = new JLabel("Nom              :");
		lblNomLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomLabel.setForeground(Color.BLACK);
		lblNomLabel.setBounds(23, 71, 115, 31);
		contentPane.add(lblNomLabel);
		
		JLabel lblPrenomLabel = new JLabel("Pr\u00E9nom         :");
		lblPrenomLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrenomLabel.setBounds(21, 124, 117, 24);
		contentPane.add(lblPrenomLabel);
		
		JLabel lblCINLabel = new JLabel("CIN               :");
		lblCINLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCINLabel.setBounds(23, 179, 115, 19);
		contentPane.add(lblCINLabel);
		
		JLabel lblCNELabel = new JLabel("CNE              : ");
		lblCNELabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCNELabel.setBounds(23, 231, 115, 24);
		contentPane.add(lblCNELabel);
		
		nom = new JTextField();
		nom.setBounds(148, 78, 86, 20);
		contentPane.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(148, 128, 86, 20);
		contentPane.add(prenom);
		prenom.setColumns(10);
		
		CIN = new JTextField();
		CIN.setBounds(148, 178, 86, 20);
		contentPane.add(CIN);
		CIN.setColumns(10);
		
		CNE = new JTextField();
		CNE.setBounds(148, 230, 86, 20);
		contentPane.add(CNE);
		CNE.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Connection bases des données
				try {
				
				// appele du model 
				UsagerDAO userdao = new UsagerDAO(Database_Connection.getConnection());
				Usager user = new Usager(nom.getText(),prenom.getText(),CIN.getText(),CNE.getText());
				boolean IsAdded = userdao.add(user);
				if(IsAdded == true)
				{
				JOptionPane.showMessageDialog(null, " usager ajouté avec succés !! ");
				
				}else {
					JOptionPane.showMessageDialog(null, " Ajout usager echoué !! ");
			     	}
				}catch(Exception e)
				{
					e.getStackTrace();
				}
			
			}
		});
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAjouter.setBounds(173, 306, 76, 23);
		contentPane.add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
		   } 
		});
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnnuler.setBounds(259, 306, 76, 23);
		contentPane.add(btnAnnuler);
		
		JLabel lblAjoutDunNouveau = new JLabel("Ajout d'un nouveau Adh\u00E9rant");
		lblAjoutDunNouveau.setForeground(Color.RED);
		lblAjoutDunNouveau.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAjoutDunNouveau.setBounds(66, 29, 222, 31);
		contentPane.add(lblAjoutDunNouveau);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsagerMenu menu = new UsagerMenu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(87, 306, 76, 23);
		contentPane.add(btnNewButton);
	}
}
