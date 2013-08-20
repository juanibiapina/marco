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
    public MarcoObject visitSymbol(@NotNull MarcoParser.SymbolContext ctx) {
        result = runtime.createMessage(ctx.getText());
        return result;
    }

    @Override
    public MarcoObject visitString(@NotNull MarcoParser.StringContext ctx) {
        result = runtime.createStringMessage(ctx.getText().substring(1, ctx.getText().length() - 1));
        return result;
    }

    public MarcoObject getResult() {
        return result;
    }
}
