package br.edu.cefsa.ftt.ec.chart.app;

//TODO: Projeto N1

//TODO: Esta é a estratura básica do projeto
//TODO: Abrir um arquivo e ler os dados
//TODO: Mudar parametros do gráfico pegando dados com usuário utilizando dialog
//TODO: Gerar o gráfico no centro da interface (border layout)
//TODO: Utilizar valor dos sliders para modificar o gráfico dinamicamente...

import java.awt.Insets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
	// tcf
	@Override
	public void start(Stage primaryStage) {

		try {

			BorderPane rootBorderPane = new BorderPane();
			Scene scene = new Scene(rootBorderPane, 800, 600);

			primaryStage.setTitle("JavaFX - Chart Controll");
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			AnchorPane pane = new AnchorPane();
			rootBorderPane.setStyle("-fx-background-color: white;");
			// Components declaration:

			Button buttonFileOpen = new Button("Open");

			Button buttonSettings = new Button("Settings");

			Slider slider = new Slider();

			slider.setMin(1);
			slider.setMax(100);
			slider.setValue(50);
			slider.setShowTickLabels(true);
			slider.setShowTickMarks(true);
			slider.setMajorTickUnit(50);
			slider.setMinorTickCount(5);
			slider.setBlockIncrement(10);

			Label status = new Label("Status: ");

			slider.valueProperty().addListener((observable, oldvalue, newvalue) -> {
				float val = newvalue.floatValue();
				if (val == 0 || val <= 10) {
					rootBorderPane.setStyle(
							"-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, silver 0%, blue 100%);");
				} else if (val > 10 && val <= 20) {
					rootBorderPane.setStyle(
							"-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, blue 0%, purple 100%);");
				} else if (val > 20 && val <= 30) {
					rootBorderPane.setStyle(
							"-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, purple 0%, pink 100%);");
				} else if (val > 30 && val <= 40) {
					rootBorderPane.setStyle(
							"-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, pink 0%, red 100%);");
				} else if (val > 40 && val <= 50) {
					rootBorderPane.setStyle(
							"-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, red 0%, orange 100%);");
				} else if (val > 50 && val <= 60) {
					rootBorderPane.setStyle(
							"-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, orange 0%, yellow 100%);");
				} else if (val > 60 && val <= 70) {
					rootBorderPane.setStyle(
							"-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, yellow 0%, green 100%);");
				} else if (val > 70 && val <= 80) {
					rootBorderPane.setStyle(
							"-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, green 0%, brown 100%);");
				} else if (val > 80 && val <= 90) {
					rootBorderPane.setStyle(
							"-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, brown 0%, gold 100%);");
				} else if (val > 90 && val <= 100) {
					rootBorderPane.setStyle(
							"-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, gold 0%, silver 100%);");
				}
				System.out.println("Slider value: " + val);
				status.setText("Status: Slider= " + val);
			});

			// Form layout...

			ToolBar toolbar = new ToolBar();

			toolbar.getItems().add(buttonFileOpen);
			toolbar.getItems().add(buttonSettings);
			toolbar.getItems().add(slider);

			HBox statusbar = new HBox();

			statusbar.getChildren().add(status);

			rootBorderPane.setTop(toolbar);

			final NumberAxis xAxis = new NumberAxis(0, 25, 1);
			final NumberAxis yAxis = new NumberAxis(0, 30, 100);
			final ScatterChart<Number, Number> sc = new ScatterChart<Number, Number>(xAxis, yAxis);
			xAxis.setLabel("");
			yAxis.setLabel("");
			sc.setTitle("");

			XYChart.Series series1 = new XYChart.Series();

			series1.setName("Legenda1");
			series1.getData().add(new XYChart.Data(2, 10));
			series1.getData().add(new XYChart.Data(2, 11));
			series1.getData().add(new XYChart.Data(2, 12));
			series1.getData().add(new XYChart.Data(2, 13));
			series1.getData().add(new XYChart.Data(2, 14));
			series1.getData().add(new XYChart.Data(2, 15));
			series1.getData().add(new XYChart.Data(2, 16));
			series1.getData().add(new XYChart.Data(2, 17));
			series1.getData().add(new XYChart.Data(2, 18));
			series1.getData().add(new XYChart.Data(2, 19));
			series1.getData().add(new XYChart.Data(2, 20));
			series1.getData().add(new XYChart.Data(2, 21));
			series1.getData().add(new XYChart.Data(2, 22));
			series1.getData().add(new XYChart.Data(2, 23));
			series1.getData().add(new XYChart.Data(3, 9));
			series1.getData().add(new XYChart.Data(3, 24));
			series1.getData().add(new XYChart.Data(4, 8));
			series1.getData().add(new XYChart.Data(4, 25));
			series1.getData().add(new XYChart.Data(5, 7));
			series1.getData().add(new XYChart.Data(5, 26));
			series1.getData().add(new XYChart.Data(6, 7));
			series1.getData().add(new XYChart.Data(6, 26));
			series1.getData().add(new XYChart.Data(7, 4));
			series1.getData().add(new XYChart.Data(7, 7));
			series1.getData().add(new XYChart.Data(7, 23));
			series1.getData().add(new XYChart.Data(7, 26));
			series1.getData().add(new XYChart.Data(8, 5));
			series1.getData().add(new XYChart.Data(8, 6));
			series1.getData().add(new XYChart.Data(8, 7));
			series1.getData().add(new XYChart.Data(8, 8));
			series1.getData().add(new XYChart.Data(8, 9));
			series1.getData().add(new XYChart.Data(8, 10));
			series1.getData().add(new XYChart.Data(8, 11));
			series1.getData().add(new XYChart.Data(8, 12));
			series1.getData().add(new XYChart.Data(8, 13));
			series1.getData().add(new XYChart.Data(8, 14));
			series1.getData().add(new XYChart.Data(8, 15));
			series1.getData().add(new XYChart.Data(8, 16));
			series1.getData().add(new XYChart.Data(8, 17));
			series1.getData().add(new XYChart.Data(8, 18));
			series1.getData().add(new XYChart.Data(8, 19));
			series1.getData().add(new XYChart.Data(8, 20));
			series1.getData().add(new XYChart.Data(8, 21));
			series1.getData().add(new XYChart.Data(8, 22));
			series1.getData().add(new XYChart.Data(8, 26));
			series1.getData().add(new XYChart.Data(9, 4));
			series1.getData().add(new XYChart.Data(9, 7));
			series1.getData().add(new XYChart.Data(9, 16));
			series1.getData().add(new XYChart.Data(9, 23));
			series1.getData().add(new XYChart.Data(9, 26));
			series1.getData().add(new XYChart.Data(10, 26));
			series1.getData().add(new XYChart.Data(10, 24));
			series1.getData().add(new XYChart.Data(10, 15));
			series1.getData().add(new XYChart.Data(10, 7));
			series1.getData().add(new XYChart.Data(11, 26));
			series1.getData().add(new XYChart.Data(11, 24));
			series1.getData().add(new XYChart.Data(11, 14));
			series1.getData().add(new XYChart.Data(11, 7));
			series1.getData().add(new XYChart.Data(12, 25));
			series1.getData().add(new XYChart.Data(12, 24));
			series1.getData().add(new XYChart.Data(12, 14));
			series1.getData().add(new XYChart.Data(12, 8));
			series1.getData().add(new XYChart.Data(13, 23));
			series1.getData().add(new XYChart.Data(13, 22));
			series1.getData().add(new XYChart.Data(13, 21));
			series1.getData().add(new XYChart.Data(13, 14));
			series1.getData().add(new XYChart.Data(13, 12));
			series1.getData().add(new XYChart.Data(13, 11));
			series1.getData().add(new XYChart.Data(13, 10));
			series1.getData().add(new XYChart.Data(13, 9));
			series1.getData().add(new XYChart.Data(14, 24));
			series1.getData().add(new XYChart.Data(14, 14));
			series1.getData().add(new XYChart.Data(15, 24));
			series1.getData().add(new XYChart.Data(15, 14));
			series1.getData().add(new XYChart.Data(16, 24));
			series1.getData().add(new XYChart.Data(16, 14));
			series1.getData().add(new XYChart.Data(17, 23));
			series1.getData().add(new XYChart.Data(17, 15));
			series1.getData().add(new XYChart.Data(18, 22));
			series1.getData().add(new XYChart.Data(18, 21));
			series1.getData().add(new XYChart.Data(18, 20));
			series1.getData().add(new XYChart.Data(18, 19));
			series1.getData().add(new XYChart.Data(18, 18));
			series1.getData().add(new XYChart.Data(18, 17));
			series1.getData().add(new XYChart.Data(18, 16));

			sc.setPrefSize(500, 400);
			sc.getData().addAll(series1);

			rootBorderPane.setCenter(sc);
			rootBorderPane.setBottom(statusbar);

			buttonFileOpen.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {

					
					series1.getData().clear();
					FileChooser fileChooser = new FileChooser();
					fileChooser.setTitle("Abrir Arquivo");

					File arq = fileChooser.showOpenDialog(primaryStage);
					String caminho = arq.getPath();

					try {
						BufferedReader br = new BufferedReader(new FileReader(caminho));

						String linha = br.readLine();						

						while (linha != null) {
							String[] itens = linha.split(",");
							//System.out.println(Integer.valueOf(itens[0]));
							//+ "," + Integer.valueOf(itens[1]));
							
							series1.getData().add(new XYChart.Data(Integer.valueOf(itens[0]), Integer.valueOf(itens[1])));
							sc.getData().add(series1);
							linha = br.readLine();
						}
							
							//sc.getData().addAll(series1);
							rootBorderPane.setCenter(sc);

						
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
					
					

				}
			});

			buttonSettings.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					// TODO: Change graphic parameters using dialog

					try {
						new SettingsTela().start(new Stage());
					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			});

			// Mágica...
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
