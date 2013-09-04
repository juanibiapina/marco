package marco.lang.values;

import marco.lang.MarcoObject;
import marco.lang.MarcoRuntime;
import marco.lang.MarcoValue;
import marco.parser.Parser;

public class ParserValue implements MarcoValue {
    private MarcoRuntime runtime;
    private Parser parser;

    public ParserValue(MarcoRuntime runtime) {
        this.runtime = runtime;
        parser = new Parser(runtime);
    }

    public boolean canActivate() {
        return false;
    }

    public MarcoObject activate(MarcoObject self, MarcoObject scope, MarcoObject on, MarcoObject message) {
        throw new RuntimeException(this.getClass().getSimpleName() + "  can not be activated");
    }

    public MarcoValue duplicate() {
        return new ParserValue(runtime);
    }

    public MarcoObject parse(String program) {
        return parser.parse(program);
    }
}
