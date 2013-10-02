package marco.parser;

import marco.lang.MarcoRuntime;
import marco.parser.antlr.MarcoBaseVisitor;
import marco.parser.antlr.MarcoParser;
import org.antlr.v4.runtime.misc.NotNull;

public class ParseTreeVisitor extends MarcoBaseVisitor<Object> {
    private MarcoRuntime runtime;
    private MarcoProgram result;

    public ParseTreeVisitor(MarcoRuntime runtime) {
        this.runtime = runtime;
    }

    @Override
    public Object visitProgram(@NotNull MarcoParser.ProgramContext ctx) {
        result = new MarcoProgram((MarcoExpr) visit(ctx.expr()));
        return result;
    }

    @Override
    public Object visitExpr(@NotNull MarcoParser.ExprContext ctx) {
        MarcoExpr expr = new MarcoExpr();

        for (MarcoParser.SingleExprContext singleExprContext : ctx.singleExpr()) {
            expr.add((MarcoSingleExpr) visit(singleExprContext));
        }

        return expr;
    }

    @Override
    public Object visitSingleExpr(@NotNull MarcoParser.SingleExprContext ctx) {
        MarcoSingleExpr singleExpr = new MarcoSingleExpr();

        for (MarcoParser.MessageContext messageContext : ctx.message()) {
            singleExpr.add((MarcoMessage) visit(messageContext));
        }

        return singleExpr;
    }

    @Override
    public MarcoSymbolMessage visitSymbol(@NotNull MarcoParser.SymbolContext ctx) {
        return new MarcoSymbolMessage(ctx.getText());
    }

    @Override
    public MarcoStringMessage visitString(@NotNull MarcoParser.StringContext ctx) {
        return new MarcoStringMessage(runtime, ctx.getText().substring(1, ctx.getText().length() - 1));
    }

    @Override
    public MarcoNumberMessage visitNumber(@NotNull MarcoParser.NumberContext ctx) {
        return new MarcoNumberMessage(runtime, ctx.getText());
    }

    public MarcoProgram getResult() {
        return result;
    }
}
