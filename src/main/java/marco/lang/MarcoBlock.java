package marco.lang;

import marco.internal.Environment;

import java.util.ArrayList;
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
    public List<String> freeVariables() {
        List<String> result = new ArrayList<>();
        for (MarcoObject form : forms) {
            result.addAll(form.freeVariables());
        }
        return result;
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public boolean isContinuation() {
        return false;
    }

    public MarcoObject invoke(Environment closure, Environment environment) {
        MarcoObject result = null;
        for (MarcoObject form : forms) {
            result = form.doEval(closure, environment);
        }
        return result;
    }
}
