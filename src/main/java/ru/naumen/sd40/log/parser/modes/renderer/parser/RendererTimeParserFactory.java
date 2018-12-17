package ru.naumen.sd40.log.parser.modes.renderer.parser;

import org.springframework.stereotype.Component;
import ru.naumen.sd40.log.parser.modes.common.TimeParser;
import ru.naumen.sd40.log.parser.modes.common.TimeParserFactory;

@Component
public class RendererTimeParserFactory implements TimeParserFactory {
    private RendererTimeParser parser = new RendererTimeParser();
    @Override
    public TimeParser create() {
        return parser;
    }
}
