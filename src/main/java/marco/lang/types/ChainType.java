package marco.lang.types;

import marco.lang.MarcoObject;

public class ChainType {
    public static void init(MarcoObject self) {
        self.setName("Chain");
        self.setParent(self.runtime.object);

        self.setSlot("messages", self.runtime.createList());
    }
}
