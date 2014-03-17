package marco.lang.especialforms;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoList;
import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;
import marco.lang.MarcoSpecialForm;
import marco.lang.contracts.Contract;

public class exit extends MarcoSpecialForm {
    public exit() {
        super(new Contract(1));
    }

    @Override
    protected MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        MarcoNumber exitCode = Cast.toNumber(arguments.get(0));

        System.exit(exitCode.getValue().intValue());

        return null;
    }
}
