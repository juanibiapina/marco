package marco.lang;

import marco.internal.Environment;
import marco.internal.Cast;

import java.util.ArrayList;
import java.util.List;

public class MarcoList extends MarcoForm {
    private List<MarcoForm> forms = new ArrayList<>();

    public void add(MarcoForm form) {
        forms.add(form);
    }

    @Override
    public MarcoObject eval(Environment environment) {
        MarcoForm first = forms.get(0);
        MarcoObject firstVal = first.eval(environment);
        MarcoRunnable runnable = Cast.toRunnable(firstVal);
        return runnable.call(environment, forms.subList(1, forms.size()));
    }

    public List<MarcoSymbol> asArgumentList() {
        List<MarcoSymbol> args = new ArrayList<>();
        for (MarcoForm form : forms) {
            args.add(Cast.toSymbol(form));
        }
        return args;
    }

    @Override
    public String typeName() {
        return "List";
    }
}
