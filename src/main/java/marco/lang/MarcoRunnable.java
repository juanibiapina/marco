package marco.lang;

import marco.internal.Environment;

import java.util.List;

public interface MarcoRunnable extends MarcoObject {
    public MarcoObject call(Environment environment, List<MarcoForm> arguments);
}
