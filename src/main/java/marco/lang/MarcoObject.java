package marco.lang;

import marco.MarcoException;
import marco.lang.types.MessageType;
import marco.lang.values.Cast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarcoObject {
    public MarcoRuntime runtime;

    private String name;
    private Map<String, MarcoObject> slots = new HashMap<String, MarcoObject>();
    private MarcoObject parent;
    private MarcoValue value;
    private boolean activatable = false;

    public MarcoObject(MarcoRuntime runtime) {
        this.runtime = runtime;
    }

    public MarcoObject getSlot(String slotName) {
        if (slots.containsKey(slotName)) {
            return slots.get(slotName);
        } else {
            if (hasParent()) {
                return parent.getSlot(slotName);
            } else {
                throw new RuntimeException("Can't find slot " + slotName);
            }
        }
    }

    public void setSlot(String name, MarcoObject value) {
        slots.put(name, value);
    }

    public void setValue(MarcoValue value) {
        this.value = value;
    }

    public void setParent(MarcoObject parent) {
        this.parent = parent;
        if (parent.value != null) {
            this.value = parent.value.duplicate();
        }
        if (parent.activatable) {
            activatable = true;
        }
    }

    public MarcoValue getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasSlot(String slotName) {
        if (slots.containsKey(slotName)) {
            return true;
        } else {
            if (hasParent()) {
                return parent.hasSlot(slotName);
            } else {
                return false;
            }
        }
    }

    public boolean hasParent() {
        return parent != null;
    }

    public String getName() {
        if (hasName()) {
            return name;
        } else {
            if (hasParent()) {
                return parent.getName();
            } else {
                throw new RuntimeException("Should not happen");
            }
        }
    }

    private boolean hasName() {
        return name != null;
    }

    public MarcoObject sendMessage(MarcoObject parentScope, String messageName) {
        return sendMessage(parentScope, runtime.createMessage(messageName));
    }

    public MarcoObject sendMessage(MarcoObject parentScope, MarcoObject message) {
        if (Cast.toBoolean(MessageType.hasCachedValue(message))) {
            return MessageType.cachedValue(message);
        }

        String slotName = MessageType.name(message);
        if (hasSlot(slotName)) {
            return getSlot(slotName).activate(parentScope, this, message);
        } else {
            throw new MarcoException("Exception: " + getName() + " does not respond to " + slotName);
        }
    }

    private MarcoObject activate(MarcoObject parentScope, MarcoObject on, MarcoObject message) {
        if (activatable) {
            MarcoObject scope = parentScope.runtime.createScope(on, message);
            scope.setSlot("parent", parentScope);
            return value.activate(this, scope, on, message);
        } else {
            return this;
        }
    }

    public List<String> slotNames() {
        List<String> slotNames = new ArrayList<String>();
        slotNames.addAll(slots.keySet());
        return slotNames;
    }

    public void setActivatable() {
        activatable = true;
    }
}
