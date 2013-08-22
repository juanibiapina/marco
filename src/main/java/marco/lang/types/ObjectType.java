package marco.lang.types;

import marco.lang.MarcoObject;
import marco.lang.helpers.Cast;
import marco.lang.values.NativeMethodValue;

public class ObjectType {
    public static void init(MarcoObject self) {
        self.setName("Object");

        self.setSlot("to_string", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject self) {
                return self.runtime.createString(self.getName());
            }
        }));

        self.setSlot("puts", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject self) {
                MarcoObject representation = self.sendMessage("to_string");
                String value = Cast.toString(representation);
                System.out.println(value);
                return self;
            }
        }));
    }
}
