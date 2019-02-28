package br.edu.cefsa.ftt.ec.chart.app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class SettingsTela extends Application{
	
	

	@Override
	public void start(Stage secondStage) throws Exception {
		// TODO Auto-generated method stub
		
		BorderPane segundaTela = new BorderPane();
		Scene scene2 = new Scene(segundaTela, 400, 100);
		
		secondStage.setTitle("Settings");
		///scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		secondStage.setScene(scene2);
		AnchorPane pane = new AnchorPane();
		segundaTela.setStyle("-fx-background-color: white;");
		
		Button buttonPlay = new Button("Play");
		Button buttonStop = new Button("Stop");
		
		Media media = new Media(SettingsTela.class.getResource("AUD-20180918-WA0025.mp3").toExternalForm());
		MediaPlayer mediaplayer = new MediaPlayer (media);
		
		buttonPlay.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	mediaplayer.play();    	
		    }
		});

		buttonStop.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	mediaplayer.pause();        
		    }
		});	
		
		
		ToolBar toolbar = new ToolBar();
	     
		toolbar.getItems().add(buttonPlay);
		toolbar.getItems().add(buttonStop);
		
		segundaTela.setTop(toolbar);
		
		
		
		secondStage.show();
		
	}

}
