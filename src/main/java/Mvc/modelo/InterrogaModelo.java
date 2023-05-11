package Mvc.modelo;

import java.io.IOException;
import java.util.List;

public interface InterrogaModelo {
    public void getSongs(String path) throws IOException;

    Object getListaRecomendaciones();
}
