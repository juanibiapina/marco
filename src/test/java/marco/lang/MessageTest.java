package marco.lang;

import marco.MarcoException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class MessageTest {
    private MarcoRuntime runtime = new MarcoRuntime();

    @Test
    public void nonExistentMessage() throws Exception {
        try {
            runtime.interpreter.eval(runtime.global, code("simplemessage"));
        } catch (MarcoException e) {
            assertThat(e.getMessage(), is("Exception: Global does not respond to simplemessage"));
            return;
        }
        fail();
    }

    private MarcoObject code(String code) {
        return runtime.parse(code);
    }
}
