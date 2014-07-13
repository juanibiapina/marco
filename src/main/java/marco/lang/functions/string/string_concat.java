package marco.lang.functions.string;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoList;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.lang.MarcoString;

public class string_concat extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoList values = Cast.toList(closure.lookUp("values"));

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < values.length(); i++) {
            String value = values.get(i).convertToString();
            builder.append(value);
        }

        return new MarcoString(builder.toString());
    }
}
