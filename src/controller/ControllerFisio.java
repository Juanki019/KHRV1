package controller;

import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ControllerFisio implements Initializable{

    @FXML
    private Button btnSensores;

    @FXML
    private Button btnConsulta;

    @FXML
    void verConsultas(ActionEvent event) {

    	TableView<Consulta> tableViewP = new TableView();

		TableColumn<Consulta, String> column1 = new TableColumn<>("Lugar");
		column1.setCellValueFactory(new PropertyValueFactory<>("lugar"));


		TableColumn<Consulta, String> column2 = new TableColumn<>("Dia");
		column2.setCellValueFactory(new PropertyValueFactory<>("dia"));

		TableColumn<Consulta, String> column3 = new TableColumn<>("Hora");
		column3.setCellValueFactory(new PropertyValueFactory<>("hora"));
		
		tableViewP.getColumns().add(column1);
		tableViewP.getColumns().add(column2);
		tableViewP.getColumns().add(column3);
    	
		String jsonString = "[{\"lugar\":\"Instalaciones Sala A\", \"dia\":\"1/2/2023\", \"hora\":\"12:30\" }, "
				+ "{\"lugar\":\"Instalaciones Sala B\", \"dia\":\"2/2/2023\", \"hora\":\"12:30\" }, "
				+ "{\"lugar\":\"Instalaciones Sala A\", \"dia\":\"3/2/2023\", \"hora\":\"12:30\" }, "
				+ "{\"lugar\":\"Instalaciones Sala B\", \"dia\":\"3/2/2023\", \"hora\":\"15:30\" }, "
				+ "{\"lugar\":\"Instalaciones Sala B\", \"dia\":\"3/2/2023\", \"hora\":\"18:30\"}]";
		
		
		Gson gson = new Gson();
		Consulta[] dataList = gson.fromJson(jsonString, Consulta[].class);
		ObservableList<Consulta> observableList = FXCollections.observableArrayList(dataList);
		tableViewP.setItems(observableList);
      
		Scene scene = new Scene(new StackPane(tableViewP));
		Stage stage = (Stage) this.btnConsulta.getScene().getWindow();//cerrar
		stage.setTitle("Partidos");
		stage.setScene(scene);
		stage.show();
		
    }

    @FXML
    void verDataSensores(ActionEvent event) throws IOException, ParseException {
    	

    
    	
    	
    	/*final String filePath = "sensores.json";

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONArray json = (JSONArray) obj;

            for (int i = 0; i < json.size(); i++) {

            JSONObject object =(JSONObject) json.get(i);
            String clave = object.get("nombre").toString();  
            String title = object.get("VelocidadPunta").toString();  


             }

} catch (Exception ex) {
System.err.println("Error :"+ex.getMessage());
}*/
    	
         try{
        	 
        	JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("sensores.json"));
            JSONObject json = (JSONObject) obj;

            
            for (int i = 0; i < json.size(); i++) {

                JSONObject object =(JSONObject) json.get(i);
                String clave = object.get("id").toString();  
                String title = object.get("nombre").toString();  

                 }
           

         }
         catch (FileNotFoundException e){
            System.out.println("ERROR. No se encuentra el archivo");
         }
    	
}
   
	public void closeWindows() {
		
        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/medicoView.fxml"));
            Parent root = loader.load();
            ControllerTipoMedico controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
           //Stage myStage = (Stage) this.btnClose.getScene().getWindow();
          // myStage.close();
            
        	}catch(IOException ex) {
        	
        		Logger.getLogger(ControllerTipoMedico.class.getName()).log(Level.SEVERE, null, ex);
        	}
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
