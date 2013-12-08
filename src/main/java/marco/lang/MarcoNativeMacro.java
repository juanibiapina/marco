package marco.lang;

import marco.lang.contracts.Contract;

public abstract class MarcoNativeMacro extends MarcoRunnable {
    public MarcoNativeMacro(Contract contract) {
        super(contract);
    }

    @Override
    public String typeName() {
        return "NativeMacro";
    }
}
