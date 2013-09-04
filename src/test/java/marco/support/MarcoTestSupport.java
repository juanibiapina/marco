package marco.support;

import marco.lang.MarcoObject;
import marco.lang.MarcoRuntime;
import org.junit.Before;

public class MarcoTestSupport {
    protected MarcoRuntime runtime;

    @Before
    public void initialize() {
        runtime = new MarcoRuntime();
    }

    protected MarcoObject parse(String code) {
        return runtime.parse(code);
    }
}
