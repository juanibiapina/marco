package marco.lang;

import marco.lang.types.Global;
import marco.lang.types.Message;
import marco.lang.types.ObjectType;
import marco.lang.values.MessageValue;
import marco.parser.Parser;

public class MarcoRuntime {
    public MarcoInterpreter interpreter = new MarcoInterpreter();

    public MarcoObject object;
    public MarcoObject global;
    public MarcoObject message;

    public MarcoRuntime() {
        object = new MarcoObject(this);
        message = new MarcoObject(this);
        global = new MarcoObject(this);

        ObjectType.init(object);
        Global.init(global);
        Message.init(message);
    }

    public MarcoObject parse(String code) {
        return new Parser(this).parse(code);
    }

    public MarcoObject createMessage(String name) {
        MarcoObject aMessage = new MarcoObject(this);
        aMessage.setParent(message);
        aMessage.setValue(new MessageValue(name));
        return aMessage;
    }
}
