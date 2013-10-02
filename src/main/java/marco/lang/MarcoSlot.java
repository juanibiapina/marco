package marco.lang;

import marco.MarcoException;

public class MarcoSlot {
    private String name;
    private MarcoObject contents;

    public MarcoSlot(String name, MarcoObject contents) {
        this.name = name;
        this.contents = contents;
    }

    public MarcoObject activate(MarcoObject target) {
        if (contents == null) {
            throw new MarcoException("Exception: " + target.getName() + " does not respond to " + name);
        }

        return contents.activate(target);
    }
}
