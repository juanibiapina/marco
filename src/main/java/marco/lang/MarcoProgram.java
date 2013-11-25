package marco.lang;

import marco.internal.Environment;

import java.util.ArrayList;
import java.util.List;

public class MarcoProgram extends MarcoForm {
    private List<MarcoForm> forms = new ArrayList<>();

    public void add(MarcoForm form) {
        forms.add(form);
    }

    public MarcoObject eval(Environment environment) {
        MarcoObject result = null;
        for (MarcoForm form : forms) {
            result = form.eval(environment);
        }
        return result;
    }

    @Override
    public String typeName() {
        return "Program";
    }
}
