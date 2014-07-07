package marco.lang.error;

import marco.runtime.MarcoRuntime;

public class Error extends RuntimeException {
    private MarcoRuntime runtime;
    private String fileName;
    private int line;

    public Error(MarcoRuntime runtime, String fileName, int line, String message) {
        super(message);
        this.runtime = runtime;
        this.fileName = fileName;
        this.line = line;
    }

    public void printMarcoStackTrace() {
        printMessage();
        printLocation();
        runtime.buildStackTrace().print();
    }

    private void printMessage() {
        System.out.println(this);
    }

    private void printLocation() {
        System.out.println("      at " + fileName + ":" + line);
    }
}
