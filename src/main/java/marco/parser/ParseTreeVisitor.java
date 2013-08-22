package marco.parser;

import marco.lang.MarcoObject;
import marco.lang.MarcoRuntime;
import marco.lang.types.ListType;
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
        result = visit(ctx.chain());
        return result;
    }

    @Override
    public MarcoObject visitChain(@NotNull MarcoParser.ChainContext ctx) {
        MarcoObject messages = runtime.createList();

        for (MarcoParser.MessageContext messageContext : ctx.message()) {
            ListType.add(messages, visit(messageContext));
        }

        return runtime.createChain(messages);
    }

    @Override
    public MarcoObject visitSymbol(@NotNull MarcoParser.SymbolContext ctx) {
        return runtime.createMessage(ctx.getText());
    }

    @Override
    public MarcoObject visitString(@NotNull MarcoParser.StringContext ctx) {
        return runtime.createStringMessage(ctx.getText().substring(1, ctx.getText().length() - 1));
    }

    @Override
    public MarcoObject visitNumber(@NotNull MarcoParser.NumberContext ctx) {
        return runtime.createNumberMessage(ctx.getText());
    }

    public MarcoObject getResult() {
        return result;
    }
}
