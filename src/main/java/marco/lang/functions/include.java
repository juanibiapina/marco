package marco.lang.functions;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.*;
import marco.lang.exceptions.MarcoException;
import marco.parser.Parser;

import java.io.InputStream;

public class include extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment environment) {
        MarcoString moduleName = Cast.toString(closure.lookUp("module-name"));

        InputStream input = this.getClass().getClassLoader().getResourceAsStream(moduleName.getValue() + ".mrc");

        if (input == null) {
            throw new MarcoException("Module not found in classpath:" + moduleName.getValue());
        }

        MarcoProgram module = Parser.instance().parse(input);
        module.eval(environment);

        return MarcoNil.NIL;
    }
}
