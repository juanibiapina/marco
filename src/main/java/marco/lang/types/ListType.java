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

        self.setSlot("size", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                ListValue listValue = (ListValue) self.getValue();
                return self.runtime.createNumber(listValue.getValue().size());
            }
        }));

        self.setSlot("popFirst", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                ListValue listValue = (ListValue) self.getValue();
                return listValue.getValue().remove(0);
            }
        }));

        self.setSlot("isEmpty", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                ListValue listValue = (ListValue) self.getValue();
                if (listValue.getValue().isEmpty()) {
                    return self.runtime.trueObject;
                } else {
                    return self.runtime.falseObject;
                }
            }
        }));

        self.setSlot("first", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                ListValue listValue = (ListValue) self.getValue();
                return listValue.getValue().get(0);
            }
        }));

        self.setSlot("second", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                ListValue listValue = (ListValue) self.getValue();
                return listValue.getValue().get(1);
            }
        }));

        self.setSlot("last", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                ListValue listValue = (ListValue) self.getValue();
                return listValue.getValue().get(listValue.getValue().size() - 1);
            }
        }));

        self.setSlot("toString", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                ListValue listValue = (ListValue) self.getValue();
                StringBuilder builder = new StringBuilder();
                builder.append("[");
                String prefix = "";
                for (MarcoObject element : listValue.getValue()) {
                    builder.append(prefix);
                    prefix = ", ";
                    builder.append(Cast.toString(element.sendMessage(scope, "toString")));
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

    public static MarcoObject addAll(MarcoObject self, MarcoObject values) {
        ListValue listValue = (ListValue) self.getValue();
        listValue.getValue().addAll(((ListValue) values.getValue()).getValue());
        return self;
    }

}
