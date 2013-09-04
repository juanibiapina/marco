package marco.lang.types;

import marco.lang.MarcoObject;
import marco.lang.values.MacroValue;

public class MacroType {
    public static void init(MarcoObject self) {
        self.setName("Macro");
        self.setActivatable();
        self.setParent(self.runtime.object);
        self.setValue(new MacroValue());
    }
}
