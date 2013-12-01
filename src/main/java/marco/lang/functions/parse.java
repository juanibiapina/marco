package marco.lang.functions;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoObject;
import marco.lang.MarcoString;
import marco.parser.Parser;

public class parse extends MarcoNativeObject {
    private Parser parser;

    public parse(Parser parser) {
        this.parser = parser;
    }

    @Override
    public MarcoObject eval(Environment environment) {
        MarcoString code = Cast.toString(environment.lookUp("code"));

        return parser.parse(code.getValue());
    }
}
