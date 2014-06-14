package marco.internal;

import marco.lang.MarcoObject;
import marco.lang.MarcoRunnable;

import java.util.List;

public class Frame {
    private Integer line;
    private MarcoRunnable runnable;
    private List<MarcoObject> arguments;
    private Environment dynamic;

    public Frame(Integer line, MarcoRunnable runnable, List<MarcoObject> arguments, Environment dynamic) {
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
}
