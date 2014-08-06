package marco.runtime;

import marco.lang.MarcoObject;

import java.util.Iterator;
import java.util.ListIterator;

public class Stack implements Iterable<Frame> {
    private java.util.Stack<Frame> stack = new java.util.Stack<>();

    public MarcoObject push(Frame frame) {
        stack.push(frame);
        MarcoObject result = frame.resolve();
        stack.pop();
        return result;
    }

    @Override
    public Iterator<Frame> iterator() {
        final ListIterator<Frame> it = stack.listIterator(stack.size());

        return new Iterator<Frame>() {
            @Override
            public boolean hasNext() {
                return it.hasPrevious();
            }

            @Override
            public Frame next() {
                return it.previous();
            }

            @Override
            public void remove() {
                it.remove();
            }
        };
    }
}
