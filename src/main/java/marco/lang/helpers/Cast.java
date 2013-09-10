package marco.lang.helpers;

import marco.MarcoException;
import marco.lang.MarcoObject;
import marco.lang.values.BooleanValue;
import marco.lang.values.ListValue;
import marco.lang.values.NumberValue;
import marco.lang.values.StringValue;

import java.util.List;

public class Cast {
    public static boolean toBoolean(MarcoObject self) {
        assertValueExists(self, "Boolean");
        BooleanValue bValue = (BooleanValue) self.getValue();
        return bValue.getValue();
    }

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

    public static List<MarcoObject> toList(MarcoObject self) {
        assertValueExists(self, "List");
        ListValue aValue = (ListValue) self.getValue();
        return aValue.getValue();
    }

    private static void assertValueExists(MarcoObject self, String type) {
        if (self.getValue() == null) {
            throw new MarcoException(self.getName() + " cannot be cast to " + type);
        }
    }
}
