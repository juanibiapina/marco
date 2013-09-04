package marco.lang.types;

import marco.lang.MarcoObject;
import marco.lang.values.Cast;
import marco.lang.values.NativeMethodValue;

public class StringType {
    public static void init(MarcoObject self) {
        self.setName("String");
        self.setParent(self.runtime.object);

        self.setSlot("to_string", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                String content = Cast.toString(self);
                return self.runtime.createString(content);
            }
        }));
    }
}
