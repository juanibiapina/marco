package marco.lang.values;

import marco.lang.MarcoObject;
import marco.lang.types.MessageType;

public abstract class NativeMethodValueWith1Argument extends NativeMethodValue {
    public abstract MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message, MarcoObject argument);

    @Override
    public MarcoObject perform(MarcoObject scope, MarcoObject self, MarcoObject message) {
        MarcoObject argument = MessageType.argument(message);
        int size = Cast.toInteger(argument.sendMessage(scope, "size"));
        if (size != 1) {
            throw new RuntimeException("Wrong number of arguments. Expected 1, got " + size);
        }
        MarcoObject arg = argument.sendMessage(scope, "first");
        MarcoObject evaluatedArg = self.runtime.interpreter.evalLine(scope.sendMessage(scope, "parent"), arg);
        return perform(scope, self, message, evaluatedArg);
    }
}
