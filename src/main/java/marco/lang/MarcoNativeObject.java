package marco.lang;

import java.util.Collections;
import java.util.List;

public abstract class MarcoNativeObject extends MarcoObject {
    @Override
    public String typeName() {
        return "NativeObject";
    }

    @Override
    public List<String> freeVariables() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public boolean isList() {
        return false;
    }
}
