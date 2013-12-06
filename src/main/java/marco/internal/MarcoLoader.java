package marco.internal;

import marco.lang.MarcoProgram;
import marco.lang.exception.MarcoException;
import marco.parser.Parser;

import java.io.InputStream;

public class MarcoLoader {
    public static MarcoProgram load(String name) {
        InputStream in = MarcoLoader.class.getClassLoader().getResourceAsStream("marco/" + name + ".mrc");

        if (in == null) {
            throw new MarcoException("could not find " + name);
        }

        return Parser.instance().parse(in);
    }
}
