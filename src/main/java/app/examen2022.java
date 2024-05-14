package app;

import java.sql.Connection;
import java.util.ArrayList;

import app.model.AvestruzDAO;
import app.model.AvestruzDO;
import app.model.KoalaDO;
import app.utils.UtilsPruebaExamen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class examen2022 extends Application {

	public static Connection con = UtilsPruebaExamen.conectarBD();
	private static ArrayList<AvestruzDO> avestruces = AvestruzDAO.cargarAvestruz(con);

	public void start(Stage stage) {
		VBox panelPrincipal = new VBox();

		MenuBar barra = new MenuBar();

		// Menu de archivo
		Menu mArchivo = new Menu("Archivo");
		MenuItem iCargar = new MenuItem("Cargar");
		MenuItem iSalir = new MenuItem("Salir");
		mArchivo.getItems().addAll(iCargar, iSalir);

		// Menu de Koala
		Menu mKoalas = new Menu("Koalas");
		MenuItem iDatos = new MenuItem("Mostrar Datos");
		mKoalas.getItems().addAll(iDatos);

		// Menu de Avestruz
		Menu mAvestruz = new Menu("Avestruz");
		MenuItem iDel = new MenuItem("Eliminar");
		MenuItem iLoad = new MenuItem("Cargar");
		mAvestruz.getItems().addAll(iDel, iLoad);

		// Le agregamos a la menuBar los menus creados anteriormente.
		barra.getMenus().addAll(mArchivo, mKoalas, mAvestruz);

		// Mostramos el choiceBox de Avestruces
		Label lblavestruces = new Label("Avestruz");
		ChoiceBox<String> choiceAve = new ChoiceBox<>();
		ScrollPane scroll1 = new ScrollPane();
		scroll1.setContent(panelPrincipal);
		// Cargamos en un arrayList todas las avestruces de la base de datos

		// TabPane
		TabPane tabPane = new TabPane();

		panelPrincipal.getChildren().addAll(barra, tabPane, lblavestruces, choiceAve);

		Tab listaElementos = new Tab("Lista de koalas");
		Tab editar = new Tab("Editar");

		listaElementos.setClosable(false);

		tabPane.getTabs().addAll(listaElementos);

		iCargar.setOnAction(e -> {
			// Meter valores en el choiceBox
			for (int i = 0; i < avestruces.size(); i++) {
				choiceAve.getItems().add(avestruces.get(i).getNombre());
			}
		});

		choiceAve.setOnAction(e -> {

			if (!panelPrincipal.getChildren().contains(choiceAve)) {

				panelPrincipal.getChildren().add(choiceAve);
			}
			ArrayList<KoalaDO> koalas = AvestruzDAO.cargarInfoKoala(choiceAve.getValue(), examen2022.con);

			// Bucle para mostrar los datos de cada koala
			for (int i = 0; i < koalas.size(); i++) {
				VBox panelKoala = new VBox();
				panelKoala.getChildren().addAll(new Label(""), new Label("KOALA NUMERO: " + (i + 1)),
						new Label("idKoala: " + koalas.get(i).getIdKoala()),
						new Label("nombre: " + koalas.get(i).getNombre()),
						new Label("nickGuerra: " + koalas.get(i).getNickGuerra()),
						new Label("edad: " + koalas.get(i).getEdad()), new Label("color: " + koalas.get(i).getColor()),
						new Label("fuerza: " + koalas.get(i).getFuerza()),
						new Label("inteligencia: " + koalas.get(i).getInteligencia()),
						new Label("horas de sueño: " + koalas.get(i).getHorasSueno()),
						new Label("tiempoBerserk: " + koalas.get(i).getTiempoBerserk()),
						new Label("Avestruz: " + koalas.get(i).getAvestruz_idAvestruz()),
						new Label("Carrito: " + koalas.get(i).getCarritoGolf_idCarritoGolf()));
				panelPrincipal.getChildren().add(panelKoala);
			}

		});

		iDatos.setOnAction(e -> {
			Paneles panel = new Paneles();
		});

		VBox panelElementos = new VBox();

		listaElementos.setContent(panelElementos);

		// Bucle para mostrar todos los datos del avestruz cuando pulse el boton editar
		for (int i = 0; i < avestruces.size(); i++) {

			Label lblComponente = new Label("Nombre :");
			Label nomComponente = new Label(avestruces.get(i).getNombre());

			Button btnEditar = new Button("Editar");

			panelElementos.getChildren().addAll(lblComponente, nomComponente, btnEditar);

			int num = i;

			// Le pasa a otra pestaña en la que puede editar los campos del avestruz
			// cuando le de al boton editar
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

				Button btnConfirm = new Button("Confirmar");

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
					int id = avestruces.get(num).getIdAvestruz();
					String nombre = txtNombre.getText();
					String nick = txtNickGuerra.getText();
					int edad = 0;
					int altura = 0;
					int malaLeche = 0;
					int huevos = 0;
					try {
						edad = Integer.valueOf(txtEdad.getText());
						altura = Integer.valueOf(txtAltura.getText());
						malaLeche = Integer.valueOf(txtNivelMalaLeche.getText());
						huevos = Integer.valueOf(txtNumHuevos.getText());
					} catch (NumberFormatException nfe) {
						Alert alerta = new Alert(AlertType.ERROR);
						alerta.setTitle("Error!");
						alerta.setHeaderText(null);
						alerta.setContentText("Introduzca un número entero");
						alerta.show();
						return;
					}

					alertaColor(new Label(nombre), new Label(nick), new Label(String.valueOf(edad)),
							new Label(String.valueOf(altura)), new Label(String.valueOf(malaLeche)),
							new Label(String.valueOf(huevos)));

					AvestruzDO temp = new AvestruzDO(id, nombre, nick, edad, altura, malaLeche, huevos);

					if (AvestruzDAO.insertAvestruz(temp, con)) {
						tabPane.getTabs().remove(editar);
						avestruces = AvestruzDAO.cargarAvestruz(con);
					} else
						alertaTabPane();
				});
			});
		}

		Scene scene = new Scene(panelPrincipal, 1000, 800);

		stage.setTitle("Examen JavaFX");
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

	public void alertaColor(Label nombre, Label nickGuerra, Label edad, Label altura, Label nivelMalaLeche,
			Label numHuevos) {
		Stage stageColor = new Stage();

		VBox panelColor = new VBox();

		panelColor.getChildren().addAll(nombre, nickGuerra, edad, altura, nivelMalaLeche, numHuevos);

		nombre.setFont(new Font("Arial", 30));
		nombre.setStyle("-fx-text-fill: #FF3408");

		nickGuerra.setFont(new Font("Arial", 25));
		nickGuerra.setStyle("-fx-text-fill: #80FF08");

		edad.setFont(new Font("Arial", 20));
		edad.setStyle("-fx-text-fill: #08FFBF");

		altura.setFont(new Font("Arial", 35));
		altura.setStyle("-fx-text-fill: #0831FF");

		nivelMalaLeche.setFont(new Font("Arial", 40));
		nivelMalaLeche.setStyle("-fx-text-fill: #A108FF");

		nombre.setFont(new Font("Arial", 15));
		numHuevos.setStyle("-fx-text-fill: #6C6C6C");

		Scene sceneColor = new Scene(panelColor, 300, 300);

		stageColor.setTitle("Nuevos valores");
		stageColor.setScene(sceneColor);
		stageColor.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
