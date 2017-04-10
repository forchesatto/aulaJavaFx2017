package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * Classe principal do sistema, onde tem qual é o Stage principal e a Scene
 * inicial
 * 
 * Possui herança da classe Application do próprio JavaFX que possibilita o
 * start da aplicação JavaFX.
 * 
 * @author forchesatto
 *
 */
public class Main extends Application {

	/**
	 * Método que o JavaFX chama por primeiro para saber qual é o conteúdo da
	 * primeira tela.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			// Elemento principal do meu layout, elemento inicial do meu xml.
			BorderPane root = (BorderPane) FXMLLoader.load(getClass()
					.getResource("clienteForm.fxml"));
			
			//Responsável por mostrar os elementos do meu layout.
			Scene scene = new Scene(root);
			//folha de estilo (css) para formatação dos elementos na tela.
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			//Preparação do Stage para mostrar o conteúdo da Scene.
			primaryStage.setScene(scene);
			//Mostra a tela para o usuário.
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
