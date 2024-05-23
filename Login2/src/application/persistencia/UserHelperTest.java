package application.persistencia;

import application.modelo.Usuario;
import javafx.collections.ObservableList;

public class UserHelperTest {
	
	
	public static void main(String[] anrg)
	{
		agregarTest();
		System.out.println("Datos actuales");
		imprimirLista();
		
		
		saveTest();
		System.out.println("\nDatos salvados");
		imprimirLista();
		
		//se eliminan todos los usuarios de la lista
		UsuariosHelper.delete();
		System.out.println("\nDatos eliminados");
		imprimirLista();
		
		//Se lee del archivo
		loardTest();
		System.out.println("\nDatos leidos del archivo");
		imprimirLista();
		
	}
	
	public static void saveTest()
	{
		//Se guarda la lista en archivo
		UsuariosHelper.save();
		//se eliminan todos los usuarios de la lista
		//UsuariosHelper.delete();
		//leemos la lista del archivo
		//UsuariosHelper.load();
		
	}
	
	public static void loardTest()
	{
		//Se guarda la lista en archivo
		//UsuariosHelper.save();
		//se eliminan todos los usuarios de la lista
		//UsuariosHelper.delete();
		//leemos la lista del archivo
		UsuariosHelper.load();
		
	}
	
	public static void agregarTest()
	{
		UsuariosHelper.add(new Usuario("Yo", "123456"));
		UsuariosHelper.add(new Usuario("Yo2", "654321"));
		
		
	}
	
	public static void imprimirLista()
	{
		ObservableList<Usuario> lista = UsuariosHelper.getAll();
		for(Usuario u: lista)
		{
			System.out.println(u);
		}
	}
}
