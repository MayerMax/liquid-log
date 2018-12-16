package ru.naumen.sd40.log.parser.modes.renderer.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.naumen.sd40.log.parser.modes.common.*;
import ru.naumen.sd40.log.parser.modes.renderer.data.RendererDataType;
import ru.naumen.sd40.log.parser.modes.renderer.data.RendererDataset;

@Component("renderer")
public class RendererBuilder implements ParseBuilder {

    private RendererDataParser parser;
    private DataSetControllerFactory dataSetControllerFactory;
    private RendererTimeParserFactory timeParserFactory;

    @Autowired
    public RendererBuilder(RendererDataParser parser, DataSetControllerFactory<RendererDataset> datasetDataSetControllerFactory,
                           RendererTimeParserFactory timeParserFactory) {
        this.parser = parser;
        this.dataSetControllerFactory = datasetDataSetControllerFactory;
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

    @Override
    public DataType[] getDataTypes() {
        return RendererDataType.values();
    }
}
