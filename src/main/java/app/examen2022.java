package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class examen2022 extends Application {

	public void start(Stage stage) {
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

		Tab listaElementos = new Tab("Lista Elementos");
		Tab editar = new Tab("Editar");

		listaElementos.setClosable(false);

		tabPane.getTabs().addAll(listaElementos);

		GridPane panelElementos = new GridPane();

		panelElementos.add(barra, 0, 0);

		Label lblComponente = new Label("Componente :");
		Label nomComponente = new Label("Vacio");

		Button btnEditar = new Button("Editar");

		// Lo puedo hacer con un bucle, cambiando el valor del texto de las labels por
		// el siguiente en la lista que me devolveria una funcion de cargar.
		panelElementos.add(lblComponente, 0, 1);
		panelElementos.add(nomComponente, 1, 1);
		panelElementos.add(btnEditar, 2, 1);

		Scene scene = new Scene(tabPane, 800, 600);

		stage.setTitle("Examen 2022");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
