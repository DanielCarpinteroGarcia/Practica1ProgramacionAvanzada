package Algoritmos;

import Tables.Table;

import java.util.ArrayList;
import java.util.List;

public class RecSys {

    private Table traindData;
    private Table testData;
    private String nameLikedItem;
    private

    public RecSys(Algorithm algorithm){
        
    }
    public void train(Table trainData){
    }
    public void run(Table testData, List<String> testItemNames){
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < testData.getRows().size(); i++){
            l.add(i, estimate());
        }
    }
    public List<String> recommend(String nameLikedItem, int numRecommendations){
    }

}
