package marco.lang.contracts;

import marco.lang.MarcoObject;
import marco.lang.exceptions.ContractViolation;

import java.util.List;

public class Contract {
    private int expectedArity;

    public Contract(int expectedArity) {
        this.expectedArity = expectedArity;
    }

    public void validate(List<MarcoObject> arguments) {
        int actualArity = arguments.size();
        if (actualArity != expectedArity) {
            throw new ContractViolation(expectedArity, actualArity);
        }
    }
}
