package app;

import java.util.ArrayList;

import app.model.AvestruzDAO;
import app.model.AvestruzDO;
import app.model.KoalaDO;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Paneles {

	public Paneles() {
		Stage stage = new Stage();

		VBox panelVertical = new VBox();

		ScrollPane scroll = new ScrollPane();
		scroll.setContent(panelVertical);

		ChoiceBox<String> choice = new ChoiceBox<>();

		ArrayList<AvestruzDO> avestruces = AvestruzDAO.cargarAvestruz(examen2022.con);

		for (int i = 0; i < avestruces.size(); i++) {
			choice.getItems().add(avestruces.get(i).getNombre());
		}

		panelVertical.getChildren().add(choice);

		choice.setOnAction(e -> {

			panelVertical.getChildren().clear();
			panelVertical.getChildren().add(choice);
			ArrayList<KoalaDO> koalas = AvestruzDAO.cargarInfoKoala(choice.getValue(), examen2022.con);

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
				panelVertical.getChildren().add(panelKoala);
			}
		});

		Scene scene = new Scene(scroll, 500, 400);
		stage.setScene(scene);
		stage.show();
	}

}
