package marco.lang;

import marco.lang.MarcoObject;
import marco.runtime.Environment;
import marco.runtime.ListHelper;

import java.util.ArrayList;
import java.util.List;

public class MarcoLiteralList extends MarcoObject {
    private List<MarcoObject> values;

    public MarcoLiteralList(List<MarcoObject> values) {
        this.values = values;
    }

    @Override
    public MarcoObject __eval(Environment dynamic) {
        List<MarcoObject> evaluatedValues = new ArrayList<>();

        for (MarcoObject value : values) {
            evaluatedValues.add(dynamic.getRuntime().eval(value, dynamic));
        }

        return ListHelper.fromJavaList(evaluatedValues);
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public String convertToString() {
        return null;
    }
}
