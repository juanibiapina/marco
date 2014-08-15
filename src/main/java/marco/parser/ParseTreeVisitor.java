package marco.parser;

import marco.lang.*;
import marco.parser.antlr.MarcoBaseVisitor;
import marco.parser.antlr.MarcoParser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseTreeVisitor extends MarcoBaseVisitor<MarcoObject> {
    private MarcoBlock result;
    private String fileName;

    public ParseTreeVisitor(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public MarcoBlock visitFile(@NotNull MarcoParser.FileContext ctx) {
        List<MarcoObject> forms = new ArrayList<>();
        for (MarcoParser.Form_with_docContext formContext : ctx.form_with_doc()) {
            forms.add(visit(formContext));
        }
        result = new MarcoBlock(forms);
        return result;
    }

    @Override
    public MarcoObject visitForm_with_doc(@NotNull MarcoParser.Form_with_docContext ctx) {
        MarcoObject form = visit(ctx.form());

        if (ctx.STRING() != null) {
            String docstring = ctx.STRING().getText().substring(1, ctx.STRING().getText().length() - 1);
            form.setDocstring(docstring);
        }

        return form;
    }

    @Override
    public MarcoApplication visitApplication(@NotNull MarcoParser.ApplicationContext ctx) {
        List<MarcoObject> rawList = new ArrayList<>();
        for (MarcoParser.Form_with_docContext formContext : ctx.form_with_doc()) {
            rawList.add(visit(formContext));
        }
        MarcoApplication marcoApplication = new MarcoApplication(rawList);
        marcoApplication.setStartLine(ctx.getStart().getLine());
        marcoApplication.setFileName(fileName);
        return marcoApplication;
    }

    @Override
    public MarcoLiteralHashMap visitHash_map(@NotNull MarcoParser.Hash_mapContext ctx) {
        Map<MarcoSymbol, MarcoObject> map = new HashMap<>();
        for (int i = 0; i < ctx.form_with_doc().size(); i++) {
            map.put(new MarcoSymbol(ctx.SYMBOL(i).getText().substring(1)), visit(ctx.form_with_doc(i)));
        }
        return new MarcoLiteralHashMap(map);
    }

    @Override
    public MarcoObject visitList(@NotNull MarcoParser.ListContext ctx) {
        List<MarcoObject> rawList = new ArrayList<>();
        for (MarcoParser.Form_with_docContext formContext : ctx.form_with_doc()) {
            rawList.add(visit(formContext));
        }
        return new MarcoLiteralList(rawList);
    }

    @Override
    public MarcoObject visitFormApplication(@NotNull MarcoParser.FormApplicationContext ctx) {
        return visit(ctx.application());
    }

    @Override
    public MarcoObject visitFormHashMap(@NotNull MarcoParser.FormHashMapContext ctx) {
        return visit(ctx.hash_map());
    }

    @Override
    public MarcoObject visitFormBlock(@NotNull MarcoParser.FormBlockContext ctx) {
        return visit(ctx.block());
    }

    @Override
    public MarcoObject visitFormMemberAccess(@NotNull MarcoParser.FormMemberAccessContext ctx) {
        return visit(ctx.member_access());
    }

    @Override
    public MarcoObject visitFormLiteral(@NotNull MarcoParser.FormLiteralContext ctx) {
        return visit(ctx.literal());
    }

    @Override
    public MarcoObject visitFormList(@NotNull MarcoParser.FormListContext ctx) {
        return visit(ctx.list());
    }

    @Override
    public MarcoMemberAccess visitMemberAccess(@NotNull MarcoParser.MemberAccessContext ctx) {
        List<MarcoName> names = new ArrayList<>();
        for (TerminalNode node : ctx.NAME()) {
            MarcoName name = new MarcoName(node.getText());
            name.setFileName(fileName);
            name.setStartLine(node.getSymbol().getLine());
            names.add(name);
        }
        return new MarcoMemberAccess(names);
    }

    @Override
    public MarcoBlock visitBlock(@NotNull MarcoParser.BlockContext ctx) {
        List<MarcoObject> rawList = new ArrayList<>();
        for (MarcoParser.Form_with_docContext formContext : ctx.form_with_doc()) {
            rawList.add(visit(formContext));
        }
        return new MarcoBlock(rawList);
    }

    @Override
    public MarcoName visitName(@NotNull MarcoParser.NameContext ctx) {
        MarcoName name = new MarcoName(ctx.getText());
        name.setFileName(fileName);
        name.setStartLine(ctx.getStart().getLine());
        return name;
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

    public MarcoBlock getResult() {
        return result;
    }
}
