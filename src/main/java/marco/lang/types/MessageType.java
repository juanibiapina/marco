package marco.lang.types;

import marco.lang.MarcoObject;
import marco.lang.values.MessageValue;

public class MessageType {
    public static void init(MarcoObject self) {
        self.setName("Message");
        self.setParent(self.runtime.object);
    }

    public static String name(MarcoObject self) {
        MessageValue value = (MessageValue) self.getValue();
        return value.getName();
    }

    public static MarcoObject hasCachedResult(MarcoObject self) {
        MessageValue message = (MessageValue) self.getValue();
        if (message.hasCachedResult()) {
            return self.runtime.trueObject;
        } else {
            return self.runtime.falseObject;
        }
    }

    public static MarcoObject getCachedResult(MarcoObject self) {
        MessageValue message = (MessageValue) self.getValue();
        return message.getCachedResult();
    }
}
