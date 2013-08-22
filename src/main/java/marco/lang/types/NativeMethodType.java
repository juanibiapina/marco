package marco.lang.types;

import marco.lang.MarcoObject;

public class NativeMethodType {
    public static void init(MarcoObject self) {
        self.setName("NativeMethod");
        self.setParent(self.runtime.object);
        self.setActivatable(true);
    }
}
