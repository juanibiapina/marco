package marco.parser;

import marco.internal.ListHelper;
import marco.lang.*;
import marco.parser.antlr.MarcoBaseVisitor;
import marco.parser.antlr.MarcoParser;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ParseTreeVisitor extends MarcoBaseVisitor<MarcoObject> {
    private MarcoProgram result;

    @Override
    public MarcoProgram visitProgram(@NotNull MarcoParser.ProgramContext ctx) {
        result = new MarcoProgram();
        for (MarcoParser.FormContext formContext : ctx.form()) {
            result.add(visit(formContext));
        }
        return result;
    }

    @Override
    public MarcoObject visitList(@NotNull MarcoParser.ListContext ctx) {
        List<MarcoObject> rawList = new ArrayList<>();
        for (MarcoParser.FormContext formContext : ctx.form()) {
            rawList.add(visit(formContext));
        }
        return ListHelper.fromJavaList(rawList);
    }

    @Override
    public MarcoObject visitFormList(@NotNull MarcoParser.FormListContext ctx) {
        return visit(ctx.list());
    }

    @Override
    public MarcoObject visitFormLiteral(@NotNull MarcoParser.FormLiteralContext ctx) {
        return visit(ctx.literal());
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
