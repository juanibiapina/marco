package marco.lang;

import marco.MarcoException;
import marco.lang.helpers.Cast;
import marco.lang.types.Message;

import java.util.HashMap;
import java.util.Map;

public class MarcoObject {
    public MarcoRuntime runtime;
    private String name;
    private MarcoValue value;
    private MarcoObject parent;
    private Map<String, MarcoObject> slots = new HashMap<String, MarcoObject>();

    public MarcoObject(MarcoRuntime runtime) {
        this.runtime = runtime;
    }

    public MarcoObject sendMessage(MarcoObject message) {
        if (Cast.toBoolean(Message.hasCachedResult(message))) {
            return Message.getCachedResult(message);
        }

        String slotName = Message.name(message);
        if (hasSlot(slotName)) {
            return getSlot(slotName);
        } else {
            throw new MarcoException("Exception: " + getName() + " does not respond to " + slotName);
        }
    }

    private MarcoObject getSlot(String name) {
        return slots.get(name);
    }

    private boolean hasSlot(String name) {
        return slots.containsKey(name);
    }

    public void setParent(MarcoObject parent) {
        this.parent = parent;
        if (parent.value != null) {
            this.value = parent.value.duplicate();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        if (hasName()) {
            return name;
        } else {
            return parent.getName();
        }
    }

    private boolean hasName() {
        return name != null;
    }

    public void setValue(MarcoValue value) {
        this.value = value;
    }

    public MarcoValue getValue() {
        return value;
    }

    public MarcoObject sendMessage(String message) {
        return sendMessage(runtime.createMessage(message));
    }

    public void setSlot(String name, MarcoObject value) {
        slots.put(name, value);
    }
}
