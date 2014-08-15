package marco.lang;

import marco.runtime.Environment;

public abstract class MarcoObject {
    private String fileName;
    private Integer startLine;
    private MarcoHashMap metadata;

    public abstract MarcoObject __eval(Environment dynamic);

    public abstract boolean isList();

    public abstract String convertToString();

    @Override
    public String toString() {
        return convertToString();
    }

    public void setStartLine(Integer startLine) {
        this.startLine = startLine;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isContinuation() {
        return false;
    }

    public MarcoObject resolve() {
        return this;
    }

    public boolean isNil() {
        return false;
    }

    public boolean isPair() {
        return false;
    }

    public String getFileName() {
        return fileName;
    }

    public Integer getStartLine() {
        return startLine;
    }

    public void addMetadata(String key, MarcoObject value) {
        if (metadata == null) {
            metadata = new MarcoHashMap();
        }
        metadata.add(key, value);
    }

    public MarcoObject withMeta(MarcoHashMap data) {
        MarcoObject result = marcoClone();
        if (metadata != null) {
            result.metadata = metadata.merge(data);
        } else {
            result.metadata = data;
        }
        return result;
    }

    private MarcoObject marcoClone() {
        MarcoObject clone = _clone();
        clone.metadata = metadata;
        return clone;
    }

    public MarcoObject getMetadata() {
        if (metadata == null) {
            return new MarcoHashMap();
        } else {
            return metadata;
        }
    }

    protected abstract MarcoObject _clone();
}
