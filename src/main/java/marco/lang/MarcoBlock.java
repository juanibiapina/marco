package marco.lang;

import marco.lang.continuation.EvalContinuation;
import marco.runtime.Environment;

import java.util.List;

public class MarcoBlock extends MarcoValue {
    private List<MarcoObject> forms;
    private Environment blockClosure;

    public MarcoBlock(List<MarcoObject> forms) {
        this.forms = forms;
    }

    @Override
    public MarcoObject __eval(Environment dynamic) {
        this.blockClosure = dynamic;
        return this;
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public String convertToString() {
        return "Block";
    }

    @Override
    protected MarcoObject _clone() {
        return new MarcoBlock(forms);
    }

    public MarcoObject invoke(Environment closure, Environment dynamic) {
        return invokeWithEnvironment(closure);
    }

    public MarcoObject invokeLexically() {
        return invokeWithEnvironment(blockClosure);
    }

    public MarcoObject invokeWithEnvironment(Environment closure) {
        for (int i = 0; i < forms.size() - 1; i++) {
            closure.getRuntime().eval(forms.get(i), closure);
        }
        return new EvalContinuation(forms.get(forms.size() - 1), closure);
    }
}
