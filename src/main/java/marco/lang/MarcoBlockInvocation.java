package marco.lang;

import marco.internal.Environment;

public class MarcoBlockInvocation extends MarcoObject {
    private MarcoBlock block;

    public MarcoBlockInvocation(MarcoBlock block) {
        this.block = block;
    }

    @Override
    protected MarcoObject doEval(Environment closure, Environment environment) {
        return block.invoke(closure, environment);
    }

    @Override
    public String typeName() {
        return "BlockInvocation";
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public boolean isContinuation() {
        return false;
    }

    @Override
    public String asString() {
        return toString();
    }
}
