package marco.lang.functions.numbers;

import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;

public class equal extends BinaryOperatorBody {
    @Override
    protected MarcoObject doEval(MarcoNumber v1, MarcoNumber v2) {
        return v1.equal(v2);
    }
}
