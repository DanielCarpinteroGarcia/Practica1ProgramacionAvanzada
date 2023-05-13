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

    ObservableList<String> listRecommendations;

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

        Label labelAlgorithm = new Label("Recomendation Type");
        RadioButton buttonKNN = new RadioButton("Recommend based on song features");
        RadioButton buttonKMeans = new RadioButton("Recommend based on guessed genre");

        buttonKNN.setOnAction(e -> controlador.tipoAlgoritmo("knn"));
        buttonKMeans.setOnAction(e -> controlador.tipoAlgoritmo("kmeans"));

        ToggleGroup groupAlgorithm = new ToggleGroup();
        buttonKNN.setToggleGroup(groupAlgorithm);
        buttonKMeans.setToggleGroup(groupAlgorithm);

        VBox vBoxAlgorithm = new VBox(labelAlgorithm,buttonKNN,buttonKMeans);


        Label labelDistance = new Label("Distance Type");
        RadioButton buttonEuclidean = new RadioButton("Euclidean");
        RadioButton buttonManhattan = new RadioButton("Manhattan");

        buttonEuclidean.setOnAction(e -> controlador.tipoDistancia("euclidean"));
        buttonManhattan.setOnAction(e -> controlador.tipoDistancia("manhattan"));

        ToggleGroup groupDistance = new ToggleGroup();
        buttonEuclidean.setToggleGroup(groupDistance);
        buttonManhattan.setToggleGroup(groupDistance);

        VBox vBoxDistance = new VBox(labelDistance, buttonEuclidean,buttonManhattan);


        Label labelSongs = new Label("Song Titles");
        listSongs = new ListView<>(getListSongs());
        Button buttonRecommend = new Button("Recommend");
        buttonRecommend.setDisable(true);
        listSongs.setOnMouseClicked(e -> buttonRecommend.setDisable(false));
        buttonRecommend.setOnAction(e -> nuevaVentana());


        VBox vBoxSongs = new VBox(labelSongs,listSongs,buttonRecommend);


        VBox types = new VBox(vBoxAlgorithm,vBoxDistance,vBoxSongs);

        Scene scene = new Scene(types);
        stage.setScene(scene);
        stage.show();
    }

    public void nuevaVentana() {
        controlador.recommend();
        Stage subStage = new Stage();
        subStage.setTitle("Recommended Titles");


        Label nRecomendations = new Label("Number of recommendations:");
        Spinner<Integer> spinnerNSongs = new Spinner<>(1,getNSongs(),5);

        HBox hBoxRecommends = new HBox(nRecomendations,spinnerNSongs);

        Label likedTitle = new Label("If you liked " + getSongSelected() + " you might like");
        ListView<String> listRecommendations = new ListView<>(this.listRecommendations);

        Button buttonClose = new Button("Close");
        buttonClose.setOnAction(e -> subStage.close());

        VBox vBox = new VBox(hBoxRecommends,likedTitle,listRecommendations, buttonClose);
        Scene scene = new Scene(vBox);
        subStage.setScene(scene);
        subStage.show();
    }

    public ObservableList<String> getListSongs() throws IOException {
        return modelo.getSongs("src/ficheros/songs_files/songs_test_names.csv");
    }

    public Integer getNSongs() {
        return modelo.getNSongs();
    }

    public ObservableList<String> listRecommendChange() {
        listRecommendations = FXCollections.observableList(modelo.getListaRecomendaciones());
        return listRecommendations;
    }

    public String getSongSelected() {
        return listSongs.getSelectionModel().getSelectedItem();
    }

}
