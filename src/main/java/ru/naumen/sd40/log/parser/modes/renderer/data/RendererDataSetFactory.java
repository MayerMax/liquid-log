package ru.naumen.sd40.log.parser.modes.renderer.data;

import org.springframework.stereotype.Component;
import ru.naumen.sd40.log.parser.modes.common.DataSetFactory;

@Component
public class RendererDataSetFactory implements DataSetFactory<RendererDataset> {
    @Override
    public RendererDataset create() {
        return new RendererDataset();
    }
}
