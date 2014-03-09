package marco.lang;

import marco.internal.Environment;

import java.util.ArrayList;
import java.util.List;

public class MarcoProgram extends MarcoObject {
    private List<MarcoObject> forms = new ArrayList<>();

    public void add(MarcoObject form) {
        forms.add(form);
    }

    public MarcoObject doEval(Environment environment) {
        MarcoObject result = null;
        for (MarcoObject form : forms) {
            result = form.eval(environment);
        }
        return result;
    }

    @Override
    public String typeName() {
        return "Program";
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
    public boolean equals(Object obj) {
        if (obj instanceof MarcoProgram) {
            MarcoProgram other = (MarcoProgram) obj;
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
    public boolean isContinuation() {
        return false;
    }
}
