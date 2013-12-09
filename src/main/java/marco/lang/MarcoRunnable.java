package marco.lang;

import marco.internal.Environment;
import marco.lang.contracts.Contract;

public abstract class MarcoRunnable extends MarcoValue {
    private Contract contract;

    public MarcoRunnable(Contract contract) {
        this.contract = contract;
    }

    public MarcoObject invoke(Environment environment, MarcoList arguments) {
        contract.validate(arguments);

        return performInvoke(environment, arguments);
    }

    protected abstract MarcoObject performInvoke(Environment environment, MarcoList arguments);
}
