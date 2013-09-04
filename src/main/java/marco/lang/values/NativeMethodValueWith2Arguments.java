package marco.lang.values;

import marco.lang.MarcoObject;
import marco.lang.types.MessageType;

public abstract class NativeMethodValueWith2Arguments extends NativeMethodValue {
    public abstract MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message, MarcoObject argument1, MarcoObject argument2);

    @Override
    public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
        MarcoObject argument = MessageType.argument(message);
        int size = Cast.toInteger(argument.sendMessage(scope, "size"));
        if (size != 2) {
            throw new RuntimeException("Wrong number of arguments. Expected 2, got " + size);
        }
        MarcoObject arg1 = argument.sendMessage(scope, "first");
        MarcoObject arg2 = argument.sendMessage(scope, "second");
        MarcoObject evaluatedArg1 = self.runtime.interpreter.evalLine(scope.sendMessage(scope, "parent"), arg1);
        MarcoObject evaluatedArg2 = self.runtime.interpreter.evalLine(scope.sendMessage(scope, "parent"), arg2);
        return perform(scope, self, message, evaluatedArg1, evaluatedArg2);
    }
}
