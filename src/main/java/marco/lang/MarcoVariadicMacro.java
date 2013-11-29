package marco.lang;

import marco.internal.Environment;

public class MarcoVariadicMacro extends MarcoRunnable {
    private final Environment closureEnv;
    private String formal;
    private MarcoObject body;

    public MarcoVariadicMacro(Environment environment, String formal, MarcoObject body) {
        this.closureEnv = environment;
        this.formal = formal;
        this.body = body;
    }

    @Override
    public MarcoObject call(Environment environment, MarcoList arguments) {
        Environment extendedEnv = closureEnv.duplicate();

        extendedEnv.rebind(formal, (MarcoObject) arguments);

        return body.eval(extendedEnv);
    }

    @Override
    public String typeName() {
        return "VariadicMacro";
    }
}
