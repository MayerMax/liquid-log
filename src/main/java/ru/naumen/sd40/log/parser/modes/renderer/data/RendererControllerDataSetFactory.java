package ru.naumen.sd40.log.parser.modes.renderer.data;

import org.springframework.stereotype.Component;
import ru.naumen.sd40.log.parser.modes.common.DataSetController;
import ru.naumen.sd40.log.parser.modes.common.DataSetControllerFactory;
import ru.naumen.sd40.log.parser.modes.common.Parameters;
import ru.naumen.sd40.log.parser.modes.renderer.holder.RendererConnector;

@Component
public class RendererControllerDataSetFactory implements DataSetControllerFactory<RendererDataset> {
    @Override
    public DataSetController<RendererDataset> create(Parameters p) {
        return new DataSetController<>(new RendererConnector(p), new RendererDataSetFactory());
    }
}
