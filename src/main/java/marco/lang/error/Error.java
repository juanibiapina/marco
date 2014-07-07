package marco.lang.error;

import marco.runtime.MarcoRuntime;

public class Error extends RuntimeException {
    private MarcoRuntime runtime;

    public Error(MarcoRuntime runtime, String message) {
        super(message);
        this.runtime = runtime;
    }

    public void printMarcoStackTrace() {
        printMessage();
        runtime.buildStackTrace().print();
    }

    private void printMessage() {
        System.out.println(this);
    }
}
