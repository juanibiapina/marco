package marco.lang;

import marco.lang.helpers.Cast;
import marco.lang.types.MessageType;

public class MarcoObject {
    public MarcoRuntime runtime;
    private String name;
    private MarcoValue value;
    private MarcoObject parent;
    private MarcoSlots slots;
    private boolean activatable = false;

    public MarcoObject(MarcoRuntime runtime) {
        this.runtime = runtime;
        slots = new MarcoSlots(this);
    }

    public MarcoObject sendMessage(MarcoObject message) {
        if (Cast.toBoolean(MessageType.hasCachedResult(message))) {
            return MessageType.getCachedResult(message);
        }

        String slotName = MessageType.name(message);
        return slots.activate(slotName);
    }

    public boolean hasParent() {
        return parent != null;
    }

    public void setParent(MarcoObject parent) {
        this.parent = parent;
        if (parent.value != null) {
            this.value = parent.value.duplicate();
        }
        if (parent.activatable) {
            this.activatable = true;
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
        slots.add(new MarcoSlot(name, value));
    }

    public void setActivatable(boolean activatable) {
        this.activatable = activatable;
    }

    public boolean isActivatable() {
        return activatable;
    }

    public MarcoObject getParent() {
        return parent;
    }

    public MarcoSlots getSlots() {
        return slots;
    }
}
