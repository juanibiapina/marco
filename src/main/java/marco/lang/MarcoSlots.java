package marco.lang;

import marco.MarcoException;

import java.util.HashMap;
import java.util.Map;

public class MarcoSlots {
    private Map<String, MarcoSlot> slots = new HashMap<String, MarcoSlot>();
    private MarcoObject owner;

    public MarcoSlots(MarcoObject owner) {
        this.owner = owner;
    }

    public void add(MarcoSlot slot) {
        slots.put(slot.getName(), slot);
    }

    public MarcoSlot getSlot(String name) {
        if (hasSlot(name)) {
            if (slots.containsKey(name)) {
                return slots.get(name);
            } else {
                return owner.getParent().getSlots().getSlot(name);
            }
        }else {
            throw new MarcoException("Exception: " + owner.getName() + " does not respond to " + name);
        }
    }

    private boolean hasSlot(String name) {
        if (slots.containsKey(name)) {
            return true;
        } else {
            if (owner.hasParent()) {
                return owner.getParent().getSlots().hasSlot(name);
            } else {
                return false;
            }
        }
    }

    public MarcoObject activate(String slotName) {
        return getSlot(slotName).activate(owner);
    }
}
