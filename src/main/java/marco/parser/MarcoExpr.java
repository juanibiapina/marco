package marco.parser;

import java.util.ArrayList;
import java.util.List;

public class MarcoExpr {
    private List<MarcoSingleExpr> singleExprs = new ArrayList<>();

    public void add(MarcoSingleExpr singleExpr) {
        singleExprs.add(singleExpr);
    }

    public List<MarcoSingleExpr> singleExprs() {
        return singleExprs;
    }
}
