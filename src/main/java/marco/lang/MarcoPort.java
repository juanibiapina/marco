package marco.lang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MarcoPort extends MarcoValue {
    private final BufferedReader reader;
    private InputStream in;

    public MarcoPort(InputStream in) {
        this.in = in;
        reader = new BufferedReader(new InputStreamReader(in));
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public String convertToString() {
        return "Port";
    }

    @Override
    protected MarcoObject _clone() {
        return new MarcoPort(in);
    }

    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("FIX IT");
        }
    }
}
