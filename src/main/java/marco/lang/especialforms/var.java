package marco.lang.especialforms;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.internal.bindings.MutableBinding;
import marco.lang.MarcoList;
import marco.lang.MarcoSpecialForm;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;
import marco.lang.contracts.Contract;

public class var extends MarcoSpecialForm {
    public var() {
        super(new Contract(2));
    }

    @Override
    public MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        String name = Cast.toName(arguments.get(0)).getValue();
        MarcoObject value = arguments.get(1).eval(environment);

        MutableBinding binding = new MutableBinding(name, value);
        environment.add(binding);

        return MarcoNil.NIL;
    }
}
