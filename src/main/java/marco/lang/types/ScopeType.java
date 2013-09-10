package marco.lang.types;

import marco.lang.MarcoObject;

public class ScopeType {
    public static void init(MarcoObject self) {
        self.setName("Scope");
        self.setParent(self.runtime.object);
    }
}
