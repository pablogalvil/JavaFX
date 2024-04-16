package app;

import app.panel.PanelFormulario;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EjemploUsoPanelFormulario extends Application {

	@Override
	public void start(Stage stage) {

		PanelFormulario panelF = new PanelFormulario();

		Scene scene = new Scene(panelF, 600, 600);

		stage.setTitle("Formulario de Contacto");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();

	}

}
