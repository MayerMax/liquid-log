package ru.naumen.sd40.log.parser.modes.top.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.naumen.sd40.log.parser.modes.common.DataParser;
import ru.naumen.sd40.log.parser.modes.common.DataSetController;
import ru.naumen.sd40.log.parser.modes.common.Parameters;
import ru.naumen.sd40.log.parser.modes.common.DataSetControllerFactory;
import ru.naumen.sd40.log.parser.modes.top.data.TopDataSet;
import ru.naumen.sd40.log.parser.modes.common.ParseBuilder;
import ru.naumen.sd40.log.parser.modes.common.TimeParser;

@Component("top")
public class TopBuilder implements ParseBuilder {
    private TopDataParser parser;
    private DataSetControllerFactory<TopDataSet> dataSetControllerFactory;
    private TopTimeParserFactory timeParserFactory;

    @Autowired
    public TopBuilder(TopDataParser parser, DataSetControllerFactory<TopDataSet> dataSetControllerFactory,
                       TopTimeParserFactory timeParserFactory) {
        this.parser = parser;
        this.dataSetControllerFactory = dataSetControllerFactory;
        this.timeParserFactory = timeParserFactory;
    }

    @Override
    public DataParser getParser() {
        return parser;
    }

    @Override
    public DataSetController getDataSetController(Parameters p) {
        return dataSetControllerFactory.create(p);
    }

    @Override
    public TimeParser getTimeParser() {
        return timeParserFactory.create();
    }
}
