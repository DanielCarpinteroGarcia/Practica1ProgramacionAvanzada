package LecturaCSV;

public class CSVLabeledFileReader extends CSVUnlabeledFileReader{
    public CSVLabeledFileReader(String f) {
        super(f);
    }

    @Override
    public void openSource(String source) {

    }

    @Override
    public void processHeaders(String headers) {

    }

    @Override
    public void processData(String data) {

    }

    @Override
    public void closeSource() {

    }

    @Override
    public boolean hasMoreData() {
        return false;
    }

    @Override
    public String getNextData() {
        return null;
    }

}
