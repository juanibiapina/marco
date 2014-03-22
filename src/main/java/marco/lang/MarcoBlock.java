package marco.lang;

import java.util.List;

public class MarcoBlock extends MarcoValue {
    private MarcoObject forms;

    public MarcoBlock(MarcoObject forms) {
        this.forms = forms;
    }

    @Override
    public String typeName() {
        return "Block";
    }

    @Override
    public List<String> freeVariables() {
        return forms.freeVariables();
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public boolean isContinuation() {
        return false;
    }
}
