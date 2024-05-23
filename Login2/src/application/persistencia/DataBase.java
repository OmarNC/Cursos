package application.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	
static  Connection conn = null;
	
	public static void Conectar(boolean nuevaDB)
	{
		String cad = "jdbc:derby:MiDB";
		if (nuevaDB )
			cad = cad  + ";create=true";

		
		try
		{
			conn = DriverManager.getConnection(cad);
			
		}
		catch(SQLException e)
		{
			System.out.println("ERROR: No se ha podido conectar a la Base de DAtos");
			System.out.println("Mensaje: " + e.getMessage());
			conn = null;
		}
	}
	
	
	public static Connection getConnection()
	{
		return conn;
	}
	
	public static void CerrarConexion()
	{
		try {
			if (conn != null && !conn.isClosed())
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
