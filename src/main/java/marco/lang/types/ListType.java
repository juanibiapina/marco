package marco.lang.types;

import marco.lang.MarcoObject;
import marco.lang.values.ListValue;

import java.util.ArrayList;

public class ListType {
    public static void init(MarcoObject self) {
        self.setName("List");
        self.setParent(self.runtime.object);
        self.setValue(new ListValue(new ArrayList<MarcoObject>()));
    }

    public static MarcoObject add(MarcoObject self, MarcoObject value) {
        ListValue listValue = (ListValue) self.getValue();
        listValue.getValue().add(value);
        return self;
    }
}
