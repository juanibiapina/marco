package marco.lang;

public abstract class MarcoObject {
    @Override
    public String toString() {
        return typeName();
    }

    public abstract String typeName();
}
