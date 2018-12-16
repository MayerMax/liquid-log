package ru.naumen.sd40.log.parser.modes.renderer.holder;

import ru.naumen.sd40.log.parser.modes.common.Holder;
import ru.naumen.sd40.log.parser.modes.common.Parameters;
import ru.naumen.sd40.log.parser.modes.renderer.data.RendererDataset;



public class RendererConnector extends Holder<RendererDataset> {
    public RendererConnector(Parameters p) {
        super(p);
    }
    @Override
    public void store(long key, RendererDataset ds) {
        if (needLogging)
        {
            System.out.print(String.format("%d;%d;%f;%f;%f;%f;%f;%f;%f;%f;\n", key, ds.getCount(),
                    ds.getMin(), ds.getMean(), ds.getStddev(), ds.getPercent50(), ds.getPercent95(),
                    ds.getPercent99(), ds.getPercent999(), ds.getMax()));
        }
        if (!ds.isNan())
        {
            influxWrapper.storeData(points, dbName, key, ds);
        }
    }
}
