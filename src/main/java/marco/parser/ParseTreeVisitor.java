package marco.parser;

import marco.lang.MarcoObject;
import marco.lang.MarcoRuntime;
import marco.parser.antlr.MarcoBaseVisitor;
import marco.parser.antlr.MarcoParser;
import org.antlr.v4.runtime.misc.NotNull;

public class ParseTreeVisitor extends MarcoBaseVisitor<MarcoObject> {
    private MarcoRuntime runtime;
    private MarcoObject result;

    public ParseTreeVisitor(MarcoRuntime runtime) {
        this.runtime = runtime;
    }

    @Override
    public MarcoObject visitProgram(@NotNull MarcoParser.ProgramContext ctx) {
        result = runtime.createMessage(ctx.ID().getSymbol().getText());
        return result;
    }

    public MarcoObject getResult() {
        return result;
    }
}
