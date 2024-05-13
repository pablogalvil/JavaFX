package app;

import java.sql.Connection;
import java.util.ArrayList;

import app.model.AvestruzDAO;
import app.model.AvestruzDO;
import app.utils.UtilsPruebaExamen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class examen2022 extends Application {

	public static Connection con = UtilsPruebaExamen.conectarBD();
	private static ArrayList<AvestruzDO> avestruces = AvestruzDAO.cargarAvestruz(con);

	public void start(Stage stage) {
		VBox panelPrincipal = new VBox();

		MenuBar barra = new MenuBar();

		Menu mArchivo = new Menu("Archivo");
		MenuItem iCargar = new MenuItem("Cargar");
		MenuItem iGuardar = new MenuItem("Guardar");
		MenuItem iSalir = new MenuItem("Salir");

		mArchivo.getItems().addAll(iCargar, iGuardar, iSalir);

		Menu mComponentes = new Menu("Componentes");
		MenuItem iTarjetaGraf = new MenuItem("Tarjeta grafica");
		MenuItem iMicroprocesadores = new MenuItem("Microprocesadores");
		MenuItem iMemoria = new MenuItem("Memoria");

		mComponentes.getItems().addAll(iTarjetaGraf, iMicroprocesadores, iMemoria);

		Menu mAyuda = new Menu("Ayuda");
		MenuItem iAcercaDe = new MenuItem("Acerca de");
		MenuItem iContacto = new MenuItem("Contacto");

		mAyuda.getItems().addAll(iAcercaDe, iContacto);

		barra.getMenus().addAll(mArchivo, mComponentes, mAyuda);

		TabPane tabPane = new TabPane();

		panelPrincipal.getChildren().addAll(barra, tabPane);

		Tab listaElementos = new Tab("Lista Elementos");
		Tab editar = new Tab("Editar");

		listaElementos.setClosable(false);

		tabPane.getTabs().addAll(listaElementos);

		iTarjetaGraf.setOnAction(e -> {
			Paneles panel = new Paneles();
		});

		VBox panelElementos = new VBox();

		listaElementos.setContent(panelElementos);

		for (int i = 0; i < avestruces.size(); i++) {

			Label lblComponente = new Label("Nombre :");
			Label nomComponente = new Label(avestruces.get(i).getNombre());

			Button btnEditar = new Button("Editar");

			panelElementos.getChildren().addAll(lblComponente, nomComponente, btnEditar);

			int num = i;

			btnEditar.setOnAction(e -> {
				ScrollPane scroll = new ScrollPane();

				VBox panelEditar = new VBox();

				Label lblNombre = new Label("Nombre :");
				Label lblNickGuerra = new Label("Nick de guerra :");
				Label lblEdad = new Label("Edad :");
				Label lblAltura = new Label("Altura :");
				Label lblNivelMalaLeche = new Label("Nivel de mala leche :");
				Label lblNumHuevos = new Label("Numero de huevos :");

				TextField txtNombre = new TextField(avestruces.get(num).getNombre());
				TextField txtNickGuerra = new TextField(avestruces.get(num).getNickGuerra());
				TextField txtEdad = new TextField(String.valueOf(avestruces.get(num).getEdad()));
				TextField txtAltura = new TextField(String.valueOf(avestruces.get(num).getAltura()));
				TextField txtNivelMalaLeche = new TextField(String.valueOf(avestruces.get(num).getNivelMalaLeche()));
				TextField txtNumHuevos = new TextField(String.valueOf(avestruces.get(num).getNumHuevos()));

				Button btnConfirm = new Button("Editar");

				panelEditar.getChildren().addAll(lblNombre, txtNombre, lblNickGuerra, txtNickGuerra, lblEdad, txtEdad,
						lblAltura, txtAltura, lblNivelMalaLeche, txtNivelMalaLeche, lblNumHuevos, txtNumHuevos,
						btnConfirm);

				scroll.setContent(panelEditar);

				editar.setContent(scroll);

				tabPane.getTabs().add(editar);
				tabPane.getSelectionModel().select(editar);

				txtNombre.textProperty().addListener((observable, oldValue, newValue) -> {
					nomComponente.setText(newValue);
				});

				btnConfirm.setOnAction(event -> {
					AvestruzDO temp = new AvestruzDO(avestruces.get(num).getIdAvestruz(), txtNombre.getText(),
							txtNickGuerra.getText(), Integer.valueOf(txtEdad.getText()),
							Integer.valueOf(txtAltura.getText()), Integer.valueOf(txtNivelMalaLeche.getText()),
							Integer.valueOf(txtNumHuevos.getText()));

					if (AvestruzDAO.insertAvestruz(temp, con)) {
						tabPane.getTabs().remove(editar);
						avestruces = AvestruzDAO.cargarAvestruz(con);
					} else
						alertaTabPane();
				});
			});
		}

		Scene scene = new Scene(panelPrincipal, 1000, 800);

		stage.setTitle("Examen 2022");
		stage.setScene(scene);
		stage.show();
	}

	public void alertaTabPane() {
		AlertType tipoAlerta = Alert.AlertType.WARNING;
		Alert infoAlert = new Alert(tipoAlerta);
		infoAlert.setTitle("Alerta!");
		infoAlert.setHeaderText("Confirma los cambios.");
		infoAlert.setContentText("Antes de cambiar un tipo de dato, cambia los datos.");
		infoAlert.showAndWait();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
