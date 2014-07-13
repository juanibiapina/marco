package marco.lang.functions.module;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.*;
import marco.lang.exceptions.MarcoException;
import marco.parser.Parser;

import java.io.InputStream;

public class require extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoString moduleName = Cast.toString(closure.lookUp("module-name"));

        String fileName = moduleName.getValue() + ".mrc";
        InputStream input = this.getClass().getClassLoader().getResourceAsStream(fileName);

        if (input == null) {
            throw new MarcoException("Module not found in classpath:" + moduleName.getValue());
        }

        MarcoProgram module = Parser.instance().parse(fileName, input);
        return module.eval(dynamic);
    }
}
