package application.controllers;

import java.io.IOException;

import application.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	
	Usuario userAdmin = new Usuario("Beto", "123456");
	
	@FXML
	private TextField tfUsuario;
	@FXML
	private PasswordField tfPassword;

	public void btnIngresar_OnClick(ActionEvent e)
	{
		Usuario user = new Usuario(tfUsuario.getText(), tfPassword.getText());
		/*System.out.println("Usuario: " + tfUsuario.getText());
		System.out.println("Contraseña: " + tfPassword.getText());*/
		//System.out.println("Se ha hecho un click en el boton");
	
		boolean result = Usuario.verificarCredenciales(userAdmin, user);
		if (result)
		{
			//Alert alerta = new Alert(AlertType.INFORMATION, "HA iniciado Sesión", ButtonType.OK);
			//alerta.show();
			
			Stage stage = new Stage();
			Parent root;
			try {
				root = FXMLLoader.load(this.getClass().getResource("ScenePrincipal.fxml"));
			} catch (IOException e1) {

				Alert alerta = new Alert(AlertType.ERROR, "No se puede cargar el archivo FXML", ButtonType.OK);
				alerta.show();
				e1.printStackTrace();
				return;
			}
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("css/application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			
			
		}
		else {
			Alert alerta = new Alert(AlertType.ERROR, "Contraseña incorrecta", ButtonType.OK);
			alerta.show();
		}
		
	
	}
	
}
