package marco.lang;

import marco.MarcoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarcoObject {
    public MarcoRuntime runtime;

    private String name;
    private MarcoObject parent;
    private MarcoValue value;
    private boolean activatable = false;
    private Map<String, MarcoSlot> slots = new HashMap<>();

    public MarcoObject(MarcoRuntime runtime) {
        this.runtime = runtime;
    }

    public void setSlot(String name, MarcoObject value) {
        slots.put(name, new MarcoSlot(value));
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

    public MarcoObject activate(MarcoObject on) {
        return value.activate(on);
    }

    public List<String> slotNames() {
        List<String> slotNames = new ArrayList<>();
        slotNames.addAll(slots.keySet());
        return slotNames;
    }

    public void setActivatable() {
        activatable = true;
    }

    public boolean isActivatable() {
        return activatable;
    }

    public MarcoObject slot(String slotName) {
        if (slots.containsKey(slotName)) {
            return slots.get(slotName).activate(this);
        } else {
            if (hasParent()) {
                return parent.getSlot(slotName).activate(this);
            } else {
                throw new MarcoException("Exception: " + getName() + " does not respond to " + slotName);
            }
        }
    }

    private MarcoSlot getSlot(String slotName) {
        if (slots.containsKey(slotName)) {
            return slots.get(slotName);
        } else {
            if (hasParent()) {
                return parent.getSlot(slotName);
            } else {
                throw new RuntimeException("Should not happen");
            }
        }
    }
}
