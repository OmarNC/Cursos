package application;

import java.io.IOException;

import application.controllers.PanelUsuariosController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class PrincipalController {

    @FXML
    private HBox hbProducto;

    @FXML
    private HBox hbUsuario;
    
    @FXML 
    private SplitPane spPrincipal;

    @FXML
    void hbProducto_OnClick(MouseEvent event) {
    	//Alert alerta = new Alert(AlertType.INFORMATION, "click en Productos", ButtonType.OK);
		//alerta.show();
		
		try {
			AnchorPane panel = FXMLLoader.load(this.getClass().getResource("PanelProductos.fxml"));
			AnchorPane panelDer = (AnchorPane)spPrincipal.getItems().get(1);
			panelDer.getChildren().remove(0);
			panelDer.getChildren().add(panel);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }

    @FXML
    void hbUsuarios_OnClick(MouseEvent event) {
    	//Alert alerta = new Alert(AlertType.INFORMATION, "click en Usuario", ButtonType.OK);
		//alerta.show();
		
		try {
			
			/*
			 *  FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
			root = loader.load();
			
			Scene2Controller scene2Controller  = loader.getController();
			scene2Controller.displayName(userName);
			 * */
			
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("PanelUsuarios.fxml"));
			AnchorPane panelUsuarios = loader.load();
			
			PanelUsuariosController controller = loader.getController();
			controller.loadUsuarios();
			
			
			//AnchorPane panelUsuarios = FXMLLoader.load(this.getClass().getResource("PanelUsuarios.fxml"));
			AnchorPane panelDer = (AnchorPane)spPrincipal.getItems().get(1);
			//panelDer.getChildren().remove(0);
			panelDer.getChildren().clear();
			panelDer.getChildren().add(panelUsuarios);
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}

/*
 
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("PanelProductos.fxml"));
		AnchorPane panel;
		AnchorPane panel2;
		
		try {
			panel = loader.load();
		
		AnchorPane ap = new AnchorPane();
		ap.getChildren().add(new Button("Hola"));
		
		SplitPane.setResizableWithParent(panel, true);
		panel2 = (AnchorPane)spPrincipal.getItems().get(1);
		panel2.getChildren().add(panel);
	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
