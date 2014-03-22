package marco.lang.especialforms;

import marco.internal.Environment;
import marco.lang.*;
import marco.internal.Cast;
import marco.lang.contracts.Contract;

import java.util.List;

public class function extends MarcoSpecialForm {
    public function() {
        super(new Contract(2));
    }

    @Override
    public MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        MarcoList formal = Cast.toList(arguments.get(0).eval(environment));
        List<String> formalList = formal.asArgumentList();

        MarcoBlock body = Cast.toBlock(arguments.get(1).eval(environment));

        return new MarcoFunction(environment, formalList, body);
    }
}
