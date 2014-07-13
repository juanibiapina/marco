package marco.lang;

import marco.internal.Cast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarcoModule extends MarcoValue {
    private Map<String, MarcoObject> values = new HashMap<>();

    public MarcoModule(MarcoData data, List<MarcoObject> values) {
        MarcoList fields = data.getFields();
        for (int i = 0; i < fields.length(); i++) {
            this.values.put(Cast.toSymbol(fields.get(i)).getValue(), values.get(i));
        }
    }

    @Override
    public String typeName() {
        return "Module";
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
