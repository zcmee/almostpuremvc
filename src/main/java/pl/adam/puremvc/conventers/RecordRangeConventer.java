package pl.adam.puremvc.conventers;

import org.springframework.core.convert.converter.Converter;
import pl.adam.puremvc.dto.RecordRange;

/**
 * Created by SkyNET on 2017-11-13.
 */

public class RecordRangeConventer implements Converter<String, RecordRange> {
    @Override
    public RecordRange convert(String source) {
        String[] values = source.split("-");
        return new RecordRange(values[0], values[1]);
    }
}
