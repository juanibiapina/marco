package marco.lang;

import java.util.List;

public interface MarcoList {
    List<String> asArgumentList();

    int size();

    MarcoObject get(int i);
}
