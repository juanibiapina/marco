package marco.lang.exceptions;

import marco.runtime.bindings.ImmutableBinding;

public class ImmutabilityError extends MarcoException {
    private String symbol;

    public ImmutabilityError(ImmutableBinding binding) {
        super("Cannot mutate symbol: " + binding.getSymbol());
        this.symbol = binding.getSymbol();
    }
}
