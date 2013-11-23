package marco.lang;

import marco.internal.Environment;
import marco.lang.helpers.Cast;

import java.util.ArrayList;
import java.util.List;

public class MarcoList implements MarcoForm {
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

    public MarcoForm get(int i) {
        return forms.get(i);
    }
}
