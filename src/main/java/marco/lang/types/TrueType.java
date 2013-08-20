package marco.lang.types;

import marco.lang.MarcoObject;
import marco.lang.values.BooleanValue;

public class TrueType {
    public static void init(MarcoObject self) {
        self.setParent(self.runtime.booleanObject);
        self.setValue(new BooleanValue(true));
    }
}
