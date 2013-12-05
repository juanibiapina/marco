package marco.lang.exception;

import marco.internal.bindings.ImmutableBinding;

public class MarcoImmutabilityError extends MarcoException {
    private String symbol;

    public MarcoImmutabilityError(ImmutableBinding binding) {
        super("Cannot mutate symbol: " + binding.getSymbol());
        this.symbol = binding.getSymbol();
    }
}
