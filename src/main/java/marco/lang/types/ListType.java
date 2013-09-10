package marco.lang.types;

import marco.lang.MarcoObject;
import marco.lang.values.Cast;
import marco.lang.values.ListValue;
import marco.lang.values.NativeMethodValue;

import java.util.ArrayList;

public class ListType {
    public static void init(MarcoObject self) {
        self.setName("List");
        self.setParent(self.runtime.object);
        self.setValue(new ListValue(new ArrayList<MarcoObject>()));

        self.setSlot("to_string", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                ListValue listValue = (ListValue) self.getValue();
                StringBuilder builder = new StringBuilder();
                builder.append("[");
                String prefix = "";
                for (MarcoObject element : listValue.getValue()) {
                    builder.append(prefix);
                    prefix = ", ";
                    builder.append(Cast.toString(element.sendMessage(scope, "to_string")));
                }
                builder.append("]");
                return self.runtime.createString(builder.toString());
            }
        }));

    }

    public static MarcoObject add(MarcoObject self, MarcoObject value) {
        ListValue listValue = (ListValue) self.getValue();
        listValue.getValue().add(value);
        return self;
    }
}
