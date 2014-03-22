package marco.lang;

import marco.internal.Cast;
import marco.internal.Environment;

import java.util.List;

public class MarcoApplication extends MarcoObject {
    private MarcoObject list;

    public MarcoApplication(MarcoObject list) {
        this.list = list;
    }

    @Override
    public MarcoObject doEval(Environment environment, Environment global) {
        MarcoList marcoList = (MarcoList) list;
        MarcoObject head = marcoList.getHead();
        MarcoList tail = marcoList.getTail();

        MarcoObject operator = head.eval(environment);
        return new MarcoContinuation(new MarcoInvocation(Cast.toRunnable(operator), tail), environment);
    }

    @Override
    public String typeName() {
        return "Application";
    }

    @Override
    public List<String> freeVariables() {
        return list.freeVariables();
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
    public boolean equals(Object obj) {
        if (obj instanceof MarcoApplication) {
            MarcoApplication other = (MarcoApplication) obj;
            return list.equals(other.list);
        } else {
            return false;
        }
    }
}
