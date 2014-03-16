package marco.lang;

import marco.internal.Environment;
import marco.lang.contracts.Contract;

import java.util.ArrayList;
import java.util.List;

public class MarcoData extends MarcoRunnable {
    private MarcoList fields;

    public MarcoData(MarcoList fields) {
        super(new Contract(fields.length()));
        this.fields = fields;
    }

    @Override
    protected MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        List<MarcoObject> values = new ArrayList<>();
        for (int i = 0; i < arguments.length(); i++) {
            MarcoObject evaluatedArg = arguments.get(i).eval(environment);
            values.add(evaluatedArg);
        }
        return new MarcoDataInstance(this, values);
    }

    @Override
    public String typeName() {
        return "Data";
    }

    public MarcoList getFields() {
        return fields;
    }
}
