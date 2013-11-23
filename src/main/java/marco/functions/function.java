package marco.functions;

import marco.internal.Environment;
import marco.lang.MarcoFunction;
import marco.lang.MarcoMacro;
import marco.lang.MarcoObject;
import marco.lang.MarcoForm;
import marco.lang.MarcoList;

import java.util.List;

public class function implements MarcoMacro {
    @Override
    public MarcoObject call(Environment environment, List<MarcoForm> arguments) {
        MarcoList formal = (MarcoList) arguments.get(0);
        MarcoForm body = arguments.get(1);
        return new MarcoFunction(environment, formal, body);
    }
}
