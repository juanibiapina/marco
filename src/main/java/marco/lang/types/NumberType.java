package marco.lang.types;

import marco.lang.MarcoObject;

public class NumberType {
    public static void init(MarcoObject self) {
        self.setName("Number");
        self.setParent(self.runtime.object);
    }
}
