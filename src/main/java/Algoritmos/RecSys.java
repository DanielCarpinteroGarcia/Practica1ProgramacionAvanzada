package Algoritmos;

import Algoritmos.Algorithm;
import Algoritmos.KMeansException;
import Rows.Row;
import Tables.Table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecSys {

    private Algorithm algorithm;
    private List<Integer> estimaciones = new ArrayList<>();
    private List<String> testItemNames;
    private Table testData;
    private List<String> recomendaciones = new ArrayList<>();

    public RecSys(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void train(Table trainData) throws KMeansException {
       algorithm.train(trainData);

    }

    public void run(Table testData, List<String> testItemNames) {
        this.testData = testData;
        this.testItemNames = testItemNames;
        estimate(testData);
    }

    private void estimate(Table testData) {
        for(int i = 0; i<testData.size(); i++) {
            estimaciones.add((Integer) algorithm.estimate(testData.getData(i)));
        }
    }

    public List<String> recommend(String nameLikedItem, int numRecommendations) {
        int index = findName(nameLikedItem);
        List<Double> data = testData.getData(index);
        Integer label = (Integer) algorithm.estimate(data);
        selectItems(index,label,numRecommendations);

        return recomendaciones;
    }

    private int findName(String nameItem) {
        for(int i = 0; i< testItemNames.size(); i++) {
            if(nameItem.equals(testItemNames.get(i)))
                return i;
        }

        return -1;
    }

    private void selectItems(int indexLikedItem, int labelLikedItem, int numRec) {
        List<Integer> matchingLabel = new ArrayList<>();

        for(int i = 0; i<testData.size(); i++ ) {
            if (estimaciones.get(i) == labelLikedItem && i != indexLikedItem ) {
                matchingLabel.add(i);
            }
        }

        List<Integer> selectedIndex = new ArrayList<>();
        int i = 0;
        for(Integer index : matchingLabel) {
            if( i >= numRec) {
                break;
            }
            selectedIndex.add(index);
            i++;
        }

        Set<String> uniqueRecommendations = new HashSet<>();
        for (Integer index : selectedIndex ) {
            uniqueRecommendations.add(testItemNames.get(index));
        }

        recomendaciones.addAll(uniqueRecommendations);
    }
}
