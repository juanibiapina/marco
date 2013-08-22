package marco.lang.values;

import marco.lang.MarcoObject;
import marco.lang.MarcoValue;

import java.util.ArrayList;

public class ListValue implements MarcoValue {
    private ArrayList<MarcoObject> value;

    public ListValue(ArrayList<MarcoObject> value) {
        this.value = value;
    }

    public ArrayList<MarcoObject> getValue() {
        return value;
    }

    @Override
    public MarcoValue duplicate() {
        return new ListValue((ArrayList<MarcoObject>) value.clone());
    }

    @Override
    public MarcoObject activate(MarcoObject owner) {
        return owner;
    }
}
