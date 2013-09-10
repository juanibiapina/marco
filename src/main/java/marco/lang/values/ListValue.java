package marco.lang.values;

import marco.lang.MarcoObject;
import marco.lang.MarcoValue;

import java.util.ArrayList;
import java.util.List;

public class ListValue implements MarcoValue {
    private ArrayList<MarcoObject> value;

    public ListValue(ArrayList<MarcoObject> value) {
        this.value = value;
    }

    public List<MarcoObject> getValue() {
        return value;
    }

    @Override
    public MarcoObject activate(MarcoObject on) {
        throw new RuntimeException(this.getClass().getSimpleName() + "  can not be activated");
    }

    @Override
    public MarcoValue duplicate() {
        return new ListValue((ArrayList<MarcoObject>) value.clone());
    }
}
