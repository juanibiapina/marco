package marco.lang.types;

import marco.lang.MarcoObject;
import marco.lang.values.MethodValue;

public class MethodType {
    public static void init(MarcoObject self) {
        self.setName("Method");
        self.setParent(self.runtime.object);
        self.setValue(new MethodValue());
    }
}
