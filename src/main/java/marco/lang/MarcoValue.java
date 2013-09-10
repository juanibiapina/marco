package marco.lang;

public interface MarcoValue {
    MarcoObject activate(MarcoObject on);

    MarcoValue duplicate();
}
