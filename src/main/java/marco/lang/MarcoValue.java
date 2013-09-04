package marco.lang;

public interface MarcoValue {
    MarcoObject activate(MarcoObject self, MarcoObject scope, MarcoObject on, MarcoObject message);

    MarcoValue duplicate();
}
