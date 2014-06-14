package marco.internal;

import marco.lang.MarcoObject;
import marco.lang.MarcoRunnable;

import java.util.List;

public class Frame {
    private MarcoRunnable runnable;
    private List<MarcoObject> arguments;
    private Environment dynamic;

    public Frame(MarcoRunnable runnable, List<MarcoObject> arguments, Environment dynamic) {
        this.runnable = runnable;
        this.arguments = arguments;
        this.dynamic = dynamic;
    }

    public MarcoObject resolve() {
        return runnable.invoke(dynamic, arguments);
    }
}
