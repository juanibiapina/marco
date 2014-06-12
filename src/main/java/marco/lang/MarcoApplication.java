package marco.lang;

import marco.internal.Cast;
import marco.internal.Environment;

import java.util.ArrayList;
import java.util.List;

public class MarcoApplication extends MarcoObject {
    private MarcoObject list;

    public MarcoApplication(MarcoObject list) {
        this.list = list;
    }

    @Override
    public MarcoObject doEval(Environment closure, Environment environment) {
        MarcoList marcoList = (MarcoList) list;
        MarcoObject head = marcoList.getHead();
        MarcoList tail = marcoList.getTail();

        MarcoObject operator = head.eval(closure);
        List<MarcoObject> arguments = new ArrayList<>();
        for (int i = 0; i < tail.length(); i++) {
            arguments.add(tail.get(i).eval(closure));
        }
        return new MarcoContinuation(new MarcoInvocation(Cast.toRunnable(operator), arguments), closure, environment);
    }

    @Override
    public String typeName() {
        return "Application";
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public boolean isContinuation() {
        return false;
    }

    @Override
    public String asString() {
        return toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MarcoApplication) {
            MarcoApplication other = (MarcoApplication) obj;
            return list.equals(other.list);
        } else {
            return false;
        }
    }
}
