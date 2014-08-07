package marco.lang.error;

public class Error extends RuntimeException {
    private String fileName;
    private int line;

    public Error(String fileName, int line, String message) {
        super(message);
        this.fileName = fileName;
        this.line = line;
    }

    public void printMarcoStackTrace() {
        printMessage();
        printLocation();
    }

    public String getFileName() {
        return fileName;
    }

    private void printMessage() {
        System.out.println(this);
    }

    private void printLocation() {
        System.out.println("      at " + fileName + ":" + line);
    }
}
