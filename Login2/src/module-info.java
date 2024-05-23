 module Login2 {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires java.sql;
	requires org.apache.derby.engine;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
	opens application.controllers to javafx.graphics, javafx.fxml, javafx.base;
	opens application.modelo to javafx.graphics, javafx.fxml, javafx.base;
	opens application.persistencia to javafx.graphics, javafx.fxml, javafx.base;
}
