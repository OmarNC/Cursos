package application.modelo;

import application.persistencia.UsuariosHelper;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserModel {
	 ObservableList<Usuario> listUsuarios = null;
	 
	public UserModel() {
		UsuariosHelper.load();
		listUsuarios = UsuariosHelper.getAll(); 
	}
	
	public ObservableList<Usuario> getListaUsuarios()
	{
		return listUsuarios;
	}
	
	public static TableColumn<Usuario, String> getLoginColumn()
	{
		 TableColumn<Usuario, String> loginCol = new  TableColumn<Usuario, String>("Login");
		 
		 loginCol.setCellValueFactory(new PropertyValueFactory<Usuario, String>("usuario"));
		 return loginCol;
	}
	
	public static TableColumn<Usuario, String> getPasswordColumn()
	{
		 TableColumn<Usuario, String> passwdCol = new  TableColumn<Usuario, String>("Password");
		 passwdCol.setCellValueFactory(new PropertyValueFactory<Usuario, String>("password"));
		 return passwdCol ;
	}
	 
	
	public void agregar(Usuario user)
	{
		listUsuarios.add(user);
	}

	public void eliminar(Usuario userSelected) {
		listUsuarios.remove(userSelected);
		
	}
	 
	
	
}
