package marco.lang.functions.number;

import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;

public class remainder extends BinaryOperatorBody {
    @Override
    protected MarcoObject invoke(MarcoNumber v1, MarcoNumber v2) {
        return new MarcoNumber(v1.getValue().remainder(v2.getValue()));
    }
}
