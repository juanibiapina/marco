package marco.lang;

import marco.internal.Cast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarcoDataInstance extends MarcoValue {
    private Map<String, MarcoObject> values = new HashMap<>();

    public MarcoDataInstance(MarcoData data, List<MarcoObject> values) {
        MarcoList fields = data.getFields();
        for (int i = 0; i < fields.length(); i++) {
            this.values.put(Cast.toSymbol(fields.get(i)).getValue(), values.get(i));
        }
    }

    @Override
    public String typeName() {
        return "DataInstance";
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public String asString() {
        return toString();
    }

    public MarcoObject getField(MarcoName field) {
        return values.get(field.getValue());
    }
}
