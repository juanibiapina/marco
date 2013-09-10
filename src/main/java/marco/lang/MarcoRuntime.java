package marco.lang;

import marco.lang.types.*;
import marco.lang.values.*;
import marco.lang.values.StringValue;

public class MarcoRuntime {

    public MarcoInterpreter interpreter = new MarcoInterpreter();

    public MarcoObject object;
    public MarcoObject nativeMethod;
    public MarcoObject message;
    public MarcoObject string;
    public MarcoObject chain;
    public MarcoObject list;
    public MarcoObject trueObject;
    public MarcoObject booleanObject;
    public MarcoObject falseObject;
    public MarcoObject number;
    public MarcoObject parser;

    public MarcoRuntime() {
        object = new MarcoObject(this);
        nativeMethod = new MarcoObject(this);
        booleanObject = new MarcoObject(this);
        trueObject = new MarcoObject(this);
        falseObject = new MarcoObject(this);
        message = new MarcoObject(this);
        string = new MarcoObject(this);
        list = new MarcoObject(this);
        chain = new MarcoObject(this);
        number = new MarcoObject(this);
        parser = new MarcoObject(this);

        NativeMethodType.init(nativeMethod);
        ObjectType.init(object);
        BooleanType.init(booleanObject);
        TrueType.init(trueObject);
        FalseType.init(falseObject);
        MessageType.init(message);
        StringType.init(string);
        NumberType.init(number);
        ListType.init(list);
        ChainType.init(chain);
        ParserType.init(parser);
    }

    public MarcoObject createMessage(String name) {
        MarcoObject aMessage = new MarcoObject(this);
        aMessage.setParent(message);
        aMessage.setValue(new MessageValue(name));
        return aMessage;
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
        aString.setValue(new NumberValue(value));
        return aString;
    }

    public MarcoObject createString(String value) {
        MarcoObject aString = new MarcoObject(this);
        aString.setParent(string);
        aString.setValue(new StringValue(value));
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

    public MarcoObject parse(String code) {
        return ParserType.parse(parser, code);
    }
}
