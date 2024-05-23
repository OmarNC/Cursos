package application.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import application.modelo.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UsuariosHelper {
	final static String FILE_NAME = "UserData.dat";
	static ObservableList<Usuario> listUsuarios = FXCollections.observableArrayList();
		
	
	public static void load() {
		//TODO: Lee los datos del archivo y llena la lista
		ObjectInputStream inStream = null;
		
		try {
			inStream  = new ObjectInputStream(new FileInputStream(FILE_NAME));
			Usuario[] arrayUsuarios = (Usuario[]) inStream.readObject();
			listUsuarios.clear();
			listUsuarios.addAll(arrayUsuarios);
			
			//listUsuarios = (ObservableList<Usuario>) inStream.readObject();
			inStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static ObservableList<Usuario> getAll()
	{
		return listUsuarios;
	}
	
	public static void add(Usuario usuario)
	{
		listUsuarios.add(usuario);
		
	}
	
	
	public static void save()
	{
		ObjectOutputStream outStream = null;
			
		try {		
			Usuario[] arrayUsuarios = listUsuarios.toArray(new Usuario[0]);
			outStream  = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			outStream.writeObject(arrayUsuarios);
			outStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public static void delete()
	{
		listUsuarios.clear();
	}
	
	
	public static boolean delete(Usuario user)
	{
		//TODO: Borra el usuario del archivo
		return false;
	}
	
	public static Usuario buscar(String login)
	{
		//TODO: Buscar el nombre en a lista de usario y regresa ese objeto
		return null;
	}
}
