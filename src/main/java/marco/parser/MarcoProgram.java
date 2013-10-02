package marco.parser;

import marco.lang.MarcoObject;

public class MarcoProgram {
    private MarcoExpr expr;

    public MarcoProgram(MarcoExpr expr) {
        this.expr = expr;
    }

    public MarcoObject eval(MarcoObject context) {
        return expr.eval(context);
    }
}
