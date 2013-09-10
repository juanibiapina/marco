package marco.lang;

import marco.lang.helpers.Cast;

import java.util.List;

public class MarcoInterpreter {
    public MarcoObject eval(MarcoObject context, MarcoObject chainList) {
        MarcoObject lastResult = context;
        List<MarcoObject> chainsList = Cast.toList(chainList);
        for (MarcoObject chain : chainsList) {
            lastResult = evalChain(context, chain);
        }
        return lastResult;
    }

    private MarcoObject evalChain(MarcoObject context, MarcoObject chain) {
        MarcoObject on = context;
        List<MarcoObject> messages = Cast.toList(chain.slot("messages"));
        for (MarcoObject message : messages) {
            on = on.sendMessage(context, message);
        }
        return on;
    }
}
