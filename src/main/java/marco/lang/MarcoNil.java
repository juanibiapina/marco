package marco.lang;

import marco.lang.exception.MarcoException;

import java.util.Arrays;
import java.util.List;

public class MarcoNil extends MarcoValue implements MarcoList {
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
    public boolean isList() {
        return true;
    }
}
