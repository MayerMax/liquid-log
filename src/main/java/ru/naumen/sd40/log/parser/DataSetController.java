package ru.naumen.sd40.log.parser;

import java.security.InvalidParameterException;

public class DataSetController implements AutoCloseable {

    private Holder connector;
    private long currentKey = -1;
    private DataSet currentDataSet;

    public DataSetController(Holder connector) {

        this.connector = connector;
    }

    public DataSet get(long key) throws InvalidParameterException {
        if (key == currentKey) {
            return currentDataSet;
        }

        if (key > currentKey) {
            if (currentKey != -1) {
                connector.store(currentKey, currentDataSet);
            }
            currentKey = key;
            currentDataSet = new DataSet();
            return currentDataSet;
        }
        throw new InvalidParameterException(String.format("Given key: %d is already stored", key));
    }

    public void close() throws DBCloseException {
        connector.store(currentKey, currentDataSet);
        connector.close();
    }
}