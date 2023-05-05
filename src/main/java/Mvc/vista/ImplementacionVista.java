package Mvc.vista;


import Mvc.controlador.Controlador;
import Mvc.modelo.InterrogaModelo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class ImplementacionVista implements InterrogaVista, InformaVista {

    private final Stage stage;
    private Controlador controlador;
    private InterrogaModelo modelo;

    private ObservableList<String> listaCanciones;


    public ImplementacionVista(final Stage stage) {
        this.stage = stage;
    }

    public void setModelo(final InterrogaModelo modelo) {
        this.modelo = modelo;
    }

    public void setControlador(final Controlador controlador) {
        this.controlador = controlador;
    }

    public void createGUI() throws IOException {
        stage.setTitle("Song Recommender");

        Label labelsubTitle1 = new Label("Recomendation Type");
        RadioButton boton1 = new RadioButton("Recommend based on song features");
        RadioButton boton2 = new RadioButton("Recommend based on guessed genre");

        boton1.setOnAction(e -> controlador.tipoAlgoritmo("knn"));
        boton2.setOnAction(e -> controlador.tipoAlgoritmo("kmeans"));

        ToggleGroup group1 = new ToggleGroup();
        boton1.setToggleGroup(group1);
        boton2.setToggleGroup(group1);

        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(labelsubTitle1,boton1,boton2);

        Label labelsubTitle2 = new Label("Distance Type");
        RadioButton boton3 = new RadioButton("Euclidean");
        RadioButton boton4 = new RadioButton("Manhattan");

        boton1.setOnAction(e -> controlador.tipoDistancia("euclidean"));
        boton2.setOnAction(e -> controlador.tipoDistancia("manhattan"));

        ToggleGroup group2 = new ToggleGroup();
        boton3.setToggleGroup(group2);
        boton4.setToggleGroup(group2);

        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(labelsubTitle2,boton3,boton4);

        Label labelsubTitle3 = new Label("Song Titles");
        controlador.inicializarCanciones();

        ListView<String> listSongs = new ListView<>(listaCanciones);
        Button boton5 = new Button("Recommend");
        boton5.setDisable(true);
        listSongs.setOnMouseClicked(e -> boton5.setDisable(false));
        boton5.setOnAction(e -> controlador.);



        VBox types = new VBox(vBox1,vBox2,labelsubTitle3,listSongs,boton5);

        Scene scene = new Scene(types);
        stage.setScene(scene);

        stage.show();
    }

    public void setListaCanciones(ObservableList<String> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }
}
