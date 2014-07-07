package marco.lang.error;

import marco.internal.StackTrace;
import marco.runtime.MarcoRuntime;

public class LookUpError extends Error {
    private MarcoRuntime runtime;
    private String binding;

    public LookUpError(MarcoRuntime runtime, String fileName, int line, String binding) {
        super(runtime, fileName, line, "Undefined binding '" + binding + "'");
        this.runtime = runtime;
        this.binding = binding;
    }

    public String getBinding() {
        return binding;
    }

    public StackTrace getMarcoStackTrace() {
        return runtime.buildStackTrace();
    }
}
