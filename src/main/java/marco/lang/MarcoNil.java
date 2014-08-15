package marco.lang;

public class MarcoNil extends MarcoValue {
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
    public boolean isList() {
        return true;
    }

    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    protected MarcoObject _clone() {
        return new MarcoNil();
    }

    @Override
    public String convertToString() {
        return "nil";
    }
}
