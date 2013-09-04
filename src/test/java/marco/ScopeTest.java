package marco;

import marco.lang.MarcoObject;
import marco.support.MarcoTestSupport;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Ignore
public class ScopeTest extends MarcoTestSupport {

    @Test
    public void shouldHaveAMessage() throws Exception {
        MarcoObject program = parse("setSlot(\"f\", macro(message))");

        runtime.interpreter.eval(runtime.object, program);

        MarcoObject message = runtime.createMessage("f");
        assertThat(runtime.object.sendMessage(runtime.object, message), is(message));
    }

    @Test
    public void shouldHaveSelf() throws Exception {
        MarcoObject program = parse("setSlot(\"f\", macro(self))");

        runtime.interpreter.eval(runtime.object, program);

        assertThat(runtime.object.sendMessage(runtime.object, "f"), is(runtime.object));
    }
}
