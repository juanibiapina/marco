package marco.lang;

import marco.internal.Environment;
import marco.lang.contracts.Contract;
import marco.lang.exception.ContractViolation;

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

    protected void assertArity(int expected, int actual) {
        if (actual != expected) {
            throw new ContractViolation(expected, actual);
        }
    }
}
