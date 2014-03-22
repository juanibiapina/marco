package marco.parser;

import marco.internal.ListHelper;
import marco.lang.*;
import marco.parser.antlr.MarcoBaseVisitor;
import marco.parser.antlr.MarcoParser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.math.BigInteger;
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
    public MarcoApplication visitApplication(@NotNull MarcoParser.ApplicationContext ctx) {
        List<MarcoObject> rawList = new ArrayList<>();
        for (MarcoParser.FormContext formContext : ctx.form()) {
            rawList.add(visit(formContext));
        }
        return new MarcoApplication(ListHelper.fromJavaList(rawList));
    }

    @Override
    public MarcoObject visitQuoted_form(@NotNull MarcoParser.Quoted_formContext ctx) {
        return new MarcoQuotedForm(visit(ctx.form()));
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
    public MarcoObject visitFormApplication(@NotNull MarcoParser.FormApplicationContext ctx) {
        return visit(ctx.application());
    }

    @Override
    public MarcoObject visitFormBlock(@NotNull MarcoParser.FormBlockContext ctx) {
        return visit(ctx.block());
    }

    @Override
    public MarcoObject visitFormNestedAccess(@NotNull MarcoParser.FormNestedAccessContext ctx) {
        return visit(ctx.nested_access());
    }

    @Override
    public MarcoObject visitFormLiteral(@NotNull MarcoParser.FormLiteralContext ctx) {
        return visit(ctx.literal());
    }

    @Override
    public MarcoObject visitFormQuotedForm(@NotNull MarcoParser.FormQuotedFormContext ctx) {
        return visit(ctx.quoted_form());
    }

    @Override
    public MarcoObject visitFormList(@NotNull MarcoParser.FormListContext ctx) {
        return visit(ctx.list());
    }

    @Override
    public MarcoNestedAccess visitNestedAccess(@NotNull MarcoParser.NestedAccessContext ctx) {
        List<MarcoName> names = new ArrayList<>();
        for (TerminalNode node : ctx.NAME()) {
            names.add(new MarcoName(node.getText()));
        }
        return new MarcoNestedAccess(names);
    }

    @Override
    public MarcoBlock visitBlock(@NotNull MarcoParser.BlockContext ctx) {
        List<MarcoObject> rawList = new ArrayList<>();
        for (MarcoParser.FormContext formContext : ctx.form()) {
            rawList.add(visit(formContext));
        }
        return new MarcoBlock(ListHelper.fromJavaList(rawList));
    }

    @Override
    public MarcoName visitName(@NotNull MarcoParser.NameContext ctx) {
        return new MarcoName(ctx.getText());
    }

    @Override
    public MarcoSymbol visitSymbol(@NotNull MarcoParser.SymbolContext ctx) {
        return new MarcoSymbol(ctx.getText().substring(1));
    }

    @Override
    public MarcoString visitString(@NotNull MarcoParser.StringContext ctx) {
        return new MarcoString(ctx.getText().substring(1, ctx.getText().length() - 1));
    }

    @Override
    public MarcoNumber visitNumber(@NotNull MarcoParser.NumberContext ctx) {
        return new MarcoNumber(new BigInteger(ctx.getText()));
    }

    public MarcoProgram getResult() {
        return result;
    }
}
