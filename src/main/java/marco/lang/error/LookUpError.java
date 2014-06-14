package marco.lang.error;

public class LookUpError extends Error {
    private int line;
    private String binding;

    public LookUpError(int line, String binding) {
        super("Undefined binding '" + binding + "'");
        this.line = line;
        this.binding = binding;
    }

    public int getLine() {
        return line;
    }

    public String getBinding() {
        return binding;
    }
}
