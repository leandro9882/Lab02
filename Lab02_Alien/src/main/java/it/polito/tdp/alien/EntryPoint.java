package it.polito.tdp.alien;

import javafx.application.Application;
import static javafx.application.Application.launch;

import it.polito.tdp.alien.FXMLController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	AlienDictionary dictionary = new AlienDictionary();
		FXMLController controller;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
		// il loader vede quale controller è associato al file fxml dove c'è il
		// riferimento alla classe java che funge da controller
		Parent root = loader.load();
		Scene scene = new Scene(root);

		controller = loader.getController();
		controller.setAlienDictionary(dictionary);

		stage.setTitle("JavaFX and Maven");
		stage.setScene(scene);
		stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
