package marco.parser;

import marco.lang.MarcoObject;

public abstract class MarcoMessage {
    public abstract boolean hasCachedValue();

    public abstract MarcoObject getCachedValue();

    public abstract String getName();
}
