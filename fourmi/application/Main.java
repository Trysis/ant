package application;

import controleur.Controleur;
import gui.Vue;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Model;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Vue vue=new Vue();
			Model model=new Model();
			new Controleur(vue,model);
			
			Scene scene = new Scene(vue,1220,810);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
