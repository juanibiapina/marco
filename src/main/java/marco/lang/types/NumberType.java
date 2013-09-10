package marco.lang.types;

import marco.lang.MarcoObject;
import marco.lang.values.Cast;
import marco.lang.values.NativeMethodValue;
import marco.lang.values.NumberValue;

public class NumberType {
    public static void init(MarcoObject self) {
        self.setName("Number");
        self.setParent(self.runtime.object);
        self.setValue(new NumberValue(0));

        self.setSlot("to_string", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                return self.runtime.createString(Integer.toString(Cast.toInteger(self)));
            }
        }));
    }

}
