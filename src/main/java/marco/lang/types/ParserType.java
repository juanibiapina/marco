package marco.lang.types;


import marco.lang.MarcoObject;
import marco.lang.values.ParserValue;

public class ParserType {
    public static void init(MarcoObject self) {
        self.setName("Parser");
        self.setParent(self.runtime.object);
        self.setValue(new ParserValue(self.runtime));
    }

    public static MarcoObject parse(MarcoObject self, String code) {
        ParserValue parser = (ParserValue) self.getValue();
        return parser.parse(code);
    }
}
