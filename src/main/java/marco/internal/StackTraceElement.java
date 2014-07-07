package marco.internal;

public class StackTraceElement {
    private final Integer line;
    private final String fileName;

    public StackTraceElement(Frame frame) {
        this.line = frame.getLine();
        this.fileName = frame.getFileName();
    }

    public Integer getLine() {
        return line;
    }

    public String buildMessage() {
        return "    from " + fileName + ":" + line + "\n";
    }
}
