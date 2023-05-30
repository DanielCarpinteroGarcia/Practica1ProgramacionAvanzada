package Mvc.vista;


import Mvc.controlador.Controlador;
import Mvc.modelo.InterrogaModelo;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
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

    private boolean ventanaAbierta = false;

    ListView<String> listSongs;
    ListView<String> listaRecomendaciones;
    Spinner<Integer> spinnerNSongs;

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

        VBox vBoxAlgorithm = new VBox(5,labelAlgorithm,buttonKNN,buttonKMeans);


        Label labelDistance = new Label("Distance Type");
        RadioButton buttonEuclidean = new RadioButton("Euclidean");
        RadioButton buttonManhattan = new RadioButton("Manhattan");

        buttonEuclidean.setOnAction(e -> controlador.tipoDistancia("euclidean"));
        buttonManhattan.setOnAction(e -> controlador.tipoDistancia("manhattan"));

        ToggleGroup groupDistance = new ToggleGroup();
        buttonEuclidean.setToggleGroup(groupDistance);
        buttonManhattan.setToggleGroup(groupDistance);

        VBox vBoxDistance = new VBox(5,labelDistance, buttonEuclidean,buttonManhattan);


        Label labelSongs = new Label("Song Titles");
        listSongs = new ListView<>(getListSongs());
        Button buttonRecommend = new Button("Recommend");
        buttonRecommend.setDisable(true);
        listSongs.setOnMouseClicked(e -> {
            if(getSongSelected() != null) {
                buttonRecommend.setDisable(false);
                buttonRecommend.setText("Recommend on " + getSongSelected() + "...");
            }
            if(e.getClickCount() == 2 && !ventanaAbierta) {
                ventanaAbierta = true;
                nuevaVentana();
            }
        });
        buttonRecommend.setOnAction(e -> {
                    if (!ventanaAbierta) {
                        ventanaAbierta = true;
                        nuevaVentana();
                    }
        });


        VBox vBoxSongs = new VBox(5,labelSongs,listSongs,buttonRecommend);


        VBox types = new VBox(5,vBoxAlgorithm,vBoxDistance,vBoxSongs);
        types.setPadding(new Insets(10));

        Scene scene = new Scene(types);
        stage.setScene(scene);
        stage.show();
    }

    public void nuevaVentana() {
        controlador.recommend();
        Stage subStage = new Stage();
        subStage.setTitle("Recommended Titles");


        Label nRecomendations = new Label("Number of recommendations:");
        spinnerNSongs = new Spinner<>(1,getNSongs(),getNumRecommendationsInicial());
        spinnerNSongs.setOnMouseClicked(e -> controlador.recommendDinamico());
        HBox hBoxRecommends = new HBox(nRecomendations,spinnerNSongs);

        Label likedTitle = new Label("If you liked " + "\"" + getSongSelected() + "\"" + " you might like");
        listaRecomendaciones = new ListView<>(getListRecommendations());

        Button buttonClose = new Button("Close");
        buttonClose.setOnAction(e -> {subStage.close();
                                      ventanaAbierta = false;});

        VBox vBox = new VBox(5,hBoxRecommends,likedTitle,listaRecomendaciones, buttonClose);
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

    public Integer getNumRecommendationsInicial() {
        return modelo.getNumRecommendationsInicial();
    }

    public Integer getNumRecommendations() {
        return spinnerNSongs.getValue();
    }

    public String getSongSelected() {
        return listSongs.getSelectionModel().getSelectedItem();
    }

    public ObservableList<String> getListRecommendations() {
        return modelo.getListaRecomendaciones();
    }

    public void listRecommendationsChanged() {
        listaRecomendaciones.setItems(modelo.getListaRecomendaciones());
    }



}
