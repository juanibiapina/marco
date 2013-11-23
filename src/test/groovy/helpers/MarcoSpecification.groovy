package helpers
import marco.MarcoRuntime
import marco.lang.MarcoObject
import org.junit.Ignore
import spock.lang.Specification

@Ignore
abstract class MarcoSpecification extends Specification {
    def runtime = new MarcoRuntime();

    def MarcoObject eval(String code) {
        runtime.eval(code)
    }

    def MarcoObject lookUp(String var) {
        runtime.lookUp(var)
    }
}
