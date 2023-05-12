package Mvc.vista;


import Algoritmos.KMeansException;
import Mvc.controlador.Controlador;
import Mvc.modelo.InterrogaModelo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class ImplementacionVista implements InterrogaVista, InformaVista {

    private final Stage stage;
    private Controlador controlador;
    private InterrogaModelo modelo;


    ListView<String> listRecommendations;

    ListView<String> listSongs;

    String songSelected;


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

        boton3.setOnAction(e -> controlador.tipoDistancia("euclidean"));
        boton4.setOnAction(e -> controlador.tipoDistancia("manhattan"));


        ToggleGroup group2 = new ToggleGroup();
        boton3.setToggleGroup(group2);
        boton4.setToggleGroup(group2);

        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(labelsubTitle2,boton3,boton4);

        Label labelsubTitle3 = new Label("Song Titles");

        listSongs = new ListView<>(getListSongs());

        Button boton5 = new Button("Recommend");
        boton5.setDisable(true);
        listSongs.setOnMouseClicked(e -> boton5.setDisable(false));
        songSelected = listSongs.getSelectionModel().getSelectedItem();
        boton5.setOnAction(e -> nuevaVentana());



        VBox types = new VBox(vBox1,vBox2,labelsubTitle3,listSongs,boton5);

        Scene scene = new Scene(types);
        stage.setScene(scene);


        stage.show();
    }


    public ObservableList<String> getListSongs() throws IOException {
        return modelo.getSongs("src/ficheros/songs_files/songs_test_names.csv");
    }
    public String getCancion() {
        return listSongs.getSelectionModel().getSelectedItem();
    }

    public ObservableList<Integer> getNSongs() {
        return modelo.getNSongs();
    }

    public void nuevaVentana() {
        Stage subStage = new Stage();
        subStage.setTitle("Recommended Titles");


        Label nRecomendations = new Label("Number of recommendations:");
        Spinner<Integer> spinnerNSongs = new Spinner<>(getNSongs());

        HBox hBox = new HBox(nRecomendations,spinnerNSongs);
        Label likedTitle = new Label("If you liked " + getCancion() + " you might like");
        listRecommendations = new ListView<>(getListRecommendations());
        VBox vBox = new VBox(hBox,likedTitle,listRecommendations);
        Scene scene = new Scene(vBox);
        subStage.setScene(scene);
        subStage.show();
    }

    public ObservableList<String> getListRecommendations() {
        return modelo.recommend();
    }

    public String getSongSelected() {
        return songSelected;
    }

}
