package marco.lang;

import marco.internal.Environment;

import java.util.List;

public class MarcoData extends MarcoRunnable {
    private MarcoList fields;

    public MarcoData(MarcoList fields) {
        super(fields.length());
        this.fields = fields;
    }

    @Override
    protected MarcoObject performInvoke(Environment dynamic, List<MarcoObject> arguments) {
        return new MarcoDataInstance(this, arguments);
    }

    @Override
    public String typeName() {
        return "Data";
    }

    @Override
    public String asString() {
        return toString();
    }

    public MarcoList getFields() {
        return fields;
    }
}
