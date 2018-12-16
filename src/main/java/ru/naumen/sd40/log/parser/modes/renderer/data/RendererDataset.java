package ru.naumen.sd40.log.parser.modes.renderer.data;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import ru.naumen.sd40.log.parser.modes.common.DataSet;

import java.util.HashMap;

import static ru.naumen.sd40.log.parser.modes.renderer.data.RendererDataType.RenderTime.*;
import static ru.naumen.sd40.log.parser.utils.NumberUtils.getSafeDouble;
import static ru.naumen.sd40.log.parser.utils.NumberUtils.roundToTwoPlaces;

public class RendererDataset implements DataSet {
    private DescriptiveStatistics ds = new DescriptiveStatistics();

    public void addValue(double value){
        ds.addValue(value);
    }

    public double getMax() { return roundToTwoPlaces(getSafeDouble(ds.getMax())); }

    public double getMean() { return roundToTwoPlaces(getSafeDouble(ds.getMean())); }

    public double getMin()
    {
        return roundToTwoPlaces(getSafeDouble(ds.getMin()));
    }

    public double getPercent50()
    {
        return roundToTwoPlaces(getSafeDouble(ds.getPercentile(50)));
    }

    public double getPercent95() { return roundToTwoPlaces(getSafeDouble(ds.getPercentile(95))); }

    public double getPercent99()
    {
        return roundToTwoPlaces(getSafeDouble(ds.getPercentile(99)));
    }

    public double getPercent999()
    {
        return roundToTwoPlaces(getSafeDouble(ds.getPercentile(99.9)));
    }

    public long getCount()
    {
        return ds.getN();
    }

    public double getStddev()
    {
        return roundToTwoPlaces(getSafeDouble(ds.getStandardDeviation()));
    }

    public boolean isNan() {return getCount() == 0;}

    @Override
    public HashMap<String, Object> getValues() {
        HashMap<String, Object> values = new HashMap<>();
        if (!isNan()) {
            values.put(COUNT, getCount());
            values.put(MIN, getMin());
            values.put(MEAN, getMean());
            values.put(STDDEV, getStddev());
            values.put(PERCENTILE50, getPercent50());
            values.put(PERCENTILE95, getPercent95());
            values.put(PERCENTILE99, getPercent99());
            values.put(PERCENTILE999, getPercent999());
            values.put(MAX, getMax());
        }
        return values;
    }
}
