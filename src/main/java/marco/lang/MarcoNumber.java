package marco.lang;

import java.math.BigInteger;

public class MarcoNumber extends MarcoValue {
    private BigInteger value;

    public MarcoNumber(int value) {
        this.value = BigInteger.valueOf(value);
    }

    public MarcoNumber(BigInteger value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MarcoNumber) {
            MarcoNumber other = (MarcoNumber) obj;
            return value.equals(other.value);
        } else {
            return false;
        }
    }

    @Override
    public String convertToString() {
        return value.toString();
    }

    @Override
    protected MarcoObject _clone() {
        return new MarcoNumber(value);
    }

    public BigInteger getValue() {
        return value;
    }
}
