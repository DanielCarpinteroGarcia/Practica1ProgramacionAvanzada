package Mvc.modelo;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface CambioModelo {
    public void loadSongs(String path) throws IOException;

    public void tipoAlgortimo(String algoritmo);

    public void tipoDistancia(String distancia);
}
