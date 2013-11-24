package marco.lang;

import marco.internal.Environment;

import java.util.List;

public abstract class MarcoRunnable implements MarcoObject {
    public abstract MarcoObject call(Environment environment, List<MarcoForm> arguments);
}
