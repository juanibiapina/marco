package marco.lang;

import marco.internal.Environment;

public class MarcoVariadicFunction extends MarcoRunnable {
    private Environment closureEnv;
    private String formal;
    private MarcoObject body;

    public MarcoVariadicFunction(Environment environment, String formal, MarcoObject body) {
        super();
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
        return "VariadicFunction";
    }
}
