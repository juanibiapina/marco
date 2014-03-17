package marco.lang.especialforms;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.*;
import marco.lang.contracts.Contract;
import marco.lang.exceptions.MarcoException;
import marco.parser.Parser;

import java.io.InputStream;

public class include extends MarcoSpecialForm {
    public include() {
        super(new Contract(1));
    }

    @Override
    protected MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        MarcoString moduleName = Cast.toString(arguments.get(0));

        InputStream input = this.getClass().getClassLoader().getResourceAsStream(moduleName.getValue() + ".mrc");

        if (input == null) {
            throw new MarcoException("Module not found in classpath:" + moduleName.getValue());
        }

        MarcoProgram module = Parser.instance().parse(input);
        module.eval(environment);

        return MarcoNil.NIL;
    }
}
