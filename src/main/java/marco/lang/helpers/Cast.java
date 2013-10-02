package marco.lang.helpers;

import marco.MarcoException;
import marco.lang.MarcoObject;
import marco.lang.values.NumberValue;
import marco.lang.values.StringValue;

public class Cast {

    public static String toString(MarcoObject self) {
        assertValueExists(self, "String");
        StringValue sValue = (StringValue) self.getValue();
        return sValue.getValue();
    }

    public static int toInteger(MarcoObject self) {
        assertValueExists(self, "Integer");
        NumberValue aValue = (NumberValue) self.getValue();
        return aValue.getValue();
    }

    private static void assertValueExists(MarcoObject self, String type) {
        if (self.getValue() == null) {
            throw new MarcoException(self.getName() + " cannot be cast to " + type);
        }
    }
}
