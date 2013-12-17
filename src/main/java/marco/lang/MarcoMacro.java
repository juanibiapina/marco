package marco.lang;

import marco.lang.contracts.Contract;

public abstract class MarcoMacro extends MarcoRunnable {
    public MarcoMacro(Contract contract) {
        super(contract);
    }

    @Override
    public String typeName() {
        return "Macro";
    }
}
