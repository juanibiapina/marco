package marco.parser;

import marco.lang.MarcoProgram;
import marco.parser.antlr.MarcoParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Parser {
    public MarcoProgram parse(String code) {
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(code);
        Lexer lexer = new Lexer(antlrInputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        MarcoParser parser = new MarcoParser(tokenStream);

        ParseTree tree = parser.program();

        ParseTreeVisitor visitor = new ParseTreeVisitor();
        visitor.visit(tree);

        return visitor.getResult();
    }
}
