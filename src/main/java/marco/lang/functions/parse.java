package marco.lang.functions;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.lang.MarcoString;
import marco.parser.Parser;

public class parse extends MarcoNativeBlock {
    private Parser parser;

    public parse(Parser parser) {
        this.parser = parser;
    }

    @Override
    public MarcoObject invoke(Environment closure, Environment environment) {
        MarcoString code = Cast.toString(closure.lookUp("code"));

        return parser.parse(code.getValue());
    }
}
