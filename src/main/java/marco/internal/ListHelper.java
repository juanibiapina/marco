package marco.internal;

import marco.lang.MarcoCons;
import marco.lang.MarcoList;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;

import java.util.List;

public class ListHelper {
    public static MarcoList fromJavaList(List<MarcoObject> rawList) {
        if (rawList.size() == 0) {
            return MarcoNil.NIL;
        }

        MarcoCons result = new MarcoCons(rawList.get(rawList.size() - 1), MarcoNil.NIL);
        for (int i = rawList.size() - 2; i >= 0; i--) {
            result = new MarcoCons(rawList.get(i), result);
        }
        return result;
    }
}
