package marco.lang.error;

import marco.lang.MarcoName;
import marco.runtime.MarcoRuntime;

public class ExportError extends Error {
    public ExportError(MarcoRuntime runtime, String fileName, int line, MarcoName member) {
        super(fileName, line, "Module does not export member: :" + member.getValue());
    }
}
