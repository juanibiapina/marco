package marco.lang.types;

import marco.lang.MarcoObject;

public class StringType {
    public static void init(MarcoObject self) {
        self.setName("String");
        self.setParent(self.runtime.object);
    }
}
