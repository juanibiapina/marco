package marco.lang;

import marco.runtime.Environment;
import marco.lang.exceptions.ContractViolation;

import java.util.List;

public abstract class MarcoRunnable extends MarcoValue {
    private int arity;

    public MarcoRunnable(int arity) {
        this.arity = arity;
    }

    public MarcoObject invoke(Environment dynamic, List<MarcoObject> arguments) {
        int actualArity = arguments.size();
        if (actualArity != arity) {
            throw new ContractViolation(arity, actualArity);
        }

        return performInvoke(dynamic, arguments);
    }

    protected abstract MarcoObject performInvoke(Environment environment, List<MarcoObject> arguments);

    @Override
    public boolean isList() {
        return false;
    }
}
