package marco.lang;

import marco.runtime.Cast;
import marco.runtime.Environment;

import java.util.ArrayList;
import java.util.List;

public class MarcoApplication extends MarcoObject {
    private MarcoList list;

    public MarcoApplication(MarcoList list) {
        this.list = list;
    }

    @Override
    public MarcoObject __eval(Environment dynamic) {
        MarcoObject head = list.getHead();
        MarcoList tail = list.getTail();

        MarcoObject operator = dynamic.getRuntime().eval(head, dynamic);
        List<MarcoObject> arguments = new ArrayList<>();
        for (int i = 0; i < tail.length(); i++) {
            arguments.add(dynamic.getRuntime().eval(tail.get(i), dynamic));
        }
        return Cast.toRunnable(operator, fileName, startLine).invoke(dynamic, arguments);
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
    public String convertToString() {
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
