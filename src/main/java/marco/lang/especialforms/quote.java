package marco.lang.especialforms;

import marco.internal.Environment;
import marco.lang.MarcoList;
import marco.lang.MarcoSpecialForm;
import marco.lang.MarcoObject;
import marco.lang.contracts.Contract;

public class quote extends MarcoSpecialForm {
    public quote() {
        super(new Contract(1));
    }

    @Override
    public MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        MarcoObject arg = arguments.get(0);

        return arg;
    }
}
