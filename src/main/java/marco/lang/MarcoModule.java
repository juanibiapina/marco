package marco.lang;

import marco.internal.Environment;

import java.util.ArrayList;
import java.util.List;

public class MarcoModule extends MarcoObject {
    private List<MarcoObject> forms = new ArrayList<>();

    public void add(MarcoObject form) {
        forms.add(form);
    }

    public MarcoObject doEval(Environment closure, Environment environment) {
        MarcoObject result = null;
        for (MarcoObject form : forms) {
            result = form.eval(closure);
        }
        return result;
    }

    @Override
    public String typeName() {
        return "Program";
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MarcoModule) {
            MarcoModule other = (MarcoModule) obj;
            int size = forms.size();

            if (size != other.forms.size()) {
                return false;
            }

            for (int i = 0; i < size; i++) {
                if (!forms.get(i).equals(other.forms.get(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    public String asString() {
        return toString();
    }

    public List<MarcoObject> getForms() {
        return forms;
    }
}
