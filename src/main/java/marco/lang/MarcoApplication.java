package marco.lang;

import marco.runtime.Cast;
import marco.runtime.Environment;

import java.util.ArrayList;
import java.util.List;

public class MarcoApplication extends MarcoObject {
    private List<MarcoObject> list;

    public MarcoApplication(List<MarcoObject> list) {
        this.list = list;
    }

    @Override
    public MarcoObject __eval(Environment dynamic) {

        MarcoObject operator = dynamic.getRuntime().eval(list.get(0), dynamic);
        List<MarcoObject> arguments = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            arguments.add(dynamic.getRuntime().eval(list.get(i), dynamic));
        }
        return Cast.toRunnable(operator, getFileName(), getStartLine()).invoke(dynamic, arguments);
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public String convertToString() {
        return "Application";
    }

    @Override
    protected MarcoObject _clone() {
        return new MarcoApplication(list);
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
