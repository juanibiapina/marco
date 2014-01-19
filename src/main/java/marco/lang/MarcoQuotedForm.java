package marco.lang;

import marco.internal.Environment;

import java.util.List;

public class MarcoQuotedForm extends MarcoObject {
    private MarcoObject form;

    public MarcoQuotedForm(MarcoObject form) {
        this.form = form;
    }

    @Override
    public MarcoObject eval(Environment environment) {
        return form;
    }

    @Override
    public String typeName() {
        return form.typeName();
    }

    @Override
    public List<String> freeVariables() {
        return form.freeVariables();
    }

    @Override
    public boolean isList() {
        return false;
    }
}
