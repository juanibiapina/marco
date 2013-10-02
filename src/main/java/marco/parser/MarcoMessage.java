package marco.parser;

import marco.lang.MarcoObject;

public interface MarcoMessage {
    public MarcoObject eval(MarcoObject target);
}
