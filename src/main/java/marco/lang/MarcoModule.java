package marco.lang;

import marco.runtime.Environment;

import java.util.HashMap;
import java.util.Map;

public class MarcoModule extends MarcoValue {
    private Map<String, MarcoObject> exports;

    public MarcoModule(Map<String, MarcoObject> exports) {
        this.exports = exports;
    }

    public MarcoModule() {
        this.exports = new HashMap<>();
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public String convertToString() {
        return "Module";
    }

    @Override
    protected MarcoObject _clone() {
        return new MarcoModule(exports);
    }

    public void export(String name, MarcoObject value) {
        exports.put(name, value);
    }

    public MarcoObject getMember(MarcoName name) {
        return exports.get(name.getValue());
    }

    public boolean hasExport(MarcoName name) {
        return exports.containsKey(name.getValue());
    }

    public void include(Environment environment) {
        for (String name : exports.keySet()) {
            environment.def(name, exports.get(name));
        }
    }
}
