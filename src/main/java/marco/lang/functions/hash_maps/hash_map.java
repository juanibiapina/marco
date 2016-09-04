package marco.lang.functions.hash_maps;

import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.runtime.Environment;
import marco.runtime.HashMapHelper;

public class hash_map extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoObject mappings = closure.lookUp("mappings");

        return HashMapHelper.fromMappingList(mappings);
    }
}
