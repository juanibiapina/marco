package marco.lang;

import marco.internal.Environment;

import java.util.List;

public class MarcoBlock extends MarcoValue {
    private List<MarcoObject> forms;

    public MarcoBlock(List<MarcoObject> forms) {
        this.forms = forms;
    }

    @Override
    public String typeName() {
        return "Block";
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public String asString() {
        return toString();
    }

    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoObject result = null;
        for (MarcoObject form : forms) {
            result = form.eval(closure);
        }
        return result;
    }
}
