package marco.lang;

import marco.internal.Environment;
import marco.lang.contracts.Contract;

import java.util.List;

public abstract class MarcoRunnable extends MarcoValue {
    private Contract contract;

    public MarcoRunnable(Contract contract) {
        this.contract = contract;
    }

    public MarcoObject invoke(Environment environment, List<MarcoObject> arguments) {
        contract.validate(arguments);

        return performInvoke(environment, arguments);
    }

    protected abstract MarcoObject performInvoke(Environment environment, List<MarcoObject> arguments);

    @Override
    public boolean isList() {
        return false;
    }
}
