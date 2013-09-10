package marco.lang;

public class MarcoSlot {
    private MarcoObject contents;

    public MarcoSlot(MarcoObject contents) {
        this.contents = contents;
    }

    public MarcoObject activate(MarcoObject target) {
        if (contents.isActivatable()) {
            return contents.activate(target);
        } else {
            return contents;
        }
    }
}
