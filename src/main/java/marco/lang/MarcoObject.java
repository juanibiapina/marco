package marco.lang;

import marco.internal.Environment;

public abstract class MarcoObject {
    private Integer startLine;

    public abstract MarcoObject eval(Environment dynamic);

    @Override
    public String toString() {
        return typeName();
    }

    public abstract String typeName();

    public abstract boolean isList();

    public abstract String asString();

    public Integer getStartLine() {
        return startLine;
    }

    public void setStartLine(Integer startLine) {
        this.startLine = startLine;
    }
}
