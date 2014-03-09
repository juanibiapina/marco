package marco.parser;

import marco.lang.exceptions.MarcoException;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ExceptionErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        String sourceName = recognizer.getInputStream().getSourceName();


        if (sourceName == null || sourceName.isEmpty()) {
            sourceName = "NO SOURCE FILE";
        } else {
            sourceName = String.format("%s:%d:%d", sourceName, line, charPositionInLine);
        }

        throw new MarcoException(sourceName + ": line " + line + ":" + charPositionInLine + " " + msg);
    }
}
