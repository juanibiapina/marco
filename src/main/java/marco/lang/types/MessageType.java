package marco.lang.types;

import marco.lang.MarcoObject;
import marco.lang.values.MessageValue;
import marco.lang.values.NativeMethodValue;

public class MessageType {
    public static void init(MarcoObject self) {
        self.setName("Message");
        self.setParent(self.runtime.object);
        self.setValue(new MessageValue(null));

        self.setSlot("argument", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                MessageValue value = (MessageValue) self.getValue();
                return value.getArgument();
            }
        }));
    }

public static String name(MarcoObject self) {
        MessageValue value = (MessageValue) self.getValue();
        return value.getName();
    }

    public static MarcoObject addArgument(MarcoObject self, MarcoObject argument) {
        MessageValue value = (MessageValue) self.getValue();
        value.setArgument(argument);
        return self;
    }

    public static MarcoObject hasCachedValue(MarcoObject self) {
        MessageValue message = (MessageValue) self.getValue();
        if (message.hasCachedResult()) {
            return self.runtime.trueObject;
        } else {
            return self.runtime.falseObject;
        }
    }

    public static MarcoObject cachedValue(MarcoObject self) {
        MessageValue message = (MessageValue) self.getValue();
        return message.getCachedResult();
    }

    public static MarcoObject argument(MarcoObject self) {
        MessageValue value = (MessageValue) self.getValue();
        return value.getArgument();
    }
}
