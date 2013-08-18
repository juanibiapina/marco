package marco.lang.types;

import marco.lang.MarcoObject;
import marco.lang.values.MessageValue;

public class Message {
    public static String name(MarcoObject self) {
        MessageValue value = (MessageValue) self.getValue();
        return value.getName();
    }
}
