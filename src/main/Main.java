package main;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle("KHR");
		
    	stage.getIcons().add(new Image("/imagenes/Logo.png"));
		
		Parent root = FXMLLoader.load(getClass().getResource("/view/InterfazLog.fxml"));		//Cargamos nuestra interfaz en el objeto Parent
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
		
		
		//--module-path C:\Program Files\Java\javafx-sdk-19 --add-modules javafx.contros,jafafx.fxml
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}