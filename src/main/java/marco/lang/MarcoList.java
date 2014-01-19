package marco.lang;

import java.util.List;

public interface MarcoList {
    List<String> asArgumentList();

    int length();

    MarcoObject get(int i);
}
