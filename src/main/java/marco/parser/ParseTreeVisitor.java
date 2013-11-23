package marco.parser;

import marco.lang.*;
import marco.parser.antlr.MarcoBaseVisitor;
import marco.parser.antlr.MarcoParser;
import org.antlr.v4.runtime.misc.NotNull;

public class ParseTreeVisitor extends MarcoBaseVisitor<Object> {
    private MarcoProgram result;

    @Override
    public MarcoProgram visitProgram(@NotNull MarcoParser.ProgramContext ctx) {
        result = new MarcoProgram();
        for (MarcoParser.FormContext formContext : ctx.form()) {
            result.add((MarcoForm) visit(formContext));
        }
        return result;
    }

    @Override
    public MarcoList visitList(@NotNull MarcoParser.ListContext ctx) {
        MarcoList list = new MarcoList();
        for (MarcoParser.FormContext formContext : ctx.form()) {
            list.add((MarcoForm) visit(formContext));
        }
        return list;
    }

    @Override
    public MarcoForm visitFormList(@NotNull MarcoParser.FormListContext ctx) {
        return (MarcoForm) visit(ctx.list());
    }

    @Override
    public MarcoForm visitFormLiteral(@NotNull MarcoParser.FormLiteralContext ctx) {
        return (MarcoForm) visit(ctx.literal());
    }

    @Override
    public MarcoSymbol visitSymbol(@NotNull MarcoParser.SymbolContext ctx) {
        return new MarcoSymbol(ctx.getText());
    }

    @Override
    public MarcoString visitString(@NotNull MarcoParser.StringContext ctx) {
        return new MarcoString(ctx.getText().substring(1, ctx.getText().length() - 1));
    }

    @Override
    public MarcoNumber visitNumber(@NotNull MarcoParser.NumberContext ctx) {
        return new MarcoNumber(Integer.parseInt(ctx.getText()));
    }

    public MarcoProgram getResult() {
        return result;
    }
}
