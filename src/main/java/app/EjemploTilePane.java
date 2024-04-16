package app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class EjemploTilePane extends Application {

	@Override
	public void start(Stage stage) {
		TilePane tilePane = new TilePane();
		ScrollPane panelScroll = new ScrollPane();

		// Añadimos 100 botones al tilePane, funciona como el float left de css
		// posicionando arriba a la izquierda todo y cuando no entra en el ancho pasa a
		// la siguiente linea
		for (int i = 1; i < 101; i++) {
			ToggleButton tglButton = new ToggleButton("Botón " + i);

			tilePane.getChildren().add(tglButton);

			tilePane.setMargin(tglButton, new Insets(5, 20, 5, 20));
		}

		// Para que un panel tenga scroll hay que meterlo dentro de un ScrollPane
		panelScroll.setContent(tilePane);

		// Creamos la escena con el panel dentro
		Scene scene = new Scene(panelScroll, 600, 400);

		// Le ponemos un titulo a la ventana
		stage.setTitle("Mi primer tile pane con scroll");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
