package marco.lang.error;

import marco.internal.StackTrace;
import marco.runtime.MarcoRuntime;

public class LookUpError extends Error {
    private MarcoRuntime runtime;
    private int line;
    private String binding;

    public LookUpError(MarcoRuntime runtime, int line, String binding) {
        super(runtime, "Undefined binding '" + binding + "'");
        this.runtime = runtime;
        this.line = line;
        this.binding = binding;
    }

    public int getLine() {
        return line;
    }

    public String getBinding() {
        return binding;
    }

    public StackTrace getMarcoStackTrace() {
        return runtime.buildStackTrace();
    }
}
