package app;

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
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class EjemploGridPane extends Application {

	@Override
	public void start(Stage stage) {
		// Creo un panel vertical, segun se van añadiendo cosas se van mostrando una
		// encima de otra
		GridPane panelGrid = new GridPane();

		Label lblNombre = new Label("Nombre:");
		Label lblCiudad = new Label("Ciudad:");
		Label lblSexo = new Label("Sexo:");
		Label lblObs = new Label("Observaciones:");
		// Para poner la alineacion vertical en un gridpane
		GridPane.setValignment(lblObs, javafx.geometry.VPos.TOP);

		TextField txtNombre = new TextField("Pedro");
		txtNombre.setMaxWidth(170);

		CheckBox cbxAcepto = new CheckBox("Acepto los terminos hasta mi muerte");

		ChoiceBox chbCiudad = new ChoiceBox();

		TextArea txtObserv = new TextArea();

		DatePicker dtNacimiento = new DatePicker();
		ColorPicker cpBackground = new ColorPicker();

		RadioButton radHombre = new RadioButton("Hombre");
		RadioButton radMujer = new RadioButton("Mujer");
		ToggleGroup tglSexo = new ToggleGroup();
		// Para que los radios sean una única selección, los tenemos que asociar a un
		// mismo toggleGroup
		radHombre.setToggleGroup(tglSexo);
		radMujer.setToggleGroup(tglSexo);

		radHombre.setSelected(true);

		Button btnAceptar = new Button("Aceptar");

		chbCiudad.getItems().addAll("Cadiz", "Jerez", "El Puerto");
		// Utilizamos el selectionModel para marcar por defecto Jerez como opcion
		// seleccionada
		chbCiudad.getSelectionModel().select(1);

		// Les ponemos margen
		panelGrid.setMargin(lblNombre, new Insets(5, 20, 5, 20));
		panelGrid.setMargin(lblCiudad, new Insets(5, 20, 5, 20));
		panelGrid.setMargin(lblSexo, new Insets(5, 20, 5, 20));
		panelGrid.setMargin(lblObs, new Insets(5, 20, 5, 20));

		panelGrid.setMargin(txtNombre, new Insets(5, 20, 5, 20));
		panelGrid.setMargin(txtObserv, new Insets(5, 20, 5, 20));

		panelGrid.setMargin(dtNacimiento, new Insets(5, 20, 5, 20));
		panelGrid.setMargin(cpBackground, new Insets(5, 20, 5, 20));

		panelGrid.setMargin(cbxAcepto, new Insets(5, 20, 5, 20));

		panelGrid.setMargin(chbCiudad, new Insets(5, 20, 5, 20));

		panelGrid.setMargin(radHombre, new Insets(5, 0, 5, 60));
		panelGrid.setMargin(radMujer, new Insets(5, 0, 5, 0));

		panelGrid.setMargin(btnAceptar, new Insets(5, 20, 5, 20));

		panelGrid.add(lblNombre, 0, 0);
		panelGrid.add(txtNombre, 1, 0);
		panelGrid.add(lblCiudad, 0, 1);
		panelGrid.add(chbCiudad, 1, 1);
		// Las dos ultimas son para colspan y rowspan
		panelGrid.add(cbxAcepto, 0, 2, 2, 1);
		panelGrid.add(lblSexo, 0, 3);
		panelGrid.add(radHombre, 1, 3);
		panelGrid.add(radMujer, 1, 3);
		panelGrid.add(lblObs, 0, 4, 1, 3);
		panelGrid.add(txtObserv, 1, 4, 2, 3);
		panelGrid.add(dtNacimiento, 0, 7);
		panelGrid.add(cpBackground, 1, 7);

		// La scene es el contenido de la ventana, cuando se crea se define su tamaño
		// por defecto
		// Cuando creamos la escena le asignamos el contenido que es compatible con node
		var scene = new Scene(panelGrid, 640, 480);

		// Ventana que emerge
		// El objeto stage es la ventana simplemente, el titulo y los botones de
		// minimizar, maximizar y cerrar
		stage.setTitle("Mi primer panel tipo Grid");
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