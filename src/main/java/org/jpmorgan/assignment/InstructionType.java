package org.jpmorgan.assignment;

import java.util.HashMap;
import java.util.Map;

/**
 * Instruction types
 * @author ekber
 *
 */
public enum InstructionType {

	BUY("outgoing"), SELL("incoming");

    private final String abbreviation;

    private static final Map<String, InstructionType> lookup = new HashMap<String, InstructionType>();

    static {
        for (InstructionType d : InstructionType.values()) {
            lookup.put(d.getAbbreviation(), d);
        }
    }

    private InstructionType(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public static InstructionType get(String abbreviation) {
        return lookup.get(abbreviation);
    }

}
