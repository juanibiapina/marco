package marco.lang;

import marco.internal.Environment;
import marco.internal.Cast;

import java.util.ArrayList;
import java.util.List;

public class MarcoList extends MarcoObject {
    private List<MarcoObject> forms = new ArrayList<>();

    public void add(MarcoObject form) {
        forms.add(form);
    }

    @Override
    public MarcoObject eval(Environment environment) {
        MarcoObject first = forms.get(0);
        MarcoObject firstVal = first.eval(environment);
        MarcoRunnable runnable = Cast.toRunnable(firstVal);
        return runnable.call(environment, forms.subList(1, forms.size()));
    }

    public List<String> asArgumentList() {
        List<String> args = new ArrayList<>();
        for (MarcoObject form : forms) {
            args.add(Cast.toSymbol(form).getValue());
        }
        return args;
    }

    @Override
    public String typeName() {
        return "List";
    }
}
