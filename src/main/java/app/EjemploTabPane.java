package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class EjemploTabPane extends Application {

	@Override
	public void start(Stage stage) {

		TabPane panelPestanas = new TabPane();

		// Creamos tres pestañas
		Tab tab1 = new Tab("Formulario");
		Tab tab2 = new Tab("Image");
		Tab tab3 = new Tab("Music");
		Tab tab4 = new Tab("Paint");

		// Añadimos las tres pestañas al panel
		panelPestanas.getTabs().addAll(tab1, tab2, tab3, tab4);

		// Creamos etiquetas y contenido
		Label lblForm = new Label("Aqui va el formulario");
		Label lblImagen = new Label("Imagen");
		Label lblMusica = new Label("Musica");
		Label lblPaint = new Label("Paint");

		// Añadimos contenido a las pestañas
		tab1.setContent(lblForm);
		tab2.setContent(lblImagen);
		tab3.setContent(lblMusica);
		tab4.setContent(lblPaint);

		tab1.setClosable(false);
		tab2.setClosable(false);
		tab3.setClosable(false);
		tab4.setClosable(false);

		// Creamos una imagen para añadirla a la segunda pestaña
		try {
			Image imagen = new Image(new FileInputStream("./img/beetlejuice.jpg"));

			ImageView imgBeetle = new ImageView(imagen);

			// Podemos cambiar el tamaño de la imagen
			imgBeetle.setPreserveRatio(true);
			imgBeetle.setFitWidth(250);

			tab2.setContent(imgBeetle);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Reproductor de video en la pestaña 3
		Media cancion = new Media(new File("./sounds/sonido.mp3").toURI().toString());
		MediaPlayer reproductor = new MediaPlayer(cancion);
		MediaView repMedios = new MediaView(reproductor);

		// Creamos un boton que al pulsarlo ejecuta el reproductor de musica
		Button btnMusica = new Button("Play Music");

		tab3.setContent(btnMusica);

		// Para que cuando se pulse se ejecute la musica, le ponemos un capturador de
		// eventos
		btnMusica.setOnAction(e -> reproductor.play());

		Scene scene = new Scene(panelPestanas, 800, 600);

		stage.setScene(scene);

		stage.setTitle("Ejemplo Pestañas Multimedia");

		stage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
