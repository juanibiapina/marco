package marco.lang;

import java.util.HashMap;
import java.util.Map;

public class MarcoModule extends MarcoValue {
    private Map<String, MarcoObject> exports = new HashMap<>();

    public MarcoModule() {
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

    public void export(MarcoSymbol symbol, MarcoObject value) {
        exports.put(symbol.getValue(), value);
    }

    public MarcoObject getMember(MarcoName name) {
        return exports.get(name.getValue());
    }

    public boolean hasExport(MarcoName name) {
        return exports.containsKey(name.getValue());
    }
}
