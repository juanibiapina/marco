package marco.parser;

import java.util.ArrayList;
import java.util.List;

public class MarcoSingleExpr {
    private List<MarcoMessage> messages = new ArrayList<>();

    public void add(MarcoMessage message) {
        messages.add(message);
    }

    public List<MarcoMessage> messages() {
        return messages;
    }
}
