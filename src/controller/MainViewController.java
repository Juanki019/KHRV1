package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;

import javafx.fxml.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainViewController implements Initializable{

	@FXML
	private Button btnPlantilla, btnLesionados,  btnDetalles1,  btnDetalles2,  btnDetalles3, btnPlartidos;
    	
    @FXML
    private Label title;
	
    @FXML
    private LineChart chartPuntos;

    @FXML
    private PieChart chart;
    
    @FXML
    private Button btnCladificacion;
    
	ObservableList<Partido>partidos;

	
    @FXML
    public void verPlantilla(ActionEvent event) {
        
        try {
        	//cargo la vista
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/plantilla_view.fxml"));
            Parent root = loader.load();
            //obtengo el controlador
            PlantillaController controlador = loader.getController();
            
            Scene scene = new Scene(root);
           // String css = this.getClass().getResource("src/controller/main.css").toExternalForm();
           // scene.getStylesheets().add(css);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
            stage.setOnCloseRequest(e -> controlador.closeWindows());

            //cierro la ventana donde estoy
           Stage myStage = (Stage) this.btnPlantilla.getScene().getWindow();//cerrar
            myStage.close();
            
        	}catch(IOException ex) {
        		Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        	}
        
    }
    
    @FXML
    void verPartidos(ActionEvent event) {
    	
        try {
        	//cargo la vista
        	FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/view/proximosPartidos.fxml"));
            Parent root1 = loader1.load();
            //obtengo el controlador
            ControllerProximosPartidos controlador1 = loader1.getController();
            
            Scene scene = new Scene(root1);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
            stage.setOnCloseRequest(e -> controlador1.closeWindows());

            //cierro la ventana donde estoy
           Stage myStage = (Stage) this.btnPlantilla.getScene().getWindow();//cerrar
            myStage.close();
            
        	}catch(IOException ex) {
        		Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        	}

    }
    
   
    @FXML
    public void verLesionados(ActionEvent event) {
    	
        try {
        	//cargo la vista
        	FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/lesionados.fxml"));
            Parent root2 = loader2.load();
            //obtengo el controlador
            LesionadosController controlador2 = loader2.getController();
            
            Scene scene = new Scene(root2);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
            stage.setOnCloseRequest(e -> controlador2.closeWindows());

            //cierro la ventana donde estoy
           Stage myStage = (Stage) this.btnLesionados.getScene().getWindow();//cerrar
            myStage.close();
            
        	}catch(IOException ex) {
        		Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        	}
    		
        
		
    }
    
    
    @FXML
    void viewDetalles1(ActionEvent event) {
        try {
        	//cargo la vista
        	FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/view/detallesPartido1.fxml"));
            Parent root3 = loader3.load();
            //obtengo el controlador
            ControllerDetallesPartido1 controlador3 = loader3.getController();
            
            Scene scene = new Scene(root3);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
            stage.setOnCloseRequest(e -> controlador3.closeWindows());

            //cierro la ventana donde estoy
           Stage myStage = (Stage) this.btnDetalles1.getScene().getWindow();//cerrar
            myStage.close();
            
        	}catch(IOException ex) {
        		Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        	}
    }

    
    @FXML
    void viewDetalles2(ActionEvent event) {
        try {
        	//cargo la vista
        	FXMLLoader loader4 = new FXMLLoader(getClass().getResource("/view/detallesPartido2.fxml"));
            Parent root4 = loader4.load();
            //obtengo el controlador
            ControllerDetallesPartido2 controlador4 = loader4.getController();
            
            Scene scene = new Scene(root4);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
            stage.setOnCloseRequest(e -> controlador4.closeWindows());

            //cierro la ventana donde estoy
           Stage myStage = (Stage) this.btnDetalles1.getScene().getWindow();//cerrar
            myStage.close();
            
        	}catch(IOException ex) {
        		Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        	}
    }

    @FXML
    void viewDetalles3(ActionEvent event) {
        try {
        	//cargo la vista
        	FXMLLoader loader5 = new FXMLLoader(getClass().getResource("/view/detallesPartido3.fxml"));
            Parent root5 = loader5.load();
            //obtengo el controlador
            ControllerDetallesPartido3 controlador5 = loader5.getController();
            
            Scene scene = new Scene(root5);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
            stage.setOnCloseRequest(e -> controlador5.closeWindows());

            //cierro la ventana donde estoy
           Stage myStage = (Stage) this.btnDetalles3.getScene().getWindow();//cerrar
            myStage.close();
            
        	}catch(IOException ex) {
        		Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        	}
    }
    
    @FXML
    void verClasificacion(ActionEvent event) {
        try {
        	//cargo la vista
        	FXMLLoader loader6 = new FXMLLoader(getClass().getResource("/view/Clasificacion.fxml"));
            Parent root6 = loader6.load();
            //obtengo el controlador
            VerClasificacionController controlador6 = loader6.getController();
            
            Scene scene = new Scene(root6);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
            stage.setOnCloseRequest(e -> controlador6.closeWindows());

            //cierro la ventana donde estoy
           Stage myStage = (Stage) this.btnDetalles3.getScene().getWindow();//cerrar
            myStage.close();
            
        	}catch(IOException ex) {
        		Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        	}
    }
    

    @FXML
    private void handle(ActionEvent evt) {
    	XYChart.Series series1 = (XYChart.Series)chartPuntos.getData().get(0);
    }
    
    
/*
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("imagenes/Logo.png"));
        return retValue;
    }*/	
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    	XYChart.Series series = new XYChart.Series<>();
    	series.setName("puntos");
    	
    	series.getData().add(new XYChart.Data<>("J0", 0));
    	series.getData().add(new XYChart.Data<>("J1", 3));
    	series.getData().add(new XYChart.Data<>("J2", 3));
    	series.getData().add(new XYChart.Data<>("J3", 6));
    	series.getData().add(new XYChart.Data<>("J4", 6));
    	series.getData().add(new XYChart.Data<>("J5", 9));
    	series.getData().add(new XYChart.Data<>("J6", 12));
    	series.getData().add(new XYChart.Data<>("J7", 15));
    	series.getData().add(new XYChart.Data<>("J8", 15));
    	series.getData().add(new XYChart.Data<>("J9", 18));
    	series.getData().add(new XYChart.Data<>("J10", 21));
    	series.getData().add(new XYChart.Data<>("J11", 21));

    	chartPuntos.getData().add(series);


    	
    } 
    



}







