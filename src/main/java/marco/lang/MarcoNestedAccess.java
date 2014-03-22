package marco.lang;

import marco.internal.Cast;
import marco.internal.Environment;

import java.util.Collections;
import java.util.List;

public class MarcoNestedAccess extends MarcoObject {
    private List<MarcoName> symbols;

    public MarcoNestedAccess(List<MarcoName> symbols) {
        this.symbols = symbols;
    }

    @Override
    protected MarcoObject doEval(Environment environment) {
        MarcoDataInstance data = Cast.toDataInstance(symbols.get(0).eval(environment));

        MarcoObject result = data.getField(symbols.get(1));
        for (int i = 2; i < symbols.size(); i++) {
            result = Cast.toDataInstance(result).getField(symbols.get(i));
        }
        return result;
    }

    @Override
    public String typeName() {
        return "NestedAccess";
    }

    @Override
    public List<String> freeVariables() {
        return Collections.emptyList();
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
