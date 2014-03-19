package marco.lang;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.internal.ListHelper;

import java.util.ArrayList;
import java.util.List;

public class MarcoPair extends MarcoObject implements MarcoList {
    private MarcoObject first;
    private MarcoObject second;
    private boolean isList;
    private int length;

    public MarcoPair(MarcoObject first, MarcoObject second) {
        this.first = first;
        this.second = second;
        this.isList = second.isList();
        if (isList()) {
            this.length = 1 + Cast.toList(second).length();
        }
    }

    @Override
    public String typeName() {
        return "Pair";
    }

    @Override
    public List<String> freeVariables() {
        List<String> result = new ArrayList<>();

        result.addAll(first.freeVariables());
        result.addAll(second.freeVariables());

        return result;
    }

    @Override
    public boolean isList() {
        return isList;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MarcoPair) {
            MarcoPair other = (MarcoPair) obj;
            return first.equals(other.first) && second.equals(other.second);
        } else {
            return false;
        }
    }

    @Override
    public MarcoObject doEval(Environment environment) {
        if (isList()) {
            List<MarcoObject> evaluatedElements = new ArrayList<>();

            for (int i = 0; i < length(); i++) {
                evaluatedElements.add(get(i).eval(environment));
            }

            return ListHelper.fromJavaList(evaluatedElements);
        } else {
            return this;
        }
    }

    @Override
    public String toString() {
        return "(" + first.toString() + ", " + second.toString() + ")";
    }

    public MarcoObject getFirst() {
        return first;
    }

    public MarcoObject getSecond() {
        return second;
    }

    @Override
    public List<String> asArgumentList() {
        List<String> result = new ArrayList<>();
        result.add(Cast.toSymbol(first).getValue());
        result.addAll(Cast.toList(second).asArgumentList());
        return result;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public MarcoObject get(int i) {
        if (i == 0) {
            return first;
        } else {
            return Cast.toList(second).get(i - 1);
        }
    }

    @Override
    public MarcoObject getHead() {
        return first;
    }

    @Override
    public MarcoList getTail() {
        return Cast.toList(second);
    }

    @Override
    public boolean isContinuation() {
        return false;
    }
}
