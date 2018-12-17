package ru.naumen.sd40.log.parser.modes.renderer.parser;

import org.springframework.stereotype.Component;
import ru.naumen.sd40.log.parser.modes.common.DataParser;
import ru.naumen.sd40.log.parser.modes.renderer.data.RendererDataset;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RendererDataParser implements DataParser<RendererDataset> {
    private static final Pattern RENDER_TIME_REG_EX = Pattern.compile("render time: (\\d+)");

    @Override
    public void parseLine(String line, RendererDataset ds) throws ParseException {
        Matcher matcher = RENDER_TIME_REG_EX.matcher(line);
        if (matcher.find()) {
            double val = Double.parseDouble(matcher.group(1));
            ds.addValue(val);
        }
    }
}
