package marco.lang;

import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.runtime.ListHelper;

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
    public MarcoObject __eval(Environment dynamic) {
        List<MarcoObject> evaluatedElements = new ArrayList<>();

        for (int i = 0; i < length(); i++) {
            evaluatedElements.add(dynamic.getRuntime().eval(get(i), dynamic));
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
    public String convertToString() {
        return toString();
    }
}
