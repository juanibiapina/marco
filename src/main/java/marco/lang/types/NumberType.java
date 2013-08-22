package marco.lang.types;

import marco.lang.MarcoObject;
import marco.lang.helpers.Cast;
import marco.lang.values.NativeMethodValue;

public class NumberType {
    public static void init(MarcoObject self) {
        self.setName("Number");
        self.setParent(self.runtime.object);

        self.setSlot("to_string", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject self) {
                Integer value = Cast.toInteger(self);
                return self.runtime.createString(value.toString());
            }
        }));
    }
}
