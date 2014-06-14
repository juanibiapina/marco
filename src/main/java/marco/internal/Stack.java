package marco.internal;

import marco.lang.MarcoObject;

public class Stack {
    private java.util.Stack<Frame> stack = new java.util.Stack<>();

    public MarcoObject push(Frame frame) {
        stack.push(frame);
        MarcoObject result = frame.resolve();
        stack.pop();
        return result;
    }
}
