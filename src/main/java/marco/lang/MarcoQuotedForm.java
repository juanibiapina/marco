package marco.lang;

import marco.internal.Environment;

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
}
