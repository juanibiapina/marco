package marco.lang;

import marco.lang.types.*;
import marco.lang.values.NativeMethodValue;
import marco.lang.values.NumberValue;
import marco.lang.values.StringValue;
import marco.parser.MarcoProgram;
import marco.parser.Parser;

public class MarcoRuntime {

    public MarcoObject object;
    public MarcoObject nativeMethod;
    public MarcoObject string;
    public MarcoObject list;
    public MarcoObject trueObject;
    public MarcoObject booleanObject;
    public MarcoObject falseObject;
    public MarcoObject number;

    private Parser parser = new Parser(this);

    public MarcoRuntime() {
        object = new MarcoObject(this);
        nativeMethod = new MarcoObject(this);
        booleanObject = new MarcoObject(this);
        trueObject = new MarcoObject(this);
        falseObject = new MarcoObject(this);
        string = new MarcoObject(this);
        list = new MarcoObject(this);
        number = new MarcoObject(this);

        NativeMethodType.init(nativeMethod);
        ObjectType.init(object);
        BooleanType.init(booleanObject);
        TrueType.init(trueObject);
        FalseType.init(falseObject);
        StringType.init(string);
        NumberType.init(number);
        ListType.init(list);
    }

    public MarcoObject createNumber(String value) {
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

    public MarcoProgram parse(String code) {
        return parser.parse(code);
    }
}
