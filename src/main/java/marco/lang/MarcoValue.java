package marco.lang;

public interface MarcoValue {
    public MarcoValue duplicate();

    MarcoObject activate(MarcoObject owner);
}
