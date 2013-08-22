package marco.lang;

import marco.lang.helpers.Cast;

import java.util.List;

public class MarcoInterpreter {
    public MarcoObject eval(MarcoObject context, MarcoObject program) {
        MarcoObject chain = program;
        List<MarcoObject> messages = Cast.toList(chain.sendMessage("messages"));
        return context.sendMessage(messages.get(0));
    }
}
