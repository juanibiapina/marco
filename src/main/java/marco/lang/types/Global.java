package marco.lang.types;

import marco.lang.MarcoObject;

public class Global {
    public static void init(MarcoObject self) {
        self.setName("Global");
        self.setParent(self.runtime.object);
    }
}
