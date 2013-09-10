package marco;

import marco.lang.MarcoObject;
import marco.lang.helpers.Cast;
import marco.support.MarcoTestSupport;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Ignore
public class MethodTest extends MarcoTestSupport{

    @Test
    public void shouldHaveABody() {
        String code =
                "setSlot(\"method\", macro(\n" +
                "setSlot(\"zMethod\", Method clone)\n" +
                "getSlot(\"zMethod\") setSlot(\"body\", message argument last)\n" +
                "getSlot(\"zMethod\")\n" +
                "))\n" +
                "\n" +
                "setSlot(\"m\", method(n, 1 +(n)))\n" +
                "\n" +
                "m(1) body toString";
        MarcoObject program = parse(code);

        MarcoObject result = runtime.interpreter.eval(runtime.object, program);

        assertThat(Cast.toString(result), is("Chain"));
    }

    @Test
    public void shouldEvaluateTheBody() {
        String code =
                "setSlot(\"method\", macro(\n" +
                "setSlot(\"zMethod\", Method clone)\n" +
                "getSlot(\"zMethod\") setActivatable\n" +
                "getSlot(\"zMethod\") setSlot(\"body\", message argument last)\n" +
                "getSlot(\"zMethod\")\n" +
                "))\n" +
                "\n" +
                "setSlot(\"m\", method(n, 1 +(1)))\n" +
                "\n" +
                "m";
        MarcoObject program = parse(code);

        MarcoObject result = runtime.interpreter.eval(runtime.object, program);

        assertThat(Cast.toInteger(result), is(2));
    }

}
