package Algoritmos;

import Tables.Table;

import java.util.ArrayList;
import java.util.List;

public class RecSys {

    private  Algorithm algorithm;
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
        Integer etiqueta = estimaciones.get(index);
        selectItems(index,etiqueta,numRecommendations);

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
        List<Integer> listaEtiquetas = new ArrayList<>();

        int i = 0;
        while(listaEtiquetas.size() != numRec - 1) {
            if(estimaciones.get(i).equals(labelLikedItem)) {
                listaEtiquetas.add(i);
            }
            i++;
        }

        for (Integer etiqueta : listaEtiquetas) {
            if (!testItemNames.get(etiqueta).equals(testItemNames.get(indexLikedItem))){
                recomendaciones.add(testItemNames.get(etiqueta));
            }

        }
    }
}
