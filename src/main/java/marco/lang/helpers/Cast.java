package marco.lang.helpers;

import marco.lang.MarcoObject;
import marco.lang.values.BooleanValue;

public class Cast {
    public static boolean toBoolean(MarcoObject self) {
        assertValueExists(self, "Boolean");
        BooleanValue bValue = (BooleanValue) self.getValue();
        return bValue.getValue();
    }

    private static void assertValueExists(MarcoObject self, String type) {
        if (self.getValue() == null) {
            throw new RuntimeException(self.getName() + " cannot be cast to " + type);
        }
    }
}
