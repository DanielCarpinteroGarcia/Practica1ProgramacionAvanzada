package LecturaCSV;

import Tables.Table;

public abstract class ReaderTemplate {

    private String fichero;

    public ReaderTemplate(String f){
        this.fichero = f;
    }
    abstract void openSource(String source);
    abstract void processHeaders(String headers);
    abstract void processData(String data);
    abstract void closeSource();
    abstract boolean hasMoreData();
    abstract String getNextData();

    public final Table readTableFromSource(){
        // 1º Abrir la fuente de datos
        openSource(fichero);
        // 2º Leer la cabecera
        processHeaders(String cabecera);
        // 3º Leer todos los puntos de datos (hasta que no haya más datos)
        processData(String datos);
        // 4º Cerrar la fuente de datos
        closeSource();
    }
}





