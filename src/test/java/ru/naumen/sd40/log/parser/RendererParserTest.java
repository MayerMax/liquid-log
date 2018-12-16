package ru.naumen.sd40.log.parser;

import org.junit.Assert;
import org.junit.Test;
import ru.naumen.sd40.log.parser.modes.renderer.data.RendererDataset;
import ru.naumen.sd40.log.parser.modes.renderer.parser.RendererDataParser;

import java.text.ParseException;

public class RendererParserTest {
    @Test
    public void parseCorrectRenderTime() throws ParseException {
        String data = "102725313 2017-12-13 03:48:56,048 [http-nio-8443-exec-83 operator1 fs000080000m0jaoh10o2ito00] DEBUG AdvFormEngine - session: fs000080000m0jaoh10o2ito00 render time: 18 ";
        RendererDataParser parser = new RendererDataParser();
        RendererDataset dataset = new RendererDataset();

        parser.parseLine(data, dataset);
        Assert.assertEquals(1, dataset.getCount());
        Assert.assertEquals(18, dataset.getMin(), 0.01);
    }
}
