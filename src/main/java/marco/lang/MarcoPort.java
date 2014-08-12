package marco.lang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MarcoPort extends MarcoValue {
    private final BufferedReader reader;

    public MarcoPort(InputStream in) {
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

    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("FIX IT");
        }
    }
}
