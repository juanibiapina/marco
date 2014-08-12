package marco.lang;

import marco.runtime.Cast;
import marco.runtime.Environment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarcoHashMap extends MarcoRunnable {
    private Map<MarcoSymbol, MarcoObject> values;

    public MarcoHashMap(Map<MarcoSymbol, MarcoObject> values) {
        super(1);
        this.values = values;
    }

    public MarcoHashMap() {
        this(new HashMap<MarcoSymbol, MarcoObject>());
    }

    @Override
    protected MarcoObject performInvoke(Environment environment, List<MarcoObject> arguments) {
        MarcoSymbol key = Cast.toSymbol(arguments.get(0));
        return values.get(key);
    }

    @Override
    public String convertToString() {
        return values.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MarcoHashMap) {
            MarcoHashMap other = (MarcoHashMap) obj;
            return values.equals(other.values);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
