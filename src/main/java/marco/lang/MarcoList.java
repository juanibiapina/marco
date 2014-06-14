package marco.lang;

import java.util.List;

public abstract class MarcoList extends MarcoValue {
    public abstract List<String> asArgumentList();

    public abstract int length();

    public abstract MarcoObject get(int i);

    public abstract MarcoObject getHead();

    public abstract MarcoList getTail();
}
