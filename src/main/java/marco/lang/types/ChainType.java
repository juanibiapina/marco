package marco.lang.types;

import marco.lang.MarcoObject;
import marco.lang.values.Cast;
import marco.lang.values.NativeMethodValue;

public class ChainType {
    public static void init(MarcoObject self) {
        self.setName("Chain");
        self.setParent(self.runtime.object);

        self.setSlot("messages", self.runtime.createList());

        self.setSlot("hasMessages", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                MarcoObject messages = self.getSlot("messages");
                if (Cast.toBoolean(messages.sendMessage(scope, "isEmpty"))) {
                    return self.runtime.falseObject;
                } else {
                    return self.runtime.trueObject;
                }
            }
        }));

        self.setSlot("popFirst", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                MarcoObject messages = self.getSlot("messages");
                return messages.sendMessage(scope, "popFirst");
            }
        }));
    }
}
