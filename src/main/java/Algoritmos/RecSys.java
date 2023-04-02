package Algoritmos;

import Rows.Row;
import Tables.Table;

import java.util.ArrayList;
import java.util.List;

public class RecSys {

    private Table trainData;
    private Table testData;
    private List<String> testItemNames;
    private List<Integer> recomendaciones = new ArrayList<>();
    private Algorithm algorithm;
    private List<Integer> listaindices;

    public RecSys(Algorithm algorithm){
        this.algorithm = algorithm;
    }

    public void train(Table trainData){
        this.trainData = trainData;
        algorithm.train(trainData);
    }

    public void run(Table testData, List<String> testItemNames){
        this.testData = testData;
        this.testItemNames = testItemNames;
        estimate(testData);
    }

    private void estimate(Table testData){
        for(int i = 0; i < testData.getRows().size(); i++){
            recomendaciones.add(i, (Integer) algorithm.estimate(testData));
        }
    }

    private int findName(String nameItem){
        int i = -1;
        for(i = 0; i < testItemNames.size(); i++){
            if(nameItem.equals(testItemNames.get(i))){
                return i;
            }
        }
        return i;
    }

    private void selectItems(int idxLikedItem, int labelLikedItem, int numRec){
        listaindices  = new ArrayList<>();
        int contador = 0;
        for(int i = 0; i < testData.getRows().size(); i++){
            if(recomendaciones.get(i) == labelLikedItem && i != idxLikedItem && contador <= numRec){
                listaindices.add(i);
                contador++;
            }
        }
    }

    private List<String> getNamesSelectedItems(){
        List<String> listanombres = new ArrayList<>();
        for(int i = 0; i < listaindices.size(); i++){
            listanombres.add(testItemNames.get(i));
        }
        return listanombres;
    }

    public List<String> recommend(String nameLikedItem, int numRecommendations){
        int idx = findName(nameLikedItem);
        Row elemento_idx = testData.getRowAt(idx);
        int lbl = (Integer) algorithm.estimate(elemento_idx.getData());
        selectItems(idx, lbl, numRecommendations);
        return getNamesSelectedItems();
    }

}
