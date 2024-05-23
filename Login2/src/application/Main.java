package application;
	
import application.persistencia.UsuariosHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Parent root = FXMLLoader.load(this.getClass().getResource("ScenePrincipal.fxml"));
			Parent root = FXMLLoader.load(this.getClass().getResource("SceneLogin.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			//primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void stop()
	{
		UsuariosHelper.save();
		System.out.println("En el método Stop()");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
