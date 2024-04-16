package app;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EjemploMenusBorderPane extends Application {

	@Override
	public void start(Stage stage) {
		BorderPane pnlDistribucion = new BorderPane();

		// ZONA SUPERIOR MENU
		Label lblMenu = new Label("Menu");

		// Barra de menus principal
		MenuBar barraMenu = new MenuBar();

		// Menus que van en la barra de menus
		Menu mArchivo = new Menu("Archivo");
		// Opciones de menu que aparecen cuando seleccionamos el menu que las contiene
		MenuItem ICargar = new MenuItem("Cargar");
		MenuItem IGuardar = new MenuItem("Guardar");
		MenuItem ISalir = new MenuItem("Salir");
		// Asignamos los items a los menus
		mArchivo.getItems().addAll(ICargar, IGuardar, ISalir);

		Menu mOpciones = new Menu("Opciones");
		MenuItem IPreferencias = new MenuItem("Preferencias");
		// mHerr va dentro de mOpciones
		Menu mHerr = new Menu("Herramientas");
		MenuItem ICopiar = new MenuItem("Copiar");
		MenuItem IPegar = new MenuItem("Pegar");
		// Asignamos los items a los menus
		mHerr.getItems().addAll(ICopiar, IPegar);

		// Asignamos los items a los menus
		mOpciones.getItems().addAll(IPreferencias, mHerr);

		Menu mAyuda = new Menu("Ayuda");
		MenuItem IManual = new MenuItem("Manual Referencia");
		MenuItem IAcerca = new MenuItem("Acerca de");
		// Asignamos los items a los menus
		mAyuda.getItems().addAll(IManual, IAcerca);

		// Añadimos los menus a la barra
		barraMenu.getMenus().addAll(mArchivo, mOpciones, mAyuda);

		// Asignamos el menu a la parte superior
		pnlDistribucion.setTop(barraMenu);
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

		TextField txtValorNota = new TextField("5");

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

		slider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				txtValorNota.setText(String.format("%.2f", new_val));
			}
		});

		// Cuando modificamos el valor cambiamos la posicion del slider
		txtValorNota.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// Le asignamos al valor del slider el numero contenido en el txtValorNota
				slider.setValue(Double.parseDouble(txtValorNota.getText()));
			}
		});

		TextArea textoFich = new TextArea();

		// Añadimos el slider y el textarea al VBox
		panelCentral.getChildren().addAll(txtValorNota, slider, textoFich);
		panelCentral.setMargin(txtValorNota, new Insets(5, 7, 5, 7));
		panelCentral.setMargin(slider, new Insets(5, 7, 5, 7));
		panelCentral.setMargin(textoFich, new Insets(5, 7, 5, 7));

		// Añadimos el VBox al centro del borderpane principal
		pnlDistribucion.setCenter(panelCentral);

		// Cuando pulsamos en la opcion de menu salir, cerramos la app
		ISalir.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// Cerramos la ventana principal
				stage.close();
			}
		});

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
