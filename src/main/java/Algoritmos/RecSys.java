package Algoritmos;

import Tables.Table;

import java.util.ArrayList;
import java.util.List;

public class RecSys {

    private Table traindData;
    private Table testData;
    private String nameLikedItem;
    private List<String> testItemNames;
    private List<Integer> recomendaciones = new ArrayList<>();

    public RecSys(Algorithm algorithm){
        
    }
    public void train(Table trainData){
    }
    public void run(Table testData, List<String> testItemNames){
        this.testData = testData;
        this.testItemNames = testItemNames;
        estimate(testData);
    }

    private void estimate(Table testData){

    }

    private int findName(String nameItem){

    }

    private void selectItems(int idxLikedItem, int labelLikedItem, int numRec){

    }

    private List<String> getNamesSelectedItems(){

    }

    public List<String> recommend(String nameLikedItem, int numRecommendations){
    }

}
