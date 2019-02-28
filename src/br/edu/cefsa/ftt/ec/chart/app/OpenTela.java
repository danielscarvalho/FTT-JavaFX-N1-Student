package br.edu.cefsa.ftt.ec.chart.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class OpenTela extends Application{

	@Override
	public void start(Stage terceiraTela) throws Exception {
		// TODO Auto-generated method stub
		
		BorderPane segundaTela = new BorderPane();
		Scene scene3 = new Scene(segundaTela, 200, 150);
		
		
		terceiraTela.setTitle("JavaFX - Chart Controll");
		///scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		terceiraTela.setScene(scene3);
		AnchorPane pane = new AnchorPane();
		segundaTela.setStyle("-fx-background-color: white;");
		
		terceiraTela.show();
		
	}

}
