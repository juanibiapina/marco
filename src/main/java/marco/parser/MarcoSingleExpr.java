package marco.parser;

import marco.lang.MarcoObject;

import java.util.ArrayList;
import java.util.List;

public class MarcoSingleExpr {
    private List<MarcoMessage> messages = new ArrayList<>();

    public void add(MarcoMessage message) {
        messages.add(message);
    }

    public MarcoObject eval(MarcoObject context) {
        MarcoObject on = context;

        for (MarcoMessage message : messages) {
            on = message.eval(on);
        }

        return on;
    }
}
