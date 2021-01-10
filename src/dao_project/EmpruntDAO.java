package dao_project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import objet_Métier.Emprunt;

public class EmpruntDAO {

	private Connection connect;
	private Statement state;
	private ResultSet result;
	
	public EmpruntDAO(Connection conn)
	{
		try {
		       if(this.state != null)
		       {
		       System.out.println("statement deja cree !");
		       }else {
		    	   this.state=conn.createStatement();
			       System.out.println("Nouvelle statement cree !");
		       }
		    }catch(Exception e)
		    {
		    	System.out.println("dude !!");
		     	e.getStackTrace();
		    }
	}
	
	public boolean add(Emprunt em)
	{
		try {
	 	
			//préparation de la requete sql
			String query = "INSERT INTO emprunt SET id_Exemplaire="+em.getId_Emprunt_Exemplaire() +", id_usager ="+em.getId_Emprunt_Usager()+", dateEmprunt ='"+em.getDateEmprunt()+"';";       
			
			System.out.println("id Exemplaire : "+em.getId_Emprunt_Exemplaire()+" id usager : "+em.getId_Emprunt_Usager()+" date emprunt : "+em.getDateEmprunt());
			
			// exécution de la requete
			state.executeUpdate(query);
			
			System.out.println("requete execute ");
			
			state.close();
			connect.close();
			return true;
			
		}catch(SQLException e)
		{
			System.out.println("error requete ");
			e.getStackTrace();
			return false;
			
		}finally {
		    try { result.close(); System.out.println("result fermeéééééé"); } catch (Exception e) { /* ignored */ }
		    try { state.close(); System.out.println("state fermeéééééé"); } catch (Exception e) { /* ignored */ }
		    try { connect.close(); System.out.println("connect fermeéééééé find()"); } catch (Exception e) { /* ignored */ }
		}
		
	}

	public boolean update(Emprunt em)
	{
		try {
			 			
			//préparation de la requete sql
			String query = "UPDATE emprunt SET  SET id_Oeuvre='"+em.getId_Emprunt_Exemplaire() +"', id_Usager ='"+em.getId_Emprunt_Usager()+"', date_Emprunt ='"+em.getDateEmprunt()+"', dateRetour_theo ='"+em.getDateRetour_theo()+", dateRetour_Eff ='"+em.getDateRetour_Eff()+"' WHERE id_Emprunt ='"+em.getId_Emprunt_Exemplaire()+"';";  
			
			// exécution de la requete
			state.executeUpdate(query);
			
			return true;
			
		}catch(SQLException e)
		{
			e.getStackTrace();
			return false;
		}finally {
		    try { result.close(); System.out.println("result fermeéééééé"); } catch (Exception e) { /* ignored */ }
		    try { state.close(); System.out.println("state fermeéééééé"); } catch (Exception e) { /* ignored */ }
		    try { connect.close(); System.out.println("connect fermeéééééé find()"); } catch (Exception e) { /* ignored */ }
		}
	}

	public boolean delete(Emprunt em)
	{
		try {

			//préparation de la requete sql
			String query = "DELETE FROM emprunt WHERE id_Emprunt = "+em.getId_Emprunt_Exemplaire()+";";  
			
			// exécution de la requete
			state.executeUpdate(query);

			return true;
		}catch(SQLException e)
		{
			e.getStackTrace();
			return false;
		}finally {
		    try { result.close(); System.out.println("result fermeéééééé"); } catch (Exception e) { /* ignored */ }
		    try { state.close(); System.out.println("state fermeéééééé"); } catch (Exception e) { /* ignored */ }
		    try { connect.close(); System.out.println("connect fermeéééééé find()"); } catch (Exception e) { /* ignored */ }
		}
	}

	public Emprunt findById(int id)
	{
		Emprunt em = new Emprunt();
		
		try {

			//préparation de la requete sql
			String query = "select * FROM emprunt WHERE id_Emprunt = "+id+";";  
			
			// exécution de la requete et récupération des données 
			ResultSet result = state.executeQuery(query);
			
			
			//remplissage de l'objet Usager
			while(result.next())
			{
				em.setId_Emprunt_Exemplaire(result.getInt(1));
				em.setId_Emprunt_Usager(result.getInt(2));
				em.setDateEmprunt(result.getString(3));
				em.setDateRetour_theo(result.getString(4));
				em.setDateRetour_Eff(result.getString(5));
			
			System.out.println("objet rempli ");
			}
			
			result.close();
			state.close();
			connect.close();
			
			return em;
		}catch(SQLException e)
		{
			e.getStackTrace();
			
			return null;
		}finally {
		    try { result.close(); System.out.println("result fermeéééééé"); } catch (Exception e) { /* ignored */ }
		    try { state.close(); System.out.println("state fermeéééééé"); } catch (Exception e) { /* ignored */ }
		    try { connect.close(); System.out.println("connect fermeéééééé find()"); } catch (Exception e) { /* ignored */ }
		}
	}

	public ArrayList<Emprunt> find()
	{
		ArrayList<Emprunt> ems = new ArrayList<Emprunt>();
		try {

			//préparation de la requete sql
			String query = "select em.id_Exemplaire,oe.titre_Oeuvre,user.nom_Usager,user.prenom_Usager,em.dateEmprunt,em.dateRetour_theo,em.dateRetour_Eff from emprunt as em, oeuvre as Oe, usager as user, exemplaire as ex where em.id_Exemplaire=ex.id_Exemplaire and Oe.id_Oeuvre=ex.id_Oeuvre and user.id_Usager=em.id_Usager;";  
			
			// exécution de la requete et récupération des données 
			ResultSet result = state.executeQuery(query);
			

			while(result.next())
			{
				ems.add(new Emprunt(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7)));	
			}
			
			return ems;
			
		}catch(SQLException e)
		{
	        e.getStackTrace();		
	 		return null;
		}finally {
		    try { result.close(); System.out.println("result fermeéééééé"); } catch (Exception e) { /* ignored */ }
		    try { state.close(); System.out.println("state fermeéééééé"); } catch (Exception e) { /* ignored */ }
		    try { connect.close(); System.out.println("connect fermeéééééé find()"); } catch (Exception e) { /* ignored */ }
		}
	}

	public Emprunt findByUser( int idExm,int iduser)
	{
	Emprunt em = new Emprunt();
		
		try {

			//préparation de la requete sql
			String query = "select * FROM emprunt WHERE id_Exemplaire = "+idExm+" and id_Usager = "+iduser+";";  
			
			System.out.println(query);
			
			// exécution de la requete et récupération des données 
			ResultSet result = state.executeQuery(query);
			
			
			//remplissage de l'objet Usager
			while(result.next())
			{
				em.setId_Emprunt_Exemplaire(result.getInt(1));
				em.setId_Emprunt_Usager(result.getInt(2));
				em.setDateEmprunt(result.getString(3));
				em.setDateRetour_theo(result.getString(4));
				em.setDateRetour_Eff(result.getString(5));
			
			System.out.println("objet rempli ");
			}
			
			return em;
		}catch(SQLException e)
		{
			e.getStackTrace();
			
			return null;
		}finally {
		    try { result.close(); System.out.println("result fermeéééééé"); } catch (Exception e) { /* ignored */ }
		    try { state.close(); System.out.println("state fermeéééééé"); } catch (Exception e) { /* ignored */ }
		    try { connect.close(); System.out.println("connect fermeéééééé find()"); } catch (Exception e) { /* ignored */ }
		}
	}
	
	
}
