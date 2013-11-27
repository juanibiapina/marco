package marco.lang;

import marco.internal.Environment;

public abstract class MarcoForm extends MarcoObject {
    public abstract MarcoObject eval(Environment environment);

    @Override
    public String typeName() {
        return "Form";
    }
}
