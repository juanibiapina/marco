package marco.lang;

import marco.internal.Environment;
import marco.runtime.MarcoRuntime;

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
    public String convertToString() {
        return toString();
    }

    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoObject result = null;
        for (MarcoObject form : forms) {
            result = form.eval(closure);
        }
        return result;
    }

    public MarcoModule module(MarcoRuntime runtime) {
        Environment moduleEnvironment = runtime.createModuleEnvironment();
        for (MarcoObject form : forms) {
            form.eval(moduleEnvironment);
        }
        return moduleEnvironment.getModule();
    }
}
