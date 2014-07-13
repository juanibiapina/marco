package marco.lang;

import marco.internal.Environment;

public abstract class MarcoObject {
    protected String fileName;
    protected Integer startLine;

    public abstract MarcoObject eval(Environment dynamic);

    @Override
    public String toString() {
        return typeName();
    }

    public abstract String typeName();

    public abstract boolean isList();

    public abstract String convertToString();

    public void setStartLine(Integer startLine) {
        this.startLine = startLine;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
