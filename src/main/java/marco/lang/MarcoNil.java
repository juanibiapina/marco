package marco.lang;

import marco.lang.exceptions.MarcoException;

import java.util.Arrays;
import java.util.List;

public class MarcoNil extends MarcoList {
    public static final MarcoNil NIL = new MarcoNil();

    private MarcoNil() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MarcoNil) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "nil";
    }

    @Override
    public String typeName() {
        return "Nil";
    }

    @Override
    public List<String> asArgumentList() {
        return Arrays.asList();
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public MarcoObject get(int i) {
        throw new MarcoException("get in nil");
    }

    @Override
    public MarcoObject getHead() {
        throw new MarcoException("head called on nil");
    }

    @Override
    public MarcoList getTail() {
        throw new MarcoException("tail called on nil");
    }

    @Override
    public boolean isList() {
        return true;
    }

    @Override
    public String asString() {
        return toString();
    }
}
