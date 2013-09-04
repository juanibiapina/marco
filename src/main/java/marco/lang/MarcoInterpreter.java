package marco.lang;

import marco.lang.values.Cast;

import java.util.List;

public class MarcoInterpreter {
    public MarcoObject evalLine(MarcoObject context, MarcoObject chain) {
        MarcoObject on = context;
        List<MarcoObject> messages = Cast.toList(chain.sendMessage(context, "messages"));
        for (MarcoObject message : messages) {
            on = on.sendMessage(context, message);
        }
        return on;
    }

    public MarcoObject eval(MarcoObject context, MarcoObject chainList) {
        MarcoObject lastResult = context;
        List<MarcoObject> chainsList = Cast.toList(chainList);
        for (MarcoObject chain : chainsList) {
            lastResult = evalLine(context, chain);
        }
        return lastResult;
    }
}
