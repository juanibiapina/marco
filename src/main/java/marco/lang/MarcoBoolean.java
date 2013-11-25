package marco.lang;

public class MarcoBoolean implements MarcoObject {
    public static final MarcoBoolean TRUE = new MarcoBoolean(true);
    public static final MarcoBoolean FALSE = new MarcoBoolean(false);

    private boolean value;

    private MarcoBoolean(boolean value) {
        this.value = value;
    }
}
