package marco.lang;

import marco.internal.Cast;
import marco.internal.Environment;

import java.util.ArrayList;
import java.util.Collections;
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
        if (isList()) {
            List<String> result = new ArrayList<>();
            result.addAll(first.freeVariables());
            result.addAll(second.freeVariables());
            return result;
        } else {
            return Collections.EMPTY_LIST;
        }
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
    public MarcoObject eval(Environment environment) {
        if (isList()) {
            MarcoObject firstVal = first.eval(environment);
            MarcoRunnable runnable = Cast.toRunnable(firstVal);
            return runnable.invoke(environment, Cast.toList(second));
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
}
