package marco.lang.functions.functions;

import marco.lang.*;
import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.runtime.ListHelper;

import java.util.ArrayList;
import java.util.List;

public class partial extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoNumber n = Cast.toNumber(closure.lookUp("n"));
        MarcoPair args = Cast.toPair("List", closure.lookUp("args"));

        MarcoRunnable runnable = Cast.toRunnable(args.getFirst(), getFileName(), getStartLine());
        List<MarcoObject> partialArgs = ListHelper.toJavaList(args.getSecond());

        List<String> parameters = new ArrayList<>();
        for (int i = 0; i < n.getValue().intValue(); i++) {
            parameters.add("a" + i);
        }

        return new MarcoFunction(dynamic, parameters, new MarcoNativeBlock() {
            @Override
            public MarcoObject invoke(Environment closure, Environment dynamic) {
                List<MarcoObject> fullArgs = new ArrayList<>();
                fullArgs.addAll(partialArgs);
                for (String parameter : parameters) {
                    fullArgs.add(closure.lookUp(parameter));
                }

                return runnable.invoke(dynamic, fullArgs);
            }
        });
    }
}
