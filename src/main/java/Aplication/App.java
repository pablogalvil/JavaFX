package Aplication;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	@Override
	public void start(Stage stage) {
		var javaVersion = SystemInfo.javaVersion();
		var javafxVersion = SystemInfo.javafxVersion();

		// Creo un panel vertical, segun se van añadiendo cosas se van mostrando una
		// encima de otra
		VBox panelVertical = new VBox();

		var lblNombre = new Label("Nombre:");
		var lblInfo = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
		TextField txtNombre = new TextField("Pedro");
		txtNombre.setMaxWidth(170);
		CheckBox cbxAcepto = new CheckBox("Acepto los terminos hasta mi muerte");
		ChoiceBox chbCiudad = new ChoiceBox();
		chbCiudad.getItems().addAll("Cadiz", "Jerez", "El Puerto");
		Button btnAceptar = new Button("Aceptar");

		// Les ponemos margen
		panelVertical.setMargin(lblNombre, new Insets(5, 20, 5, 20));
		panelVertical.setMargin(lblInfo, new Insets(5, 20, 5, 20));
		panelVertical.setMargin(txtNombre, new Insets(5, 20, 5, 20));
		panelVertical.setMargin(cbxAcepto, new Insets(5, 20, 5, 20));
		panelVertical.setMargin(chbCiudad, new Insets(5, 20, 5, 20));
		panelVertical.setMargin(btnAceptar, new Insets(5, 20, 5, 20));

		panelVertical.getChildren().addAll(lblInfo, lblNombre, txtNombre, cbxAcepto, chbCiudad, btnAceptar);

		// La scene es el contenido de la ventana, cuando se crea se define su tamaño
		// por defecto
		// Cuando creamos la escena le asignamos el contenido que es compatible con node
		var scene = new Scene(panelVertical, 640, 480);

		// Ventana que emerge
		// El objeto stage es la ventana simplemente, el titulo y los botones de
		// minimizar, maximizar y cerrar
		stage.setTitle("Mi primera aplicacion");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
		try {
			Document document = new Document();

			FileOutputStream pdfFile = new FileOutputStream("fichero.pdf");

			PdfWriter.getInstance(document, pdfFile);

			document.open();

			// Agregar parrafo
			document.add(new Paragraph("¡Hola mundo! Este es mi primer PDF iText."));

			// Creamos el objeto y le añadimos la imagen
			Image image = Image.getInstance("img/beetlejuice0905111-645b4815c5b77.jpg");
			image.scaleToFit(100, 100);// Ajustar tamaño

			document.add(image);

			document.close();

			System.out.println("Archivo PDF creado correctamente");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}