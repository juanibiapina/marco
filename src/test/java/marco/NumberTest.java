package marco;

import marco.lang.MarcoObject;
import marco.lang.values.Cast;
import marco.support.MarcoTestSupport;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Ignore
public class NumberTest extends MarcoTestSupport {

    @Test
    public void shouldAddTwoNumbers() throws Exception {
        MarcoObject program = parse("1 +(1)");

        MarcoObject result = runtime.interpreter.eval(runtime.object, program);

        assertThat(Cast.toInteger(result), is(2));
    }

}
