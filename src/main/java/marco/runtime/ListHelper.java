package marco.runtime;

import marco.lang.MarcoNil;
import marco.lang.MarcoObject;
import marco.lang.MarcoPair;

import java.util.ArrayList;
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

    public static List<String> asArgumentList(MarcoObject list) {
        List<String> result = new ArrayList<>();
        if (list.isNil()) {
            return result;
        } else {
            MarcoPair pair = Cast.toPair("List", list);
            result.add(Cast.toSymbol(pair.getFirst()).getValue());
            result.addAll(asArgumentList(((MarcoPair) list).getSecond()));
            return result;
        }
    }

    public static List<MarcoObject> toJavaList(MarcoObject list) {
        List<MarcoObject> result = new ArrayList<>();
        if (list.isNil()) {
            return result;
        } else {
            MarcoPair pair = (MarcoPair) list;
            result.add(pair.getFirst());
            result.addAll(toJavaList(pair.getSecond()));
            return result;
        }
    }
}
