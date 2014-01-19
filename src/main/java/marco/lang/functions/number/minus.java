package marco.lang.functions.number;

import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;

public class minus extends BinaryOperatorBody {
    @Override
    protected MarcoObject doEval(MarcoNumber v1, MarcoNumber v2) {
        return new MarcoNumber(v1.getValue().subtract(v2.getValue()));
    }
}
