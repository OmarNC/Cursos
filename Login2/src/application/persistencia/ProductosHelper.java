package application.persistencia;


import java.sql.*;
import java.util.ArrayList;

import application.modelo.Producto;
import application.modelo.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductosHelper {
	
	//final static String FILE_NAME = "UserData.dat";
	//static ObservableList<Producto> listProductos= FXCollections.observableArrayList();
	
	
	
	
	
	public static void createTable()
	{
		String strSQL = "CREATE TABLE Productos(" +
				"id INTEGER NOT NULL PRIMARY KEY, " +
				"nombre VARCHAR(30) NOT NULL, " + 
				"descripcion VARCHAR(50), " +
				"precio REAL)";
		
		ejecutarSQL(strSQL);
		
	}
	
	
	
	public static void eliminarTable(){
		String strSQL = "DROP TABLE Productos";
		
		ejecutarSQL(strSQL);
	}
	
	public static void ejecutarSQL(String strSQL) {

		Connection conn = DataBase.getConnection();
		if (conn == null )
		{
			DataBase.Conectar(false);
			conn = DataBase.getConnection();
		}
		
		Statement sent = null;
		
		try {
			sent = conn.createStatement();
			sent.execute(strSQL);
			sent.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido un error al ejecutar el Query: ");
			System.out.println(strSQL);
			e.printStackTrace();
		}
	}
	
	public static int addProducto(Producto p)
	{
		int result = 0;
		
		String strSQL = "INSERT INTO Productos VALUES ( ?, ?, ?, ?)";
		
	
		Connection conn = DataBase.getConnection();
		if (conn == null )
		{
			DataBase.Conectar(false);
			conn = DataBase.getConnection();
		}
		
		PreparedStatement sent = null;
		
		try {
			sent = conn.prepareStatement(strSQL);
			sent.setInt(1, p.getId());
			sent.setString(2, p.getNombre());
			sent.setString(3,  p.getDescripcion());
			sent.setDouble(4, p.getPrecio());

			result = sent.executeUpdate();
			sent.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido un error al ejecutar el Query: ");
			System.out.println(strSQL);
			e.printStackTrace();
		}
	
		
		return result;
	}
	
	
	
	public static int UpdateProducto(Producto p)
	{
		int result = 0;
		
		String strSQL = "UPDATE Productos" +
						" SET " + 
						"nombre = ?, " +
						"descripcion = ?, " + 
						"precio = ? " +
						"WHERE id = ? ";
		
	
		Connection conn = DataBase.getConnection();
		if (conn == null )
		{
			DataBase.Conectar(false);
			conn = DataBase.getConnection();
		}
		
		PreparedStatement sent = null;
		
		try {
			sent = conn.prepareStatement(strSQL);
			sent.setString(1, p.getNombre());
			sent.setString(2,  p.getDescripcion());
			sent.setDouble(3, p.getPrecio());
			sent.setInt(4, p.getId());

			result = sent.executeUpdate();
			sent.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido un error al ejecutar el Query: ");
			System.out.println(strSQL);
			e.printStackTrace();
		}
	
		
		return result;
	}
	
	
public static int DeleteProducto(Producto p)
{
	int result = 0;
	
	String strSQL = "DELETE FROM Productos " +
					"WHERE id = ? ";
	

	Connection conn = DataBase.getConnection();
	if (conn == null )
	{
		DataBase.Conectar(false);
		conn = DataBase.getConnection();
	}
	
	PreparedStatement sent = null;
	
	try {
		sent = conn.prepareStatement(strSQL);
		sent.setInt(1, p.getId());

		result = sent.executeUpdate();
		sent.close();
	} catch (SQLException e) {
		System.out.println("Se ha producido un error al ejecutar el Query: ");
		System.out.println(strSQL);
		e.printStackTrace();
	}

	
	return result;
	}


public static ArrayList<Producto> getAllProducto()
{
	ResultSet rs = null;
	ArrayList<Producto> lista = new ArrayList<Producto>();
	
	String strSQL = "SELECT id, nombre, descripcion, precio " + 
					"FROM Productos ";
	

	Connection conn = DataBase.getConnection();
	if (conn == null )
	{
		DataBase.Conectar(false);
		conn = DataBase.getConnection();
	}
	
	Statement sent = null;
	
	try {
		sent = conn.createStatement();
		rs = sent.executeQuery(strSQL);
		//Procesar el resultado para obtener un ArrayList de Productos
		while(rs.next()) {
			Producto p = new Producto(rs.getInt("Id"),
					rs.getString("Nombre"), 
					rs.getString("Descripcion"),
					rs.getDouble("Precio"));
			lista.add(p);
		}
		
		sent.close();
	} catch (SQLException e) {
		System.out.println("Se ha producido un error al ejecutar el Query: ");
		System.out.println(strSQL);
		e.printStackTrace();
	}

	
	return lista;
	}



public static Producto getProducto(int id)
{
	ResultSet rs = null;
	Producto p = null;
	
	String strSQL = "SELECT id, nombre, descripcion, precio " + 
					"FROM Productos WHERE ID = ?";
	

	Connection conn = DataBase.getConnection();
	if (conn == null )
	{
		DataBase.Conectar(false);
		conn = DataBase.getConnection();
	}
	
	PreparedStatement sent = null;
	
	try {
		sent = conn.prepareStatement(strSQL);
		sent.setInt(1, id);
		rs = sent.executeQuery();
		//Procesar el resultado para obtener un ArrayList de Productos
		if (rs.next()) {
			 p = new Producto(rs.getInt("Id"),
					rs.getString("Nombre"), 
					rs.getString("Descripcion"),
					rs.getDouble("Precio"));
		}
	
		
		sent.close();
	} catch (SQLException e) {
		System.out.println("Se ha producido un error al ejecutar el Query: ");
		System.out.println(strSQL);
		e.printStackTrace();
	}
	return p;
	}


}


