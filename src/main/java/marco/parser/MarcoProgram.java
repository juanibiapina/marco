package marco.parser;

public class MarcoProgram {
    private MarcoExpr expr;

    public MarcoProgram(MarcoExpr expr) {
        this.expr = expr;
    }

    public MarcoExpr expr() {
        return expr;
    }
}
