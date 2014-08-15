package marco.lang;

import marco.runtime.Environment;

import java.util.HashMap;
import java.util.Map;

public class MarcoLiteralHashMap extends MarcoObject {
    private Map<MarcoSymbol, MarcoObject> values;

    public MarcoLiteralHashMap(Map<MarcoSymbol, MarcoObject> values) {
        this.values = values;
    }

    @Override
    public MarcoObject __eval(Environment dynamic) {
        Map<MarcoSymbol, MarcoObject> map = new HashMap<>();
        for (Map.Entry<MarcoSymbol, MarcoObject> entry : values.entrySet()) {
            map.put(entry.getKey(), dynamic.getRuntime().eval(entry.getValue(), dynamic));
        }
        return new MarcoHashMap(map);
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public String convertToString() {
        return null;
    }

    @Override
    protected MarcoObject _clone() {
        return new MarcoLiteralHashMap(values);
    }
}
