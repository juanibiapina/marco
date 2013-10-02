package marco.parser;

import marco.lang.MarcoObject;

public class MarcoProgram {
    private MarcoExpr expr;

    public MarcoProgram(MarcoExpr expr) {
        this.expr = expr;
    }

    public MarcoObject eval(MarcoObject context) {

        MarcoObject lastResult = context;
        for (MarcoSingleExpr singleExpr : expr.singleExprs()) {
            lastResult = singleExpr.eval(context);
        }

        return lastResult;
    }
}
