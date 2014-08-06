package marco.runtime;

import marco.lang.MarcoObject;
import marco.lang.MarcoRunnable;

import java.util.List;

public class Frame {
    private Integer line;
    private MarcoRunnable runnable;
    private List<MarcoObject> arguments;
    private Environment dynamic;
    private String fileName;

    public Frame(String fileName, Integer line, MarcoRunnable runnable, List<MarcoObject> arguments, Environment dynamic) {
        this.fileName = fileName;
        this.line = line;
        this.runnable = runnable;
        this.arguments = arguments;
        this.dynamic = dynamic;
    }

    public MarcoObject resolve() {
        return runnable.invoke(dynamic, arguments);
    }

    public Integer getLine() {
        return line;
    }

    public String getFileName() {
        return fileName;
    }
}
