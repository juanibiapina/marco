package marco.lang;

import marco.internal.Environment;

import java.util.List;

public class MarcoQuotedForm extends MarcoObject {
    private MarcoObject form;

    public MarcoQuotedForm(MarcoObject form) {
        this.form = form;
    }

    @Override
    public MarcoObject doEval(Environment environment, Environment global) {
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

    @Override
    public boolean isContinuation() {
        return false;
    }
}
