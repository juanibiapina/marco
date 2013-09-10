package marco.lang.types;

import marco.lang.MarcoObject;
import marco.lang.values.*;

import java.util.List;

public class ObjectType {
    public static void init(MarcoObject self) {

        self.setName("Object");

        self.setSlot("Object", self);
        self.setSlot("Number", self.runtime.number);
        self.setSlot("Parser", self.runtime.parser);

        self.setSlot("to_string", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                return self.runtime.createString(self.getName());
            }
        }));

        self.setSlot("puts", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                MarcoObject repr = self.sendMessage(scope, "to_string");
                System.out.println(((StringValue) repr.getValue()).getValue());
                return self;
            }
        }));

        self.setSlot("clone", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                MarcoObject result = new MarcoObject(self.runtime);
                result.setParent(self);
                return result;
            }
        }));

        self.setSlot("macro", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                MarcoObject body = MessageType.argument(message);
                return self.runtime.createMacro(body);
            }
        }));

        self.setSlot("set_slot", self.runtime.createNativeMethod(new NativeMethodValueWith2Arguments() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message, MarcoObject argument1, MarcoObject argument2) {
                self.setSlot(Cast.toString(argument1), argument2);
                return self;
            }
        }));

        self.setSlot("get_slot", self.runtime.createNativeMethod(new NativeMethodValueWith1Argument() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message, MarcoObject argument) {
                return self.getSlot(Cast.toString(argument));
            }
        }));

        self.setSlot("slot_names", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                List<String> slotNames = self.slotNames();
                MarcoObject list = self.runtime.createList();
                for (String slotName : slotNames) {
                    ListType.add(list, self.runtime.createString(slotName));
                }
                return list;
            }
        }));

        self.setSlot("set_activatable", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                self.setActivatable();
                return self;
            }
        }));
    }
}
