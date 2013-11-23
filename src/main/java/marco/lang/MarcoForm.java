package marco.lang;

import marco.internal.Environment;

public interface MarcoForm extends MarcoObject {
    MarcoObject eval(Environment environment);
}
