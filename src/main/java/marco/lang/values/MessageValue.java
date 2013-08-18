package marco.lang.values;

import marco.lang.MarcoValue;

public class MessageValue extends MarcoValue {
    private String name;

    public MessageValue(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
