package marco.lang.types;

import marco.lang.MarcoObject;

public class BooleanType {
    public static void init(MarcoObject self) {
        self.setParent(self.runtime.object);
        self.setName("Boolean");
    }
}
