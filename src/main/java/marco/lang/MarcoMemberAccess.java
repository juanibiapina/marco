package marco.lang;

import marco.internal.Cast;
import marco.internal.Environment;

import java.util.List;

public class MarcoMemberAccess extends MarcoObject {
    private List<MarcoName> symbols;

    public MarcoMemberAccess(List<MarcoName> symbols) {
        this.symbols = symbols;
    }

    @Override
    public MarcoObject eval(Environment dynamic) {
        MarcoModule data = Cast.toModule(symbols.get(0).eval(dynamic));

        MarcoObject result = data.getField(symbols.get(1));
        for (int i = 2; i < symbols.size(); i++) {
            result = Cast.toModule(result).getField(symbols.get(i));
        }
        return result;
    }

    @Override
    public String typeName() {
        return "MemberAccess";
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public String asString() {
        return toString();
    }
}
