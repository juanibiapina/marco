package marco.lang;

public class MarcoSlot {
    private MarcoObject contents;

    public MarcoSlot(MarcoObject contents) {
        this.contents = contents;
    }

    public MarcoObject activate() {
        return contents;
    }
}
