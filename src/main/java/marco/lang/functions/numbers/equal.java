package marco.lang.functions.numbers;

import marco.lang.MarcoBoolean;
import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;

public class equal extends BinaryOperatorBody {
    @Override
    protected MarcoObject doEval(MarcoNumber v1, MarcoNumber v2) {
        return MarcoBoolean.from(v1.getValue().equals(v2.getValue()));
    }
}
