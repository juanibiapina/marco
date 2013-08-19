

import marco.lang.MarcoObject
import marco.lang.MarcoRuntime
import org.junit.Ignore
import spock.lang.Specification

@Ignore
abstract class IntegrationSpecification extends Specification {
    def runtime = new MarcoRuntime();

    def String eval(String code) {
        MarcoObject program = runtime.parse(code)
        return runtime.interpreter.eval(runtime.global, program);
    }

    def message(String message) {
        runtime.parse(message)
    }
}
