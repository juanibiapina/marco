package marco.lang;

public class MarcoBoolean extends MarcoValue {
    public static final MarcoBoolean TRUE = new MarcoBoolean(true);
    public static final MarcoBoolean FALSE = new MarcoBoolean(false);

    private boolean value;

    private MarcoBoolean(boolean value) {
        this.value = value;
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public String convertToString() {
        return Boolean.toString(value);
    }

    public static MarcoBoolean from(boolean value) {
        if (value) {
            return TRUE;
        } else {
            return FALSE;
        }
    }

    public MarcoObject not() {
        return from(!value);
    }
}
