package marco.lang;

public class MarcoSlot {
    private MarcoObject owner;
    private final MarcoObject content;

    public MarcoSlot(MarcoObject owner, MarcoObject content) {
        this.owner = owner;
        this.content = content;
    }

    public MarcoObject activate(MarcoObject target) {
        if (content.isActivatable()) {
            return content.getValue().activate(target);
        } else {
            return content;
        }
    }
}
