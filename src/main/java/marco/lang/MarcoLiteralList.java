package marco.lang;

import marco.internal.Environment;
import marco.internal.ListHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MarcoLiteralList extends MarcoObject {
    private MarcoList list;

    public MarcoLiteralList(MarcoList list) {
        this.list = list;
    }

    @Override
    protected MarcoObject doEval(Environment closure, Environment environment) {
        List<MarcoObject> evaluatedElements = new ArrayList<>();

        for (int i = 0; i < list.length(); i++) {
            evaluatedElements.add(list.get(i).eval(closure));
        }

        return ListHelper.fromJavaList(evaluatedElements);
    }

    @Override
    public String typeName() {
        return "LiteralList";
    }

    @Override
    public List<String> freeVariables() {
        return Collections.emptyList();
    }

    @Override
    public boolean isList() {
        return true;
    }

    @Override
    public boolean isContinuation() {
        return false;
    }
}
