package marco.lang.functions.functions;

import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.lang.MarcoRunnable;
import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.runtime.ListHelper;

public class apply extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoRunnable runnable = Cast.toRunnable(closure.lookUp("runnable"), getFileName(), getStartLine());
        MarcoObject args = closure.lookUp("args");

        return runnable.invoke(dynamic, ListHelper.toJavaList(args));
    }
}
