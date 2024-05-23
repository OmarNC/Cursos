package application.controllers;

import java.util.function.Predicate;

import application.modelo.UserModel;
import application.modelo.Usuario;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PanelUsuariosController{
	

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TextField tfBuscar;

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfPassword;

    @FXML
    private TableView<?> tvUsarios;
    
    @FXML
    private ScrollPane scrollPanelTableView;
    
    //Atributos
    
    UserModel modeloUsuario = new UserModel();
    
    Usuario userSelected = null;
    
    FilteredList<Usuario> listaFiltrada = null;
    
    //Métodos y/o Eventos
    
    
    @FXML
    void btnActualizar_OnClick(ActionEvent event) {
    	String user = tfLogin.getText();
    	String passwd = tfPassword.getText();
    	
    	if(userSelected!= null && user.length() > 3 && passwd.length() > 3)
    	{
    		userSelected.setUsuario(user);
    		userSelected.setPassword(passwd);
    		
    		tfLogin.setText("");
    		tfPassword.setText("");
    		
    		userSelected = null;
    	}
    }

    @FXML
    void btnAgregar_OnClick(ActionEvent event) {
    	/*Alert mensaje = new Alert(Alert.AlertType.INFORMATION, "Click en el boton  btnAgregar", ButtonType.APPLY);
    	mensaje.show();
    	*/
    	String user = tfLogin.getText();
    	String passwd = tfPassword.getText();
    	if(passwd.length() > 3 && passwd.length() > 3)
    	{
    		modeloUsuario.agregar(new Usuario(user, passwd));
    		tfLogin.setText("");
    		tfPassword.setText("");
    	}
    	else
    	{
    		Alert mensaje = new Alert(Alert.AlertType.ERROR, "El nombre de usuario y/o contraseña debe ser maroy a 3 caracteres", ButtonType.APPLY);
        	mensaje.show();
    	}
    	
    	
    }

    @FXML
    void btnBuscar_OnClick(ActionEvent event) {
    	Predicate<Usuario> filtro = null;
    		if(tfBuscar.getLength() > 0)
    		{
	    		filtro =  usuario -> {
	    			return usuario.getUsuario().toLowerCase().contains(tfBuscar.getText().toLowerCase());
	    		};
    		}
    		else  filtro = usuario -> true;
    		
    		listaFiltrada.setPredicate(filtro);
    		
    }

    @FXML
    void btnEliminar_OnClick(ActionEvent event) {
    	
    	if (userSelected != null)
    	{
    		Alert alerta = new Alert(AlertType.CONFIRMATION, "¿Deseas eliminar al usario: " + userSelected.getUsuario() + "?", ButtonType.YES );
    		alerta.showAndWait();
    		
    		modeloUsuario.eliminar(userSelected);
    		tfLogin.setText("");
    		tfPassword.setText("");
    	}
    }

    public void loadUsuarios()
    {
    	//TODO: Inicializar la tabla con los usuarios
    	//Alert mensaje = new Alert(Alert.AlertType.INFORMATION, "Leer lista usuario", ButtonType.APPLY);
    	//mensaje.show();
    	
    	
    	listaFiltrada = new FilteredList<Usuario>(modeloUsuario.getListaUsuarios(), p -> true);
    	
    	TableView<Usuario> nuevoTvUsarios = new TableView<Usuario>(listaFiltrada);
    	boolean all = nuevoTvUsarios.getColumns().addAll(
    			UserModel.getLoginColumn(),
    			UserModel.getPasswordColumn()
    			);
    	
    	nuevoTvUsarios.setOnMouseClicked((evento) -> {
    		
    		if (evento.getClickCount() == 2) {//Double Click
    			Usuario user = nuevoTvUsarios.getSelectionModel().getSelectedItem();
    			tfLogin.setText(user.getUsuario());
    			tfPassword.setText(user.getPassword());
    			userSelected = user;
    		}
    	});
    	
    	scrollPanelTableView.setContent(nuevoTvUsarios);
    	//tvUsarios = nuevoTvUsarios;
    	
    	
    	
    }

}
