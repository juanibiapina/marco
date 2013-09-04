package marco;

import marco.lang.MarcoObject;
import marco.lang.values.Cast;
import marco.support.MarcoTestSupport;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MessagePassingTest extends MarcoTestSupport {

    @Test
    public void shouldLookUpASymbolOnTheContext() throws Exception {
        // given
        MarcoObject context = new MarcoObject(runtime);
        MarcoObject expectedResult = new MarcoObject(runtime);
        context.setSlot("aSlot", expectedResult);
        MarcoObject program = parse("aSlot");

        // when
        MarcoObject result = runtime.interpreter.eval(context, program);

        // then
        assertThat(result, is(expectedResult));
    }

    @Test
    public void shouldLookUpThreeSymbolsInSequence() throws Exception {
        // given
        MarcoObject context = new MarcoObject(runtime);
        MarcoObject firstValue = new MarcoObject(runtime);
        context.setSlot("firstValue", firstValue);
        MarcoObject secondValue = new MarcoObject(runtime);
        firstValue.setSlot("secondValue", secondValue);
        MarcoObject thirdValue = new MarcoObject(runtime);
        secondValue.setSlot("thirdValue", thirdValue);

        MarcoObject program = parse("firstValue secondValue thirdValue");

        // when
        MarcoObject result = runtime.interpreter.eval(context, program);

        // then
        assertThat(result, is(thirdValue));
    }

    @Test
    public void shouldNotDestroyTheChainsAfterEvaluation() throws Exception {
        // given
        MarcoObject context = new MarcoObject(runtime);
        MarcoObject expectedResult = new MarcoObject(runtime);
        context.setSlot("aSlot", expectedResult);
        MarcoObject program = parse("aSlot");

        // when
        runtime.interpreter.eval(context, program);

        // then
        assertThat(Cast.toBoolean(program.sendMessage(runtime.object, "first").sendMessage(runtime.object, "hasMessages")), is(true));
    }

}
