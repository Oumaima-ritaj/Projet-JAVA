package dao_project;

import java.util.ArrayList;

import objet_Métier.Usager;

public class TheMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//     	Oeuvre oeu = new Oeuvre(2,"Le dernier jour","victor hugo",14,2,"Roman Drame");
//		
//		OeuvreDAO oeudao = new OeuvreDAO(Database_Connection.getConnection());
		
//		ArrayList<Oeuvre> oeus = oeudao.find();
//		
//		for(int i=0; i<oeus.size();i++)
//		{
//			System.out.println(oeus.get(i));
//		}
//		
//	System.out.println(oeudao.isExist(oeu));
		
//		Date emp = new SimpleDateFormat("YYYY-MM-DD").parse("2019-12-03");
//		String sourceDate = "2017-05-27";  // Start date
//
//
//		ExemplaireDAO emdao = new ExemplaireDAO(Database_Connection.getConnection());
//		
//		
//		
//		
//		Exemplaire exp = new Exemplaire(4, "vieux ");
//		
//		emdao.add(exp);
//		try {
//		
//		Statement state = Database_Connection.getConnection().createStatement();
//		
//		//préparation de la requete sql
//		String query = "select * FROM usager WHERE nom_usager = 'yakiry' and prenom_usager = 'othmane';";  
//		
//		System.out.println(query);
//		
//		// exécution de la requete et récupération des données 
//		ResultSet result = state.executeQuery(query);
//		
//		System.out.println(result);
//		}catch(SQLException e)
//		{
//			e.getStackTrace();
//		}
		
//		UsagerDAO userdao = new UsagerDAO(Database_Connection.getConnection());
//		Usager user = new Usager(12,"Sakhry","Hamza","DK231432","FA213122");
//		
//		System.out.println(userdao.update(user));
		UsagerDAO userdao = new UsagerDAO(Database_Connection.getConnection());
//		Usager user1 = new Usager("Jelloul", "Samir", "KJ983746", "HDG384756");
		
		ArrayList<Usager> user2 = userdao.find();
		
		for(Usager a : user2)
		{
			System.out.println(a);
		}
		
		
		
//		if(userdao.add(user1) == false) {
//			System.out.println(" ajouter avec succées ");
//		}else
//		{
//			System.out.println(" pas d'ajout");
//		}
		
		
		
		
		
		
		
		


		
		
		
		
		
		

		
		
		
		
	}

}
