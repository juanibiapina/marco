package marco.lang;

import marco.parser.MarcoExpr;
import marco.parser.MarcoMessage;
import marco.parser.MarcoProgram;
import marco.parser.MarcoSingleExpr;

import java.util.List;

public class MarcoInterpreter {
    public MarcoObject eval(MarcoObject context, MarcoProgram program) {
        MarcoExpr expr = program.expr();

        MarcoObject lastResult = context;
        for (MarcoSingleExpr singleExpr : expr.singleExprs()) {
            lastResult = evalSingleExpr(context, singleExpr);
        }

        return lastResult;
    }

    private MarcoObject evalSingleExpr(MarcoObject context, MarcoSingleExpr singleExpr) {
        MarcoObject on = context;

        List<MarcoMessage> messages = singleExpr.messages();
        for (MarcoMessage message : messages) {
            on = message.eval(on);
        }

        return on;
    }
}
