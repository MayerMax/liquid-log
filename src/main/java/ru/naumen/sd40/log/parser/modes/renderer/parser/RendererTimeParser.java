package ru.naumen.sd40.log.parser.modes.renderer.parser;

import ru.naumen.sd40.log.parser.modes.common.TimeParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RendererTimeParser implements TimeParser {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS",
            new Locale("ru", "RU"));

    private static final Pattern TIME_PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{3}");

    public RendererTimeParser()
    {
        DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    @Override
    public void configureTimeZone(String timeZone) {
        DATE_FORMAT.setTimeZone(TimeZone.getTimeZone(timeZone));
    }

    @Override
    public void setFileName(String fileName) { return;}

    @Override
    public long parseLine(String line) throws ParseException {
        Matcher matcher = TIME_PATTERN.matcher(line);
        if (matcher.find())
        {
            String timeString = matcher.group(0);
            Date recDate = DATE_FORMAT.parse(timeString);
            return recDate.getTime();
        }
        return 0;
    }
}
