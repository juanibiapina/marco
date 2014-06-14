package marco.internal;

public class StackTraceElement {
    private final Integer line;

    public StackTraceElement(Frame frame) {
        this.line = frame.getLine();
    }

    public Integer getLine() {
        return line;
    }
}
