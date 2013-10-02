package marco.parser;

import marco.lang.MarcoObject;

import java.util.ArrayList;
import java.util.List;

public class MarcoExpr {
    private List<MarcoSingleExpr> singleExprs = new ArrayList<>();

    public void add(MarcoSingleExpr singleExpr) {
        singleExprs.add(singleExpr);
    }

    public MarcoObject eval(MarcoObject context) {
        MarcoObject lastResult = context;
        for (MarcoSingleExpr singleExpr : singleExprs) {
            lastResult = singleExpr.eval(context);
        }

        return lastResult;
    }
}
