package marco.lang;

public class MarcoPair extends MarcoValue {
    private MarcoObject first;
    private MarcoObject second;

    public MarcoPair(MarcoObject first, MarcoObject second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MarcoPair) {
            MarcoPair other = (MarcoPair) obj;
            return first.equals(other.first) && second.equals(other.second);
        } else {
            return false;
        }
    }

    @Override
    public String convertToString() {
        return "(" + first.toString() + ", " + second.toString() + ")";
    }

    @Override
    public boolean isPair() {
        return true;
    }

    @Override
    protected MarcoObject _clone() {
        return new MarcoPair(first, second);
    }

    public MarcoObject getFirst() {
        return first;
    }

    public MarcoObject getSecond() {
        return second;
    }
}
