package marco.parser;

import marco.lang.MarcoObject;

public class MarcoSymbolMessage implements MarcoMessage {
    private String value;

    public MarcoSymbolMessage(String text) {
        this.value = text;
    }

    @Override
    public MarcoObject eval(MarcoObject target) {
        return target.slot(value);
    }
}
