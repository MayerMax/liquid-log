package ru.naumen.sd40.log.parser.modes.renderer.data;

import com.google.common.collect.Lists;
import ru.naumen.sd40.log.parser.modes.common.DataType;
import ru.naumen.sd40.log.parser.utils.GlobalConstants;

import java.util.List;

public enum  RendererDataType implements DataType {
    RENDER_TIME(RenderTime.getProps());

    private List<String> props;

    RendererDataType(List<String> props) {
        this.props = props;
    }

    @Override
    public List<String> getProps() {
        return props;
    }

    public static class RenderTime {
        private RenderTime() {}
        public static final String PERCENTILE50 = "r_percent50";
        public static final String PERCENTILE95 = "r_percent95";
        public static final String PERCENTILE99 = "r_percent99";
        public static final String PERCENTILE999 = "r_percent999";
        public static final String MAX = "r_max";
        public static final String MIN = "r_min";
        public static final String COUNT = "r_count";
        public static final String MEAN = "r_mean";
        public static final String STDDEV = "r_stddev";

        static List<String> getProps()
        {
            return Lists.newArrayList(GlobalConstants.TIME, COUNT, MEAN, STDDEV, PERCENTILE50, PERCENTILE95, PERCENTILE99,
                    PERCENTILE999, MAX, MIN);
        }
    }
}
