package marco.lang;

public class MarcoNil extends MarcoValue {
    public static final MarcoObject NIL = new MarcoNil();

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
}
