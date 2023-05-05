package Mvc.controlador;

import java.io.IOException;

public interface Controlador {
    public void inicializarCanciones() throws IOException;
    public void tipoAlgoritmo(String algortimo);

    public void tipoDistancia(String s);
}
