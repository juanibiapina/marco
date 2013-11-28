package marco.lang;

import marco.internal.Environment;

import java.util.ArrayList;
import java.util.List;

public class MarcoProgram extends MarcoObject {
    private List<MarcoObject> forms = new ArrayList<>();

    public void add(MarcoObject form) {
        forms.add(form);
    }

    public MarcoObject eval(Environment environment) {
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
}
