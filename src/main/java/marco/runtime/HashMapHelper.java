package marco.runtime;

import marco.lang.MarcoHashMap;
import marco.lang.MarcoObject;
import marco.lang.MarcoSymbol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapHelper {
    public static MarcoHashMap fromMappingList(MarcoObject mappings) {
        if (mappings.isNil()) {
            return new MarcoHashMap();
        } else {
            List<MarcoObject> values = ListHelper.toJavaList(mappings);
            Map<MarcoSymbol, MarcoObject> map = new HashMap<>();
            for (int i = 0; i < values.size(); i+=2) {
                map.put(Cast.toSymbol(values.get(i)), values.get(i + 1));
            }
            return new MarcoHashMap(map);
        }
    }
}
