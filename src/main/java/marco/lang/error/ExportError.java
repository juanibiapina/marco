package marco.lang.error;

import marco.lang.MarcoName;

public class ExportError extends Error {
    public ExportError(String fileName, int line, MarcoName member) {
        super(fileName, line, "Module does not export member: :" + member.getValue());
    }
}
