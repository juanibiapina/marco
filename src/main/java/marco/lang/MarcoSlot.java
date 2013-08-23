package marco.lang;

public class MarcoSlot {
    private final MarcoObject content;
    private String name;

    public MarcoSlot(String name, MarcoObject content) {
        this.name = name;
        this.content = content;
    }

    public MarcoObject activate(MarcoObject target) {
        if (content.isActivatable()) {
            return content.getValue().activate(target);
        } else {
            return content;
        }
    }

    public String getName() {
        return name;
    }
}
