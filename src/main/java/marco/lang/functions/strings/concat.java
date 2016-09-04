package marco.lang.functions.strings;

import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.lang.MarcoString;
import marco.runtime.Environment;
import marco.runtime.ListHelper;

import java.util.List;

public class concat extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        List<MarcoObject> values = ListHelper.toJavaList(closure.lookUp("values"));

        StringBuilder builder = new StringBuilder();
        for (MarcoObject value : values) {
            builder.append(value.convertToString());
        }

        return new MarcoString(builder.toString());
    }
}
