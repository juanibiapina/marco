package marco.internal;

import marco.lang.MarcoNil;
import marco.lang.MarcoObject;
import marco.lang.MarcoPair;

import java.util.List;

public class ListHelper {
    public static MarcoObject fromJavaList(List<MarcoObject> rawList) {
        if (rawList.size() == 0) {
            return MarcoNil.NIL;
        }

        MarcoPair result = new MarcoPair(rawList.get(rawList.size() - 1), MarcoNil.NIL);
        for (int i = rawList.size() - 2; i >= 0; i--) {
            result = new MarcoPair(rawList.get(i), result);
        }
        return result;
    }
}
