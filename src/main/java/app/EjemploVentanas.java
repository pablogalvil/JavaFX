package app;

import app.panel.PanelFormulario;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EjemploVentanas extends Application {

	public Label lblInfo;

	@Override
	public void start(Stage stage) {

		PanelFormulario panelF = new PanelFormulario();

		VBox panelVertical = new VBox();

		panelVertical.getChildren().add(panelF);

		Button btnVentanaInfo = new Button("Ventana Info");
		Button btnVentanaConf = new Button("Ventana Confirmación");
		Button btnPersonal1 = new Button("Ventana Personalizada interactiva");
		Button btnPersonal2 = new Button("Ventana Personalizada modal");

		lblInfo = new Label("Información");

		btnVentanaInfo.setOnAction(event -> {
			mostrarAlerta(Alert.AlertType.INFORMATION);
		});

		btnVentanaConf.setOnAction(event -> {
			mostrarAlerta(Alert.AlertType.CONFIRMATION);
		});

		btnPersonal1.setOnAction(e -> {
			abrirVentanaContacto();
		});

		btnPersonal2.setOnAction(e -> {
			abrirVentanaModal(stage);
		});

		// Añadimos los elementos al panel vertical
		panelVertical.getChildren().addAll(btnVentanaInfo, btnVentanaConf, btnPersonal1, btnPersonal2, lblInfo);

		panelVertical.setMargin(btnVentanaInfo, new Insets(5, 10, 5, 10));
		panelVertical.setMargin(lblInfo, new Insets(5, 10, 5, 10));
		panelVertical.setPadding(new Insets(5, 10, 5, 10));

		// Añadimos a la escena el panel vertical
		Scene scene = new Scene(panelVertical, 600, 600);

		stage.setTitle("Formulario de Contacto");
		stage.setScene(scene);
		stage.show();
	}

	public void abrirVentanaModal(Stage stage) {

		Stage ventanaEmergente = new Stage();

		StackPane stackpane = new StackPane();

		stackpane.getChildren().add(new Label("Contenido de prueba"));

		Scene scene = new Scene(stackpane, 300, 300);

		// Para bloquear a la ventana padre hay que definir quien es el padre con
		// initOwner y poner la modalidad
		ventanaEmergente.initOwner(stage);
		ventanaEmergente.initModality(Modality.WINDOW_MODAL);

		ventanaEmergente.setTitle("Ventana Modal");
		ventanaEmergente.show();

	}

	// Funcion que abre la ventana del formulario de contacto
	public void abrirVentanaContacto() {
		Stage ventanaEmergente = new Stage();

		PanelFormulario panelForm = new PanelFormulario();

		Scene scene = new Scene(panelForm, 300, 300);

		// Añadimos un evento al boton del formulario
		panelForm.btnAceptar.setOnAction(e -> {
			this.lblInfo.setText(panelForm.txtObs.getText());
		});

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Contacto");
		ventanaEmergente.show();
	}

	// Funcion que muestra una ventana de alerta
	public void mostrarAlerta(AlertType tipoAlerta) {

		if (tipoAlerta == Alert.AlertType.INFORMATION) {
			Alert infoAlert = new Alert(tipoAlerta);
			infoAlert.setTitle("Información Relevante");
			infoAlert.setHeaderText("Ultimas noticias");
			infoAlert.setContentText(
					"Si no lees esta información te vas a perder lo último en crypto, pasame tu clave privada, please");
			infoAlert.showAndWait();
		}

		if (tipoAlerta == Alert.AlertType.CONFIRMATION) {
			Alert confirmAlert = new Alert(tipoAlerta);
			confirmAlert.setTitle("Mayor de edad");
			confirmAlert.setHeaderText("Confirma los datos");
			confirmAlert.setContentText("¿Eres mayor de edad?");

			// Al mostrar la ventana, esta nos devuelve el tipo de boton que se ha pulsado
			ButtonType btnPulsado = confirmAlert.showAndWait().orElse(ButtonType.NO);

			if (btnPulsado == ButtonType.CANCEL) {
				this.lblInfo.setText("El usuario es Menor de edad");
			} else {
				this.lblInfo.setText("El usuario es Mayor de edad");
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();

	}

}
