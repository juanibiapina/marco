package marco.lang;

public class MarcoInterpreter {
    public MarcoObject eval(MarcoObject context, MarcoObject program) {
        return context.sendMessage(program); // Program is just one message
    }
}
