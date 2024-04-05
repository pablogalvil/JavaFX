package Aplication;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EjemploMenusBorderPane extends Application {

	@Override
	public void start(Stage stage) {
		BorderPane pnlDistribucion = new BorderPane();

		// ZONA SUPERIOR MENU
		Label lblMenu = new Label("Menu");

		// Asignamos el menu a la parte superior
		pnlDistribucion.setTop(lblMenu);
		pnlDistribucion.setMargin(lblMenu, new Insets(10, 7, 10, 7));
		pnlDistribucion.setAlignment(lblMenu, Pos.CENTER);

		// ZONA LATERAL IZQUIERDA, UN CONJUNTO DE BOTONES
		VBox panelLateral = new VBox();
		Button btnCargar = new Button("Cargar");
		Button btnGuardar = new Button("Guardar");

		// Añadimos los dos botones al panel lateral
		panelLateral.getChildren().addAll(btnCargar, btnGuardar);

		// En la zona izquierda del borderpane ponemos el VBox con los botones
		pnlDistribucion.setLeft(panelLateral);
		panelLateral.setMargin(btnCargar, new Insets(5, 7, 5, 7));
		panelLateral.setMargin(btnGuardar, new Insets(5, 7, 5, 7));

		// PANEL CENTRAL, VAMOS A PONER UN TEXTAREA Y UN SLIDER

		VBox panelCentral = new VBox();

		Label lblValorNota = new Label("5");

		Slider slider = new Slider();
		slider.setMaxWidth(380);
		slider.setMin(0);
		slider.setMax(10);
		slider.setValue(5);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(10);
		slider.setMinorTickCount(1);
		slider.setBlockIncrement(1);

		slider.setOnDragDetected(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				lblValorNota.setText(Double.toString(slider.getValue()));
			}
		});

		TextArea textoFich = new TextArea();

		// Añadimos el slider y el textarea al VBox
		panelCentral.getChildren().addAll(lblValorNota, slider, textoFich);
		panelCentral.setMargin(lblValorNota, new Insets(5, 0, 5, 193.5));
		panelCentral.setMargin(slider, new Insets(5, 7, 5, 7));
		panelCentral.setMargin(textoFich, new Insets(5, 7, 5, 7));

		// Añadimos el VBox al centro del borderpane principal
		pnlDistribucion.setCenter(panelCentral);

		var scene = new Scene(pnlDistribucion, 800, 600);

		stage.setTitle("Ejemplo Menu");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
