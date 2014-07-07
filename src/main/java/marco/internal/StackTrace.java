package marco.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StackTrace implements Iterable<marco.internal.StackTraceElement> {
    private List<StackTraceElement> trace;

    public StackTrace(Stack stack) {
        trace = new ArrayList<>();
        for (Frame frame : stack) {
            trace.add(new StackTraceElement(frame));
        }
    }

    @Override
    public Iterator<StackTraceElement> iterator() {
        return trace.iterator();
    }

    public void print() {
        System.out.println(buildMessage());
    }

    public String buildMessage() {
        StringBuilder builder = new StringBuilder();
        for (StackTraceElement element : trace) {
            builder.append(element.buildMessage());
        }
        return builder.toString();
    }
}
