package ru.naumen.sd40.log.parser.holders;

import ru.naumen.sd40.log.parser.Parameters;
import ru.naumen.sd40.log.parser.datasetfactory.GCDataSet;

public class GCInfluxConnector extends Holder<GCDataSet> {

    public GCInfluxConnector(Parameters p ) {
        super(p);
    }

    @Override
    public void store(long key, GCDataSet ds) {
        if (!ds.isNan())
        {
            influxWrapper.storeGc(points, dbName, key, ds);
        }
    }
}