package marco.lang;

import marco.internal.Environment;

public class MarcoBlockInvocation extends MarcoObject {
    private MarcoBlock block;
    private Environment closure;
    private Environment environment;

    public MarcoBlockInvocation(MarcoBlock block, Environment closure, Environment environment) {
        this.block = block;
        this.closure = closure;
        this.environment = environment;
    }

    @Override
    protected MarcoObject doEval(Environment closure, Environment environment) {
        return block.invoke(this.closure, this.environment);
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
        return true;
    }

    @Override
    public String asString() {
        return toString();
    }
}
