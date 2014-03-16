package marco.lang.especialforms;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoData;
import marco.lang.MarcoList;
import marco.lang.MarcoObject;
import marco.lang.MarcoSpecialForm;
import marco.lang.contracts.Contract;

public class data extends MarcoSpecialForm {
    public data() {
        super(new Contract(1));
    }

    @Override
    protected MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        MarcoList fields = Cast.toList(arguments.get(0));

        MarcoData data = new MarcoData(fields);

        return data;
    }
}
