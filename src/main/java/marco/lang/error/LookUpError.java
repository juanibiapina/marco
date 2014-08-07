package marco.lang.error;

public class LookUpError extends Error {
    private String binding;

    public LookUpError(String fileName, int line, String binding) {
        super(fileName, line, "Undefined binding '" + binding + "'");
        this.binding = binding;
    }

    public String getBinding() {
        return binding;
    }
}
