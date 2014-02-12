package marco.parser;

import marco.lang.MarcoProgram;
import marco.lang.exception.MarcoException;
import marco.parser.antlr.MarcoParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.io.InputStream;

public class Parser {
    private static Parser parser;

    private Parser() {
    }

    public MarcoProgram parse(String code) {
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(code);
        Lexer lexer = new Lexer(antlrInputStream);

        lexer.removeErrorListeners();
        lexer.addErrorListener(new ExceptionErrorListener());

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        MarcoParser parser = new MarcoParser(tokenStream);

        parser.removeErrorListeners();
        parser.addErrorListener(new ExceptionErrorListener());

        ParseTree tree = parser.program();

        ParseTreeVisitor visitor = new ParseTreeVisitor();
        visitor.visit(tree);

        return visitor.getResult();
    }

    public MarcoProgram parse(InputStream in) {
        ANTLRInputStream antlrInputStream = null;
        try {
            antlrInputStream = new ANTLRInputStream(in);
        } catch (IOException e) {
            throw new MarcoException("inputstream error");
        }
        Lexer lexer = new Lexer(antlrInputStream);

        lexer.removeErrorListeners();
        lexer.addErrorListener(new ExceptionErrorListener());

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        MarcoParser parser = new MarcoParser(tokenStream);

        parser.removeErrorListeners();
        parser.addErrorListener(new ExceptionErrorListener());

        ParseTree tree = parser.program();

        ParseTreeVisitor visitor = new ParseTreeVisitor();
        visitor.visit(tree);

        return visitor.getResult();
    }

    public static Parser instance() {
        if (parser == null) {
            parser = new Parser();
        }

        return parser;
    }
}
