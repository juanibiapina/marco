package marco.lang.types;

import marco.lang.MarcoObject;
import marco.lang.values.Cast;
import marco.lang.values.NativeMethodValue;
import marco.lang.values.NumberValue;

public class NumberType {
    public static void init(MarcoObject self) {
        self.setName("Number");
        self.setParent(self.runtime.object);
        self.setValue(new NumberValue(0));

        self.setSlot("to_string", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                return self.runtime.createString(Integer.toString(Cast.toInteger(self)));
            }
        }));

        self.setSlot("+", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                MarcoObject args = MessageType.argument(message);
                MarcoObject arg0chain = args.sendMessage(scope, "popFirst");
                MarcoObject arg0 = self.runtime.interpreter.evalLine(self, arg0chain);
                return self.runtime.createNumber(Cast.toInteger(self) + Cast.toInteger(arg0));
            }
        }));

        self.setSlot("*", self.runtime.createNativeMethod(new NativeMethodValue() {
            @Override
            public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
                MarcoObject args = MessageType.argument(message);
                MarcoObject arg0chain = args.sendMessage(scope, "popFirst");
                MarcoObject arg0 = self.runtime.interpreter.evalLine(self, arg0chain);
                return self.runtime.createNumber(Cast.toInteger(self) * Cast.toInteger(arg0));
            }
        }));
    }

}
