package marco.lang;

import marco.lang.types.*;
import marco.lang.values.MessageValue;
import marco.lang.values.NativeMethodValue;
import marco.lang.values.NumberValue;
import marco.lang.values.StringValue;
import marco.parser.Parser;

public class MarcoRuntime {
    public MarcoInterpreter interpreter = new MarcoInterpreter();

    public MarcoObject object;
    public MarcoObject global;
    public MarcoObject message;
    public MarcoObject string;
    public MarcoObject booleanObject;
    public MarcoObject trueObject;
    public MarcoObject falseObject;
    public MarcoObject number;
    public MarcoObject chain;
    public MarcoObject list;
    public MarcoObject nativeMethod;

    public MarcoRuntime() {
        object = new MarcoObject(this);
        nativeMethod = new MarcoObject(this);
        message = new MarcoObject(this);
        global = new MarcoObject(this);
        string = new MarcoObject(this);
        booleanObject = new MarcoObject(this);
        trueObject = new MarcoObject(this);
        falseObject = new MarcoObject(this);
        number = new MarcoObject(this);
        chain = new MarcoObject(this);
        list = new MarcoObject(this);

        NativeMethodType.init(nativeMethod);
        ObjectType.init(object);
        Global.init(global);
        MessageType.init(message);
        StringType.init(string);
        BooleanType.init(booleanObject);
        TrueType.init(trueObject);
        FalseType.init(falseObject);
        NumberType.init(number);
        ChainType.init(chain);
        ListType.init(list);
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

    public MarcoObject createString(String value) {
        MarcoObject aString = new MarcoObject(this);
        aString.setParent(string);
        aString.setValue(new StringValue(value));
        return aString;
    }

    public MarcoObject createStringMessage(String value) {
        MarcoObject aMessage = new MarcoObject(this);
        aMessage.setParent(message);
        MessageValue messageValue = new MessageValue(value);
        messageValue.setCachedResult(createString(value));
        aMessage.setValue(messageValue);
        return aMessage;
    }

    public MarcoObject createNumberMessage(String name) {
        MarcoObject aMessage = new MarcoObject(this);
        aMessage.setParent(message);
        MessageValue messageValue = new MessageValue(name);
        messageValue.setCachedResult(createNumber(name));
        aMessage.setValue(messageValue);
        return aMessage;
    }

    private MarcoObject createNumber(String value) {
        MarcoObject aString = new MarcoObject(this);
        aString.setParent(number);
        aString.setValue(NumberValue.fromString(value));
        return aString;
    }

    public MarcoObject createChain(MarcoObject messages) {
        MarcoObject aChain = new MarcoObject(this);
        aChain.setParent(chain);
        aChain.setSlot("messages", messages);
        return aChain;
    }

    public MarcoObject createList() {
        MarcoObject aList = new MarcoObject(this);
        aList.setParent(list);
        return aList;
    }

    public MarcoObject createNativeMethod(NativeMethodValue nativeMethodValue) {
        MarcoObject aMethod = new MarcoObject(this);
        aMethod.setParent(nativeMethod);
        aMethod.setValue(nativeMethodValue);
        return aMethod;
    }
}
