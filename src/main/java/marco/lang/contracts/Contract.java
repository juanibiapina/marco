package marco.lang.contracts;

import marco.lang.MarcoList;
import marco.lang.exceptions.ContractViolation;

public class Contract {
    private int expectedArity;

    public Contract(int expectedArity) {
        this.expectedArity = expectedArity;
    }

    public void validate(MarcoList arguments) {
        int actualArity = arguments.length();
        if (actualArity != expectedArity) {
            throw new ContractViolation(expectedArity, actualArity);
        }
    }
}
