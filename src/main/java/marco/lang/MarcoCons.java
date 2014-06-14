package marco.lang;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.internal.ListHelper;

import java.util.ArrayList;
import java.util.List;

public class MarcoCons extends MarcoList {
    private MarcoObject head;
    private MarcoList tail;
    private int length;

    public MarcoCons(MarcoObject head, MarcoList tail) {
        this.head = head;
        this.tail = tail;
        this.length = 1 + tail.length();
    }

    @Override
    public String typeName() {
        return "List";
    }

    @Override
    public boolean isList() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MarcoCons) {
            MarcoCons other = (MarcoCons) obj;
            return head.equals(other.head) && tail.equals(other.tail);
        } else {
            return false;
        }
    }

    @Override
    public MarcoObject doEval(Environment closure, Environment environment) {
        List<MarcoObject> evaluatedElements = new ArrayList<>();

        for (int i = 0; i < length(); i++) {
            evaluatedElements.add(get(i).eval(closure));
        }

        return ListHelper.fromJavaList(evaluatedElements);
    }

    @Override
    public String toString() {
        return "(" + head.toString() + ", " + tail.toString() + ")";
    }

    @Override
    public List<String> asArgumentList() {
        List<String> result = new ArrayList<>();
        result.add(Cast.toSymbol(head).getValue());
        result.addAll(tail.asArgumentList());
        return result;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public MarcoObject get(int i) {
        if (i == 0) {
            return head;
        } else {
            return tail.get(i - 1);
        }
    }

    @Override
    public MarcoObject getHead() {
        return head;
    }

    @Override
    public MarcoList getTail() {
        return tail;
    }

    @Override
    public boolean isContinuation() {
        return false;
    }

    @Override
    public String asString() {
        return toString();
    }
}
