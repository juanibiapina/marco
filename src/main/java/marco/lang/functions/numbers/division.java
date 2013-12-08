package marco.lang.functions.numbers;

import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;

public class division extends BinaryOperatorBody {
    @Override
    protected MarcoObject doEval(MarcoNumber v1, MarcoNumber v2) {
        return new MarcoNumber(v1.getValue().divide(v2.getValue()));
    }
}
